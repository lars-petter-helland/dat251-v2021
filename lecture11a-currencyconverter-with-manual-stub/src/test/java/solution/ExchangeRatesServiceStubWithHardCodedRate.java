package solution;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class ExchangeRatesServiceStubWithHardCodedRate implements ExchangeRatesService {

	@Override
	public ExchangeRate getRate(String source, String target) throws IOException, JsonSyntaxException {
		ExchangeRate exRate = new ExchangeRate();
		
		if (source.equals("NOK") && target.equals("USD")) {
			exRate.rate = 1.0/8.3;
		}
		
		return exRate;
	}
}
