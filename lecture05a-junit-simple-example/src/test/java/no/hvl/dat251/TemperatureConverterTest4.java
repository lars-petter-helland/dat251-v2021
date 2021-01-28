package no.hvl.dat251;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TemperatureConverterTest4 {

	TemperatureConverter tc = new TemperatureConverter();

	@Test
	public void zeroCelsiusShouldBe27315Kelvin() {
		assertEquals("Message here", 273.15, tc.celciusToKelvin(0.0), Double.MIN_VALUE);
	}

	@Test
	public void oneHundredCelsiusShouldBe37315Kelvin() {
		assertEquals(373.15, tc.celciusToKelvin(100.0), Double.MIN_VALUE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void minus274CelsiusShouldThrowException() {
		tc.celciusToKelvin(-274.0);
	}

}
