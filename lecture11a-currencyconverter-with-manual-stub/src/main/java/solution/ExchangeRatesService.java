package solution;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public interface ExchangeRatesService {

	ExchangeRate getRate(String source, String target) throws IOException, JsonSyntaxException;

}