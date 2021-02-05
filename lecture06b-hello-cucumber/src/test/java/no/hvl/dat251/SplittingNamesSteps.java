package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SplittingNamesSteps {
	
	String fulltNavn;
	
	@Given("Navnet er {string}")
	public void navnet_er(String fulltNavn) {
		this.fulltNavn = fulltNavn;
	}

	@When("Vi splitter navnet")
	public void vi_splitter_navnet() {
	}

	@Then("Fornavnet blir {string}")
	public void fornavnet_blir(String firstName) {
		assertEquals(firstName, NameSplitter.getFirstName(fulltNavn));
	}

	@Then("Etternavnet blir {string}")
	public void etternavnet_blir(String lastName) {
		assertEquals(lastName, NameSplitter.getLastName(fulltNavn));
	}	

}
