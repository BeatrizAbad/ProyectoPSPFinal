/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class CasosVO {

    private int idcaso;
    private TicketVO tickets;
    private String nombre;

    /**
     * Método que devuelve la id del caso
     *
     * @return devuelve id de tipo int
     */
    public int getIdcaso() {
        return idcaso;
    }

    /**
     * Método que devuelve el nombre del caso
     *
     * @return devuelve nombre de tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que sirve para modificar la id del caso
     *
     * @param idcaso parámetro id que será modificado
     */
    public void setIdcaso(int idcaso) {
        this.idcaso = idcaso;
    }

    /**
     * Método que sirve para modificar el nombre
     *
     * @param nombre parámetro nombre que será modificado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve un ticket
     *
     * @return devuelve ticket de tipo TicketVO
     */
    public TicketVO getTickets() {
        return tickets;
    }

    /**
     * Método que sirve para modificar la id
     *
     * @param tickets parámetro id que será modificado
     */
    public void setTickets(TicketVO tickets) {
        this.tickets = tickets;
    }

}
