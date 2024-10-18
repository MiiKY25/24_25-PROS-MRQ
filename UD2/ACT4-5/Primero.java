package Actividades2;

public class Primero extends Thread {
	
	public void run(){
		//Bucle de 15 repeticiones
		for (int i=1;i<=15;i++) {
			System.out.println("Primero " + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
