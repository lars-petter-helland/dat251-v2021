package mypackage;

import static spark.Spark.get;
import static spark.Spark.stop;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyWebService {

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		
		// My own stuff
		ReadFromFile readFromFile = new ReadFromFile();
		Map<String, Poststed> poststeder = readFromFile.fetchPoststeder();
		
		// Gson for JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// Using http://sparkjava.com/
		get("/poststed/:postnr",
				(request, response) -> {
					response.type("application/json");
					return poststeder.get(request.params(":postnr"));}, 
				gson::toJson);
	}
	
	public static void shutdown() {
		stop();
	}
}
