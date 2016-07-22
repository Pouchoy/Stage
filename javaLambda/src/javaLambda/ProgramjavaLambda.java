package javaLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramjavaLambda {

	public static void main(String[] args) {
		List<String> liste = new ArrayList<>();
		liste.add("au revoir");
		liste.add("gfgdg");
		liste.add("pardon");
		liste.add("salut");
		liste.add("aieaieaie");
		liste.add("bus");
		liste.add("voiture");
		
		for(String str: liste)
		{
			System.out.println(str);
		}
		
		List<String> resultat = liste.stream()
								.filter(s -> s.length() > 5)
								.map(s -> s.toUpperCase())
								.collect(Collectors.toList());
		
		for(String str: resultat)
		{
			System.out.println(str);
		}
		
		IPalindrome p = s -> {
			int debut = 0;
			int fin = s.length() - 1;
			while(debut < fin)
			{
				if(s.charAt(debut++) != s.charAt(fin--))
					return false;
			}
			return true;
		};
		
		//List<Integer> longueurs = liste.stream().map(s -> s.length()).collect(Collectors.toList());
		
		/*
		Collections.sort(liste, (s1,s2) -> ((Integer)s1.length()).compareTo(s2.length()));
		
		System.out.println("------------------------");
		for(String str: liste){
			System.out.println(str);
		}*/
		

	}

}
