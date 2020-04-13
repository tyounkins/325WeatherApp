/* CNIT 325 Final Group Project
 * Weather Application
 * 
 * Authors:
 * Taylor Younkins
 * Taylor Kern
 */


public class Main {

	public static void main(String[] args) {
		
		Address address = new Address("215 N. Russell Street", "West Lafayette", "IN");
		DarkSkyJSONHandler js = new DarkSkyJSONHandler(address);
	}

}
