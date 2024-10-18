package Actividades;

public class Hilo1 extends Thread{

	private String mensaje;

	//Constructor
    public Hilo1(String mensaje) {
        this.mensaje = mensaje;
    }

    public void run() {
    	//Bucle de 20 repeticiones
        for (int i = 1; i <= 20; i++) {
            System.out.println(mensaje + " " + i);
        }
    }
	
}
