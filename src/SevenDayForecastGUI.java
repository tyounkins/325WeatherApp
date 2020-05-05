
import java.awt.Container;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

/* Author: Dan */

public class SevenDayForecastGUI {

	/*
	 * public static void main(String[] args){ DayGUI daygui = new DayGUI();
	 * daygui.setVisible(true); }
	 */

	Day[] days;
	SevenDayForecast sdf;

	JPanel pnlContain;

	String country;

	JLabel lblday1date, lblday1temp, lblday1precip, lblday2date, lblday2temp, lblday2precip, lblday3date, lblday3temp,
			lblday3precip, lblday4date, lblday4temp, lblday4precip, lblday5date, lblday5temp, lblday5precip,
			lblday6date, lblday6temp, lblday6precip;

//    TimeHandler timehandler = new TimeHandler();
//    Temperature temperature = new Temperature(60.0, 70.0, 60.0, 70.0, 65.0, 65.0);
//    Precipitation precipitation = new Precipitation(70.0, "Rain");
//    Day day = new Day(timehandler.getTime(), precipitation, temperature, "placeholder");

	public String getFormattedDate(int i) {
		String pattern = "E MM/dd/yyy";
		SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		
		Locale locale = new Locale(country.toUpperCase(), country);
		System.out.println("locale: " + locale);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		
		return "\nDate: " + dateFormat.format(days[i].getDate());



	}

	public String getFormattedTemp(int i) {
		return "Temperature: " + days[i].getDayTemp().toReadableString();
	}

	public String getFormattedPrecip(int i) {
		return "Precipitation: " + days[i].getDayPrecip().toReadableString();
	}

	public JPanel getSevenDayForecastGUI(String lc) {

		country = lc;

		lblday1date = new JLabel(getFormattedDate(1));
		lblday1temp = new JLabel(getFormattedTemp(1));
		lblday1precip = new JLabel(getFormattedPrecip(1));

		lblday2date = new JLabel(getFormattedDate(2));
		lblday2temp = new JLabel(getFormattedTemp(2));
		lblday2precip = new JLabel(getFormattedPrecip(2));

		lblday3date = new JLabel(getFormattedDate(3));
		lblday3temp = new JLabel(getFormattedTemp(3));
		lblday3precip = new JLabel(getFormattedPrecip(3));

		lblday4date = new JLabel(getFormattedDate(4));
		lblday4temp = new JLabel(getFormattedTemp(4));
		lblday4precip = new JLabel(getFormattedPrecip(4));

		lblday5date = new JLabel(getFormattedDate(5));
		lblday5temp = new JLabel(getFormattedTemp(5));
		lblday5precip = new JLabel(getFormattedPrecip(5));

		lblday6date = new JLabel(getFormattedDate(6));
		lblday6temp = new JLabel(getFormattedTemp(6));
		lblday6precip = new JLabel(getFormattedPrecip(6));

		pnlContain = new JPanel(new FlowLayout());
		pnlContain.setPreferredSize(new Dimension(300, 600));

		pnlContain.add(lblday1date);
		pnlContain.add(lblday1temp);
		pnlContain.add(lblday1precip);
		pnlContain.add(lblday2date);
		pnlContain.add(lblday2temp);
		pnlContain.add(lblday2precip);
		pnlContain.add(lblday3date);
		pnlContain.add(lblday3temp);
		pnlContain.add(lblday3precip);
		pnlContain.add(lblday4date);
		pnlContain.add(lblday4temp);
		pnlContain.add(lblday4precip);
		pnlContain.add(lblday5date);
		pnlContain.add(lblday5temp);
		pnlContain.add(lblday5precip);
		pnlContain.add(lblday6date);
		pnlContain.add(lblday6temp);
		pnlContain.add(lblday6precip);

//		cp.add(pnlContain);
		return pnlContain;
	}

	public SevenDayForecastGUI(SevenDayForecast sdf) {
		this.sdf = sdf;
		days = sdf.getSevenDays();
		System.out.println(sdf == null);
//		getSevenDayForecastGUI();

	}
}