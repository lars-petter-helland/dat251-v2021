package solution;

import java.util.Currency;

public class Main {

	private static final Currency USD = Currency.getInstance("USD");
	private static final Currency NOK = Currency.getInstance("NOK");
	
	public static void main(String[] args) {
		
		MyCurrencyConverter currencyConverter = new MyCurrencyConverter();
		double amountInUsd = currencyConverter.convertAmount(100.0, NOK, USD);
		System.out.printf("%s %.3f %s%n", "100 kr =", amountInUsd, "dollar");
		
		double amountInNok = currencyConverter.convertAmount(100.0, USD, NOK);
		System.out.printf("%s %.3f %s%n", "100 dollar =", amountInNok, "kr");

	}

}
