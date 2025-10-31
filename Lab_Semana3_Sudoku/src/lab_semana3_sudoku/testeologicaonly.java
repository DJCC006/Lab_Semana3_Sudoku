/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_semana3_sudoku;

/**
 *
 * @author David
 */
public class testeologicaonly extends GeneradorTableroLogic{
    
    public testeologicaonly(){
        super(new int[9][9]);
        super.printTableroLogico();
    }  
    
    
    
    
    
    
    public static void main(String[] args) {
       testeologicaonly view = new testeologicaonly();
       
       
       boolean gane = view.ganeValido();
       if(gane){
           System.out.println("Ganaste");
       }else{
           System.out.println("No has ganado");
       }
       
    }
}
