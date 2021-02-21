package somepackage;

/**
 * {"success":true, "source":"USD", "target":"EUR", "rate":"0.8996300",
 * "amount":0.9, "message":""}
 */
public class ExchangeRate {

	boolean success;
	String source;
	String target;
	public double rate;
	double amount;
	String message;

	public ExchangeRate() {
	}

	// For use in testing with lambdas
	public ExchangeRate(double rate) {
		this.rate = rate;
	}

}
