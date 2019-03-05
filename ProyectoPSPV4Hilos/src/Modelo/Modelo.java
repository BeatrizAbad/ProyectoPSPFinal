/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class Modelo {

    private TicketsDAO ticket;

    public Modelo() {
        this.ticket = new JDBC();
    }

    public boolean altaTicket(TicketVO ticket) {
        return this.ticket.altaTicket(ticket);
    }

    public void actualizarTicket(int idticket) {
        this.ticket.actualizarTicket(idticket);
    }

    public boolean altaADR(AdministradorVO adr) {
        return this.ticket.altaADR(adr);
    }

    public boolean compruebaADR(AdministradorVO adr) {
        return this.ticket.compruebaADR(adr);
    }

    public TicketVO devuelveDatosTickets(String idticket) {
        return this.ticket.devuelveDatosTickets(idticket);
    }

    public ArrayList<String> devuelveTicketsPendientes(String idcaso, String idadr) {
        return this.ticket.devuelveTicketsPendientes(idcaso, idadr);
    }

    public ArrayList<String> devuelveListaADR() {
        return this.ticket.devuelveListaADR();
    }

}
