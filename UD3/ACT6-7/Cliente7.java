package Actividad6_7;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente7 {
	
	public static void main(String[] args) {
		System.out.println("PROGRAMA CLIENTE INICIANDO");
		try {
				Socket s=new Socket("localhost", 6013);
				DataInputStream dis=new DataInputStream(s.getInputStream());
				System.out.println("Recibiendo mensaje del servidor:");
				System.out.println(dis.readUTF());
				dis.close();
				s.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
