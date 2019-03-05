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
public interface TicketsDAO {

    /**
     * Metodo que da de alta un nuevo ticket
     *
     * @param ticket recibe un objeto ticket por parametro
     * @return devuelve true o false
     */
    public boolean altaTicket(TicketVO ticket);

    /**
     * Método que actualiza un ticket
     *
     * @param idticket recibe un idticket por parámetro
     *
     */
    public void actualizarTicket(int idticket);

    /**
     * Metodo que da de alta un nuevo Administrador de reserva
     *
     * @param adr recibe un objeto administrador por parametro
     * @return devuelve true o false
     */
    public boolean altaADR(AdministradorVO adr);

    /**
     * Metodo que recoge el total de casos que hay
     *
     * @return devuelve un arraylist de casos
     */
    public ArrayList<String> devolverCasos();

    /**
     * Metodo que devuelve el total de tickets que contiene cada caso
     *
     * @return devuelve un arraylist de tickets
     */
    public ArrayList<String> devolverTicket(int idCaso);

    /**
     * Metodo que devuelve los casos que corresponden a un administrador
     *
     * @param idAdr recibe una id de administrador
     * @return devuelve una lista con los datos obtenidos de la BD
     */
    public ArrayList<String> devolverCasos(String idAdr);

    /**
     * Metodo que comprueba si el administrador de reserva existe
     *
     * @param adr recibe un objeto administrador por parametro
     * @return devuelve true o false
     */
    public boolean compruebaADR(AdministradorVO adr);

    /**
     * Metodo que recoge los datos del ticket para mostrarlos en el formularios
     *
     * @param idticket Recobe un string por parametro
     * @return devuelve un objeto TicketVO con los datos obtenidos de la BD
     */
    public TicketVO devuelveDatosTickets(String idticket);

    /**
     * Metodo que devuelve un listado de tickets pendientes de la BD
     *
     * @param idcaso recibe un String con los casos pendientes
     * @return devuelve una lista con los casos pendientes
     */
    public ArrayList<String> devuelveTicketsPendientes(String idcaso, String idadr);

    /**
     * Metodo que devuelve una lista con las id de los administradores de
     * reserva
     *
     * @return devuelve una lista con las ids obtenidas de la base de datos
     */
    public ArrayList<String> devuelveListaADR();
}
