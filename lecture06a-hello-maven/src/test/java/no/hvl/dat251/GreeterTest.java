package no.hvl.dat251;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GreeterTest {

	private Greeter greeter = new Greeter();

	@Test
	void greetingShouldContainHello() {
		assertTrue(greeter.sayHello().contains("Hello"));
	}

	@Test
	void greetingShouldSayIgnoringCase() {
		assertThat(greeter.sayHello(), equalToIgnoringCase("hello dat251! :)"));
	}
}
