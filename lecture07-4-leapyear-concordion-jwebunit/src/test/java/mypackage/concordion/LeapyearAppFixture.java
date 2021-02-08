package mypackage.concordion;

/*
 * B�r ogs� sjekke ut
 * 	http://htmlunit.sourceforge.net
 *  https://jsoup.org/
 *  
 * Det ser ut som om disse har mer p� � f� tak i innholdet, ikke bare ...?
 */

import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.getElementById;
import static net.sourceforge.jwebunit.junit.JWebUnit.getElementTextByXPath;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTextField;
import static net.sourceforge.jwebunit.junit.JWebUnit.submit;

import java.util.HashMap;
import java.util.Map;

import org.concordion.api.BeforeSpecification;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class LeapyearAppFixture {

	private final static String BASE_URL 
			= "http://localhost:8080/lecture07-4-leapyear-concordion-jwebunit";
	
	private final static String START_PAGE = "/";
	private final static String YEAR_FIELD_NAME = "year";
	public String title;
	public String message;

	@BeforeSpecification
	public void setup() {
        setBaseUrl(BASE_URL);
	}

	public void beginAtStartPage() {
		beginAt(START_PAGE);
	}

	public void enterYear(String year) {
        setTextField(YEAR_FIELD_NAME, year);
	}

	public Map<String, String> pressSubmitButton() {
		
		submit();
		
        Map<String, String> page = new HashMap<>();
        page.put("title", getElementTextByXPath("//title"));
        page.put("message", getElementById("message").getTextContent());
        
        return page;
	}
	

}