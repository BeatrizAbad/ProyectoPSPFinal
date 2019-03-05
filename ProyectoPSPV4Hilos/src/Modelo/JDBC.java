/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class JDBC implements TicketsDAO {

    Connection conn;
    Conexion connect;
    Statement comando;

    /**
     * Constructor JDBC que inicia y realiza la conexión, lanza una excepción si
     * no conecta
     */
    public JDBC() {
        connect = new Conexion();
        conn = connect.getConnection();
        try {
            comando = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que da de alta un ticket en la BD implementado por la clase DAO
     *
     * @param ticket parámetro de tipo TicketVO
     * @return devuelve true si se ha insertado con éxito
     */
    @Override
    public boolean altaTicket(TicketVO ticket) {

        try {
            comando.executeUpdate("insert into tickets(idticket, idcaso, idadr, fecha, asunto, prioridad, descripcion, estado) values (" + ticket.getIdTicket() + "," + ticket.getIdCaso() + "," + ticket.getIdADR() + ",'" + ticket.getFecha() + "','" + ticket.getAsunto() + "','" + ticket.getPrioridad() + "', '" + ticket.getDescripcion() + "','" + ticket.getEstado() + "')");

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la sentencia: " + e.getMessage());
            return false;
        }

    }

    /**
     * Método que actualiza un ticket en la BD implementado por la clase DAO
     *
     * @param idticket parámetro de tipo int
     */
    @Override
    public void actualizarTicket(int idticket) {

        try {
            comando.executeUpdate("delete from tickets where idticket = " + idticket);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la sentencia: " + e.getMessage());

        }
    }

    /**
     * Método que da de alta al administrador de reservas en la BD implementado
     * por la clase DAO
     *
     * @param adr parámetro de tipo AdministradorVO
     * @return devuelve true si se ha insertado con éxito
     */
    @Override
    public boolean altaADR(AdministradorVO adr) {
        try {
            comando.executeUpdate("insert into administrador(idadr) values (" + adr.getId() + ")");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la sentencia SQL" + e.getMessage());
            return false;
        }
    }

    /**
     * Método que devuelve el número de casos
     *
     * @return devuelve un ArrayList de String en el que se guardan los casos
     * recogidos
     */
    @Override
    public ArrayList<String> devolverCasos() {
        ArrayList<String> casos = new ArrayList<>();

        try {

            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("select distinct idcaso from tickets");
            while (registro.next()) {
                casos.add(registro.getString("idcaso"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga de lista" + e.getMessage());
        }
        return casos;
    }

    /**
     * Metodo que devuelve el total de tickets que contiene cada caso
     *
     * @param idCaso de tipo int
     * @return devuelve un arraylist de tickets
     */
    @Override
    public ArrayList<String> devolverTicket(int idCaso) {
        ArrayList<String> tickets = new ArrayList<>();

        try {

            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("select idticket from tickets where idcaso = " + idCaso);
            while (registro.next()) {
                tickets.add(registro.getString("idticket"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga de lista" + e.getMessage());
        }
        return tickets;
    }

    /**
     * Metodo que comprueba si el administrador de reserva existe
     *
     * @param adr recibe un objeto administrador por parametro
     * @return devuelve true o false
     */
    @Override
    public boolean compruebaADR(AdministradorVO adr) {
        boolean respuesta = false;

        try {
            ResultSet registro = comando.executeQuery("select idadr from administrador where idadr = " + adr.getId());

            if (registro.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la sentencia: " + e.getMessage());
        }

        return respuesta;
    }

    /**
     * Metodo que recoge los datos del ticket para mostrarlos en el formularios
     *
     * @param idticket Recobe un string por parametro
     * @return devuelve un objeto TicketVO con los datos obtenidos de la BD
     */
    @Override
    public TicketVO devuelveDatosTickets(String idticket) {

        TicketVO datos = new TicketVO();
        try {
            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("select * from tickets where idticket = " + idticket);

            if (registro.next()) {
                datos.setIdADR(registro.getInt(1));
                datos.setIdCaso(registro.getInt(2));
                datos.setIdADR(registro.getInt(3));
                datos.setAsunto(registro.getString(5));
                datos.setPrioridad(registro.getString(6));
                datos.setEstado(registro.getString(8));
                datos.setDescripcion(registro.getString(7));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la sentencia: " + e.getMessage());
        }
        return datos;
    }

    /**
     * Metodo que devuelve un listado de tickets pendientes de la BD
     *
     * @param idcaso recibe un String con los casos pendientes
     * @return devuelve una lista con los casos pendientes
     */
    @Override
    public ArrayList<String> devuelveTicketsPendientes(String idcaso, String idadr) {
        ArrayList<String> ticketsPendientes = new ArrayList<>();
        try {
            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("select idticket from tickets where estado = 'Pendiente' and idcaso = " + idcaso + " and idadr = " + idadr);
            while (registro.next()) {
                ticketsPendientes.add(registro.getString("idticket"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketsPendientes;
    }

    /**
     * Metodo que devuelve una lista con las id de los administradores de
     * reserva
     *
     * @return devuelve una lista con las ids obtenidas de la base de datos
     */
    @Override
    public ArrayList<String> devuelveListaADR() {
        ArrayList<String> listaAdr = new ArrayList<>();
        try {

            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("select idadr from administrador order by idadr");
            while (registro.next()) {
                listaAdr.add(registro.getString("idadr"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAdr;

    }

    /**
     * Metodo que devuelve los casos que corresponden a un administrador
     *
     * @param idAdr recibe una id de administrador
     * @return devuelve una lista con los datos obtenidos de la BD
     */
    @Override
    public ArrayList<String> devolverCasos(String idAdr) {
        ArrayList<String> casos = new ArrayList<>();
        int contador = 0;
        try {

            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("select idcaso from tickets where idadr = " + idAdr);

            while (registro.next()) {
                casos.add(registro.getString("idcaso"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga de lista" + e.getMessage());
        }
        return casos;
    }
}
