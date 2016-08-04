package javaHeritage;

public class Employe extends Personne {

	public static final String POSTE_DEFAULT = "stromstrooper";
	public static final double SALAIRE_DEFAULT = 5000;
	private String poste;
	private double salaire;
	
	public String getPoste() {return poste;}
	public void setPoste(String poste) {this.poste = poste;}
	public double getSalaire() {return salaire;}
	public void setSalaire(double salaire) {this.salaire = salaire;}
	
	public Employe(){this(NOM_DEFAULT, PRENOM_DEFAULT, POSTE_DEFAULT, SALAIRE_DEFAULT);}
	public Employe(String nom, String prenom, String poste, double salaire) {
		super(nom, prenom);
		setPoste(poste);
		setSalaire(salaire);
		this.salaire = salaire;
	}
	
	@Override
	public void afficher(){
		System.out.println("Employe : " + this.getPoste() + ", " + this.getSalaire() + " => ");
		super.afficher();
		//super permet ici de préciser que l'on souhaite rappeller la méthode affiché de notre parent
		// et pas la notre.
		//on ne peut pas chainé super.super, on ne peut pas courcircuiter une méthode du parent si celui-ci
		//ne l'autorise pas fournissant sa propre méthode
	}
	
	//on a le droit d'augmenter la visibilité d'une méthode overridé mais pas de la réduire
	@Override
	public void methode1() {
		super.methode1();
	}
	@Override
	public String toString() {
		return "Employe [poste=" + poste + ", salaire=" + salaire + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + "]";
	}
	
	@Override
	public void contacter(String message) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public String toString() {
		return "Employe : " + getNom();
	}*/
	
	
	
	
	
	
}
