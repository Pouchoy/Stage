package javaThread3;

public class Worker1 implements Runnable {

	private String nom;
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	public Worker1(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++)
		{
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){e.printStackTrace();}
			System.out.println(getNom() + " iteration" + i);
		}
	}

}
