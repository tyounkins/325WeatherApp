import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.*;
import org.json.*;

public class DarkSkyJSONHandler {

	static double latitude;
	static double longitude;
	Address address;

	public DarkSkyJSONHandler(Address a) {

		address = a;

		// updates latitude and longitude
		GeocodingParser gp = new GeocodingParser(address);
		latitude = gp.getLatitude();
		longitude = gp.getLongitude();
		parser();

	}

	public void parser() {
		try {
			CompletableFuture<String> cf = handler();
			String result = cf.get();

			System.out.println("result: " + result);
			
			JSONObject jsobj = new JSONObject(result);
			
			//get DATAAAAAA!!!!!!!!
			
			JSONObject currently = jsobj.getJSONObject("currently");
			
			String summary = currently.getString("summary");
			double temperature = currently.getDouble("temperature");
			double feelsLike = currently.getDouble("apparentTemperature");
			System.out.println(summary);
			System.out.println("Temperature: " + temperature + "°F");
			System.out.println("Feels Like: " + feelsLike + "°F");
			
			//7 day forecast - starts at line 1312


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CompletableFuture<String> handler() {

		String apiLatLong = latitude + "," + longitude;
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.darksky.net/forecast/f22b1a9a580fb95232327fe4ed285165/" + apiLatLong))
				.build();

		return client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body);
	}
}
