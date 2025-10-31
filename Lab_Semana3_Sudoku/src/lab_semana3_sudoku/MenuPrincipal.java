/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab_semana3_sudoku;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author HP
 */
public class MenuPrincipal extends javax.swing.JFrame {

    fondoPanel fondo = new fondoPanel();

    public MenuPrincipal() {
        
        setTitle("SUDOKU");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        interfaz();
        this.setVisible(true);
    }

    private void interfaz() {
        JPanel fondo = new fondoPanel();
        fondo.setLayout(new BorderLayout());
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        //btn salir
        JButton btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Bodoni Bd BT", Font.BOLD, 20));
        btnSalir.setBackground(Color.LIGHT_GRAY);
        btnSalir.setForeground(Color.BLACK);
        Border bs = new LineBorder(Color.BLACK, 5);
        btnSalir.setBorder(bs);
        btnSalir.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnSalir.setPreferredSize(new Dimension(150, 150));
        btnSalir.setMaximumSize(new Dimension(150, 150));

        JPanel panelSuperior = new JPanel();
        panelSuperior.setOpaque(false);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(btnSalir);
        panelPrincipal.add(panelSuperior);

        JButton btnJugar = new JButton("JUGAR");
        btnJugar.setFont(new Font("Bodoni Bd BT", Font.BOLD, 20));
        btnJugar.setForeground(Color.BLACK);
        Border bj = new LineBorder(Color.BLACK, 5);
        btnJugar.setBorder(bj);
        btnJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnJugar.setPreferredSize(new Dimension(250, 50));
        btnJugar.setMaximumSize(new Dimension(250, 50));

        panelPrincipal.add(Box.createVerticalGlue());
        panelPrincipal.add(Box.createVerticalStrut(70));
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 300)));
        panelPrincipal.add(btnJugar);
        panelPrincipal.add(Box.createVerticalGlue());
        
        fondo.add(panelPrincipal, BorderLayout.CENTER);

        this.add(fondo);
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
    
    class fondoPanel extends JPanel {

        private Image img;

        @Override
        public void paint(Graphics g) {
            img = new ImageIcon(getClass().getResource("/imgFondo/fondo.jpg")).getImage();

            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
