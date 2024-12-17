package Actividad11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(6000);
			while(true) {
				Socket socket=new Socket();
				socket=server.accept();
				HiloServidor hilo=new HiloServidor(socket);
				hilo.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
