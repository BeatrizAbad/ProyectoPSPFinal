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
import Vista.VentanaListadoTickets;
import Vista.VentanaFormulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class ControladorTickets implements ActionListener {

    private Modelo modelo;
    private VentanaListadoTickets vt;
    private TicketsDAO ticketDAO = new JDBC();
    VentanaFormulario formulario;
    private TicketVO ticket;

    /**
     * Constructor del Controlador Tickets que está asociado a la ventana del
     * listado de Tickets existentes
     *
     * @param modelo parámetro que asocia el modelo
     * @param vt parámetro que asocia la VentanaListadoTickets
     */
    public ControladorTickets(Modelo modelo, VentanaListadoTickets vt) {
        this.modelo = modelo;
        this.vt = vt;
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
            String valor = vt.getjListTickets();
            ticket = modelo.devuelveDatosTickets(valor);
            formulario.setCampoIdTicket(valor);
            formulario.setCampoIdCaso(String.valueOf(ticket.getIdCaso()));
            formulario.setCampoIdADR(String.valueOf(ticket.getIdADR()));
            formulario.setCampoAsunto(String.valueOf(ticket.getAsunto()));
            formulario.setComboPrioridad(ticket.getPrioridad());
            formulario.setComboEstado(ticket.getEstado());
            formulario.setCampoDescripcion(ticket.getDescripcion());
        }
        vt.cargaListaTicket();
    }

    /**
     * Método que devuelve un ArrayList de los casos
     *
     * @return ArrayList de string que devuelve los casos
     */
    public ArrayList<String> getListaTicketBd() {
        return ticketDAO.devolverCasos();
    }

    /**
     * Método que devuelve un ArrayList de los tickets de un caso concreto
     *
     * @return ArrayList de string que devuelve los tickets de un caso concreto
     */
    public ArrayList<String> getListaTicketsCasos() {
        return ticketDAO.devolverTicket(Integer.valueOf(vt.getjComboBoxCasos()));
    }

    /**
     * Método que devuelve un Ticket
     *
     * @param ticket parámetro tipo TicketVO
     * @return devuelve un objeto TicketVO
     */
    public TicketVO dameTicket(TicketVO ticket) {
        return this.ticket = ticket;
    }
}
