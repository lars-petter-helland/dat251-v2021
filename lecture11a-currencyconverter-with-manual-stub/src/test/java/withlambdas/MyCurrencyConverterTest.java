package withlambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
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
		currencyConverter.setExchangeRatesService((s, t) -> new ExchangeRate(100.0/830.0));
		assertEquals(100.0, currencyConverter.convertAmount(830.0, NOK, USD));
	}

	@Test
	public void testZeroIsReturnedWhenIOException() {
		currencyConverter.setExchangeRatesService((s, t) -> {throw new IOException();});
		assertEquals(0.0, currencyConverter.convertAmount(830.0, NOK, USD));
	}
}
