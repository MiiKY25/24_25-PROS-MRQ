package Actividades2;

public class Posicion implements Runnable {
	
	
	String text;
	
	public Posicion(String text) {
		this.text=text;
	}
	
	public void run() {
		for (int i=1;i<=15;i++)
			System.out.println( text+" "+ i );
	}
}