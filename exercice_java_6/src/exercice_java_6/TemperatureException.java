package exercice_java_6;

public class TemperatureException extends RuntimeException {
	public TemperatureException() {
		super("la temperature ne peut pas etre inf�rieur � 273,15 degr� celsius");
	}
}
