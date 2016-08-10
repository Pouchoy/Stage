package iteratorJava;

import java.util.Arrays;

public class AdresseIPV4 implements Comparable<AdresseIPV4> {
	private short[] parts;
	
	
	public AdresseIPV4(String adress){
		String[] champs = adress.split("[.]");
		parts = new short[4];
		parts[0] = Short.parseShort(champs[0]);
		parts[1] = Short.parseShort(champs[1]);
		parts[2] = Short.parseShort(champs[2]);
		parts[3] = Short.parseShort(champs[3]);
	}
	
	public AdresseIPV4(int a, int b, int c, int d){
		parts = new short[4];
		parts[0] = (short)a;
		parts[1] = (short)b;
		parts[2] = (short)c;
		parts[3] = (short)d;
	}
	
	public AdresseIPV4 successor(){
		short[] newParts = parts.clone();
		for(int i = 3; i >= 0; i--){
			newParts[i]=(short)(parts[i] + 1);
			if(newParts[i] <= 255)
				break;
			newParts[i] = 0;
		}
		return new AdresseIPV4(newParts[0], newParts[1], newParts[2], newParts[3]);
	}

	public AdresseIPV4 predecessor(){
		short[] newParts = parts.clone();
		for(int i = 3; i >= 0; i--){
			newParts[i]=(short)(parts[i] - 1);
			if(newParts[i] >= 0)
				break;
			newParts[i] = 255;
		}
		return new AdresseIPV4(newParts[0], newParts[1], newParts[2], newParts[3]);
	}
	
	@Override
	public String toString() {
		return "AdresseIPV4 : " + parts[0] + "."  + parts[1] + "."  + parts[2] + "."  + parts[3];
	}

	@Override
	public int compareTo(AdresseIPV4 o) {
		for(int i = 0; i < parts.length; i++)
		{
			if(parts[i] > o.parts[i])
				return 1;
			if(parts[i] < o.parts[i])
				return -1;
		}
		return 0;
	}

	
	
}
