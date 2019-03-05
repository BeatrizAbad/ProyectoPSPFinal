/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorADR;
import Modelo.Modelo;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class VentanaADR extends javax.swing.JFrame {

    private static DatagramSocket socket;
    private Modelo modelo = new Modelo();
    ControladorADR listener;

    /**
     * Creates new form VentanaADR2
     */
    public VentanaADR() {
        this.setLocationRelativeTo(null);
        this.setTitle("Administrador de Reservas");
        initComponents();
        cargaLayout();
        setResizable(false);
    }

    private void initComponents() {

        generarTicket = new javax.swing.JButton();
        leerTicket = new javax.swing.JButton();
        enviarEmail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generarTicket.setText("Generar Ticket");
        leerTicket.setText("Leer Tickets");
        enviarEmail.setText("Enviar email");
        
        listener = new ControladorADR(modelo);
        generarTicket.addActionListener(listener);
        leerTicket.addActionListener(listener);
        enviarEmail.addActionListener(listener);
        
        try {
            listener.openSocket();
        } catch (SocketException ex) {
            Logger.getLogger(VentanaADR.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getEnviarEmail() {
        return enviarEmail.getText();
    }

    public String getLeerTicket() {
        return leerTicket.getText();
    }

    public void setEnviarEmail(String enviarEmail) {
        this.enviarEmail.setText(enviarEmail);
    }

    public void setGenerarTicket(String generarTicket) {
        this.generarTicket.setText(generarTicket);
    }

    public void setLeerTicket(String leerTicket) {
        this.leerTicket.setText(leerTicket);
    }
   
    
    public void cargaLayout() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(generarTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(leerTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(enviarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(generarTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leerTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enviarEmail)
                                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaADR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaADR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaADR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaADR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaADR().setVisible(true);
            }
        });
    }

    private javax.swing.JButton enviarEmail;
    private javax.swing.JButton generarTicket;
    private javax.swing.JButton leerTicket;

}
