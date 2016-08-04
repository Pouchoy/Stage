package exercice_java_6;

import exercice_java_6.TemperatureException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		try {
			double temperature= saisie_temperature();
			System.out.println("temperature : " + temperature + " Celsius");
			System.out.println("temperature : " + temperature_farenheit(temperature) + " Fahrenheit");
			System.out.println("temperature : " + temperature_kelvin(temperature) + " Kelvin");
			System.out.println();
		}
		catch (Exception ex) {
			System.out.println("ouhla, une erreur est survenue..." + ex.getMessage());
		}
		finally {
			System.out.println("nettoyage");
		}
		
		System.out.println("fin du programme");
		
	}
	
	private static double temperature_kelvin(double temperature) {
		return temperature + 273.15;
	}

	private static double temperature_farenheit(double temperature) {
		return temperature * 9/5 + 32;
	}

	public static double saisie_temperature() throws TemperatureException
	{
		Scanner reader = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("votre temperature ?");
				String saisie = reader.nextLine();
				double temperature = Double.parseDouble(saisie);
				if (temperature < -273.15) {
					TemperatureException ageex = new TemperatureException();
					throw ageex;
				}
				return temperature;
			}
			catch (NumberFormatException e) {
				System.out.println("ceci n'est pas un nombre, erreur : " + e.getMessage());
			}
			
		}
	}

	

}
