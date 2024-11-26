package Actividad4_5;

import java.net.URI;

public class Actividad4 {
	
	private static void Visualizar(URI URI) {
		System.out.println("URI: "+URI.toString());
		System.out.println("\tHost: "+URI.getHost());
		System.out.println("\tPort: "+URI.getPort());
		System.out.println("\tPath: "+URI.getPath());
		System.out.println("\tScheme: "+URI.getScheme());
		System.out.println("\tAuthority: "+URI.getAuthority());
	}
	
	public static void main(String[] args) {
		try {
			URI uri1= new URI("http://docs.oracle.com");
			URI uri2= new URI("http://docs.oracle.com/javase/7");
			URI uri3= new URI("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");
			
			Visualizar(uri1);
			Visualizar(uri2);
			Visualizar(uri3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
