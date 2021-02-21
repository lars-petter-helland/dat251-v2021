package myapp.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import myapp.domain.Forecast;
import myapp.domain.Timestamp;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) //To avoid errors when stubbing
												  //with different parameters
public class ForecastCacheTest {

	// --- Data values used in the tests -------------------------------------
	
		// ... Maybe you can set up some test data to be reused in the tests?


	// --- Instance variables ------------------------------------------------

	@Mock private ForecastFetcher mockedForecastFetcher;
	@Mock private TimestampService mockedTimestampService;

	private ForecastCache forecastCache;

	// --- Test setup --------------------------------------------------------

	@BeforeEach
	public void setup() {
		
		// ... General setup ...
		
		// ... Maybe you eventually can refactor out default behavior for the 
		//     mocks, which can be overridden in test methods if needed?
	}

	// --- The tests ---------------------------------------------------------

	@Test
	public void firstRequestShouldFetchAndReturnForcastFromYr() {
		//fail();
	}
	
	// ... more tests ...

}
