import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.*;

import org.json.*;

public class DarkSkyJSONHandler {
	
	String latitude;
	String longitude;

	public static void main(String args[]) {
		DarkSkyJSONHandler js = new DarkSkyJSONHandler();
	
		try {
			CompletableFuture<String> cf = GeocodingAPIRequest();
			String result = cf.get();
			
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DarkSkyJSONHandler() {
		
	}

	public static CompletableFuture<String> GeocodingAPIRequest() {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"https://maps.googleapis.com/maps/api/geocode/json?address=215+N.+Russell+Street,+West+Lafayette,+IN&key=AIzaSyAjZHAcljtCjOY8PEL9AkMIDJhuVeXGA7Q"))
				.build();
		
		 return client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body);
		
/*	client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println)
				.join();
				*/

	}

}
