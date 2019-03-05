/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.JDBC;
import Modelo.Modelo;
import Modelo.TicketVO;
import Modelo.TicketsDAO;
import Vista.VentanaFormulario;
import Vista.VentanaResponderTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class ControladorResponderTicket implements ActionListener {

    private VentanaResponderTicket vrt;
    private Modelo modelo;
    private TicketsDAO ticketDAO = new JDBC();
    VentanaFormulario formulario;
    private TicketVO ticket;

    /**
     * Constructor del controlador que se encarga de responder los tickets, el
     * Administrador de sistemas
     *
     * @param vrt
     * @param modelo
     */
    public ControladorResponderTicket(VentanaResponderTicket vrt, Modelo modelo) {
        this.vrt = vrt;
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

        if (evento.equals("Aceptar")) {
            formulario = new VentanaFormulario(modelo);
            formulario.setVisible(true);
            String valor = vrt.getjListTickets();
            ticket = modelo.devuelveDatosTickets(valor);
            formulario.setCampoIdTicket(valor);
            formulario.setCampoIdCaso(String.valueOf(ticket.getIdCaso()));
            formulario.setCampoIdADR(String.valueOf(ticket.getIdADR()));
            formulario.setCampoAsunto(String.valueOf(ticket.getAsunto()));
            formulario.setComboPrioridad(ticket.getPrioridad());
            formulario.setComboEstado(ticket.getEstado());
            formulario.setCampoDescripcion(ticket.getDescripcion());
        }

        if (evento.equals("casos")) {
            vrt.cargaLista();
        }

        if (evento.equals("admin")) {
            vrt.cargaListaTicket();
        }

    }

    /**
     * Método que devuelve un arrayList de los tickets pendientes
     *
     * @return ArrayList de Strings referentes a los diferentes casos pendientes
     */
    public ArrayList<String> getListaTicketsCasos() {
        return ticketDAO.devuelveTicketsPendientes(vrt.getjComboBoxCasos(), vrt.getjComboBoxAdr());
    }

    /**
     * Método que devuelve un arrayList de los casos
     *
     * @return ArrayList de Strings referentes a los diferentes casos
     */
    public ArrayList<String> devolverCasos() {
        return ticketDAO.devolverCasos(vrt.getjComboBoxAdr());
    }

    /**
     * Método que devuelve un arrayList de los administradores de reservas
     *
     * @return ArrayList de Strings referentes a los administradores de reservas
     */
    public ArrayList<String> devuelveListaADR() {
        return ticketDAO.devuelveListaADR();
    }

}
