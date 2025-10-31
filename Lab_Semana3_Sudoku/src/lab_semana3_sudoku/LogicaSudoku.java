/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_semana3_sudoku;

/**
 *
 * @author Hp
 */
public class LogicaSudoku extends GeneradorTableroLogic {
    
    private boolean[][] Fijadas;
    
    public LogicaSudoku(int dificultad) {
        super(new int[9][9], dificultad);
        Fijadas = new boolean[9][9];
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                Fijadas[fila][col] = (tableroLogico[fila][col] != 0);
            }
        }
    }
    
    public boolean[][] getFijadas() {
        return Fijadas;
    }
    
    public void setDesdeUI(int [][] grid) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                tableroLogico[fila][col] = grid[fila][col];
            }
        }
    }
    
    public int[][] CopiarGrid() {
        int[][] salida = new int [9][9];
        for (int fila = 0; fila < 9; fila++) {
            System.arraycopy(tableroLogico[fila], 0, salida[fila], 0, 9);
        }
        
        return salida;
    }
    
    public boolean esVictoria() {
        return ganeValido();
    }
}
