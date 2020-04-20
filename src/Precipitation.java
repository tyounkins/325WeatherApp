
public class Precipitation {
	private String type;
	private double probability;
	
	//potentially add a time?
	
	public Precipitation(double probability, String type) {
		this.type = type;
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "Precipitation [type=" + type + ", probability=" + probability + "]";
	}

	public String getTypePrecip() {
		return type;
	}

	public void setTypePrecip(String s) {
		type = s;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double d) {
		probability = d;
	}


}
