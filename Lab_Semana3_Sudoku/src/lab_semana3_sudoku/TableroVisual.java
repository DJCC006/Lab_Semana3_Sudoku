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

public class TableroVisual extends JPanel {
    
    private JComboBox<String>[][] Celdas = new JComboBox[9][9];
    private String Vacias = "";
    private String[] Numeros = {Vacias, "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    
    public TableroVisual() {
        setLayout(new GridLayout(9, 9, 0, 0)); //9 filas, 9 columnas, 0 espacio entre ellas tanto vertical como horizontalmente
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        ListCellRenderer centrado = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> lista, Object valor, int indice, boolean seleccionado, boolean focuscelda) {
                Component componente = super.getListCellRendererComponent(lista, valor, indice, seleccionado, focuscelda);
                setHorizontalAlignment(CENTER);
                
                return componente;
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
                add(CB);
            }
        }
        
        setPreferredSize(new Dimension(500, 500));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableroVisual().setVisible(true);
        });
    }
}
