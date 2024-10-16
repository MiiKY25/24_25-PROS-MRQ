package Actividades;

public class Actividad2 {
	
	public static void main(String[] args) {
		int n=5;
		for (int i = 0; i <= n; i++) {
			Thread hilo=new Hilo2("Hilo "+i);
			hilo.run();
		}
		System.out.println("Programa terminado");
	}
	

}
