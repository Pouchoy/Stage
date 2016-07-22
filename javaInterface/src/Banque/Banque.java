package Banque;

public interface Banque extends Comparable<Banque> {

	double getSolde();
	boolean retirer(double montant);
	void deposer(double montant);
}
