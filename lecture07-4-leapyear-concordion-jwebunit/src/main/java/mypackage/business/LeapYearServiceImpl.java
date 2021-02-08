package mypackage.business;

public class LeapYearServiceImpl implements LeapYearService {

	public boolean isLeapYear(int year) {
		
		if (year < 1583) {
			throw new RuntimeException();
		}
		return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
	}
}
