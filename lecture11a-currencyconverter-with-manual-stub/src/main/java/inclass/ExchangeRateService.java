package inclass;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

@FunctionalInterface
public interface ExchangeRateService {
	
	ExchangeRate getRate(String source, String target)
			throws IOException, JsonSyntaxException;
}
