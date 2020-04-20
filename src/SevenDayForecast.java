import java.util.Arrays;

public class SevenDayForecast {
	
	Day[] sevenDays;
	
	public SevenDayForecast(Day[] sv) {
		sevenDays = sv;
	}

	public Day[] getSevenDays() {
		return sevenDays;
	}

	public void setSevenDays(Day[] sevenDays) {
		this.sevenDays = sevenDays;
	}

	@Override
	public String toString() {
		return "SevenDayForecast [sevenDays=" + Arrays.toString(sevenDays) + "]";
	}

}
