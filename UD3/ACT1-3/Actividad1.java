package Actividad1_3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {
	
	public static void main(String[] args) {
		try {
			InetAddress address[] = InetAddress.getAllByName("www.spotify.com");
			for (InetAddress  addres: address) {
				System.out.println( addres );
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
