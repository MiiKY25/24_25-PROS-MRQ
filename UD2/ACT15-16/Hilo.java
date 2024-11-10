package Actividad15_16;

import java.time.LocalDateTime;

class Hilo extends Thread { 
	
	public void run(){
		for(int i=0;i<5;i++) {
			System.out.println(this.getName()+" - "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
