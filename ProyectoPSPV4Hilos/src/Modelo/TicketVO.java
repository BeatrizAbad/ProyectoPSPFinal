/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Beatriz Abad, Daniel Villegas, David Camacho
 */
public class TicketVO implements Serializable {

    private int idTicket;
    private int idCaso;
    private int idADR;
    private String fecha;
    private String asunto;
    private String prioridad;
    private String descripcion;
    private String estado;

    /**
     * Constructor que iniciarliza la case
     * @param idTicket id del ticket
     * @param idCaso id del caso
     * @param idADR id del administrador de reserva
     * @param fecha fecha del dia del sistema
     * @param asunto asunto
     * @param prioridad prioridad
     * @param descripcion descripcion
     * @param estado estado
     */
    public TicketVO(int idTicket, int idCaso, int idADR, String fecha,
            String asunto, String prioridad, String descripcion, String estado) {
        this.idTicket = idTicket;
        this.idCaso = idCaso;
        this.idADR = idADR;
        this.fecha = fecha;
        this.asunto = asunto;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    /**
     * Constructor vacio por defecto
     */
    public TicketVO() {
    }

    /**
     * Metodo que devuelve la id del ticket
     * @return devuelve un entero con la id del ticket
     */
    public int getIdTicket() {
        return idTicket;
    }

    /**
     * Metodo que devuelve la id del caso
     * @return devuelve un entero con la id del caso
     */
    public int getIdCaso() {
        return idCaso;
    }

    /**
     * Metodo que devuelve la id del administrador
     * @return devuelve un entero con la id del administrador
     */
    public int getIdADR() {
        return idADR;
    }

    /**
     * Metodo que devuelve la fecha del ticket
     * @return devuelve un String con la fecha del ticket
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Metodo que devuelve el asunto del ticket
     * @return devuelve un String con el contenido
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Metodo que devuelve la prioridad del ticket
     * @return devuelve un String con la prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Metodo que devuelve la descripcion del ticket
     * @return devuelve un String con la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que devuelve el estado del ticket
     * @return devuelve un String con el estado del ticket
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que modifica la id del ticket
     * @param idTicket recibe un entero por parametro
     */
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * metodo que modifica la id del caso
     * @param idCaso
     */
    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    /**
     * metodo que modidica la id del administrador de reserva
     * @param idADR recive un entero por parametro
     */
    public void setIdADR(int idADR) {
        this.idADR = idADR;
    }

    /**
     * metodo que modifica la fecha del ticket
     * @param fecha recibe una cadena por parametro
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que modifica el asusnto del ticket
     * @param asunto recibe una cadena por parametro
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Metodo que modifica la prioridad del ticket
     * @param prioridad recibe una cadena por parametro
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Metodo que modifica la descripcion del ticket
     * @param descripcion recibe una cadena por parametro
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** 
     * Metodo que modifica el estado de un ticket
     * @param estado recibe una cadena por parametro
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nTicketVO{" + "\nidTicket= " + idTicket + ", \nidCaso= " + idCaso + ", \nidADR= " + idADR + ", \nfecha= " + fecha + ", \nasunto= " + asunto + ", \nprioridad= " + prioridad + ", \nestado= " + estado + ", \ndescripcion= " + descripcion + '}';
    }
}
