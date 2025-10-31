/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_semana3_sudoku;

/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unchecked")
public class TableroVisual extends JFrame {
    
    private JComboBox<String>[][] Celdas = new JComboBox[9][9];
    private String Vacias = "";
    private String[] Numeros = {Vacias, "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private JSpinner SpnDificultad = new JSpinner(new SpinnerNumberModel(25, 5, 60, 1));
    
    private LogicaSudoku Logica;
    
    public TableroVisual() {
        super("Sudoku - Juego");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel PanelGrid = new JPanel();
        PanelGrid.setLayout(new GridLayout(9, 9, 0, 0)); //9 filas, 9 columnas, absolutamente 0 espacio entre ellos 
        PanelGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        ListCellRenderer centrado = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean seleccionado, boolean focuscelda) {
                Component c = super.getListCellRendererComponent(list, value, index, seleccionado, focuscelda);
                setHorizontalAlignment(CENTER);
                return c;
            }
        };
        
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                JComboBox<String> CB = new JComboBox<>(Numeros);
                CB.setFont(new Font("Monospaced", Font.BOLD, 18));
                CB.setRenderer(centrado);
                CB.setMaximumRowCount(10);
                
                //Bordes
                int arriba = (fila % 3 == 0) ? 3 : 1;
                int abajo = (fila == 8) ? 3 : 1;
                int izquierda = (col % 3 == 0) ? 3 : 1;
                int derecha = (col == 8) ? 3 : 1;
                
                CB.setBorder(BorderFactory.createMatteBorder(arriba, izquierda, abajo, derecha, Color.DARK_GRAY));
                
                Celdas[fila][col] = CB;
                PanelGrid.add(CB);
            }
        }
        
        add(PanelGrid, BorderLayout.CENTER);
        
        JPanel PanelBotones = new JPanel();
        PanelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel LblPistas = new JLabel("Pistas: ");
        
        JButton BtnGenerar = new JButton("Generar");
        BtnGenerar.addActionListener(e -> GenerarDesafio());
        
        JButton BtnLimpiar = new JButton("Limpiar");
        BtnLimpiar.addActionListener(e -> Limpiar());
        
        JButton BtnSincronizar = new JButton("Sincronizar");
        BtnSincronizar.addActionListener(e -> SyncVista());
        
        JButton BtnValidar = new JButton("Validar Victoria");
        BtnValidar.addActionListener(e -> ValidarVictoria());
        
        PanelBotones.add(LblPistas);
        PanelBotones.add(SpnDificultad);
        PanelBotones.add(BtnGenerar);
        PanelBotones.add(BtnSincronizar);
        PanelBotones.add(BtnValidar);
        PanelBotones.add(BtnLimpiar);
        
        add(PanelBotones, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /*
        Simple metodo de limpieza para mas facilidad
    */
    public void Limpiar() {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                Celdas[fila][col].setSelectedItem(Vacias);
                Celdas[fila][col].setEnabled(true);
                Celdas[fila][col].setForeground(Color.BLACK);
                Celdas[fila][col].setBackground(Color.WHITE);
            }
        }
    }
    
    private int[][] GridDesdeUI() {
        int[][] grid = new int[9][9];
        
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                Object celda = Celdas[fila][col].getSelectedItem();
                if (celda == null || celda.toString().isBlank()) {
                    grid[fila][col] = 0;
                } else {
                    grid[fila][col] = Integer.parseInt(celda.toString());
                }
            }
        }
        
        return grid;
    }
    
    /*
        Devolver el grid de la vista
    */
    private void GridtoUI(int[][] grid, boolean[][] fijados) {
        Limpiar();
        
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                int valor = grid[fila][col];
                
                if (valor != 0) {
                    Celdas[fila][col].setSelectedItem(String.valueOf(valor));
                }
                if (fijados != null && fijados[fila][col]) {
                    Celdas[fila][col].setEnabled(false);
                    Celdas[fila][col].setForeground(Color.BLACK);
                    Celdas[fila][col].setBackground(new Color(220, 220, 220));
                }
            }
        }
    }
    
    private void GenerarDesafio() {
        int pistas = (Integer) SpnDificultad.getValue();
        Logica = new LogicaSudoku(pistas);
        GridtoUI(Logica.CopiarGrid(), Logica.getFijadas());
    }
    
    private void SyncVista() {
        if (Logica == null) {
            JOptionPane.showMessageDialog(this, "Primero genera un reto");
            return;
        }
        
        Logica.setDesdeUI(GridDesdeUI());
        
        JOptionPane.showMessageDialog(this, "Tablero sincronizado exitosamente");
    }
    
    public void ValidarVictoria() {
        if (Logica == null) {
            JOptionPane.showMessageDialog(this, "Primero genera un reto");
            return;
        }
        
        Logica.setDesdeUI(GridDesdeUI());
        boolean victoria = Logica.esVictoria();
        
        if (victoria) {
            JOptionPane.showMessageDialog(this, "Felicidades!\nTu tablero ha sido validado y has ganado!");
        } else {
            JOptionPane.showMessageDialog(this, "Tu tablero no ha sido validado como correcto\nArregla tu tablero y vuelve a intentar!", "Vuelve a intentar", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void setCelda(int fila, int col, int valor) {
        Celdas[fila][col].setSelectedItem(valor >= 1 && valor <= 9 ? String.valueOf(valor) : Vacias);
    }
    
    /*
        Habilitar/deshabilitar una celda
    */
    public void setCeldaHabilitada(int fila, int col, boolean habilitado) {
        Celdas[fila][col].setEnabled(habilitado);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableroVisual().setVisible(true);
        });
    }
}
