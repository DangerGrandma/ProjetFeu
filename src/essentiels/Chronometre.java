package essentiels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.Timer;
import java.awt.Color;

public class Chronometre extends JFrame {

	private JPanel contentPane;
    private static int secondes = 0;
    private static int minutes = 0;
    private static int millisecondes = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chronometre frame = new Chronometre();
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
	public Chronometre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelChrono = new JPanel();
		panelChrono.setBackground(Color.MAGENTA);
		panelChrono.setBounds(264, 79, 168, 95);
		contentPane.add(panelChrono);
		panelChrono.setLayout(null);
		
		JLabel Bt_Mins = new JLabel("00 :");
		Bt_Mins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Mins.setBounds(20, 11, 46, 14);
		panelChrono.add(Bt_Mins);
		
		JLabel Bt_Secs = new JLabel("00 :");
		Bt_Secs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Secs.setBounds(60, 11, 46, 14);
		panelChrono.add(Bt_Secs);
		
		JLabel Bt_Millis = new JLabel("0000");
		Bt_Millis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Millis.setBounds(100, 11, 46, 14);
		panelChrono.add(Bt_Millis);
		
		Timer T = new Timer(8, new ActionListener()
	    {
	        public void actionPerformed (ActionEvent e)
	        {
	            millisecondes+=8;
	            
	                    Bt_Millis.setText(""+millisecondes);
	                    if (millisecondes>=1000)  //Une seconde écoulée
	                    {
	                        millisecondes = 0;
	                        Bt_Millis.setText(""+0);
	                        secondes++;
	                        Bt_Secs.setText(""+ secondes+"s :");
	                     
	                    }
	                    if(secondes>=60) //Une minute écoulée
	                    {
	                         secondes = 0;
	                         Bt_Secs.setText(""+ 0);
	                         minutes++;
	                         Bt_Mins.setText(""+ minutes+"m :");
	                    }
	        }
	    });
		
		JButton Btn_Start = new JButton("Lancer");
		Btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 T.start();
			}
		});

		Btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Start.setBounds(10, 36, 63, 23);
		panelChrono.add(Btn_Start);
		
		JButton Btn_Stop = new JButton("Arr\u00EAter");
		Btn_Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  T.stop();
			}
		});
		Btn_Stop.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Stop.setBounds(80, 36, 63, 23);
		panelChrono.add(Btn_Stop);
		
		JButton Btn_Reset = new JButton("Recommencer");
		Btn_Reset.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T.stop();
		        millisecondes = 0;
		        minutes = 0;
		        secondes = 0;
		        Bt_Millis.setText(""+millisecondes+" :");
		        Bt_Mins.setText(""+minutes+" :");
		        Bt_Secs.setText(""+secondes+" :");
			}
		});
		Btn_Reset.setBounds(24, 61, 107, 23);
		panelChrono.add(Btn_Reset);
		
		

		
		
	}

}

