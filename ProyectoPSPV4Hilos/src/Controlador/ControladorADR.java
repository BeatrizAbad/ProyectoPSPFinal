/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.VentanaADR;
import Vista.VentanaCasosADR;
import Vista.VentanaEnviarEmail;
import Vista.VentanaFormulario;
import Vista.VentanaListadoTickets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class ControladorADR implements ActionListener {

	private static DatagramSocket socket;
	private static final int PORT = 34562;
	private Modelo modelo;

	/**
	 * Método que devuelve un datagrama
	 *
	 * @return DatagramSocket
	 */
	public DatagramSocket getDatagramSocket() {
		return socket;
	}

	/**
	 * Crea la instancia del datagrama y le asigna un puerto
	 *
	 * @throws SocketException excepción en la creación del socket
	 */
	public void openSocket() throws SocketException {
		this.socket = new DatagramSocket(/* PORT */);
		System.out.println("Socket abierto en puerto " + socket.getPort());
	}

	/**
	 * Constructor del controlador ADR al cual se le pasa por parámetro el modelo y
	 * lo asocia
	 *
	 * @param modelo parámetro de tipo Modelo
	 */
	public ControladorADR(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * Método que recoge los eventos de botón, implementado por ActionListener
	 *
	 * @param e parámetro que recoge el evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String evento = e.getActionCommand();

		if (evento.equals("Generar Ticket")) {
			VentanaCasosADR casos = new VentanaCasosADR();
			casos.setVisible(true);
		} else if (evento.equals("Leer Tickets")) {
			VentanaListadoTickets vt = new VentanaListadoTickets(modelo);
			vt.setVisible(true);
		} else if (evento.equals("Enviar email")) {
			VentanaEnviarEmail vm = new VentanaEnviarEmail();
			vm.setVisible(true);
		}

	}

}
