
public class Precipitation {
	private String type;
	private double probability;
	
	public Precipitation(String type, double probability) {
		super();
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
