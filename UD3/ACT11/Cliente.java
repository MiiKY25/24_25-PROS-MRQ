package Actividad11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAMA CLIENTE INICIANDO");
        String texto = "";
        String resp = "";

        try {
            Socket socket = new Socket("localhost", 6000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            System.out.println("Introduce una cadena (escribe '*' para terminar):");
            texto = input.nextLine();

            while (!texto.equals("*")) { // Bucle principal
                dos.writeUTF(texto);
                resp = dis.readUTF();
                System.out.println(" => Respuesta: " + resp);

                System.out.println("Introduce otra cadena:");
                texto = input.nextLine();
            }

            // Envía el '*' para terminar
            dos.writeUTF(texto); // Envía '*'
            resp = dis.readUTF(); // Espera confirmación del servidor
            System.out.println(" => Respuesta: " + resp);

            System.out.println("Fin del envío....");
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }
}
