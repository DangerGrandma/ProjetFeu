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

public class MainFrame extends JFrame {
	
	
	public MainFrame() {
		
		super("Feu Intelligent");
		getContentPane().setLayout(null);
		
		Chrono caca = new Chrono();
		caca.setBounds(155, 113, 156, 100);
		
		PaneauFeu test = new PaneauFeu();
		test.setBounds(321, 124, 58, 89);
		
		Container c = getContentPane();
		c.add(caca);
		c.add(test);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
