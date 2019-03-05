/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.VentanaCasosADR;
import Vista.VentanaFormulario;
import Vista.VentanaListadoTickets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class ControladorCasos implements ActionListener {

    private VentanaFormulario vf;
    private Modelo modelo;
    private VentanaCasosADR casos;

    /**
     * Constructor del controlador de los Casos asociada a la ventana que
     * permite seleccionar los casos
     *
     * @param modelo parámetro asociado al modelo
     * @param casos parámetro asociado a la vista de los casos
     */
    public ControladorCasos(Modelo modelo, VentanaCasosADR casos) {
        this.modelo = modelo;
        this.casos = casos;
        vf = new VentanaFormulario(modelo);
    }

    /**
     * Método que recoge los eventos que se producen al interactuar con la vista
     *
     * @param e parámetro que recoge el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String evento = e.getActionCommand();

        if (casos.getjRadioButtonContinuarCaso().isSelected()) {
            if (evento.equals("Aceptar")) {
                VentanaListadoTickets ticket = new VentanaListadoTickets(modelo);
                ticket.setVisible(true);
            } else if (evento.equals("Cancelar")) {
                casos.dispose();
            }
        } else if (casos.getjRadioButtonCrearCaso().isSelected()) {
            if (evento.equals("Aceptar")) {
                if (vf.isShowing()) {
                    System.out.println("¡Tienes abierto una pestaña de ticket!");
                    System.out.println("!Envia el ticket para detener la ejecucion!");
                } else {

                    vf.setVisible(true);
                }
            } else if (evento.equals("Cancelar")) {
                casos.dispose();
            }
        }

    }

}
