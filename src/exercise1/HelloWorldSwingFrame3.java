package exercise1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class HelloWorldSwingFrame3 extends HelloWorldSwingFrame {
	
	private Timer timer;
	private JCheckBox timeCheckBox;
	private JTextField timeInputField;
	
	public HelloWorldSwingFrame3() {
		super();
	}
	
	@Override
	protected JPanel formFontSizePanel() {
		class TimeFieldListener implements ActionListener {
			private void showErrorMessage() {
				JOptionPane.showMessageDialog(new JFrame(), "Not a valid value.");
			}
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					int num = Integer.parseInt(timeInputField.getText());
					if(1 <= num && num <= 10) {
						showErrorMessage();
					}
				} catch(NumberFormatException e) {
					showErrorMessage();
				}
			}
		}
		
		JPanel panel = super.formFontSizePanel();
		JLabel clearAfterLabel = new JLabel(" clear after: ");
		
		// These have to be initialized earlier as this function is called in super()
		timeCheckBox = new JCheckBox();
		timeInputField = new JTextField("thing");
		timeInputField.addActionListener(new TimeFieldListener());
		
		panel.add(timeCheckBox);
		panel.add(clearAfterLabel);
		panel.add(timeInputField);

		return panel;
	}
	
	protected class ShowButtonListener2 extends ShowButtonListener {
		class TimerListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
				timer = null;
				HelloWorldSwingFrame3.super.formattedTextLabel.setText("");
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			super.actionPerformed(event);
			if(timeCheckBox.isSelected()) {
				timer = new Timer(Integer.parseInt(timeInputField.getText()) * 1000, new TimerListener());
				timer.start();
			}
		}
	}
	
	@Override
	protected JPanel formButtonPanel(ShowButtonListener showButtonListener) {
		return super.formButtonPanel(new ShowButtonListener2());
	}
	
}
