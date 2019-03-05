/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorResponderTicket;
import Modelo.Modelo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class VentanaResponderTicket extends javax.swing.JFrame {

    private ControladorResponderTicket listener;
    private Modelo modelo;
    private DefaultListModel modeloLista;

    /**
     * Creates new form VentanaResponderTicket
     */
    public VentanaResponderTicket(Modelo modelo) {
        this.setLocationRelativeTo(null);
        this.modelo = modelo;
        initComponents();
        cargaLayout();
        cargaID();
        cargaLista();
        cargaListaTicket();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelADR = new javax.swing.JLabel();
        jComboBoxAdr = new javax.swing.JComboBox<>();
        labelCasos = new javax.swing.JLabel();
        jComboBoxCasos = new javax.swing.JComboBox<>();
        labelTicketsPendientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTickets = new javax.swing.JList<>();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelADR.setText("Administradores:");

        jComboBoxAdr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));

        labelCasos.setText("Casos:");

        jComboBoxCasos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));

        labelTicketsPendientes.setText("Tickets pendientes:");

        modeloLista = new DefaultListModel();
        jListTickets.setModel(modeloLista);
        jScrollPane1.setViewportView(jListTickets);

        botonAceptar.setText("Aceptar");

        listener = new ControladorResponderTicket(this, modelo);
        botonAceptar.addActionListener(listener);
        jComboBoxCasos.addActionListener(listener);
        jComboBoxAdr.addActionListener(listener);

        jComboBoxAdr.setActionCommand("casos");
        jComboBoxCasos.setActionCommand("admin");

    }

    public JButton getBotonAceptar() {
        return botonAceptar;
    }

    public String getjComboBoxAdr() {
        return String.valueOf(jComboBoxAdr.getSelectedItem());
    }

    public String getjComboBoxCasos() {
        return String.valueOf(jComboBoxCasos.getSelectedItem());
    }

    public String getjListTickets() {
        return jListTickets.getSelectedValue();
    }

    public void setBotonAceptar(JButton botonAceptar) {
        this.botonAceptar = botonAceptar;
    }

    public void cargaLista() {
        jComboBoxCasos.removeAllItems();
        getjComboBoxCasos();
        ArrayList<String> listaCasos = listener.devolverCasos();

        for (String string : listaCasos) {
            jComboBoxCasos.addItem(string);

        }
    }

    public void cargaID() {
        getjComboBoxAdr();
        ArrayList<String> listaIdAdr = listener.devuelveListaADR();
        for (String string : listaIdAdr) {
            jComboBoxAdr.addItem(string);
        }
    }

    public boolean cargaListaTicket() {
        boolean vacio = false;
        ArrayList<String> listaTickets = listener.getListaTicketsCasos();
        modeloLista.clear();
        if (listaTickets == null) {
            JOptionPane.showConfirmDialog(null, "No hay tickets para mostrar");
            vacio = true;
        } else {
            for (String string2 : listaTickets) {
                modeloLista.addElement(string2);
            }
        }
        return vacio;
    }

    public void cargaLayout() {

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botonAceptar)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(labelADR)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jComboBoxAdr, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(labelCasos)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jComboBoxCasos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(labelTicketsPendientes)
                                                .addComponent(jScrollPane1)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelADR)
                                        .addComponent(jComboBoxAdr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCasos)
                                        .addComponent(jComboBoxCasos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)
                                .addComponent(labelTicketsPendientes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(botonAceptar)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> jComboBoxAdr;
    private javax.swing.JComboBox<String> jComboBoxCasos;
    private javax.swing.JList<String> jListTickets;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelADR;
    private javax.swing.JLabel labelCasos;
    private javax.swing.JLabel labelTicketsPendientes;

}
