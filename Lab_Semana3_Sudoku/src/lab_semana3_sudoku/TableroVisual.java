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
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
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
        
        JButton BtnCargar = new JButton("Cargar Ejemplo");
        BtnCargar.addActionListener(e -> CargarEjemplo());
        
        JButton BtnLimpiar = new JButton("Limpiar");
        BtnLimpiar.addActionListener(e -> Limpiar());
        
        PanelBotones.add(BtnCargar);
        PanelBotones.add(BtnLimpiar);
        
        add(PanelBotones, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /*
        Como dice, carga el tablero.
        los 0 son tomados como vacio
    */
    public void CargarTablero(int[][] grid, boolean numerosnoceros) {
        Limpiar();
        
        for (int filas = 0; filas < 9; filas++) {
            for (int col = 0; col < 9; col++) {
                int wasd = grid[filas][col];
                
                if (wasd >= 1 && wasd <= 9) {
                    Celdas[filas][col].setSelectedItem(String.valueOf(wasd));
                    
                    if (numerosnoceros) {
                        Celdas[filas][col].setEnabled(false);
                        Celdas[filas][col].setForeground(Color.BLUE);
                    }
                }
            }
        }
    }
    
    /*
        Ejemplo para que se forme una idea de que hacer al jugar
    */
    public void CargarEjemplo() {
        int[][] ejemplo = {
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };
        
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                int valor = ejemplo[fila][col];
                
                if (valor != 0) {
                    Celdas[fila][col].setSelectedItem(String.valueOf(valor));
                    Celdas[fila][col].setEnabled(false);
                    Celdas[fila][col].setForeground(Color.BLACK);
                    Celdas[fila][col].setBackground(Color.LIGHT_GRAY);
                } else {
                    Celdas[fila][col].setSelectedItem(Vacias);
                    Celdas[fila][col].setEnabled(true);
                    Celdas[fila][col].setForeground(Color.BLACK);
                    Celdas[fila][col].setBackground(Color.WHITE);
                }
            }
        }
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
    
    /*
        Devolver el grid de la vista
    */
    public Integer[][] getGrid() {
        Integer[][] grid = new Integer[9][9];
        
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                Object celda = Celdas[fila][col].getSelectedItem();
                
                if (celda == null || Vacias.equals(celda.toString().trim())) {
                    grid[fila][col] = 0;
                } else {
                    grid[fila][col] = Integer.parseInt(celda.toString());
                }
            }
        }
        
        return grid;
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
