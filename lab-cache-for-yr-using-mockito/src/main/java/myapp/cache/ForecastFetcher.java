package myapp.cache;

import myapp.domain.Forecast;

public interface ForecastFetcher {

	Forecast fetchForecastFor(String location);

}
