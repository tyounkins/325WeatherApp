import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Author: Carlos Perez 
 * 
 */

public class InputGUI extends JFrame implements ActionListener {
	JPanel pnlContain;
	JLabel lblstreet, lblcity, lblstate, lblcountry;
	JTextField txtstreet, txtcity, txtstate, txtcountry;
	JButton btnexit, btnclear, btnenter;
	Address a;
	
	JLabel lbltime;
	
	ObjectMaker om;
	boolean exit = false;

	public InputGUI() {
		Address a = null;
		ObjectMaker om = null;
		Container cp = getContentPane();
		lblstreet = new JLabel("Street (Optional):");
		lblcity = new JLabel("City: ");
		lblstate = new JLabel("State (Optional): ");
		lblcountry = new JLabel("Country: ");
		txtcountry = new JTextField(20);
		txtstreet = new JTextField(20);
		txtcity = new JTextField(20);
		txtstate = new JTextField(20);
		btnexit = new JButton("Exit");
		btnclear = new JButton("Clear");
		btnenter = new JButton("Enter");
		pnlContain = new JPanel();
		lbltime = new JLabel("");

		btnclear.addActionListener(this);
		btnenter.addActionListener(this);
		btnexit.addActionListener(this);

		pnlContain.add(lblcity);
		pnlContain.add(txtcity);
		pnlContain.add(lblstate);
		pnlContain.add(txtstate);
		pnlContain.add(lblstreet);
		pnlContain.add(txtstreet);
		pnlContain.add(lblcountry);
		pnlContain.add(txtcountry);
		pnlContain.add(btnenter);
		pnlContain.add(btnclear);
		pnlContain.add(btnexit);
		pnlContain.add(lbltime);
		cp.add(pnlContain);
	}

	public JPanel getInputGUI() {
		return pnlContain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnclear) {
			txtcity.setText("");
			txtstate.setText("");
			txtstreet.setText("");
			txtcountry.setText("");
		}
		if (e.getSource() == btnexit) {
			System.exit(0);
			exit = true;
		}
		if (e.getSource() == btnenter) {
			if (txtcity.getText().isEmpty() || txtcountry.getText().isEmpty()) {
				InputGUI my = new InputGUI();
				JOptionPane.showMessageDialog(my, "Please enter location", "Location error", JOptionPane.ERROR_MESSAGE);
				txtcity.requestFocus();
			} else {

				String city = txtcity.getText();
				String state = txtstate.getText();
				String street = txtstreet.getText();
				String country = txtcountry.getText();

				System.out.println(txtcity.getText());
				System.out.println(txtstate.getText());
				System.out.println(txtstreet.getText());
				System.out.println(txtcountry.getText());

				a = new Address(city, state, street, country);
				om = new ObjectMaker(a);

				System.out.println(om.getD() == null);

				TimeHandler t = new TimeHandler();
				String locale = t.getLocale(country);
		        lbltime.setText(t.getTime(country).toString());
		        
				DayGUI daygui = new DayGUI(om.getD());
				pnlContain.add(daygui.getDayGUI(locale));
				this.repaint();

				SevenDayForecastGUI sdfgui = new SevenDayForecastGUI(om.getSdf());
				pnlContain.add(sdfgui.getSevenDayForecastGUI(locale));
				this.repaint();

			}
		}

	}

	public boolean getExit() {
		return exit;
	}

	public ObjectMaker getObjectMaker() {
		return om;
	}

	public Address getAddress() {
		return a;
	}
}