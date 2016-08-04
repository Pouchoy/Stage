package program;

import java.util.Random;

import javaHeritage.Client;
import javaHeritage.Employe;
import javaHeritage.Personne;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Personne p1 = new Personne("kylo", "ren");
		Client c1 = new Client("Solo", "Han", "han@leboncoin.gx", -300.0);
		//p1.afficher();
		c1.afficher();
		
		//Client -> Personne : conversion implicite
		//la consersion d'enfant vers parent marche toujours donc implicite
		/*
		Personne p2 = new Client("Binks", "jarjar", "jarjar@sithlord.com", 450.0);
		p2.afficher();
		
		//parent -> enfant doit etre explicite elle peut echouer
		//si l'objet présent dans la variable parent n'est pas "compatible"
		
		
		Random rd = new Random();
		if (rd.nextBoolean())
			p2 = new Client("skywalker", "luke", "luke@jedibook.com", 200.00);
		else
			p2 = new Personne("leHut", "jabba");
		
		
		Client c2 = (Client) p2;
		if(p2 instanceof Client){
			System.out.println(c2.getEmail());
		}
		else{
			c2 = null;
			System.out.println("p2 n'est pas un client!");
		}
		*/
		
		Employe e1 = new Employe("chewbacca", "chewie", "mecanicien", 8000);
		e1.methode1();
		
		Object o1 = e1;
		
		System.out.println(e1);
		//System.out.println(p2);
		
		//Personne pers1 = new Personne("kenobi", "obiwan");
		//Personne pers2 = new Personne("kenobi", "obiwan");
		
		//System.out.println("emp1 == emp2" + (pers1 == pers2));
		//System.out.println("emp1 equals emp2" + (pers1.equals(pers2)));
		//System.out.println("hash pers1 =>" + pers1.hashCode());
		//System.out.println("hash pers2 =>" + pers2.hashCode());
		
	}

}
