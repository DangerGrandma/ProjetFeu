package essentiels;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

public class MainFrame extends JFrame {
	
	
	private JTextArea textArea;
	private JButton btn;
	
	
	public MainFrame() {
		super("Hello");
		
		setLayout(new BorderLayout());
		textArea = new JTextArea();
		btn = new JButton("Click me!");
		
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



}
