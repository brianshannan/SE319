package exercise1;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorldSwing3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("HelloWorldSwing!");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(new Dimension(370, 220));

	    JPanel panel = new HelloWorldSwingPanel();

	    frame.add(panel);
	    
	    //frame.pack();
	    frame.setVisible(true);
	}

}
