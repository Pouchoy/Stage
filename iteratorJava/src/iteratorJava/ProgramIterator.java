package iteratorJava;

public class ProgramIterator {

	public static void main(String[] args) {
		
		AdresseIPV4 myip = new AdresseIPV4(192, 168, 1, 10);
		System.out.println(myip);

		AdresseIPV4 myip2 = new AdresseIPV4("192.168.1.60");
		System.out.println(myip2);
		
	/*	IPInterval int1 = new IPInterval(myip, myip2);
		System.out.println(int1);
		
		for (IPAdress ip : int1) {
			System.out.println(ip);
		}*/
		AdresseIPV4Interval int1 = new AdresseIPV4Interval(new AdresseIPV4("192.168.4.10"), new AdresseIPV4("192.168.5.50"));
		
		for (AdresseIPV4 ip : int1) 
		{
			System.out.println(ip);
		}
	}

}
