package Actividades;

public class Actividad1 {
	
    public static void main(String[] args) {
        Hilo1 hiloPrimero = new Hilo1("Primero");
        Hilo1 hiloSegundo = new Hilo1("Segundo");

        hiloPrimero.start();
        hiloSegundo.start();

        System.out.print("Fin programa");
    }
}

