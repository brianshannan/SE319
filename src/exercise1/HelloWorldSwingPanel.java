package exercise1;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HelloWorldSwingPanel extends JPanel {
	
	private JLabel formattedTextLabel;
	public HelloWorldSwingPanel() {
		formattedTextLabel = new JLabel("thing");
		
		JPanel fontSizePanel = new FontSizePanel();
		add(fontSizePanel);
		
		JPanel fontStylePanel = new FontStylePanel();
	    fontStylePanel.setLayout(new BoxLayout(fontStylePanel, BoxLayout.Y_AXIS));
	    add(fontStylePanel);
		
		add(formattedTextLabel);
	}
	
	private class FontSizePanel extends JPanel {
		private final String[] fontSizeTags = new String[] {"Tiny", "Small", "Medium", "Large"};
		
		private JLabel textLabel;
		private JTextField inputField;
		private JComboBox<String> fontSizeBox;
		
		public FontSizePanel() {
			textLabel = new JLabel("Text: ");
			add(textLabel);
			
			inputField = new JTextField("thing");
			inputField.addActionListener(new TextFieldListener());
			add(inputField);
			
			fontSizeBox = new JComboBox<String>(fontSizeTags);
			fontSizeBox.addActionListener(new FontSizeListener());
		    add(fontSizeBox);
		}
		
		private class TextFieldListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent event) {
				formattedTextLabel.setText(inputField.getText()); 
			}
			
		}
		
		private class FontSizeListener implements ActionListener {
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
	}
	
	private class FontStylePanel extends JPanel {
		private JRadioButton plain, bold, italic, boldItalic;
		
		public FontStylePanel() {
			plain = new JRadioButton("Plain");
			bold = new JRadioButton("Bold");
			italic = new JRadioButton("Italic");
			boldItalic = new JRadioButton("Bold Italic");
			
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
			
			add(plain);
			add(bold);
			add(italic);
			add(boldItalic);
		}
		
		private class FontStyleListener implements ActionListener {

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
	}
	
}
