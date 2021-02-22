package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import somepackage.ExchangeRate;
import somepackage.ExchangeRatesService;
import somepackage.MyCurrencyConverter;

@ExtendWith(MockitoExtension.class)
public class MyCurrencyConverterTest {

	private static final Currency NOK = Currency.getInstance("NOK");
	private static final Currency USD = Currency.getInstance("USD");

	@Mock
	private ExchangeRatesService service;

	private MyCurrencyConverter currencyConverter;

	@BeforeEach
	public void setup() {
		currencyConverter = new MyCurrencyConverter();
		currencyConverter.setExchangeRatesService(service);
	}

	@Test
	public void testBasicCurrencyConversion() throws IOException {
		when(service.getRate("NOK", "USD")).thenReturn(new ExchangeRate(100.0/830.0));
		assertEquals(100.0, currencyConverter.convertAmount(830, NOK, USD));
	}

	@Test
	public void testZeroIsReturnedWhenIOException() throws IOException {
		doThrow(new IOException()).when(service).getRate(any(String.class), any(String.class));
		assertEquals(0.0, currencyConverter.convertAmount(800, NOK, USD), Double.MIN_VALUE);
	}

	@Test
	public void verifyThatGetRateWillBeCalledOnce() throws IOException {

		when(service.getRate(any(String.class), any(String.class)))
				.thenReturn(new ExchangeRate(100.0/830.0));

		currencyConverter.convertAmount(800, NOK, USD);

		verify(service, times(1)).getRate("NOK", "USD");
	}

}
