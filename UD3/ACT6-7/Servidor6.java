package Actividad6_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor6 {
	
	public static void main(String[] args) {
		
		int puerto=6011;
		
		try {
			ServerSocket servidor = new ServerSocket (puerto);

			Socket clienteConectado = null;

			System.out.println("Esperando al cliente.....");

			clienteConectado = servidor.accept();
			
			// Creación del flujo de entrada del cliente
			InputStream entrada = null;
			entrada = clienteConectado.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream (entrada);
		
			//Leer el numero que ha enviado el cliente
			int num=Integer.parseInt(flujoEntrada.readUTF());
			
			int cuadrado=num*num;
			
			// Flujo de salida al servidor
			DataOutputStream flujoSalida = new DataOutputStream (clienteConectado.getOutputStream());

			// Enviar el cuadradro al cliente 
			flujoSalida.writeUTF("\tEl cuadrado del número "+num+" es "+cuadrado);

			// Cerrar streams y sockets
			entrada.close();
			flujoEntrada.close();
			flujoSalida.close();
			clienteConectado.close();
			servidor.close(); 
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
