import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* Author: Dan */

public class DayGUI extends JFrame{

    public static void main(String[] args){
        DayGUI daygui = new DayGUI();
        daygui.setVisible(true);
    }

    JPanel pnlContain;
    JLabel lbltime, lbltemperature, lblprecipitation;

    TimeHandler timehandler = new TimeHandler();
    Temperature temperature = new Temperature(60.0, 70.0, 60.0, 70.0, 65.0, 65.0);
    Precipitation precipitation = new Precipitation(70.0, "Rain");
    Day day = new Day(timehandler.getTime(), precipitation, temperature, "placeholder");

    public DayGUI() {
            Container cp = getContentPane();
            lbltime = new JLabel(day.getDate().toString());
            lbltemperature = new JLabel(day.getDayTemp().toString());
            lblprecipitation = new JLabel(day.getDayPrecip().toString());
            
            pnlContain = new JPanel();

            pnlContain.add(lbltime);
            pnlContain.add(lbltemperature);
            pnlContain.add(lblprecipitation);
            cp.add(pnlContain);
    }
}