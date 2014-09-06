package exercise1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HelloWorldSwingFrame extends JFrame {
	
	private JLabel formattedTextLabel;
	
	public HelloWorldSwingFrame() {
		super("HelloWorldSwing!");
	    super.setSize(new Dimension(370, 220));
	    
		formattedTextLabel = new JLabel("thing");
		JPanel fontSizePanel = this.formFontSizePanel();
		JPanel fontStylePanel = this.formFontStylePanel();
	    JPanel buttonPanel = this.formButtonPanel();
	    
	    fontStylePanel.setLayout(new BoxLayout(fontStylePanel, BoxLayout.Y_AXIS));
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    panel.add(fontSizePanel, BorderLayout.NORTH);
	    panel.add(fontStylePanel, BorderLayout.WEST);
	    panel.add(formattedTextLabel, BorderLayout.EAST);
	    panel.add(buttonPanel, BorderLayout.SOUTH);
		
		super.add(panel);
	}
	
	protected JPanel formFontSizePanel() {
		final String[] fontSizeTags = new String[] {"Tiny", "Small", "Medium", "Large"};
		
		final JLabel textLabel = new JLabel("Text: ");
		final JTextField inputField = new JTextField("thing");
		final JComboBox<String> fontSizeBox = new JComboBox<String>(fontSizeTags);
		
		class TextFieldListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent event) {
				formattedTextLabel.setText(inputField.getText()); 
			}
			
		}
		
		class FontSizeListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedItem = (String) fontSizeBox.getSelectedItem();
				float fontSize;
				if(selectedItem == fontSizeTags[0]) {
					fontSize = 8f;
				} else if(selectedItem == fontSizeTags[1]) {
					fontSize = 12f;
				} else if(selectedItem == fontSizeTags[2]) {
					fontSize = 20f;
				} else {
					fontSize = 28f;
				}

				formattedTextLabel.setFont(formattedTextLabel.getFont().deriveFont(fontSize));
			}
			
		}
		
		JPanel panel = new JPanel();
		
		inputField.addActionListener(new TextFieldListener());
		fontSizeBox.addActionListener(new FontSizeListener());
	    
	    panel.add(textLabel);
	    panel.add(inputField);
	    panel.add(fontSizeBox);
	    return panel;
	}
	
	protected JPanel formFontStylePanel() {
		final JRadioButton plain = new JRadioButton("Plain");
		final JRadioButton bold = new JRadioButton("Bold");
		final JRadioButton italic = new JRadioButton("Italic");
		final JRadioButton boldItalic = new JRadioButton("Bold Italic");
		
		class FontStyleListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent event) {
				Object sourceObj = event.getSource();
				int fontStyle;
				if(sourceObj == plain) {
					fontStyle = Font.PLAIN;
				} else if(sourceObj == bold) {
					fontStyle = Font.BOLD;
				} else if(sourceObj == italic) {
					fontStyle = Font.ITALIC;
				} else {
					fontStyle = Font.BOLD + Font.ITALIC;
				}

				formattedTextLabel.setFont(formattedTextLabel.getFont().deriveFont(fontStyle));
			}
			
		}
		
		JPanel panel = new JPanel();
		FontStyleListener listener = new FontStyleListener();
		plain.addActionListener(listener);
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		boldItalic.addActionListener(listener);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(plain);
		bg.add(bold);
		bg.add(italic);
		bg.add(boldItalic);
		
		panel.add(plain);
		panel.add(bold);
		panel.add(italic);
		panel.add(boldItalic);
		
		return panel;
	}
	
	protected JPanel formButtonPanel() {
		class ShowButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color oldFontColor = formattedTextLabel.getForeground();
				Color newFontColor = oldFontColor == Color.RED ? Color.BLACK : Color.RED;
				formattedTextLabel.setForeground(newFontColor);
			}
		}
		
		class ExitButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
				HelloWorldSwingFrame.super.dispose();
			}
		}
		
		JPanel panel = new JPanel();
		
		final JButton showButton = new JButton("Show!");
		showButton.addActionListener(new ShowButtonListener());
		
		final JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonListener());
		
		panel.add(showButton);
		panel.add(exitButton);
		
		return panel;
	}
}
