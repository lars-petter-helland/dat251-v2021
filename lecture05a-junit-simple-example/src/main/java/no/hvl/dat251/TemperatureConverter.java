package no.hvl.dat251;

public class TemperatureConverter {
	
	private double ABSOLUTE_ZERO_IN_CELCIUS = -273.15;
	
	public double celciusToKelvin(double tempInCelcius) {

		if (tempInCelcius < ABSOLUTE_ZERO_IN_CELCIUS) {
			throw new IllegalArgumentException(
					"The temperature can not be below the absolute zero.");
		}
		return tempInCelcius - ABSOLUTE_ZERO_IN_CELCIUS;
	}
}
