package mypackage.jwebunit;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.Before;
import org.junit.Test;

public class JWebUnitTests {
	
	private final static String BASE_URL 
			= "http://localhost:8080/lecture07-3-leapyear-jwebunit";
	private final static String START_PAGE = "/";
	private final static String RESULT_PAGE = "/result";
	
	private final static String START_PAGE_TITLE = "LeapYearVerifier";
	private final static String RESULT_PAGE_TITLE = "LeapYearVerifier Result";
	
	private final static String YEAR_FIELD_NAME = "year";
	private final static String SOME_VALID_YEAR = "1999";
	
	private final static String LINK_TO_START_PAGE_ID = "start_link";
	private final static String RESULT_MESSAGE_ID = "message";

	@Before
	public void setup() {
        setBaseUrl(BASE_URL);
	}

	@Test
	/**
	 * Test1: Verify that pressing the submit-button on the start-page brings 
	 * us to the result page.
	 */
	public void pressingSubmitButtonShouldGetResultPage() throws Exception {
        beginAt(START_PAGE);
        submit();
        assertTitleEquals(RESULT_PAGE_TITLE);
	}

	@Test
	/**
	 * Test2: Verify that the message on the result-page contains the year 
	 * that was entered on the start page.
	 */
	public void messageOnResultPageShouldContainEnteredYear() throws Exception {
        beginAt(START_PAGE);
        setTextField(YEAR_FIELD_NAME, SOME_VALID_YEAR);
        submit();
        assertTextInElement(RESULT_MESSAGE_ID, SOME_VALID_YEAR);
	}

	@Test
	/**
	 * Test3: Verify that the result-page contains a link back to the 
	 * start-page.
	 */
	public void resultPageShouldContainLinkToStartPage() throws Exception {
        beginAt(RESULT_PAGE);
        clickLink(LINK_TO_START_PAGE_ID);
        assertTextPresent("Enter year:");
        assertTitleEquals(START_PAGE_TITLE);
	}
}
