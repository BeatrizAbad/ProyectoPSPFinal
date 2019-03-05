package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.apache.commons.net.pop3.POP3;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

public class ControladorRecibirEmail implements ActionListener {

	public static void main(String[] args) {
		String server = "pop.gmail.com";
		String username = "djcloud13.95@gmail.com";
		String password = "proyectopsp";
		int puerto = 995;

		POP3Client pop3 = new POP3Client();

		try {
			// nos conectamos al servidor
			pop3.connect(server, puerto);
			System.out.println("Conexion realizada a " + server);

			// iniciamos sesion
			if (!pop3.login(username, password)) {
				System.out.println("error al logear");
			} else {
				// obtenemos todos los mensajes en un array
				POP3MessageInfo[] men = pop3.listMessages();

				if (men == null) {
					System.out.println("Imposible recuperar mensajes");
				} else {
					System.out.println("Nº de mensajes: " + men.length);
				}
				pop3.logout();
			}

			pop3.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error " + e);
		}
	}

	public ControladorRecibirEmail() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
