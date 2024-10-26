package Actividad10;

public class Hilo extends Thread {
	
	String text;
	
	//Constuctor
	public Hilo(String text) {
		this.text=text;
	}
	
	public void run(){
		System.out.println("Ejecutando "+text);
	}
}