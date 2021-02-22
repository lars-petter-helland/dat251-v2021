package inclass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonSyntaxException;

import somepackage.ExchangeRate;
import somepackage.ExchangeRatesService;
import somepackage.MyCurrencyConverter;

@ExtendWith(MockitoExtension.class)
public class MyCurrencyConverterTest {

	private static final Currency USD = Currency.getInstance("USD");
	private static final Currency NOK = Currency.getInstance("NOK");
	
	private MyCurrencyConverter currencyConverter;
	
	@Mock
	private ExchangeRatesService ersMock;

	@BeforeEach
	public void createNewCurrencyConverter() {
		currencyConverter = new MyCurrencyConverter();
		currencyConverter.setExchangeRatesService(ersMock);
	}

	@Test
	public void testBasicCurrencyConversion() throws JsonSyntaxException, IOException {
		when(ersMock.getRate("NOK", "USD")).thenReturn(new ExchangeRate(8.4));
		assertEquals(840.0, currencyConverter.convertAmount(100.0, NOK, USD));
	}

	@Test
	public void testZeroIsReturnedWhenIOException() throws JsonSyntaxException, IOException {
		doThrow(new IOException()).when(ersMock).getRate(any(String.class), any(String.class));
		assertEquals(0.0, currencyConverter.convertAmount(830.0, NOK, USD));
	}
	
	@Test
	public void verifyThatRateServiceIsCalledOnce() throws JsonSyntaxException, IOException {
		when(ersMock.getRate("NOK", "USD")).thenReturn(new ExchangeRate(8.4));
		currencyConverter.convertAmount(100.0, NOK, USD);
		
		verify(ersMock, times(1)).getRate("NOK", "USD");
	}
}













