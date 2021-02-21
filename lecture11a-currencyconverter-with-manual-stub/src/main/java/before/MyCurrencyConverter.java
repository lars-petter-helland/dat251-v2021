package before;

import java.io.IOException;
import java.util.Currency;

public class MyCurrencyConverter {

	private RealTimeExchangeRates exchangeRates = new RealTimeExchangeRates();

	/** Converts an amount from one currency to another. If the 
	 *  exchange rate is unavailable, the value 0.0 is returned. 
	 */
	public double convertAmount(double amount, Currency from, Currency to) {

		ExchangeRate exRate;
		try {
			exRate = exchangeRates.getRate(from.getCurrencyCode(), to.getCurrencyCode());
		} catch (IOException e) {
			return 0;
		}
		return amount * exRate.rate;
	}
	
}
