package Actividad4_5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Actividad5 {
	
	private static void VisualizarConexión(URI URI) {
		
		try {
			HttpClient client= HttpClient.newHttpClient();
			HttpRequest request=HttpRequest.newBuilder(URI).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			System.out.println("Conexión con "+URI.getHost());
			System.out.println("==========================");
			
			System.out.println("\tMétodo toString():"+response);
			System.out.println("\tMétodo getStatusCode():"+response.statusCode());
			System.out.println("\tMétodo getContentType():"+response.headers().firstValue("Content-Type").orElse("N/A"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			URI uri= new URI("http://www.vitoria-gasteiz.com");
			
			VisualizarConexión(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}