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
    
    public boolean isFijado(int r, int c) {
        return Fijadas[r][c];
    }
    
    public void setDesdeUI(int [][] grid) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                tableroLogico[fila][col] = grid[fila][col];
            }
        }
    }
    
    public boolean PuedeColocar(int r, int c, int n) {
        if (n < 1 || n > 9) 
            return false;

        
        for (int j = 0; j < 9; j++) {
            if (j == c) continue;
            if (tableroLogico[r][j] == n) return false;
        }
        
        for (int i = 0; i < 9; i++) {
            if (i == r) continue;
            if (tableroLogico[i][c] == n) return false;
        }
        
        int br = (r / 3) * 3, bc = (c / 3) * 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int rr = br + i, cc = bc + j;
                if (rr == r && cc == c) continue;
                if (tableroLogico[rr][cc] == n) return false;
            }
        }       
        return true;
    }
    
    public void setvalor(int r, int c, int n) {
        tableroLogico[r][c] = n;
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
