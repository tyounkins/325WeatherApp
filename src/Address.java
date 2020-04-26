
/* Author(s): Taylor Younkins */


public class Address {

	private String street;
	private String city;
	private String state;
	private String country;
	
	public Address(String str, String c, String st, String country) {
		street = str;
		city = c;
		state = st;
		this.country= country;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", country=" + country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
