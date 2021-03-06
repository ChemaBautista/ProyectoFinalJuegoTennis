/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tennisgame;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Ch3ma
 */
public class Inicio extends javax.swing.JFrame {

    Tablero tablero = new Tablero();
    Eventos juegoTennis;
    Thread hiloPrincipal;
    public Inicio() {
       
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        idiomaEsp1 = new javax.swing.JRadioButton();
        idiomaEng1 = new javax.swing.JRadioButton();
        idiomaDeu1 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        idiomaEsp2 = new javax.swing.JRadioButton();
        idiomaEng2 = new javax.swing.JRadioButton();
        idiomaDeu2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecciona Idioma"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador 1"));

        buttonGroup1.add(idiomaEsp1);
        idiomaEsp1.setText("Español");
        jPanel2.add(idiomaEsp1);

        buttonGroup1.add(idiomaEng1);
        idiomaEng1.setText("English");
        jPanel2.add(idiomaEng1);

        buttonGroup1.add(idiomaDeu1);
        idiomaDeu1.setText("Deutsch");
        idiomaDeu1.setToolTipText("");
        jPanel2.add(idiomaDeu1);

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador 2"));

        buttonGroup2.add(idiomaEsp2);
        idiomaEsp2.setText("Español");
        jPanel3.add(idiomaEsp2);

        buttonGroup2.add(idiomaEng2);
        idiomaEng2.setText("English");
        jPanel3.add(idiomaEng2);

        buttonGroup2.add(idiomaDeu2);
        idiomaDeu2.setText("Deutsch");
        jPanel3.add(idiomaDeu2);

        jPanel1.add(jPanel3);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jLabel1.setText("Proyecto Final");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 309, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(layout.createSequentialGroup()
                .add(123, 123, 123)
                .add(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(25, 25, 25)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int idioma1 = 0,idioma2 = 0;
        idioma1 = (idiomaEsp1.isSelected())?0:(idiomaEng1.isSelected())?1:(idiomaDeu1.isSelected())?3:10;
        idioma2 = (idiomaEsp2.isSelected())?0:(idiomaEng2.isSelected())?1:(idiomaDeu2.isSelected())?3:10;
        
        juegoTennis = new Eventos(idioma1,idioma2);
        hiloPrincipal = new Thread(juegoTennis);
        
        iniciarJuego();
        hiloPrincipal.start();
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    public void iniciarJuego(){
        JFrame cancha = new JFrame();
	cancha.setSize(600, 400);
	cancha.setLocation(400, 200);
	cancha.setTitle("Juego Tennis");
	cancha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cancha.add(juegoTennis);
	cancha.addKeyListener(juegoTennis);
	juegoTennis.setBackground(Color.LIGHT_GRAY);
	cancha.setVisible(true);
	cancha.setResizable(false);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton idiomaDeu1;
    private javax.swing.JRadioButton idiomaDeu2;
    private javax.swing.JRadioButton idiomaEng1;
    private javax.swing.JRadioButton idiomaEng2;
    private javax.swing.JRadioButton idiomaEsp1;
    private javax.swing.JRadioButton idiomaEsp2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
