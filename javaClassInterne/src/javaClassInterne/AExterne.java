package javaClassInterne;

public class AExterne {

	private static int aex1 = 0;
	private int aex2 = 0;
	
	public static class AInterne1{
		private int aint1;
		
		public AInterne1(){
			aint1 =0;
		}
		
		public void test1()
		{
			//aex1 = 42;
			//aex2 = 5;
			System.out.println("aex1 = " + aex1++);
			System.out.println("aint1 = " + aint1++);
		}
	}
	
	public static void methodeAExterne()
	{//j'ai le droit d'instancier
		AInterne2 a2 = new AInterne2();
	}
	
	//cette classe est visible que depuis AExterne
	private static class AInterne2{
		public void test1(){
			
		}
	}
	
	public class AInterne3{
		private int aint1;
		
		public AInterne3(){
			aint1 =0;
		}
		
		public void test1()
		{
			//aex1 = 42;
			//aex2 = 5;
			System.out.println("aex1 (variable statique externe) = " + aex1++);
			System.out.println("aex2 (variable instance externe) = " + aex2++);
			System.out.println("aint1(variable interne) = " + aint1++);
		}
	}
}
