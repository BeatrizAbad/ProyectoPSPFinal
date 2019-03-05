package Controlador;

import Vista.VentanaEnviarEmail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.swing.JOptionPane;

import org.apache.commons.net.smtp.*;

import java.util.*;

/**
 *
 * @author Beatriz Abad, Daniel Villegas, David Camacho
 */
public class ControladorEnviarEmail implements ActionListener {

	VentanaEnviarEmail vee;

	AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

	final String miCorreo = "djcloud13.95@gmail.com";
	final String miContraseña = "proyectopsp";
	final String servidorSMTP = "smtp.gmail.com";
	final int puertoEnvio = 587;
	String mailReceptor = null;
	String asunto = null;
	String cuerpo = null;

	/**
	 * Controlador Enviar Email
	 * 
	 * @param vee
	 */
	public ControladorEnviarEmail(VentanaEnviarEmail vee) {
		this.vee = vee;

	}

	/**
	 * Enviara el email cuando se pulse enviar
	 */
	public void actionPerformed(ActionEvent ae) {
		String evento = ae.getActionCommand();
		int respuesta;
		if (evento.equals("Enviar")) {
			try {
				this.mailReceptor = vee.getTextFieldPara();
				this.asunto = vee.getjTextFieldAsunto();
				this.cuerpo = vee.getCuerpoTextArea();

				KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
				kmf.init(null, null);
				javax.net.ssl.KeyManager km = kmf.getKeyManagers()[0];

				// conexion al servidor smtp
				client.connect(servidorSMTP, puertoEnvio);
				// se establece la clave para la comunicación segura
				client.setKeyManager(km);
				respuesta = client.getReplyCode();
				if (!SMTPReply.isPositiveCompletion(respuesta)) {
					client.disconnect();
					JOptionPane.showMessageDialog(null, "CONEXIÓN RECHAZADA", "ERROR", 0);
					System.exit(1);
				}

				// se envía el commando EHLO
				client.ehlo(servidorSMTP);// obligatorio
				System.out.println("2 - " + client.getReplyString());

				// Se ejecuta el comando STARTTLS y se comprueba si es true
				if (client.execTLS()) {
					System.out.println("3 - " + client.getReplyString());

					// se realiza la autenticación con el servidor
					if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, miCorreo, miContraseña)) {
						System.out.println("4 - " + client.getReplyString());

						// se crea la cabecera
						SimpleSMTPHeader cabecera = new SimpleSMTPHeader(mailReceptor, mailReceptor, asunto);

						// el nombre de usuario y el email de origen coinciden
						client.setSender(miCorreo);
						client.addRecipient(mailReceptor);
						System.out.println("5 - " + client.getReplyString());

						// se envia DATA
						Writer writer = client.sendMessageData();
						if (writer == null) { // fallo si no encuentra el usuario al que enviar
							JOptionPane.showMessageDialog(null, "FALLO AL ENVIAR DATA.", "ERROR", 0);
							System.exit(1);
						}

						writer.write(cabecera.toString()); // cabecera
						writer.write(cuerpo);// luego mensaje
						writer.close();
						System.out.println("6 - " + client.getReplyString());

						boolean exito = client.completePendingCommand();
						System.out.println("7 - " + client.getReplyString());

						// Fallo al finalizar la transacción
						if (!exito) {
							JOptionPane.showMessageDialog(null, "FALLO AL FINALIZAR TRANSACCIÓN.", "ERROR", 0);
							System.exit(1);
						} else
							JOptionPane.showMessageDialog(null, "MENSAJE ENVIADO CON EXITO!!", "Mensaje enviado", 1);

					} else
						JOptionPane.showMessageDialog(null, "USUARIO NO AUTENTICADO.", "ERROR", 0);
				} else
					JOptionPane.showMessageDialog(null, "FALLO AL EJECUTAR  STARTTLS.", "ERROR", 0);

			} catch (IOException | NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException
					| InvalidKeyException | InvalidKeySpecException e) {
				System.out.println("error masivo " + e);
				e.printStackTrace();
			}
			try {
				client.disconnect();
			} catch (IOException f) {
				f.printStackTrace();
			}

			JOptionPane.showMessageDialog(null, "Fin del envío", "Mensaje enviado", 1);
			System.exit(0);

		}
	}

}
