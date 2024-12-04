package Actividad6_7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor7 {
	
	public static void main(String[] args) {
		System.out.println("Esperando a los clientes.....");
		try {
			ServerSocket s=new ServerSocket(6013);
			for(int i=1;i<4;i++) {
				Socket cli=s.accept();
				DataOutputStream dos=new DataOutputStream(cli.getOutputStream());
				dos.writeUTF("Hola cliente "+i);
				dos.close();
				cli.close();
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
