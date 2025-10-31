/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_semana3_sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class ventanaseleccionDificultad {
    
    private int dificultad=0;
    boolean btFpressed =false;
    boolean btMpressed = false;
    boolean btDpressed = false;
    
    public ventanaseleccionDificultad(){
                 
     JFrame screen = new JFrame();
     screen.setSize(800, 600);  //Tamaño standard para menus
     screen.setResizable(false);
     screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     screen.setLocationRelativeTo(null);
     screen.setLayout(null);
        
     JLabel titulo = new JLabel("Seleccione Dificultad");
     titulo.setBounds(150, 50, 700, 100);
     titulo.setBounds(150, 50, 700, 100);
     titulo.setFont(new Font("Serif", Font.BOLD, 50));
     
     
     JButton btFacil = new JButton("Facil");
     btFacil.setBackground(Color.LIGHT_GRAY);
     btFacil.setBounds(100,290, 150, 50);
     btFacil.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            
            if(btFpressed==false){
                btFacil.setBackground(Color.red);
                btFpressed=true;
                dificultad=9;
                System.out.println("DIF: "+dificultad);
            }else{
                btFacil.setBackground(Color.LIGHT_GRAY);
                btFpressed=false;
            }
        }             
     });
     
     
     JButton btMed = new JButton("Mediana");
     btMed.setBackground(Color.LIGHT_GRAY);
     btMed.setBounds(300,290, 150, 50);
     btMed.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            
            if(btMpressed==false){
                btMed.setBackground(Color.red);
                btMpressed=true;
                dificultad=4;
                System.out.println("DIF: "+dificultad);
            }else{
                btMed.setBackground(Color.LIGHT_GRAY);
                btMpressed=false;
            }
            
            
        }             
     });


    JButton btDif = new JButton("Dificil");
    btDif.setBackground(Color.LIGHT_GRAY);
     btDif.setBounds(500,290, 150, 50);
     btDif.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            
            if(btDpressed==false){
                btDif.setBackground(Color.red);
                btDpressed=true;
                dificultad=2;
                System.out.println("DIF: "+dificultad);
            }else{
                btDif.setBackground(Color.LIGHT_GRAY);
                btDpressed=false;
            }
            
            
        }             
     });
     
     
     JButton btPlay = new JButton("Jugar");
     btPlay.setBounds(250,390, 150, 50);
     btPlay.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            System.out.println("REDIRECCIONANDO AL JUEGO");
        }             
     });
     
     
     JButton btRegresar = new JButton("Volver");
     btRegresar.setBounds(450,390, 150, 50);
     btRegresar.addActionListener(new ActionListener(){
     @Override 
     public void actionPerformed(ActionEvent e){
            MenuInicial ventana = new MenuInicial();
            screen.dispose();
        }             
     });
     
     
     screen.add(btPlay);
     screen.add(btRegresar);
     screen.add(btDif);
     screen.add(btFacil);
     screen.add(btMed);
     screen.add(titulo);
     
     screen.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        ventanaseleccionDificultad ventana = new ventanaseleccionDificultad();
    }
   
    
}
