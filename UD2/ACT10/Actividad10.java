package Actividad10;

public class Actividad10 {

    public static void main(String[] args) {
        // Crear el hilo principal y asignarle un nombre
        Thread main = new Thread();
        main.setName("main");

        // Crear una nueva instancia de hilo h1 con el nombre "Hilo-prioridad 7"
        Hilo h1 = new Hilo("Hilo-prioridad 7");
        h1.setPriority(7); // Establecer la prioridad de h1 en 7

        // Crear otra instancia de hilo h2 con el nombre "Hilo-prioridad 3"
        Hilo h2 = new Hilo("Hilo-prioridad 3");
        h2.setPriority(3); // Establecer la prioridad de h2 en 3
        
        //Imprimir mensajes
        System.out.println(main.getName() + " tiene la prioridad " + main.getPriority());
        System.out.println(h2.getName() + " tiene la prioridad " + h2.getPriority());
        System.out.println(h1.getName() + " tiene la prioridad " + h1.getPriority());

        // Iniciar los hilos h2 y h1
        h2.start();
        h1.start();

        System.out.println("Final programa");
    }

}

