import java.util.*;

/* Author(s): Taylor Younkins, Taylor Kern */


public class Day
{
	private Date date;
	private Precipitation dayPrecip;
	private Temperature dayTemp;
	private String summaryDay;
	private String summaryCurrent;
	private Temperature[] hourlyTemps; //  //possible if GUI poeple decide to show hourly temperature changes? 
	
	public Day(Date date, Precipitation dayPrecip, Temperature dayTemp, String summaryDay) {
		super();
		this.date = date;
		this.dayPrecip = dayPrecip;
		this.dayTemp = dayTemp;
		this.summaryDay = summaryDay;
		summaryCurrent = "";
	}
	
	@Override
	public String toString() {
		return "Day [date=" + date + ", dayPrecip=" + dayPrecip + ", dayTemp=" + dayTemp + ", summaryDay=" + summaryDay
				+ ", summaryCurrent=" + summaryCurrent + "]";
	}

	public Date getDate() {
		return date;
	}
	public Precipitation getDayPrecip() {
		return dayPrecip;
	}
	public Temperature getDayTemp() {
		return dayTemp;
	}
	public String getSummaryDay() {
		return summaryDay;
	}
	
	//only to be used for present day, if we choose to use it at all
	public String getSummaryCurrent() {
		return summaryCurrent;
	}
	
	public void setCurrentSummary(String cs) {
		summaryCurrent = cs;
	}
	
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDayPrecip(Precipitation dayPrecip) {
		this.dayPrecip = dayPrecip;
	}
	public void setDayTemp(Temperature dayTemp) {
		this.dayTemp = dayTemp;
	}
	public void setSummaryDay(String summaryDay) {
		this.summaryDay = summaryDay;
	}
	public void setSummaryCurrent(String summaryCurrent) {
		this.summaryCurrent = summaryCurrent;
	}
	
	

	//Line 1312 in pastebin https://pastebin.com/ch7XjXhe
}
