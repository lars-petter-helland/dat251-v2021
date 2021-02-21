package mypackage.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LeapYearServiceTest {

	private LeapYearService leapYearService = new LeapYearServiceImpl();

	@Test
	public void normalYearsThatShouldBeLeapYears() {
		assertYearShouldBeALeapYear(1996);
		assertYearShouldBeALeapYear(2004);
		assertYearShouldBeALeapYear(2008);
		assertYearShouldBeALeapYear(2012);
	}

	@Test
	public void normalYearsThatShouldNotBeLeapYears() {
		assertYearShouldNotBeALeapYear(1583);
		assertYearShouldNotBeALeapYear(1998);
		assertYearShouldNotBeALeapYear(1999);
		assertYearShouldNotBeALeapYear(2009);
		assertYearShouldNotBeALeapYear(2010);
		assertYearShouldNotBeALeapYear(2011);
	}

	@Test
	public void specialYearsThatShouldBeLeapYears() {
		assertYearShouldBeALeapYear(1600);
		assertYearShouldBeALeapYear(2000);
	}

	@Test
	public void specialYearsThatShouldNotBeLeapYears() {
		assertYearShouldNotBeALeapYear(1700);
		assertYearShouldNotBeALeapYear(1800);
		assertYearShouldNotBeALeapYear(1900);
		assertYearShouldNotBeALeapYear(2100);
	}

//	@Test (expected = RuntimeException.class)
//	public void yearsBefore1583ShouldThrowARuntimeException() {
//			leapYearService.isLeapYear(1582);
//	}

	//-----------------------------------------------------------------------
	
	private void assertYearShouldBeALeapYear(int year) {
		assertTrue(leapYearService.isLeapYear(year), "" + year + " should be a leap year");
	}

	private void assertYearShouldNotBeALeapYear(int year) {
		assertFalse(leapYearService.isLeapYear(year), "" + year + " should not be a leap year");
	}
}
