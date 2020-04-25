import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputGUI extends JFrame implements ActionListener{
	JPanel pnlContain;
	JLabel lblstreet, lblcity, lblstate;
	JTextField txtstreet, txtcity, txtstate;
	JButton btnexit, btnclear, btnenter;
	
	public InputGUI()
	{
		Container cp = getContentPane();
		lblstreet = new JLabel("Street:");
		lblcity = new JLabel("City: ");
		lblstate = new JLabel("State: ");
		txtstreet = new JTextField(20);
		txtcity = new JTextField(20);
		txtstate = new JTextField(20);
		btnexit = new JButton("Exit");
		btnclear = new JButton("Clear");
		btnenter = new JButton("Enter");
		pnlContain = new JPanel();
		pnlContain.add(lblcity);
		pnlContain.add(txtcity);
		pnlContain.add(lblstate);
		pnlContain.add(txtstate);
		pnlContain.add(lblstreet);
		pnlContain.add(txtstreet);
		pnlContain.add(btnenter);
		pnlContain.add(btnclear);
		pnlContain.add(btnexit);
		cp.add(pnlContain);
	}
//	public static void main (String [] args)
//	{
//		InputGUI my = new InputGUI();
//		my.setBounds(300,300,300,300);
//		my.setVisible(true);
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnclear)
		{
			txtcity.setText("");
			txtstate.setText("");
			txtstreet.setText("");
		}
		if (e.getSource() == btnexit)
		{
			System.exit(0);
		}
		if (e.getSource() == btnenter)
		{
			System.out.println(txtcity.getText());
			System.out.println(txtstate.getText());
			System.out.println(txtstreet.getText());
		}
	}
}