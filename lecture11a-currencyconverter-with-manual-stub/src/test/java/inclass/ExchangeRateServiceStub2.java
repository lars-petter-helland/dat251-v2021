package inclass;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class ExchangeRateServiceStub2 implements ExchangeRateService {

	@Override
	public ExchangeRate getRate(String source, String target) 
			throws IOException, JsonSyntaxException {
		throw new IOException();
	}
}
