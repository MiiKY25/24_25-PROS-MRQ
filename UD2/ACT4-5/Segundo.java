package Actividades2;

public class Segundo extends Thread {
	
	public void run(){
		//Bucle de 15 repeticiones
		for (int i=1;i<=15;i++) {
			System.out.println("Segundo " + i);
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
