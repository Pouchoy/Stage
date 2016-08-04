package javaClassInterne;

import javaClassInterne.AExterne.AInterne1;
import javaClassInterne.AExterne.AInterne3;

public class ProgramClassInterne {

	public static void main(String[] args) {
		AInterne1 a1 = new AExterne.AInterne1();
		a1.test1();
		AInterne1 a2 = new AExterne.AInterne1();
		a2.test1();
		
		AExterne ax1 = new AExterne();
		
		AInterne3 a3 = ax1.new AInterne3();
	}

}
