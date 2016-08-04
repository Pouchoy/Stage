package program;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import exercice_java_4_1.Ticket;
import exercice_java_4_1.TicketDeveloppement;
import exercice_java_4_1.TicketPanne;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {

		
		Random rd = new Random();
		
		Ticket[] peoples = new Ticket[6];
		for (int i = 0; i < peoples.length; i++) {
			if (rd.nextBoolean())
				peoples[i] = new TicketPanne( i,new Date(), "panne"+i, 2, "manque processeur", "paris");
			else
				peoples[i] = new TicketDeveloppement( i,new Date(), "panne"+i, 2, "github", 1);
		}
		for (Ticket p : peoples)
			System.out.println(p);

		System.out.println(peoples[1].save());
		
		
		//ecrire dans un fichier
		PrintWriter pw = new PrintWriter("tickets.csv");
		
		for(Ticket t : peoples)
		{
			pw.println(t.save());
		}
		pw.close();
	}

}
