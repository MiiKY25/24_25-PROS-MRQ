package Actividades;

import java.util.Iterator;

public class Hilo2 extends Thread{
	
	//Constructor
	public Hilo2 (String str) {
		super(str);
	}
	
	public void run() {
		//Bucle de 20 repeticiones
		for (int i = 0; i < 20; i++) {
			System.out.println(this.getName());
			
		}
	}

}
