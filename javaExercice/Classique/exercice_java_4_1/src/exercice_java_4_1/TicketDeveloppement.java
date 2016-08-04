package exercice_java_4_1;

import java.util.Date;

public class TicketDeveloppement extends Ticket {
	

	public static final String NOMLOGICIEL_DEFAULT = "stromstrooper";
	public static final int VERSION_DEFAULT = 1;
	
	private String nomLogiciel;
	private int version;
	
	public String getNomLogiciel() {
		return nomLogiciel;
	}
	
	public void setNomLogiciel(String nomLogiciel) {
		this.nomLogiciel = nomLogiciel;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TicketDeveloppement(int identifiant, Date dateTicket, String description, int urgence, String nomLogiciel,
			int version) {
		super(identifiant, dateTicket, description, urgence);
		setNomLogiciel(description);
		setVersion(urgence);
	}

	@Override
	public String toString() {
		return "TicketDeveloppement [nomLogiciel=" + nomLogiciel + ", version=" + version + ", getIdentifiant()="
				+ getIdentifiant() + ", getDateTicket()=" + format.format(getDateTicket()) + ", getDescription()=" + getDescription()
				+ ", getUrgence()=" + getUrgence() + "]";
	}
	
	@Override
	public String save(){
		return super.save() + ";" + getNomLogiciel() + ";" + getVersion() ;
	}
}
