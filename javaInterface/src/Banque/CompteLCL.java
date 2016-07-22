package Banque;

public class CompteLCL extends LCLEntities implements Banque {

	private double solde;
	private String noIban;

	
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getNoIban() {
		return noIban;
	}

	public void setNoIban(String noIban) {
		this.noIban = noIban;
	}
		

	public CompteLCL(String entitiesNumber, double solde, String noIban) {
		super(entitiesNumber);
		setSolde(solde);
		setNoIban(noIban);
	}

	@Override
	public boolean retirer(double montant) {
		if(montant < getSolde() + 200.0)
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
		return "CompteLCL [solde=" + solde + ", noIban=" + noIban + ", getEntitiesNumber()=" + getEntitiesNumber()
				+ "]";
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
