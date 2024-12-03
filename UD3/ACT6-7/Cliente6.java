package Actividad6_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente6 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String host="localhost";

		int puerto = 6011;

		System.out.println("PROGRAMA CLIENTE INICIANDO");
		
		//Leer numero de la consola
		System.out.println("Introduce un número");
		int num = Integer.parseInt(scanner.nextLine());
		
		try {
			Socket Cliente = new Socket (host, puerto);
			
			// Flujo de salida al servidor para poder enviar informacion 
			DataOutputStream flujoSalida = new DataOutputStream (Cliente.getOutputStream());

			//Enviar el numero al servidor
			flujoSalida.writeUTF(num+"");
			
			// Creación del flujo de entrada del servidor
			InputStream entrada = null;
			entrada = Cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream (entrada);
		
			//Leer el numero que ha enviado el cliente
			String mensaje=flujoEntrada.readUTF();
			System.out.println("Recibiendo mensaje del servidor: ");
			System.out.println(mensaje);
			
			
			
			// Cerrar streams y sockets
			flujoEntrada.close();
			entrada.close();
			flujoSalida.close();
			Cliente.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
