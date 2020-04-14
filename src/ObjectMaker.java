import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.*;
import org.json.*;

import java.util.*;

/* Author(s): Taylor Younkins */

public class ObjectMaker {

	JSONObject jsobj;

	public ObjectMaker() {

		/*
		 * Where all the objects get made
		 */

		Address address = new Address("215 N. Russell Street", "West Lafayette", "IN");
		DarkSkyJSONHandler js = new DarkSkyJSONHandler(address);
		jsobj = js.parser();

		makeDayObject();

	}

	public Day makeDayObject() {

		// int date, Precipitation dayPrecip, Temperature dayTemp, String summaryDay,
		// String summaryCurrent

		Temperature t = makeTemperatureObject();
		Precipitation p = makePrecipitationObject();

		Day d = null;

		JSONObject currently = jsobj.getJSONObject("currently");

		String currentSummary = currently.getString("summary");
		System.out.println(currentSummary);

		JSONObject daily = jsobj.getJSONObject("daily");
		String dailySummary = currently.getString("summary");

		long timeUnix = currently.getLong("time");

		Date time = new Date(timeUnix * 1000);
		System.out.println(time.toString());

		d = new Day(time, p, t, dailySummary, currentSummary);

		return d;
	}

	public Temperature makeTemperatureObject() {

		// (double minTemp, double maxTemp, double lowTemp, double highTemp, double
		// currentTemp, double feelsLike
		
		//possible needs an array of 24 temperature objects. OR we loop through HERE and get the high/low. ? 
		//or we make an array and make the temperature class loop through and get the temps. << I like this idea. 
		
		Temperature t;

		JSONObject currently = jsobj.getJSONObject("currently");

		String summary = currently.getString("summary");
		double currentTemp = currently.getDouble("temperature");
		double feelsLike = currently.getDouble("apparentTemperature");
		System.out.println("Temperature: " + currentTemp + "°F");
		System.out.println("Feels Like: " + feelsLike + "°F");

//		t = new Temperature(currentTemp, feelsLike);

		return null;

	}

	public Precipitation makePrecipitationObject() {
		Precipitation p;
		//possible needs to be an array of 24 precipitation objects
		// String type, double probability

		return null;
	}

}
