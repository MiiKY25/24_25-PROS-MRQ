package Actividad1_3;

import java.net.InetAddress;

public class Actividad3 {
	
	public static void main(String[] args) {
		if (args.length==0) {
			//vacio
			try {
				InetAddress direccion = InetAddress.getLocalHost();
				System.out.println("Dirección IP: "+direccion.getHostAddress());
				System.out.println("Nombre: "+direccion.getHostName());
				System.out.println(direccion);
				System.out.println(direccion.getHostAddress()+".");
				
				for (InetAddress ip : InetAddress.getAllByName(direccion.getHostName())) {
                    System.out.println(ip);
                }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			//web encontrada
			try {
                InetAddress direccion = InetAddress.getByName(args[0]);
                System.out.println("Dirección IP: "+direccion.getHostAddress());
                System.out.println("Nombre: "+direccion.getHostName());
                System.out.println(direccion);
                
                System.out.println(direccion.getHostAddress() + ".");
                for (InetAddress dir : InetAddress.getAllByName(direccion.getHostName())) {
                    System.out.println(dir);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}
}
