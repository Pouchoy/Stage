package javaHeritage;

public abstract class Personne {
	public static final String NOM_DEFAULT = "doe";
	public static final String PRENOM_DEFAULT = "john";
	
	private String nom;
	private String prenom;
	
	public String getNom(){return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	
	public Personne(){ this(NOM_DEFAULT,PRENOM_DEFAULT);}
	
	public Personne(String nom, String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	public void afficher(){
		System.out.println("personne : " + this.getNom() + ", " + this.getPrenom());
	}
	
	protected void methode1(){
		System.out.println("methode1 de Personne");
	}
	
	public abstract void contacter(String message);
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
}
