/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_semana3_sudoku;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class ventanaseleccionDificultad {
    
    public ventanaseleccionDificultad(){
                 
     JFrame screen = new JFrame();
     screen.setSize(800, 600);  //Tamaño standard para menus
     screen.setResizable(false);
     screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     screen.setLocationRelativeTo(null);
     screen.setLayout(null);
        
     JLabel titulo = new JLabel("Buscador de Empleado");
     titulo.setBounds(150, 50, 700, 100);
     titulo.setBounds(150, 50, 700, 100);
     titulo.setFont(new Font("Serif", Font.BOLD, 50));
     
    }
   
    
}
