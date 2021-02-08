package mypackage.cukesteps;

import static com.mashape.unirest.http.Unirest.get;
import static com.mashape.unirest.http.Unirest.head;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.gson.Gson;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mypackage.MyWebService;
import mypackage.Poststed;

public class WebServiceSteps {
	
	Poststed result;
	
	@Before("@first-scenario")
	public void beforeFirstScenario() {
		System.out.println("Starting the web-service ...");
		MyWebService.start();
	}
	
	@Before
	public void beforeEachScenario() {
		System.out.println("Resetting the result to null ...");
		result = null;
	}
	
	@After("@last-scenario")
	public void afterLastScenario() {
		System.out.println("Stopping the web-service ...");
		MyWebService.shutdown();
	}
	
	@Given("^the service is up and running$")
	public void the_service_is_up_and_running() throws Throwable {
		assertNotNull(head("http://localhost:4567"));
	}

	@When("^I request the postal addresses with the postal number (\\d+)$")
	public void i_request_the_postal_addresses_with_the_postal_number(int arg1) throws Throwable {
		String s = get("http://localhost:4567/poststed/"+arg1).asString().getBody();
		result = new Gson().fromJson(s, Poststed.class);
	}

	@Then("^the poststed should be (.*)$")
	public void the_poststed_should_be(String arg1) throws Throwable {
		assertEquals(arg1, result.poststed);
	}

	@And("^the kommune should be (.*)$")
	public void the_kommune_should_be(String arg1) throws Throwable {
		assertEquals(arg1, result.kommune);
	}
}
