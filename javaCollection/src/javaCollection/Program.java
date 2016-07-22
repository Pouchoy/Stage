package javaCollection;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

	public static void main(String[] args) {
		
		ArrayList tab = new ArrayList();

		tab.add("lundi");
		tab.add("mardi");
		tab.add("mercredi");
	
		for(Object str: tab)
			System.out.println(str);
		
		System.out.println("taille tab = " + tab.size());
		
		System.out.println("------------------------------");
		
		tab.add(0, "bonjour");
		
		for(Object str: tab)
			System.out.println(str);
		
		tab.remove(2);
		System.out.println("------------------------------");
		for(Object str: tab)
			System.out.println(str);
		
		String resultat = (String) tab.get(0) + (String) tab.get(1);
	
		ArrayList<String> tab2 = new ArrayList<>();
		
		tab2.add("janvier");
		tab2.add("fevrier");
		
		//tableau associatif
		HashMap<String, Double> map = new HashMap<>();
		map.put("vincent", 45.5);
		map.put("john", 75.1);
		map.put("arnold", 88.1);
		
		
		System.out.println(map.get("john"));
	
		Paire<String, Double> paire1 = new Paire<String, Double>("hello", 5.5);
		System.out.println(paire1);
		
		FenetreList f1 = new FenetreList();
		f1.setVisible(true);
		
	}
	

}
