
/* Author(s): Taylor Younkins, Taylor Kern */

public class Temperature {
	private double minTemp;
	private double maxTemp;
	private double lowTemp;
	private double highTemp;
	private double currentTemp;
	private double feelsLike;

	public Temperature(double minTemp, double maxTemp, double lowTemp, double highTemp, double currentTemp,
			double apparentCurrTemp) {
		super();
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.lowTemp = lowTemp;
		this.highTemp = highTemp;
		this.currentTemp = currentTemp;
		this.feelsLike = apparentCurrTemp;
	}

	@Override
	public String toString() {
		return "Temperature [minTemp=" + minTemp + "°F, maxTemp=" + maxTemp + "°F, lowTemp=" + lowTemp + "°F, highTemp="
				+ highTemp + "°F, currentTemp=" + currentTemp + "°F, feelsLike=" + feelsLike + "°F]";
	}

	public double getMinTemp() {
		return minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public double getLowTemp() {
		return lowTemp;
	}

	public double getHighTemp() {
		return highTemp;
	}

	public double getCurrentTemp() {
		return currentTemp;
	}

	public double getApparentCurrTemp() {
		return feelsLike;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public void setLowTemp(double lowTemp) {
		this.lowTemp = lowTemp;
	}

	public void setHighTemp(double highTemp) {
		this.highTemp = highTemp;
	}

	public void setCurrentTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}

	public void setApparentCurrTemp(double apparentCurrTemp) {
		this.feelsLike = apparentCurrTemp;
	}
}
