/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.TicketVO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Beatriz Abad , Daniel Villegas , David Camacho
 */
public class AdrServidor implements Runnable {

    public static void main(String[] args) {
        new Thread().start();
    }

//    static void servidorUDP() {
//
//    }
    @Override
    public void run() {
        try {

            byte[] buffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket(12347);
            System.out.println("Rellena el formulario para enviar ticket-------");
            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
            socket.receive(recibo);

            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream in = new ObjectInputStream(bais);

            TicketVO ticket = (TicketVO) in.readObject();

            in.close();

            System.out.println("Puerto de origen " + recibo.getPort());
            System.out.println("IP de origen " + recibo.getAddress().getHostAddress());
            System.out.println("Puerto destino " + socket.getLocalPort());
            System.out.println("Objeto recibido: " + ticket.toString());

            socket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
