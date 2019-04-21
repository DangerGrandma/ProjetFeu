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
		setResizable(false);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		PaneauFeu test = new PaneauFeu();
		test.setBackground(new Color(47, 79, 79));
		test.setBounds(677, 20, 58, 89);
		
		ComboBoxTrafic menuTrafic = new ComboBoxTrafic();
		menuTrafic.setBackground(new Color(47, 79, 79));
		menuTrafic.setBounds(514, 12, 133, 40);
		getContentPane().add(menuTrafic);
		
		Container c = getContentPane();
		c.add(test);
		
		JLabel lblChronomtre = new JLabel("Chronom\u00E8tre");
		lblChronomtre.setForeground(Color.BLACK);
		lblChronomtre.setBounds(784, 0, 120, 52);
		getContentPane().add(lblChronomtre);
		lblChronomtre.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		
		Chrono caca = new Chrono();
		caca.setBackground(new Color(47, 79, 79));
		caca.setBounds(764, 28, 170, 81);
		getContentPane().add(caca);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(24, 28, 99, 60);
		getContentPane().add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setEnabled(false);
		editorPane.setBackground(new Color(47, 79, 79));
		editorPane.setBounds(0, 0, 944, 116);
		getContentPane().add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(new Color(95, 158, 160));
		editorPane_1.setBounds(0, 114, 154, 557);
		getContentPane().add(editorPane_1);
		
		setSize(950, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
