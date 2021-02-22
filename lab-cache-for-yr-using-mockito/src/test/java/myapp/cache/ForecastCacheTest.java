package myapp.cache;

import static org.junit.jupiter.api.Assertions.assertSame;
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
	
	private static final String BERGEN = "Bergen";
	private static final String OSLO = "Oslo";
	private static final Forecast FORECAST1_FROM_BERGEN = new Forecast(BERGEN);
	private static final Forecast FORECAST2_FROM_BERGEN = new Forecast(BERGEN);
	private static final Forecast FORECAST_FROM_OSLO = new Forecast(OSLO);
	
		// ... Maybe you can set up some test data to be reused in the tests?


	// --- Instance variables ------------------------------------------------

	@Mock private ForecastFetcher mockedForecastFetcher;
	@Mock private TimestampService mockedTimestampService;

	private ForecastCache forecastCache;

	// --- Test setup --------------------------------------------------------

	@BeforeEach
	public void setup() {
		
		// ... General setup ...
		forecastCache = new ForecastCache(
				mockedForecastFetcher, mockedTimestampService);
		
		// ... Maybe you eventually can refactor out default behavior for the 
		//     mocks, which can be overridden in test methods if needed?
		when(mockedForecastFetcher.fetchForecastFor(BERGEN))
				.thenReturn(FORECAST1_FROM_BERGEN).thenReturn(FORECAST2_FROM_BERGEN);
		when(mockedForecastFetcher.fetchForecastFor(OSLO))
				.thenReturn(FORECAST_FROM_OSLO);
		when(mockedTimestampService.hasExpired(any(Timestamp.class)))
				.thenReturn(false);
	}

	// --- The tests ---------------------------------------------------------

	@Test
	public void firstRequestShouldFetchAndReturnForcastFromYr() {
		
		assertSame(FORECAST1_FROM_BERGEN, forecastCache.getForecastFor(BERGEN));
		verify(mockedForecastFetcher, times(1)).fetchForecastFor(BERGEN);
	}
	
	
	@Test
	public void secondRequestShouldReturnForcastFromCache() {
		
		//Fetching one forecast for Bergen and storing in cache
		forecastCache.getForecastFor(BERGEN);
		
		assertSame(FORECAST1_FROM_BERGEN, forecastCache.getForecastFor(BERGEN));
		verify(mockedForecastFetcher, times(1)).fetchForecastFor(BERGEN);
	}

	@Test
	public void firstRequestToOtherLocationShouldFetch() {
		
		//Fetching one forecast for Bergen and storing in cache
		forecastCache.getForecastFor(BERGEN);

		assertSame(FORECAST_FROM_OSLO, forecastCache.getForecastFor(OSLO));
		verify(mockedForecastFetcher, times(1)).fetchForecastFor(OSLO);
	}
	
	@Test
	public void secondRequestWithExpiredTimestampBlabla() {
		
		//Fetching one forecast for Bergen and storing in cache
		forecastCache.getForecastFor(BERGEN);
		
		when(mockedTimestampService.hasExpired(any(Timestamp.class)))
				.thenReturn(true);
		
		assertSame(FORECAST2_FROM_BERGEN, forecastCache.getForecastFor(BERGEN));
		verify(mockedForecastFetcher, times(2)).fetchForecastFor(BERGEN);
	}

	
}








