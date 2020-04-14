import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.*;
import org.json.*;

/* Author(s): Taylor Younkins */

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

	}

	public JSONObject parser() {

		try {
			CompletableFuture<String> cf = handler();
			String result = cf.get();

			System.out.println("result: " + result);

			JSONObject jsobj = new JSONObject(result);

			return jsobj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
