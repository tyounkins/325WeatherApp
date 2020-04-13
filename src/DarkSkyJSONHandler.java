import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.*;

import org.json.*;

public class DarkSkyJSONHandler {

	static double latitude;
	static double longitude;
	Address address;

	public static void main(String args[]) {
		Address address = new Address("215 N. Russell Street", "West Lafayette", "IN");
		DarkSkyJSONHandler js = new DarkSkyJSONHandler(address);
	}

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
			
//			JSONObject jsobj = new JSONObject(result);
//			JSONArray results = jsobj.getJSONArray("results");
//			JSONObject resultsAll = (JSONObject) results.get(0);
//			JSONObject geometry = (JSONObject) resultsAll.get("geometry");
//			JSONObject location = (JSONObject) geometry.get("location");
//
//			latitude = location.getDouble("lat");
//			longitude = location.getDouble("lng");
//
//			System.out.println("lat: " + latitude + "\nlongitude: " + longitude);

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
