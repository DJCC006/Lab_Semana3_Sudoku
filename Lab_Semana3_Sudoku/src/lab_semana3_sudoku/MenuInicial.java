/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_semana3_sudoku;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class MenuInicial {
    public MenuInicial(){
     JFrame screen = new JFrame();
     screen.setSize(800, 600);  //Tamaño standard para menus
     screen.setResizable(false);
     screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     screen.setLocationRelativeTo(null);
     screen.setLayout(null);
     
     JLabel titulo = new JLabel("SUDOKU");
     titulo.setBounds(150, 50, 700, 100);
     titulo.setBounds(150, 50, 700, 100);
     titulo.setFont(new Font("Serif", Font.BOLD, 50));
     
     
     
     
      JButton btJUGAR = new JButton("JUGAR");
     btJUGAR.setBounds(100,290, 150, 50);
     btJUGAR.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            ventanaseleccionDificultad pagina= new ventanaseleccionDificultad();
            screen.dispose();
          
        }             
     });
     
     
     JButton btSALIR = new JButton("SALIR");
     btSALIR.setBounds(300,290, 150, 50);
     btSALIR.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            screen.dispose();
        }             
     });
     
     
     
     screen.add(btJUGAR);
     screen.add(btSALIR);
     screen.add(titulo);
     screen.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        MenuInicial ventana = new MenuInicial();
    }
}
