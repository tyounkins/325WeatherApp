
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TimeHandler {
    public static void main (String args[]) {
        TimeHandler t = new TimeHandler();
        System.out.println(t.getTime());
        //System.out.println("did it work?");
    }
    
    public void TimeHandler() {
        
    }
    
    public Date getTime()
    {
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
                
                String d = formatter[1]; //this is the date section
                String t = formatter[2]; //this is the time section
                
                d = d.concat(" " + t);
                try{
                    //SimpleDateFormat sdf = new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]");
                    Date date = new SimpleDateFormat("yy-MM-dd HH:mm:ss").parse(d);
                    System.out.println(date);
                    return date;
                    //System.out.println(datestr);
                }
                catch(ParseException p) {
                    System.out.println("error thrown");
                }
            } finally {
                s.close();
            }
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
        return null;
    } //end public
}
