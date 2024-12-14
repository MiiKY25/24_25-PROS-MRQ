package Actividad10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) {
        try {
        	DatagramSocket socket = new DatagramSocket(34567);
            Tenista tenista = new Tenista("del Potro", 198);

            // Enviar objeto Tenista
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            byte[] sendData = baos.toByteArray();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 12348);
            socket.send(sendPacket);
            System.out.println("Envío el objeto: " + tenista);

            // Recibir objeto Tenista modificado
            System.out.println("Esperando datagrama.......");
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);

            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista receivedTenista = (Tenista) ois.readObject();
            System.out.println("He recibido el objeto: " + receivedTenista);

            System.out.println("Fin del cliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
