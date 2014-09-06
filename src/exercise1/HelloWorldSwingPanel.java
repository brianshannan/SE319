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
		
		JPanel fontSizePanel = this.formFontSizePanel();
		add(fontSizePanel);
		
		JPanel fontStylePanel = this.formFontStylePanel();
	    fontStylePanel.setLayout(new BoxLayout(fontStylePanel, BoxLayout.Y_AXIS));
	    add(fontStylePanel);
		
		add(formattedTextLabel);
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
	
}
