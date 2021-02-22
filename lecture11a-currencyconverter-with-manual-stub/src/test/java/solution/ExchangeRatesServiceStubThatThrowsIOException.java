package solution;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class ExchangeRatesServiceStubThatThrowsIOException implements
		ExchangeRatesService {

	@Override
	public ExchangeRate getRate(String source, String target) throws IOException, JsonSyntaxException {
		throw new IOException();
	}
}
