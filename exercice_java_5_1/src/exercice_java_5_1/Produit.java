package exercice_java_5_1;

import java.util.Comparator;

public class Produit implements Comparable<Produit> {

	private final static String ACTION_NOM = "O'Neill";
	public final static double ACTION_PRIX = 100.0;
	public final static double ACTION_POIDS = 5.0;
	
	private String nom;
	private double prix;
	private double poids;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	public Produit(String nom, double prix, double poids) {
		super();
		setNom(nom);
		setPrix(prix);
		setPoids(poids);
	}
	
	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + ", poids=" + poids + "]";
	}
	
	public String toCSV()
	{
		return this.getNom() + ";" + this.getPrix() + ";" + this.getPoids();
	}
	
	public static Produit comeToCSV(String texte){
		String[] separ;
		
		separ = texte.split(";");
		if(separ.length != 3)
		{
			throw new RuntimeException("format csv produit invalide");
		}
		return new Produit(separ[0],Double.parseDouble(separ[1]), Double.parseDouble(separ[2]));
	}
	
	@Override
	public int compareTo(Produit o) {
		
		return Double.compare(this.getPrix(), o.getPrix());
	}
	
	//déclaration d'une classe interne
	public static class PoidsComparator implements Comparator<Produit>{
		public int compare(Produit o1, Produit o2)
		{
			if(o1.getPoids()< o2.getPoids())
				return -1;
			if(o1.getPoids() > o2.getPoids())
				return 1;
			return 0;
		}
	}
	
	//déclaration d'une classe interne
		public static class NomComparator implements Comparator<Produit>{
			public int compare(Produit o1, Produit o2)
			{
				return o1.getNom().compareTo(o2.getNom());
			}
		}
	
	
	
}
