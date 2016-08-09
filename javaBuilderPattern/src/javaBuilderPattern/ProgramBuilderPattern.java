package javaBuilderPattern;

import java.util.Date;

public class ProgramBuilderPattern {

	public static void main(String[] args) {
		Personne p1 = new Personne("eponge","bob",21, "","","",null);
		Personne p2 = new PersonneBuilder("eponge","bob").age(21).build();
		Personne p3 = new PersonneBuilder("star","patrick").age(25).adresse("2 rue de l'ananas").build();
	
		System.out.println(p3);
		Maison m1 = new Maison.Builder("221 baker street", new Date()).hasCheminee().nbEtage(2).nombrePiece(5).build();
		System.out.println(m1);
	}

}
