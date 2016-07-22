package javaInterface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import Banque.Banque;
import Banque.CompteLCL;
import Banque.CompteSG;

public class Program {

	public static void main(String[] args) {
		
		CompteSG c1 = new CompteSG(12345, "FR1234567890", 400.0, "capitaine");
		CompteLCL c2 = new CompteLCL("CPT123456", 300.0, "FR1234567890");

		System.out.println(c1);
		System.out.println(c2);
		
		transfert(c1,c2, 200.0);
		
		System.out.println(c1);
		System.out.println(c2);
		
		Banque ic1 = c1;
		Banque[] comptes = new Banque[10];
		Random rd = new Random();
		for(int i = 0; i < comptes.length; i++)
		{
			if(rd.nextBoolean())
				comptes[i] = new CompteSG(i, "FR33" + i, rd.nextDouble() * 1000.0, "bob" + i);
			else
				comptes[i] = new CompteLCL("CP" + i, rd.nextDouble() * 1000.0, "FR33" + i);
		} 
		System.out.println("----------------------------------");
		for(Banque ic : comptes)
			System.out.println(ic);
		
		Arrays.sort(comptes);
		
		System.out.println("----------------------------------");
		
	}

	public static boolean transfert(Banque source, Banque destination, double montant)
	{
		if(source.retirer(montant))
		{
			destination.deposer(montant);
			return true;
		}
		return false;	
	}
}
