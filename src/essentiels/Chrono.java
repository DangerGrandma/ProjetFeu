package essentiels;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Chrono extends JPanel {

    private static int secondes = 0;
    private static int minutes = 0;
    private static int millisecondes = 0;

	/**
	 * Create the panel.
	 */
    
    
	public Chrono() {
		
		setLayout(null);

		JLabel Bt_Mins = new JLabel("00 :");
		Bt_Mins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Mins.setBounds(20, 11, 46, 14);
		add(Bt_Mins);
		
		JLabel Bt_Secs = new JLabel("00 :");
		Bt_Secs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Secs.setBounds(60, 11, 46, 14);
		add(Bt_Secs);

		JLabel Bt_Millis = new JLabel("0000");
		Bt_Millis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Millis.setBounds(100, 11, 46, 14);
		add(Bt_Millis);
		
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
		Btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Start.setBounds(10, 36, 63, 18);
		Btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 T.start();
			}
		});
		add(Btn_Start);
		
		JButton Btn_Reset = new JButton("Recommencer");
		Btn_Reset.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Reset.setBounds(24, 58, 107, 18);
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
		add(Btn_Reset);
		
		JButton Btn_Stop = new JButton("Arreter");
		Btn_Stop.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Stop.setBounds(80, 36, 63, 18);
		Btn_Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  T.stop();
			}
		});
		add(Btn_Stop);
	}
}
