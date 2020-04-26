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
	

	public ObjectMaker(Address address) {

		/*
		 * Where all the objects get made
		 */
//		Address address = new Address("215 N. Russell Street", "West Lafayette", "IN");
		DarkSkyJSONHandler js = new DarkSkyJSONHandler(address);
		jsobj = js.parser();

		Day d = makeDayObject();
		System.out.println(d.toString());
		makeSevenDayForecast();

	}

	public Day makeDayObject() {

		// int date, Precipitation dayPrecip, Temperature dayTemp, String summaryDay,
		// String summaryCurrent

		Temperature t = makeTemperatureObject();
		Precipitation p = makePrecipitationObject();

		Day d = null;

		/* make this an add-on for only presentDay
		JSONObject currently = jsobj.getJSONObject("currently");
		String currentSummary = currently.getString("summary");
		System.out.println(currentSummary);
		*/

		JSONObject daily = jsobj.getJSONObject("daily");
		String dailySummary = daily.getString("summary");

		long timeUnix= 0;
		
		JSONArray data = daily.getJSONArray("data");
		for (int i = 0; i < 1; i++) {
			JSONObject item = data.getJSONObject(i);
			 timeUnix = item.getLong("time"); //1587268800
		}
		
		

		Date time = new Date(timeUnix * 1000);
		System.out.println(time.toString());

		d = new Day(time, p, t, dailySummary);
//		d.setCurrentSummary(currentSummary);

		return d;
	}

	public Temperature makeTemperatureObject() {

		Temperature t;

		/* this needs to be modified to be optional, if we choose to use it */
		JSONObject currently = jsobj.getJSONObject("currently");
		double currentTemp = currently.getDouble("temperature");
		double feelsLike = currently.getDouble("apparentTemperature");
		/* ignoring this for right now */
		
		
		JSONObject daily = jsobj.getJSONObject("daily");
		JSONArray data = daily.getJSONArray("data");

		double minTemp = 0.0;
		double maxTemp = 0.0;
		double lowTemp = 0.0;
		double highTemp = 0.0;
		double average = 0.0;
		double avgfeelslike = 0.0;

		// only gets present day
		for (int i = 0; i < 1; i++) {
			JSONObject item = data.getJSONObject(i);

			minTemp = item.getDouble("temperatureMin");
			maxTemp = item.getDouble("temperatureMax");
			lowTemp = item.getDouble("temperatureLow");
			highTemp = item.getDouble("temperatureHigh");
			
			double lowFeels = item.getDouble("apparentTemperatureLow");
			double highFeels = item.getDouble("apparentTemperatureHigh");
			average = (highTemp + lowTemp) / 2.0;
			feelsLike = (highFeels + lowFeels) / 2.0;
		}

		//overridden w new values now
		t = new Temperature(minTemp, maxTemp, lowTemp, highTemp, average, avgfeelslike);

		return t;

	}

	public Precipitation makePrecipitationObject() {
		Precipitation p = null;
		
		JSONObject daily = jsobj.getJSONObject("daily");
		JSONArray data = daily.getJSONArray("data");
		
		for (int i = 0; i < 1; i++) {
			JSONObject item = data.getJSONObject(i);

			double probability = item.getDouble("precipProbability");
			String type = item.getString("precipType");
			
			p = new Precipitation(probability, type);
		}

		return p;
	}
	
	public void makeSevenDayForecast() {
		JSONObject daily = jsobj.getJSONObject("daily");
		JSONArray data = daily.getJSONArray("data");
		
		Day[] sevenDays = new Day[7];
		//ok so. we can only get the predictions for the next 7 days from the daily. therefore, lets make the 
		//present day options for Day only values you can set, with a presentDay() method, instead of as part
		// of the constructor. Same with temperature
		
		for (int i = 0; i < 7; i++) {
			
			//make all the items that go into a day... im just gonna make em here.. why did i make those methods then? IDk, im a loser
			JSONObject item = data.getJSONObject(i);

			double probability = item.getDouble("precipProbability");
			String type = item.getString("precipType");
			
			Precipitation p = new Precipitation(probability, type);
			
			double minTemp = item.getDouble("temperatureMin");
			double maxTemp = item.getDouble("temperatureMax");
			double lowTemp = item.getDouble("temperatureLow");
			double highTemp = item.getDouble("temperatureHigh");
			
			double lowFeels = item.getDouble("apparentTemperatureLow");
			double highFeels = item.getDouble("apparentTemperatureHigh");
			double average = (highTemp + lowTemp) / 2.0;
			double feelsLike = (highFeels + lowFeels) / 2.0;
			
			/* double minTemp, double maxTemp, double lowTemp, double highTemp, double currentTemp,
			double apparentCurrTemp */
			Temperature t =  new Temperature(minTemp, maxTemp, lowTemp, highTemp, average, feelsLike);
			
			long timeUnix =  item.getLong("time");
			Date time = new Date(timeUnix * 1000);
			
			String dailySummary = daily.getString("summary");
			
			Day d = new Day(time, p, t, dailySummary);
			
			sevenDays[i] =  d;
			
		}
		
	}

}
