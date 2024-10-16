package Actividades;

public class Hilo1 extends Thread{

	private String mensaje;

    public Hilo1(String mensaje) {
        this.mensaje = mensaje;
    }

    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(mensaje + " " + i);
        }
    }
	
}
