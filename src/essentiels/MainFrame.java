package essentiels;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	
	public MainFrame() {
		
		super("Feu Intelligent");
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		PaneauFeu test = new PaneauFeu();
		test.setBounds(10, 48, 58, 89);
		
		Container c = getContentPane();
		c.add(test);
		
		Chrono caca = new Chrono();
		caca.setBounds(285, 48, 170, 124);
		getContentPane().add(caca);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(0, 0, 74, 60);
		getContentPane().add(lblNewLabel);
		
		JLabel lblChronomtre = new JLabel("Chronom\u00E8tre");
		lblChronomtre.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		lblChronomtre.setBounds(309, 4, 120, 52);
		getContentPane().add(lblChronomtre);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(47, 79, 79));
		editorPane.setBounds(0, 0, 584, 90);
		getContentPane().add(editorPane);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
