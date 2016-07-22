package exercice_java_6;

public class TemperatureException extends RuntimeException {
	public TemperatureException() {
		super("la temperature ne peut pas etre inférieur à 273,15 degré celsius");
	}
}
