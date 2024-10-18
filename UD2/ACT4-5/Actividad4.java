package Actividades2;

public class Actividad4 {
	
	public static void main(String[] args) {
		new Thread(new Posicion("Primero")).start();
		new Thread(new Posicion("Segundo")).start();
		System.out.println("Final Programa");
	}
	
}
