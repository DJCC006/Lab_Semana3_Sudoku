/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_semana3_sudoku;
import java.util.Random;
/**
 *
 * @author David
 */
public abstract class GeneradorTableroLogic {
    
    protected int[][] tableroLogico;
    
    public GeneradorTableroLogic(){
        tableroLogico= new int[9][9];
        
    }
    
    
    
    private void genNumerosIniciales(int[][] tableroLogico){
        //gen 4 numeros random
        //filas y columnas random
        Random rand= new Random();
        int prevfilaRand=0;
        int prevcolumnaRand=0;
        for(int i=0; i<5; i++){
            int numInit = rand.nextInt(9)+1;
            int filaRand = rand.nextInt(9)+1;
            int columnaRand = rand.nextInt(9)+1;
            if(filaRand != prevfilaRand && columnaRand != prevcolumnaRand){
                tableroLogico[filaRand-1][columnaRand-1]= numInit;
                System.out.println("Num Gen: "+numInit+ "En "+filaRand+","+columnaRand);
                prevfilaRand= filaRand;
                prevcolumnaRand= columnaRand;
            }
        }  
    }
    
    private void printTableroLogico(){
        //testing only
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(tableroLogico[i][j]==0){
                    System.out.print(" - ");
                }else{
                    System.out.println(" "+tableroLogico[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
    
    public int[][] getTableroLogico(){
        return tableroLogico;
    }
    
    
//    
//    public static void main(String[] args) {
//        
//        
//        genNumerosIniciales(tableroLogico);
//        printTableroLogico();
//    }
    
}
