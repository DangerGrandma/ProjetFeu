package essentiels;

import javax.swing.JPanel;
import javax.swing.Timer;

import essentiels.elementsRoute.Bretelle;
import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Troncon1;
import essentiels.elementsRoute.Troncon2;
import essentiels.elementsRoute.Troncon3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class Chrono extends JPanel {

	// Paramètres de temps
	
	protected static int secondes = 0;
	protected static int minutes = 0;
	protected static int millisecondes = 0;

// Le chronomètre est un objet JPanel à placer sur un interface graphique
	
	public Chrono() {
		
		setLayout(null);

		// Texte affichant les millisecondes au chronomètre
		
		JLabel Bt_Millis = new JLabel("0");
		Bt_Millis.setForeground(Color.BLACK);
		Bt_Millis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Millis.setBounds(100, 11, 46, 14);
		add(Bt_Millis);
		
		// Texte affichant les minutes au chronomètre
		
		JLabel Bt_Mins = new JLabel("0 :");
		Bt_Mins.setForeground(Color.BLACK);
		Bt_Mins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Mins.setBounds(20, 11, 46, 14);
		add(Bt_Mins);
	
		// Texte affichant les secondes au chronomètre
		
		JLabel Bt_Secs = new JLabel("0 :");
		Bt_Secs.setForeground(Color.BLACK);
		Bt_Secs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Secs.setBounds(60, 11, 46, 14);
		add(Bt_Secs);
		
		// Création d'un objet Timer. Il se met à jour au 8 millisecondes
		
		Timer T = new Timer(8, new ActionListener()
	    {
	        public void actionPerformed (ActionEvent e)
	        {
	        	
	        	// 8 millisecondes sont ajoutées à l'entier @param millisecondes, à toutes les 8 millisecondes
	        	
	            millisecondes+=8;
	            
	            // Mise à jour du chronomètre et son texte à toutes les 8 millisecondes
	            
	                    Bt_Millis.setText(""+millisecondes);
	                    if (millisecondes>=1000)  //Une seconde écoulée
	                    {
	                    	// Cette fonction réinitialise les millisecondes à 0 puis ajoute 1 seconde au chronomètre
	                        millisecondes = 0;
	                        Bt_Millis.setText(""+0);
	                        secondes++;
	                        Bt_Secs.setText(""+ secondes+"s :");
	                        
	                        // Mise à jour du nombre de voiture sur les éléments de la route
	                        Bretelle.MAJVoitures();
	                        Rondpoint.MAJVoitures();
	                        Troncon1.MAJVoitures();
	                        Troncon2.MAJVoitures();
	                        Troncon3.MAJVoitures();
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
		
		// Bouton pour démarrer le chronomètre
		
		JButton Btn_Start = new JButton("Lancer");
		Btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Start.setBounds(10, 36, 63, 18);
		Btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 T.start();

			}
		});
		add(Btn_Start);
		
		//Bouton pour recommencer le chronomètre
		
		JButton Btn_Reset = new JButton("Recommencer");
		Btn_Reset.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Reset.setBounds(24, 58, 107, 18);
		Btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T.stop();
				
				// Les voitures sur les éléments de la routes sont aussi réinitialisées
				
				Bretelle.ResetVoitures();
				Rondpoint.ResetVoitures();
				Troncon1.ResetVoitures();
				Troncon2.ResetVoitures();
                Troncon3.ResetVoitures();
                
				
		        millisecondes = 0;
		        minutes = 0;
		        secondes = 0;
		        Bt_Millis.setText(""+millisecondes+" :");
		        Bt_Mins.setText(""+minutes+" :");
		        Bt_Secs.setText(""+secondes+" :");
			}
		});
		add(Btn_Reset);
		
		//Bouton pour arrêter le chronomètre
		
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
