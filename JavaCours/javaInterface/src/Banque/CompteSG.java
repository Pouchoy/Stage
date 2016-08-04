package Banque;

public class CompteSG extends SgAssets implements Banque {

	private String iban;
	private double solde;
	private String proprietaire;

	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public CompteSG(int sgIdentifiant, String iban, double solde, String proprietaire) {
		super(sgIdentifiant);
		setIban(iban);
		setSolde(solde);
		setProprietaire(proprietaire);
	}
	
	@Override
	public boolean retirer(double montant) {
		if(montant < getSolde())
		{
			setSolde(getSolde() - montant);
			return true;
		}
		return false;
	}
	
	@Override
	public void deposer(double montant) {
		setSolde(getSolde() + montant);
	}
	
	@Override
	public String toString() {
		return "CompteSG [iban=" + iban + ", solde=" + solde + ", proprietaire=" + proprietaire
				+ ", getSgIdentifiant()=" + getSgIdentifiant() + "]";
	}
	
	@Override
	public int compareTo(Banque o) {
		if(getSolde() > o.getSolde())
			return 1;
		if(getSolde() < o.getSolde())
			return -1;
		return 0;
	}
	
	
	
	
	
}
