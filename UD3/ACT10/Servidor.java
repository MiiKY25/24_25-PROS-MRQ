package Actividad10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) {
        try {
        	DatagramSocket socket = new DatagramSocket(12348);
            System.out.println("Esperando datagrama.......");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Recibir objeto Tenista
            ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista tenista = (Tenista) ois.readObject();
            System.out.println("Recibo el objeto: " + tenista);

            System.out.println("IP de origen: " + packet.getAddress());
            System.out.println("Puerto de origen: " + packet.getPort());

            // Modificar objeto Tenista
            tenista.setApellido("Karlovic");
            tenista.setAltura(208);
            System.out.println("Envío el objeto: " + tenista);

            // Enviar objeto modificado de vuelta
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            byte[] sendData = baos.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, packet.getAddress(), packet.getPort());
            socket.send(sendPacket);

            System.out.println("Fin del servidor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
