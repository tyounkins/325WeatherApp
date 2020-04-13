import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.*;
import org.json.*;

public class GeocodingParser {
	
	double latitude; 
	double longitude;
	static Address address;

	public GeocodingParser(Address a) {
		
		address = a;
		latitude = 0.0;
		longitude = 0.0;
		
		parser();
	}
	
	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void parser() {
		try {
			CompletableFuture<String> cf = handler();
			String result = cf.get();

			JSONObject jsobj = new JSONObject(result);
			JSONArray results = jsobj.getJSONArray("results");
			JSONObject resultsAll = (JSONObject) results.get(0);
			JSONObject geometry = (JSONObject) resultsAll.get("geometry");
			JSONObject location = (JSONObject) geometry.get("location");

			latitude = location.getDouble("lat");
			longitude = location.getDouble("lng");

			System.out.println("lat: " + latitude + "\nlongitude: " + longitude);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String toGeocodingString() {
		
		//not internationalized............. ?
		
		String adr = address.getStreet().replaceAll(" ", "+");
		adr+= ",+" + address.getCity().replaceAll(" ", "+");
		adr+= ",+" + address.getState().replaceAll(" ", "+");
		
		System.out.println(adr);
		return adr;
		
	}

	public static CompletableFuture<String> handler() {
		
		String apiAddr = toGeocodingString();

		HttpClient client = HttpClient.newHttpClient();
		
		//215+N.+Russell+Street,+West+Lafayette,+IN
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"https://maps.googleapis.com/maps/api/geocode/json?address=" + apiAddr + "&key=AIzaSyAjZHAcljtCjOY8PEL9AkMIDJhuVeXGA7Q"))
				.build();

		return client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body);

	}

}
