package Actividad8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
	
	final static int PUERTO_SERVIDOR = 12346;
	
	public static void main(String[] args) {
       
		try {
			DatagramSocket socketServidor = new DatagramSocket(PUERTO_SERVIDOR);
			System.out.println("Esperando datagrama...");
			
	        byte[] datosRecepcion = new byte[1024];
	        
	        DatagramPacket paqueteRecepcion = new DatagramPacket(datosRecepcion, datosRecepcion.length);
	        socketServidor.receive(paqueteRecepcion);
	        String cadenaRecibida = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
	        
	        int numeroRecibido = Integer.parseInt(cadenaRecibida);
	        System.out.println("Vamos a calcular el cubo de: " + numeroRecibido);
	        
	        String ipCliente = paqueteRecepcion.getAddress().toString();
	        int puertoCliente = paqueteRecepcion.getPort();
	        
	        System.out.println("IP de origen: " + ipCliente);
	        System.out.println("Puerto de origen: " + puertoCliente);
	        
	        int cubo = numeroRecibido * numeroRecibido * numeroRecibido;
	        byte[] datosEnvio = String.valueOf(cubo).getBytes();
	        DatagramPacket paqueteEnvio = new DatagramPacket(datosEnvio, datosEnvio.length, paqueteRecepcion.getAddress(), puertoCliente);
	        
	        socketServidor.send(paqueteEnvio);
	        
	        System.out.println("Enviamos el resultado... " + cubo);
	        System.out.println("Adiósss");
	        socketServidor.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
