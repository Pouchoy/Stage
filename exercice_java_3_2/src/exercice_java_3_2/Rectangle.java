package exercice_java_3_2;

public class Rectangle {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return this.y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return this.x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return this.y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Rectangle(){
		this(0, 1, 0, 1);
	}
	
	public Rectangle(int x1, int y1, int x2, int y2){
		int variable = 0; 
		
		if(x1 > x2)
		{
			variable = x1;
			x1 = x2;
			x2 = variable;
		}
		
		variable = 0;
		
		if(y1 > y2)
		{
			variable = y1;
			y1 = y2;
			y2 = variable;
		}
		
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);
	}
	
	public void afficher()
	{
		int i = 0;
		int j = 0;
		
		while(i < this.y2 + 4)
		{
			while(j < this.x2 + 4)
			{
				if(i == 0 || j == 0)
					System.out.print("#");
				else if ( i >= this.x1 && i <= this.x2 && (j == y1 || j == y2) ||
						j >= this.y1 && j <= this.y2 && (i == x1 || i == x2))
					System.out.print("*");
				else 
					System.out.print(" ");
				j++;
			}
			System.out.println();
			j = 0;
			i++;
		}
		
	}
	
	public int getAire()
	{
		return (this.x2-this.x1)*(this.y2-this.y1);
	}
	
	public static boolean collision( Rectangle r1, Rectangle r2)
	{
		//si r2 est a gauche de r1(r2.x2 < r1.x1) pas de collision
		if ( r2.getX2() < r1.getX1())
			return false;
		if ( r1.getX2() < r2.getX1())//r2 est a droite de r1
			return false;
		if(r2.getY2() < r1.getY1())//r2 est au dessus de r1
			return false;
		if(r1.getY2() < r2.getY1())//r2 est en dessous de r1
			return false;
		
		return true;
	}
}

