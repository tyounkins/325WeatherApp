
public class Address {

	private String street;
	private String city;
	private String state;
	
	public Address(String str, String c, String st) {
		street = str;
		city = c;
		state = st;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}
}
