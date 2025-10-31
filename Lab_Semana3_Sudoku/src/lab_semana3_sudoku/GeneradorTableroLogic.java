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
    protected int dificultad;//entre mas facil sea la dificultad, mas numeros iniciales son agregados
    
    public GeneradorTableroLogic(int[][] arregloTablero, int dificultad){
        tableroLogico= arregloTablero;
        this.dificultad=dificultad;
        genNumerosIniciales();
        
    }
    
    
    
    private void genNumerosIniciales(){
        //gen 4 numeros random
        //filas y columnas random
        Random rand= new Random();
        int prevfilaRand=1;
        int prevcolumnaRand=1;
        for(int i=0; i<dificultad; i++){
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
    
    public void printTableroLogico(){
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
    
    public void addNumero(int fila, int columna, int num){//agreguar valores reales
        tableroLogico[fila-1][columna-1]= num;
    }
    
    
    private boolean validacionFilas(int[][] tableroLogico){
        for(int i=0; i<9; i++){
            boolean[]vistoYa= new boolean[10];
            
            for(int j=0; j<9; j++){
                int num = tableroLogico[i][j];
                
                if(num>=1 && num<=9){
                    
                    if(vistoYa[num]){
                        return false;//Este numero ya se repitio
                    }
                    vistoYa[num]= true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean validacionColumnas(int[][] tableroLogico){
        for(int j=0; j<9; j++){
            boolean[] vistoYa= new boolean[10];
            
            for(int i=0; i<9; i++){
                int num= tableroLogico[i][j];
                
                if(num>= 1 && num<=9){
                    if(vistoYa[num]){
                        return false;
                    }
                    vistoYa[num]=true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean validacionCajas(int[][] tableroLogico){
        for(int k=0; k<9; k++){
            boolean[] vistoYa = new boolean[10];
            
            
            int nuevaFila= (k/3)*3;
            int nuevaColumna= (k%3)*3;
            
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                 
                    int num = tableroLogico[nuevaFila+i][nuevaColumna+j];
                    if(num>=1 && num<=9){
                        if(vistoYa[num]){
                            return false;
                        }
                        vistoYa[num]=true;
                    }else{
                        return false;
                    }
                }
            }
            
        }
        
        return true;
    }
    
    
    public  boolean ganeValido(){
        boolean validacionFilas = validacionFilas(tableroLogico);
        boolean validacionColumnas= validacionColumnas(tableroLogico);
        boolean validacionCajas=validacionCajas(tableroLogico);
        
        
        if(validacionFilas== true && validacionColumnas == true && validacionCajas== true){
            return true;
        }
        return false;
        
    }
    
    
}
