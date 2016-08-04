package javaThread2;

public class CompteurPartage {

	private int compteur;

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public void incrementCompteur(){
		int valeur = this.getCompteur();
		valeur++;
		this.compteur = valeur;
	}
}
