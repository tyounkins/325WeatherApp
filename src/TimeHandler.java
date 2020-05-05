
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class TimeHandler implements TimeAndDate {

	public String getLocale(String country) {

		String abbr = "";
		
		String[] locales = Locale.getISOCountries();

		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);

			System.out.println("Country Code = " + obj.getCountry()
				+ ", Country Name = " + obj.getDisplayCountry());
			
			if(country.contentEquals(obj.getDisplayCountry())) {
				return countryCode;
			}

		}

		return abbr;
	}

	public String getTime(String country) {
		try {
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
			try {
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);
				String line = "";
				while (in.hasNextLine()) {
					line = in.nextLine();
				}
				String[] formatter = line.split(" ", 4);

				String d = formatter[1]; // this is the date section
				String t = formatter[2]; // this is the time section

				d = d.concat(" " + t);
				Date date;

				Locale locale = new Locale(getLocale(country).toLowerCase(), getLocale(country));
				System.out.println("locale: " + locale);
				DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
				String sdate = dateFormat.format(new Date());
				System.out.print(sdate);

//					if (country.contentEquals("United States")) {
//						date = new SimpleDateFormat("yy-MM-dd").parse(d);
//					} else {
//						date = new SimpleDateFormat("dd-MM-yy").parse(d);
//					}

//                    System.out.println(date);
				return sdate;
				// System.out.println(datestr);
			} finally {
				s.close();
			}
		} catch (IOException ioexc) {
			ioexc.printStackTrace();
		}
		return "";
	} // end public
}
