package Actividad14;

public class Actividad14 extends Thread { 
	
	public static void main(String args[]) {
	    // Se crean dos instancias de la clase Recurso
	    Recurso a = new Recurso(); 
	    Recurso b = new Recurso(); 
	    
	    // Se crean dos hilos, pasando los recursos a y b
	    Hilo h1 = new Hilo(a, b, "uno"); 
	    Hilo h2 = new Hilo(a, b, "dos"); 
	    
	    // Se inician los hilos para que ejecuten sus tareas de forma concurrente
	    h1.start();
	    h2.start(); 
	}

}
