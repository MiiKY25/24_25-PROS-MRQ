package Actividad11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidor extends Thread{
	
	private Socket socket;
	
	public HiloServidor(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
	    System.out.println("Cliente Conectado.....");
	    try {
	        DataInputStream dis = new DataInputStream(socket.getInputStream());
	        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

	        while (true) {
	            String texto = dis.readUTF();
	            System.out.println("Comunico con: Socket[addr=" + socket.getInetAddress() + ",port=" + socket.getPort() + ",localport=" + socket.getLocalPort() + "]");

	            if (texto.equals("*")) { // Cliente envió '*'
	                System.out.println("Fin de la conexión con: ");
	                System.out.println("Socket[addr=" + socket.getInetAddress() + ",port=" + socket.getPort() + ",localport=" + socket.getLocalPort() + "]");
	                dos.writeUTF("*"); // Responde con '*'
	                break; // Sale del bucle
	            }

	            texto = texto.toUpperCase();
	            dos.writeUTF(texto); // Responde con texto en mayúsculas
	        }

	        dis.close();
	        dos.close();
	        socket.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	
}
