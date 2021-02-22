package inclass;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class RealTimeExchangeRates implements ExchangeRateService {
	
    // Home and documentation:
	// https://currency-api.appspot.com/
	//
	// Example URL:
    // https://currency-api.appspot.com/api/USD/EUR.json
	//
    // Example JSON Result:
    // {"success":true,
	//	"source":"USD",
	//	"target":"EUR",
	//	"rate":"0.8996300",
	//	"amount":0.9,
	//	"message":""}
	
	@Override
	public ExchangeRate getRate(String source, String target) 
			throws IOException, JsonSyntaxException {
        
    	String baseUrl = "https://currency-api.appspot.com/api/";
    	String format = "json";
    	
        String queryString = baseUrl + source + "/" + target + "." + format;
        
        URL googleCcApiUrl = new URL(queryString);
        Reader apiReader = new InputStreamReader(googleCcApiUrl.openStream());

        Gson gson = new Gson();
        return gson.fromJson(apiReader, ExchangeRate.class);
    }

}
