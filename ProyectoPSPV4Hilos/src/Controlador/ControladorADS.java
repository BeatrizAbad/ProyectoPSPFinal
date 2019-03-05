/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.VentanaADS;
import Vista.VentanaListadoTickets;
import Vista.VentanaResponderTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class ControladorADS implements ActionListener {

    private VentanaADS ADS;
    private Modelo modelo = new Modelo();

    /**
     * Constructor del Controlador ADS, es decir, controlador del administrador
     * de sistemas
     *
     * @param ADS parámetro asociado a la Ventana del administrador de sistemas
     * @param modelo parámetro del modelo
     */
    public ControladorADS(VentanaADS ADS, Modelo modelo) {
        this.ADS = ADS;
        this.modelo = modelo;
    }

    /**
     * Método que recoge los eventos que se producen al interactuar con la vista
     *
     * @param e parámetro que recoge el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String evento = e.getActionCommand();

        if (evento.equals("Responder ticket")) {
            VentanaResponderTicket vrt = new VentanaResponderTicket(modelo);
            vrt.setVisible(true);
        } else if (evento.equals("Leer ticket")) {
            VentanaListadoTickets vl = new VentanaListadoTickets(modelo);
            if (!vl.cargaListaTicket()) {
                vl.setVisible(true);
            }
        }
    }

}
