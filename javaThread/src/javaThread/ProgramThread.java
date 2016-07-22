package javaThread;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ProgramThread {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("appuyez sur entrée pour commencer");
		reader.nextLine();
		
		Thread t2 = new Thread(() -> compter());
		
		Date debut = new Date();
		t2.start();
		System.out.println("--------------------------------");
		compter();
		//atend la fin du thread t2
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fin = new Date();
		System.out.println("temps ecoulé = " + (fin.getTime() - debut.getTime()));
	}
	
	public static void compter(){
		Random rd = new Random();
		double d = rd.nextDouble();
		System.out.println(d);
		for(long l = 0; l < 2000000000; l++)
		{
			d = Math.sqrt(d * Math.PI);
			if(l%100000000 == 0)
			{
				System.out.println("iteration = " + l);
			}
		}
		System.out.println("d = " + d);
	}

}
