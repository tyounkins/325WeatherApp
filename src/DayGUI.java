
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.FlowLayout;

/* Author: Dan */

public class DayGUI {

	/*
	 * public static void main(String[] args){ DayGUI daygui = new DayGUI();
	 * daygui.setVisible(true); }
	 */

	Day day;

	JPanel pnlContain;

	JLabel lbldate, lbltemp, lblprecip;

//    TimeHandler timehandler = new TimeHandler();
//    Temperature temperature = new Temperature(60.0, 70.0, 60.0, 70.0, 65.0, 65.0);
//    Precipitation precipitation = new Precipitation(70.0, "Rain");
//    Day day = new Day(timehandler.getTime(), precipitation, temperature, "placeholder");

	public JPanel getDayGUI(String country) {
		


		String pattern = "E MM/dd/yyy";
		SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		
		Locale locale = new Locale(country.toUpperCase(), country);
		System.out.println("locale: " + locale);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String sdate = dateFormat.format(new Date());
		
		
		
		lbldate = new JLabel("Date: " + sdate);
		
		
		

		lbltemp = new JLabel("Temperature: " + day.getDayTemp().toReadableString());

		lblprecip = new JLabel("Precipitation: " + day.getDayPrecip().toReadableString());

		pnlContain = new JPanel(new FlowLayout());
		pnlContain.setPreferredSize(new Dimension(300, 50));

		pnlContain.add(lbldate);
		pnlContain.add(lbltemp);
		pnlContain.add(lblprecip);
//		cp.add(pnlContain);
		return pnlContain;
	}

	public DayGUI(Day day) {
		this.day = day;
//		Container cp = getContentPane();
		System.out.println(day == null);
//		getDayGUI();
//		cp.add(pnlContain);

	}
}