/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdministradorVO;
import Modelo.Modelo;
import Modelo.TicketVO;
import Vista.VentanaFormulario;
import Vista.VentanaListadoTickets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class ControladorFormulario implements ActionListener {

    private Modelo modelo;
    private VentanaFormulario vf;
    private ControladorADR controladorADR;
    Date fecha = new Date();

    /**
     * Constructor del Controlador del formulario en el que añadiremos o
     * actualizaremos datos
     *
     * @param modelo parámetro del modelo
     * @param vf parámetro de la ventana formulario asociada
     */
    public ControladorFormulario(Modelo modelo, VentanaFormulario vf) {
        this.modelo = new Modelo();
        this.vf = vf;
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

            TicketVO ticket = new TicketVO();
            AdministradorVO adr = new AdministradorVO();
            ticket.setIdTicket(Integer.valueOf(vf.getCampoIdTicket()));
            ticket.setIdCaso(Integer.valueOf(vf.getCampoIdCaso()));
            ticket.setIdADR(Integer.valueOf(vf.getCampoIdADR()));
            ticket.setAsunto(vf.getCampoAsunto());
            ticket.setPrioridad(vf.getComboPrioridad());
            ticket.setEstado(vf.getComboEstado());
            ticket.setDescripcion(vf.getCampoDescripcion());
            ticket.setFecha(String.valueOf(fecha));
            adr.setId(vf.getCampoIdADR());
            adr.setNombre("A");

            if (!modelo.compruebaADR(adr)) {
                JOptionPane.showMessageDialog(null, "No existe un administrador con esa ID, se ha creado automaticamente");
                modelo.altaADR(adr);
            }

            enviarTicketUDP(ticket);

            modelo.actualizarTicket(Integer.parseInt(vf.getCampoIdTicket()));
            System.out.println("alta");
            modelo.altaTicket(ticket);
            VentanaListadoTickets vt = new VentanaListadoTickets(modelo);
            vt.cargaListaTicket();
            System.out.println("¡Ticket enviado!");

        } else if (evento.equals("Cancelar")) {
            vf.dispose();
        }
    }

    /**
     * Método que envia un ticket por medio de un DatagramSocket, cuando se
     * envía el formulario
     *
     * @param ticket parámetro de tipo TicketVO
     */
    private void enviarTicketUDP(TicketVO ticket) {

        try {
            InetAddress destino = InetAddress.getLocalHost();
            int port = 12347;

            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream ob = new ObjectOutputStream(bs);
            ob.writeObject(ticket);
            ob.close();

            byte[] ticketParaEnviar = bs.toByteArray();

            DatagramPacket envio = new DatagramPacket(ticketParaEnviar, ticketParaEnviar.length, destino, port);

            controladorADR = new ControladorADR(modelo);
            controladorADR.openSocket();
            DatagramSocket socket = controladorADR.getDatagramSocket();

            socket.send(envio);

        } catch (UnknownHostException ex) {
            Logger.getLogger(ControladorFormulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
