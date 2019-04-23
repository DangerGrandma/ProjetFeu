package com.objet;

import javax.swing.JPanel;

import com.zone.Bretelle;
import com.zone.Rondpoint;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets; 
import java.util.Timer; 
import java.util.TimerTask; 


// Paneau du feu intelligent

public class PaneauFeu extends JPanel {

	private static int feuTemps;
	private static int timerStamp;
	private static boolean etatFeu = true;
	private static JLabel feuRouge; 
	private JButton switchMode; 

	public PaneauFeu() {
		
		setLayout(null);

		// Initialisation du paneau

		feuRouge = new JLabel(""); 

		// Changement de couleur du feu selon une valeur booléenne

		if (etatFeu) {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feuvert.png")));
		} else {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feurouge.png")));
		}
		feuRouge.setBounds(14, 0, 30, 65); 
		add(feuRouge);

		// Bouton pour ajuster manuellement la couleur du feu

		JButton btnFeu = new JButton("Switch");
		btnFeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (switchMode.getText().equals("Manuel")) { 

					if (etatFeu) {
						etatFeu = false;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feurouge.png")));
					}
	
					else {
						etatFeu = true;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feuvert.png")));
	
					}
				}
			}
		});
		btnFeu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFeu.setBounds(0, 68, 58, 20); 
		btnFeu.setMargin(new Insets(0, 0, 0, 0)); 
		btnFeu.setBackground(Color.GRAY); 
		add(btnFeu);
		
		 
	    // creation et ajustement du bouton pour alterner entre le mode manuel et automatique du feu 
		
		switchMode = new JButton("Intelligent"); 
		switchMode.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				
				if (switchMode.getText().equals("Intelligent")) { 

					switchMode.setText("Manuel"); 
					btnFeu.setBackground(new JButton().getBackground()); 
				} 
				
				else { 
					
					switchMode.setText("Intelligent"); 
					btnFeu.setBackground(Color.GRAY);					
				} 
			} 
		}); 
		switchMode.setFont(new Font("Tahoma", Font.PLAIN, 9)); 
		switchMode.setBounds(0, 88, 58, 20); 
		switchMode.setMargin(new Insets(0, 0, 0, 0)); 
		add(switchMode); 

	}
  
	//retourne un boolean selon la couleur du feu: true veut dire que le feu est vert et false veut dire que le feu est rouge 
	
	public static boolean getEtatFeu() { 
		return etatFeu; 
	} 
	
	public static void resetFeu() {
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feuvert.png")));
		feuTemps = 0;
		timerStamp = 0;
		
	};
	
	public static void startVert() {
		feuTemps = (int)(Bretelle.getVoituresSize()/2);
		timerStamp = Chrono.getTimestamp();
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feuvert.png")));
		etatFeu = true;
		System.out.println("Feu vert actif pour " + feuTemps + " secondes.");		
	};
	
	public static void startRouge() {
		feuTemps = (int)(Rondpoint.getVoituresSize()/2);
		timerStamp = Chrono.getTimestamp();
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feurouge.png")));
		etatFeu = false;
		System.out.println("Feu rouge actif pour " + feuTemps + " secondes.");
		
	};
	
	public static void checkTimer() {
		if(Chrono.getTimestamp() - timerStamp >= feuTemps) {
			if(etatFeu) {
				startRouge();
			}
			else {
				startVert();
			}	
		};
	};
	 
}
