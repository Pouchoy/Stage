package exerciceWeb3.metier;

public class Produit {
	String nom;
	double prix;
	double poids;
	int stock;
	int id;
	
	
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
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Produit() { this(0,"", 0.0, 0.0, 0);}


	public Produit(int id, String nom, double prix, double poids, int stock) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
		this.stock = stock;
	}


	
}
