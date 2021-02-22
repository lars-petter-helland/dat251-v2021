package solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCurrencyConverterTest {

	private static final Currency USD = Currency.getInstance("USD");
	private static final Currency NOK = Currency.getInstance("NOK");
	
	private MyCurrencyConverter currencyConverter;

	@BeforeEach
	public void createNewCurrencyConverter() {
		currencyConverter = new MyCurrencyConverter();
	}

	@Test
	public void testBasicCurrencyConversion() {
		
		// Replacing the ExchangeRatesService with a dummy implementation
		// that uses hard coded exchange rates.
		currencyConverter.setExchangeRatesService(
				new ExchangeRatesServiceStubWithHardCodedRate());
		
		assertEquals(100.0, currencyConverter.convertAmount(830.0, NOK, USD), 
				0.0000001);
	}

	@Test
	public void testZeroIsReturnedWhenIOException() {

		// Replacing the ExchangeRatesService with a dummy implementation
		// that always throws an IOException.
		currencyConverter.setExchangeRatesService(
				new ExchangeRatesServiceStubThatThrowsIOException());
		
		assertEquals(0.0, currencyConverter.convertAmount(830.0, NOK, USD), 
				Double.MIN_VALUE);
	}
}
