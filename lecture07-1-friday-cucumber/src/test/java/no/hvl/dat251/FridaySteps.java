package no.hvl.dat251;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.no.Gitt;
import io.cucumber.java.no.Når;
import io.cucumber.java.no.Så;

public class FridaySteps {

	private String iDag;
	private String gittSvar;

	@Gitt("at det er {string} i dag")
	public void at_det_er_spmdag_i_dag(String dag) {
		iDag = dag;
	}
	
	@Når("jeg spør om det er blitt fredag nå")
	public void jeg_spør_om_det_er_blitt_fredag_nå() {
		gittSvar = ErDetFredag.erDetFredag(iDag);
	}

	@Så("skal svaret være {string}")
	public void skal_svaret_være(String fasit) {
		assertEquals(fasit, gittSvar);
	}
}
