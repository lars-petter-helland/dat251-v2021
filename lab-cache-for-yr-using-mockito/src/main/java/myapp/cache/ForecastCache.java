package myapp.cache;

import java.util.HashMap;
import java.util.Map;

import myapp.domain.Forecast;

public class ForecastCache {
	
	private ForecastFetcher forecastFetcher;
	private TimestampService timestampService;
	
	private Map<String, Forecast> cache = new HashMap<>();
	
	public ForecastCache(ForecastFetcher forecastFetcher, TimestampService timestampService) {
		this.forecastFetcher = forecastFetcher;
		this.timestampService = timestampService;
	}

	public Forecast getForecastFor(String location) {
		Forecast f = cache.get(location);
		if (f == null || timestampService.hasExpired(f.getTimestamp())) {
			cache.put(location, forecastFetcher.fetchForecastFor(location));
		}
		return cache.get(location);
	}
}
