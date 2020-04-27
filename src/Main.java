import java.awt.Container;

import javax.swing.JFrame;

/* CNIT 325 Final Group Project
 * Weather Application
 * 
 * Authors:
 * Taylor Younkins
 * Taylor Kern
 */

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		InputGUI ig = new InputGUI();

		Container cp = frame.getContentPane();

		cp.add(ig.getInputGUI());
		frame.setSize(250, 400);
		frame.setVisible(true);

		ObjectMaker om = ig.getObjectMaker();

	}

}
