package exercice_java_4_1;

import java.util.Date;

public class TicketPanne extends Ticket {
	
	public static final String NOMATERIEL_DEFAULT = "stromstrooper";
	public static final int LOCALISATION_DEFAULT = 1;
	private String noMateriel;
	private String localisation;
	
	public String getNoMateriel() {
		return noMateriel;
	}

	public void setNoMateriel(String noMateriel) {
		this.noMateriel = noMateriel;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public TicketPanne(int identifiant, Date dateTicket, String description, int urgence, String noMateriel,
			String localisation) {
		super(identifiant, dateTicket, description, urgence);
		setNoMateriel(noMateriel);
		setLocalisation(localisation);
	}

	@Override
	public String toString() {
		return "TicketPanne [noMateriel=" + noMateriel + ", localisation=" + localisation + ", getIdentifiant()="
				+ getIdentifiant() + ", getDateTicket()=" + getDateTicket() + ", getDescription()=" + getDescription()
				+ ", getUrgence()=" + getUrgence() + "]";
	}

	@Override
	public String save(){
		return super.save() + ";" + getNoMateriel() + ";" + getLocalisation() ;
	}

	

}
