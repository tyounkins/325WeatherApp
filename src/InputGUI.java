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


public class InputGUI extends JFrame implements ActionListener{
	JPanel pnlContain;
	JLabel lblstreet, lblcity, lblstate, lblcountry;
	JTextField txtstreet, txtcity, txtstate, txtcountry;
	JButton btnexit, btnclear, btnenter;
	
	public InputGUI()
	{
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
		cp.add(pnlContain);
	}
	public static void main (String [] args)
	{
		InputGUI my = new InputGUI();
		my.setBounds(300, 400, 1700, 200);
		my.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnclear)
		{
			txtcity.setText("");
			txtstate.setText("");
			txtstreet.setText("");
			txtcountry.setText("");
		}
		if (e.getSource() == btnexit)
		{
			System.exit(0);
		}
		if (e.getSource() == btnenter)
		{
			if (txtcity.getText().isEmpty() || txtcountry.getText().isEmpty())
			{
				InputGUI my = new InputGUI();
				JOptionPane.showMessageDialog(my, "Please enter location", "Location error", JOptionPane.ERROR_MESSAGE);
				txtcity.requestFocus();
			}
			else {
			System.out.println(txtcity.getText());
			System.out.println(txtstate.getText());
			System.out.println(txtstreet.getText());
			System.out.println(txtcountry.getText());
			}
		}
		
	}
}