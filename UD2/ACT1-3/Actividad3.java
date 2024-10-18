package Actividades;

public class Actividad3 {
	
	public static void main(String[] args) {
		//Creamos el Thread
		Thread t=new Thread();
		
		System.out.println("El nombre del hilo es "+t.getName()+" y tiene la prioridad "+t.getPriority());
		//Cambiamos los datos
		t.setName("SUPER-HILO-DM2");
		t.setPriority(6);
		System.out.println("Ahora el nombre del hilo es "+t.getName()+" y tiene la prioridad "+t.getPriority());
		System.out.println("Final del programa");
		
	}

}
