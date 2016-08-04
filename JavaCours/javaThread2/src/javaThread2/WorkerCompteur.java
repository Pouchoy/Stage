package javaThread2;

public class WorkerCompteur implements Runnable {

	private String nom;
	private CompteurPartage cpt;
	public String getNom(){return nom;}
	public void setNom(String nom){this.nom = nom;}
	
	public WorkerCompteur(String nom, CompteurPartage cpt)
	{
		setNom(nom);
		this.cpt = cpt;
		
	}
	
	@Override
	public void run() {
		for(long l = 0; l < 100000000; l++)
		{
			cpt.incrementCompteur();
			if(l%100000 == 0)
				System.out.println(getNom() + "iteration = " + l);
		}
	}

}
