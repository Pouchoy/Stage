package exercice_java_3_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Produit {

	private static final double DISCOUNT_DEFAULT = 0.05;
	
	private String denomination;
	private double prix;
	private double poids;
	private int id;	
	
	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		if (denomination.length() < 3 ||denomination.length() > 50)
			denomination = "error";
		this.denomination = denomination;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		if(prix < 0.0)
			prix = 0.0;
		this.prix = prix;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		if(poids < 0.0)
			poids = 0.0;
		this.poids = poids;
	}

	public int getId() {
		return id;
	}

	static{
		compteurId =1;
	}
	
	private static int compteurId = 0;
	public static int getCompteurId() {
		return compteurId;
	}
	
	public void affichage(){
		System.out.println(" id : " + this.id + " , denomination : " + this.denomination + " , prix : " + this.prix + " euros , poids : " + this.poids + " kg");
	}
	
	public void getPrice(int quantite)
	{
		if (quantite > 10)
		{
			System.out.println("quantite : " + quantite + " prix : " + (this.prix *(1 - DISCOUNT_DEFAULT))* quantite);
		}
	}
	
	public Produit() {
		this( "eau", 0.0, 0.0); // je rappelle l'autre constructeur
	}
	
	public Produit(String denomination, double prix, double poids) {
		compteurId++;
		this.id = compteurId;
		setDenomination(denomination);
		setPrix(prix);
		setPoids(poids);
	}
}
