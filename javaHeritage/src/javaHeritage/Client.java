package javaHeritage;

public class Client extends Personne
{
	public static final String EMAIL_DEFAULT = "doe";
	public static final double SOLDECOMPTE_DEFAULT = 2015.20;
	
	private String email;
	private double soldeCompte;
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public double getSoldeCompte() {return soldeCompte;}
	public void setSoldeCompte(double soldeCompte) {this.soldeCompte = soldeCompte;}
	
	public Client(){ this(NOM_DEFAULT, PRENOM_DEFAULT, EMAIL_DEFAULT, SOLDECOMPTE_DEFAULT );}
	
	public Client(String nom, String prenom, String email, double soldeCompte) {
		super(nom, prenom);
		setEmail(email);
		setSoldeCompte(soldeCompte);
	}
	
	@Override //cette anotation indique au compilateur java de vérifier qu'on remplace bien une méthode existante
	public void afficher(){
		System.out.println("Client : " + getNom() + " , " + getPrenom() + ", email : " + getEmail() + ", solde :" + getSoldeCompte());
	}
	@Override
	public String toString() {
		return "Client [email=" + email + ", soldeCompte=" + soldeCompte + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + "]";
	}
	@Override
	public void contacter(String message) {
		// TODO Auto-generated method stub
		
	}
	
	
}
