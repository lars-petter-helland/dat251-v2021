package myapp.cache;

import myapp.domain.Timestamp;


public interface TimestampService {

	Timestamp getTimestamp();
	boolean hasExpired(Timestamp timestamp);

}
