package exercise1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelloWorldSwingFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldSwingFrame2 frame = new HelloWorldSwingFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelloWorldSwingFrame2() {
		setTitle("HelloWorldSwing!");
		setBounds(100, 100, 372, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblText = new JLabel("Text:    ");
		panel.add(lblText);
		final JLabel label = new JLabel("Hello World!");
		input = new JTextField();
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(input.getText());
			}
		});
		input.setText("Hello World!\n");
		panel.add(input);
		input.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		final String[] fontSizeTags = new String[] {"Tiny", "Small", "Medium", "Large"};
		comboBox.setModel(new DefaultComboBoxModel(fontSizeTags));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
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

				label.setFont(label.getFont().deriveFont(fontSize));
			}
		});
		
		panel.add(comboBox);
		
		
		
		JButton btnShow = new JButton("Show!");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color oldFontColor = label.getForeground();
				Color newFontColor = oldFontColor == Color.RED ? Color.BLACK : Color.RED;
				label.setForeground(newFontColor);
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelloWorldSwingFrame2.super.dispose();
			}
		});
		
		JRadioButton rdbtnPlain = new JRadioButton("Plain");
		rdbtnPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setFont(label.getFont().deriveFont(Font.PLAIN));
			}
		});
		buttonGroup.add(rdbtnPlain);
		
		JRadioButton rdbtnBold = new JRadioButton("Bold");
		rdbtnBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setFont(label.getFont().deriveFont(Font.BOLD));
			}
		});
		buttonGroup.add(rdbtnBold);
		
		JRadioButton rdbtnItalic = new JRadioButton("Italic");
		rdbtnItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setFont(label.getFont().deriveFont(Font.ITALIC));
			}
		});
		buttonGroup.add(rdbtnItalic);
		
		JRadioButton rdbtnBoldItalic = new JRadioButton("Bold Italic");
		rdbtnBoldItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setFont(label.getFont().deriveFont(Font.BOLD + Font.ITALIC));
			}
		});
		buttonGroup.add(rdbtnBoldItalic);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnBold)
							.addGap(78)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addComponent(btnShow)
							.addGap(60)
							.addComponent(btnExit))
						.addComponent(rdbtnPlain)
						.addComponent(rdbtnItalic)
						.addComponent(rdbtnBoldItalic)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(rdbtnPlain)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(rdbtnBold))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnItalic)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnBoldItalic)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShow)
						.addComponent(btnExit))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
