package exercice_java_3_2;

import java.util.Random;

import exercice_java_3_2.Rectangle;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle r1 = new Rectangle(2,3,5,8);
		System.out.println("aire  : " + r1.getAire());
		r1.afficher();
		
		Random rd = new Random();
		Rectangle[] rectangles = new Rectangle[5];
		for (int i = 0; i < rectangles.length; i++)
		{
			rectangles[i] = new Rectangle(rd.nextInt(15),
											rd.nextInt(15),
											rd.nextInt(15),
											rd.nextInt(15));
		}
		for(Rectangle r : rectangles)
		{
			System.out.println("(" + r.getX1() + ", " + r.getY1() + ", " + r.getX2() + ", " + r.getY2());
			System.out.println("en collision ? " + Rectangle.collision(r1, r));
		} 
	}

}
