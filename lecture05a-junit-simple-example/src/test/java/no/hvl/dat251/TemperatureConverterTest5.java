/* 
 * http://junit.org/junit5/docs/current/user-guide/
 */

package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TemperatureConverterTest5 {
	
	TemperatureConverter tc = new TemperatureConverter();

	@Test
	void zeroCelsiusShouldBe27315Kelvin() {
		assertEquals(273.15, tc.celciusToKelvin(0.0), Double.MIN_VALUE, "Message here");
	}
	
	@Test
	void oneHundredCelsiusShouldBe37315Kelvin() {
		assertEquals(373.15, tc.celciusToKelvin(100.0), Double.MIN_VALUE);
	}

	@ParameterizedTest(name = "{0} C should be {1} K")
	@CsvSource({"0.0, 273.15",
		        "-10.0, 264.15",
				"100.0, 373.15"})
	void someCelsiusShouldBeOtherKelvin(double celcius, double kelvin) {
		assertEquals(kelvin, tc.celciusToKelvin(celcius));
	}
	
	@Test
	void minus274CelsiusShouldThrowException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, 
				() -> tc.celciusToKelvin(-274.0));
		assertEquals("The temperature can not be below the absolute zero.", 
				exception.getMessage());
	}

}
