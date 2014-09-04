package exercise1;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Here we just get started with Java Swing.
 * First let's play with JFrame - which is the main window created
 * when we run a typical Java Swing program.
 * 
 * @author smitra
 *
 */
public class BasicGUI01 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("HelloWorldSwing!");
		
	    frame.setSize(new Dimension(300, 200));
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //frame.pack();
	    
	    frame.setVisible(true);
	}

}
