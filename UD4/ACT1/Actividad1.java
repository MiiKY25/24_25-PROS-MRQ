package Actividad1;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class Actividad1 {

	public static void main(String[] args) {
		
		FTPClient cliente=new FTPClient();
		String servidor="ftp.rediris.es";
		
		System.out.println("Nos conectamos a "+servidor);
		
		try {
			cliente.connect(servidor);
			boolean login=cliente.login("anonymous", "dm2");
			
			//Comprobar login
			if(login) {
				System.out.println("Login correcto");
				System.out.println("Directorio actual:"+cliente.printWorkingDirectory());
				
				boolean crear=cliente.makeDirectory("DM2PROS");
				
				//Comprobar si se ha creado el directorio
				if (crear) {
					System.out.println("Directorio creado....");
				}else {
					System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
				}
				
				boolean logout=cliente.logout();
				
				//Comprobar si podemos hacer logout
				if(logout) {
					System.out.println("Logout del servidor FTP...");
				}else {
					System.out.println("Error al hacer logout...");
				}
				
				//Desconectarnos
				cliente.disconnect();
				System.out.println("Desconectado...");
			}else {
				System.out.println("Login incorrecto…");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
