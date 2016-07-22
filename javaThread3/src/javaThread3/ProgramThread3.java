package javaThread3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProgramThread3 {

	public static void main(String[] args) {

		ExecutorService serv = Executors.newFixedThreadPool(4);
		
		serv.submit(new Worker1("prof"));
		serv.submit(new Worker1("grincheux"));
		serv.submit(new Worker1("chanceux"));
		serv.submit(new Worker1("joyeux"));
		serv.submit(new Worker1("dormeur"));
		serv.submit(new Worker1("atchoum"));
		serv.submit(new Worker1("simplet"));
		
		System.out.println("attente de la fin du travail");
		serv.shutdown();
		try{
			serv.awaitTermination(15, TimeUnit.SECONDS);
		}
		catch(InterruptedException e){e.printStackTrace();}
		
	}

}
