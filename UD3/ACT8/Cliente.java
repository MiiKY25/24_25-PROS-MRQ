package Actividad8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {
	
	final static int PUERTO_SERVIDOR = 12346;
	final static int PUERTO_CLIENTE = 34568;
	final static byte NUMERO = 4;
	
	public static void main(String[] args) {
		try {
			DatagramSocket socketCliente = new DatagramSocket(PUERTO_CLIENTE);
			byte[] datosEnvio = String.valueOf(NUMERO).getBytes();
			InetAddress direccionServidor = InetAddress.getByName("localhost");
			DatagramPacket paqueteEnvio = new DatagramPacket(datosEnvio, datosEnvio.length, direccionServidor, PUERTO_SERVIDOR);
			socketCliente.send(paqueteEnvio);
	        
			System.out.println("Esperando respuesta...");
	        
	        byte[] datosRecepcion = new byte[1024];
	        DatagramPacket paqueteRecepcion = new DatagramPacket(datosRecepcion, datosRecepcion.length);
	          
	        socketCliente.receive(paqueteRecepcion);
	        String respuesta = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
	        String simbolo = "-";
	          
	        if (NUMERO > 0) {
	        	simbolo = "+";
	        }
	          
	        System.out.println("Esperando respuesta...: el cubo de " + simbolo + " " + Math.abs(NUMERO) + " es " + respuesta);
	        System.out.println("Adiós…");
	        
	        socketCliente.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
