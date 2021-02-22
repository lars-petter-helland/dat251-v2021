package solution;

import java.io.IOException;
import java.util.Currency;

public class MyCurrencyConverter {

	/* Loose coupled, but providing a default implementation. */
	private ExchangeRatesService exchangeRates = new RealTimeExchangeRates();

	/** Setter injection. Enables you to replace the ExchangeRatesService when testing */
	public void setExchangeRatesService(ExchangeRatesService ers) {
		this.exchangeRates = ers;
	}
	
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
