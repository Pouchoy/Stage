package javaCollection;

public class Paire <T1, T2>
{
	//j'utilise T1 et T2 commes des types classiques
	//dans ma classe
	//ils seront remplacés par le type qu'on lui affecte
	private T1 valeur1;
	private T2 valeur2;
	
	public T1 getValeur1() {
		return valeur1;
	}
	public void setValeur1(T1 valeur1) {
		this.valeur1 = valeur1;
	}
	public T2 getValeur2() {
		return valeur2;
	}
	public void setValeur2(T2 valeur2) {
		this.valeur2 = valeur2;
	}
	public Paire(T1 valeur1, T2 valeur2) {
		super();
		setValeur1(valeur1);
		setValeur2(valeur2);
	}
	
	@Override
	public String toString() {
		return "Paire [valeur1=" + valeur1 + ", valeur2=" + valeur2 + "]";
	}
	
	
	
	
}
