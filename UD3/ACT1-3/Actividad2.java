package Actividad1_3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {
	
	public static void main(String[] args) {
		if (args.length==0) {
			//vacio
			System.out.println("Se necesita una URL para obtener su dirección");
		}else {
			//web encontrada
			System.out.println("Las direcciones asociadas a "+args[0]+" son:");
			try {
				InetAddress address[] = InetAddress.getAllByName(args[0]);
				for (InetAddress  addres: address) {
					System.out.println( addres );
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
}
