package before;

import java.util.Currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {

	private static final Currency USD = Currency.getInstance("USD");
	private static final Currency NOK = Currency.getInstance("NOK");
	
	private MyCurrencyConverter currencyConverter;

	@BeforeEach
	public void createNewCurrencyConverter() {
		currencyConverter = new MyCurrencyConverter();
	}

	@Test
	public void testBasicCurrencyConversion() {

	}

	@Test
	public void testZeroIsReturnedWhenIOException() {

	}
}
