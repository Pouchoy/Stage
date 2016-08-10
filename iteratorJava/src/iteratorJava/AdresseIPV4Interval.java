package iteratorJava;

import java.util.Iterator;

public class AdresseIPV4Interval implements Iterable<AdresseIPV4> {
	private AdresseIPV4 debut;
	private AdresseIPV4 fin;
	
	public AdresseIPV4 getDebut() {
		return debut;
	}
	public void setDebut(AdresseIPV4 debut) {
		this.debut = debut;
	}
	public AdresseIPV4 getFin() {
		return fin;
	}
	public void setFin(AdresseIPV4 fin) {
		this.fin = fin;
	}
	
	public AdresseIPV4Interval(AdresseIPV4 debut, AdresseIPV4 fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}
	
	@Override
	public String toString() {
		return "AdresseIPV4Interval [debut=" + debut + ", fin=" + fin + "]";
	}
	
	
	@Override
	public Iterator<AdresseIPV4> iterator() {
		return new AdressIPV4Iterator();
	}
	
	
	public class AdressIPV4Iterator implements Iterator<AdresseIPV4>{
		private AdresseIPV4 currentIP;
		
		public AdressIPV4Iterator() {
			currentIP = debut.predecessor();
		}
		
		@Override
		public boolean hasNext() {
			if(currentIP.compareTo(fin)  == -1)
				return true;
			else
				return false;
		}

		@Override
		public AdresseIPV4 next() {
			currentIP = currentIP.successor();
			return currentIP;
		}
		
	}

	
	
	
}
