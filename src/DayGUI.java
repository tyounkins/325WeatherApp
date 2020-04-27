import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* Author: Dan */

public class DayGUI {

	/*
	 * public static void main(String[] args){ DayGUI daygui = new DayGUI();
	 * daygui.setVisible(true); }
	 */

	Day day;

	JPanel pnlContain;
	JLabel lbltime, lbltemperature, lblprecipitation;

	JLabel lbltime2, lbltemperature2, lblprecipitation2;

//    TimeHandler timehandler = new TimeHandler();
//    Temperature temperature = new Temperature(60.0, 70.0, 60.0, 70.0, 65.0, 65.0);
//    Precipitation precipitation = new Precipitation(70.0, "Rain");
//    Day day = new Day(timehandler.getTime(), precipitation, temperature, "placeholder");

	public JPanel getDayGUI() {


		lbltime2 = new JLabel("Time Right Now: ");
		lbltemperature2 = new JLabel("Temperature: ");
		lblprecipitation2 = new JLabel("Precipitation: ");

		lbltime = new JLabel(day.getDate().toString());
		lbltemperature = new JLabel(day.getDayTemp().toString());
		lblprecipitation = new JLabel(day.getDayPrecip().toString());

		pnlContain = new JPanel();

		pnlContain.add(lbltime2);
		pnlContain.add(lbltime);
		pnlContain.add(lbltemperature2);
		pnlContain.add(lbltemperature);
		pnlContain.add(lblprecipitation2);
		pnlContain.add(lblprecipitation);
//		cp.add(pnlContain);
		return pnlContain;
	}

	public DayGUI(Day day) {
		this.day = day;
//		Container cp = getContentPane();
		System.out.println(day == null);
		getDayGUI();
//		cp.add(pnlContain);

	}
}