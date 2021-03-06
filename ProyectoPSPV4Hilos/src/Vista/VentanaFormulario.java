/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorFormulario;
import Modelo.Modelo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class VentanaFormulario extends javax.swing.JDialog {
    
    private Modelo modelo;

    /**
     * Creates new form VentanaFormulario
     */
    public VentanaFormulario(Modelo modelo) {
        this.modelo = modelo;
        this.setTitle("Formulario");
        initComponents();
        cargarLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        
        panelFormulario = new javax.swing.JPanel();
        labelTicket = new javax.swing.JLabel();
        labelCaso = new javax.swing.JLabel();
        labelADR = new javax.swing.JLabel();
        campoIdTicket = new javax.swing.JTextField();
        campoIdCaso = new javax.swing.JTextField();
        campoIdADR = new javax.swing.JTextField();
        labelAsunto = new javax.swing.JLabel();
        labelPrioridad = new javax.swing.JLabel();
        jScrollPaneAsunto = new javax.swing.JScrollPane();
        campoAsunto = new javax.swing.JTextArea();
        comboPrioridad = new javax.swing.JComboBox<>();
        labelEstado = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        labelDescripcion = new javax.swing.JLabel();
        jScrollPaneDescripcion = new javax.swing.JScrollPane();
        campoDescripcion = new javax.swing.JTextArea();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        labelTicket.setText("Id ticket:");
        labelCaso.setText("Id caso:");
        labelADR.setText("Id ADR:");
        labelAsunto.setText("Asunto:");
        labelPrioridad.setText("Prioridad:");
        labelEstado.setText("Estado:");
        labelDescripcion.setText("Descripcion:");
        
        campoAsunto.setColumns(20);
        campoAsunto.setRows(5);
        
        jScrollPaneAsunto.setViewportView(campoAsunto);
        jScrollPaneDescripcion.setViewportView(campoDescripcion);
        
        comboPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Baja", "Media", "Alta"}));
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Abierto", "Cerrado", "Pendiente"}));
        
        campoDescripcion.setColumns(20);
        campoDescripcion.setRows(5);
        
        botonCancelar.setText("Cancelar");
        botonAceptar.setText("Aceptar");
        
        ControladorFormulario listener = new ControladorFormulario(modelo, this);
        botonAceptar.addActionListener(listener);
        botonCancelar.addActionListener(listener);
        
    }
    
    public String getBotonAceptar() {
        return botonAceptar.getText();
    }
    
    public String getBotonCancelar() {
        return botonCancelar.getText();
    }
    
    public String getCampoAsunto() {
        return campoAsunto.getText();
    }
    
    public String getCampoDescripcion() {
        return campoDescripcion.getText();
    }

    public int getCampoIdADR() {
        return Integer.valueOf(campoIdADR.getText());
    }
    
    public String getCampoIdCaso() {
        return campoIdCaso.getText();
    }
    
    public String getCampoIdTicket() {
        return campoIdTicket.getText();
    }
    
    public String getComboEstado() {
        return String.valueOf(comboEstado.getSelectedItem());
    }
    
    public String getComboPrioridad() {
        return String.valueOf(comboPrioridad.getSelectedItem());
    }
    
    public void setBotonAceptar(String botonAceptar) {
        this.botonAceptar.setText(botonAceptar);
    }
    
    public void setBotonCancelar(String botonCancelar) {
        this.botonCancelar.setText(botonCancelar);
    }
    
    public void setCampoAsunto(String campoAsunto) {
        this.campoAsunto.setText(campoAsunto);
    }
    
    public void setCampoDescripcion(String campoDescripcion) {
        this.campoDescripcion.setText(campoDescripcion);
    }
    
    public void setCampoIdADR(String campoIdADR) {
        this.campoIdADR.setText(campoIdADR);
    }
    
    public void setCampoIdCaso(String campoIdCaso) {
        this.campoIdCaso.setText(campoIdCaso);
    }
    
    public void setCampoIdTicket(String campoIdTicket) {
        this.campoIdTicket.setText(campoIdTicket);
    }
    
    public void setComboEstado(String comboEstado) {
        this.comboEstado.setSelectedItem(comboEstado);
    }
    
    public void setComboPrioridad(String comboPrioridad) {
        this.comboPrioridad.setSelectedItem(comboPrioridad);
    }
    
    public void cargarLayout() {
        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
                panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormularioLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneAsunto)
                                                .addContainerGap())
                                        .addGroup(panelFormularioLayout.createSequentialGroup()
                                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelAsunto)
                                                        .addComponent(comboPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormularioLayout.createSequentialGroup()
                                                .addComponent(labelDescripcion)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormularioLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneDescripcion)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormularioLayout.createSequentialGroup()
                                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelTicket)
                                                        .addComponent(campoIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(78, 78, 78)
                                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelCaso)
                                                        .addComponent(campoIdCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(campoIdADR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelADR))
                                                .addContainerGap())
                                        .addGroup(panelFormularioLayout.createSequentialGroup()
                                                .addComponent(labelPrioridad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelEstado)
                                                .addGap(94, 94, 94))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCancelar)
                                .addContainerGap())
        );
        panelFormularioLayout.setVerticalGroup(
                panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelCaso)
                                                .addComponent(labelADR))
                                        .addComponent(labelTicket))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoIdCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoIdADR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(labelAsunto)
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPaneAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPrioridad)
                                        .addComponent(labelEstado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(labelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonCancelar)
                                        .addComponent(botonAceptar))
                                .addGap(20, 20, 20))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
    }
    
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextArea campoAsunto;
    private javax.swing.JTextArea campoDescripcion;
    private javax.swing.JTextField campoIdADR;
    private javax.swing.JTextField campoIdCaso;
    private javax.swing.JTextField campoIdTicket;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboPrioridad;
    private javax.swing.JScrollPane jScrollPaneAsunto;
    private javax.swing.JScrollPane jScrollPaneDescripcion;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelADR;
    private javax.swing.JLabel labelAsunto;
    private javax.swing.JLabel labelCaso;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelPrioridad;
    private javax.swing.JLabel labelTicket;
    private javax.swing.JPanel panelFormulario;
    
}
