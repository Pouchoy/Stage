package exercice_java_4_1;

import java.util.Date;

public abstract class Ticket {	
	private int identifiant;
	private Date dateTicket;
	private String description;
	private int urgence;
	
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public Date getDateTicket() {
		return dateTicket;
	}
	
	public void setDateTicket(Date dateTicket) {
		this.dateTicket = dateTicket;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getUrgence() {
		return urgence;
	}
	
	public void setUrgence(int urgence) {
		this.urgence = urgence;
	}

	public Ticket(int identifiant, Date dateTicket, String description, int urgence) {
		setIdentifiant(identifiant);
		setDateTicket(dateTicket);
		setDescription(description);
		setUrgence(urgence);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identifiant;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (identifiant != other.identifiant)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [identifiant=" + identifiant + ", dateTicket=" + dateTicket + ", description=" + description
				+ ", urgence=" + urgence + "]";
	}
	

	public String save(){
		return identifiant + ";" + dateTicket + ";" + description
				+ ";" + urgence ;
	}
	
}
