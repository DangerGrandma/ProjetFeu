/** 
 * Classe PaneauFeu, version 3.1.7, 22 avril 2019
 * 
 * Il s'agit du paneau affichant l'�tat du feu, rouge ou vert. Les voitures
 * provenant de la bretelle n�cessitent le feu vert pour acc�der au rondpoint.
 * L'�tat de la lumi�re et sa dur�e changent selon la fil d'attente en bretelle
 * et le nombre de voitures sur le rondpoint.
 * 
 */

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

public class PaneauFeu extends EquipementIntelligent {

	private static int	 feuTemps;	// Nombre de temps d'activation du feu
	private static int	 timerStamp; // Empreinte de temps � laquelle le feu a �t� allum�
	private static boolean	 etat = true;  //true = feu vert false = feu rouge
	private static JLabel 	feuRouge; // Label o� l'�tat du feu est dispos�
	private JButton 	switchMode;  // Bouton pour changer le mode de automatique � intelligent

	public PaneauFeu() {
		
		setLayout(null);

		// Initialisation du paneau

		feuRouge = new JLabel(""); 

		// Changement de couleur du feu selon une valeur bool�enne

		if (etat) {
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

					if (etat) {
						etat = false;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feurouge.png")));
					}
	
					else {
						etat = true;
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
		
		 
	    // Creation et ajustement du bouton pour alterner entre le mode manuel et automatique du feu 
		
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
  
	// Retourne un boolean selon la couleur du feu: true veut dire que le feu est vert et false veut dire que le feu est rouge 
	
	public static boolean getEtat() { 
		return etat; 
	} 
	
	// R�initialisation du feu
	
	public static void resetFeu() {
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feuvert.png")));
		feuTemps = 0;
		timerStamp = 0;	
	};
	
	// Lancement du feu vert. @param feuTemps d�pend du nombre de voiture sur la bretelle
	
	public static void startVert() {
		feuTemps = (int)(Bretelle.getVoituresSize()/2);
		timerStamp = Chrono.getTimestamp();
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feuvert.png")));
		etat = true;
		System.out.println("Feu vert actif pour " + feuTemps + " secondes.");		
	};
	
	// Lancement du feu rouge. @param feuTemps d�pend du nombre de voiture sur le rondpoint
	
	public static void startRouge() {
		feuTemps = (int)(Rondpoint.getVoituresSize()/2);
		timerStamp = Chrono.getTimestamp();
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/com/images/feurouge.png")));
		etat = false;
		System.out.println("Feu rouge actif pour " + feuTemps + " secondes.");
		
	};
	
	// V�rification de l'empreinte de temps de lancement du feu. Changement de feu si le temps est �coul�
	
	public static void checkTimer() {
		if(Chrono.getTimestamp() - timerStamp >= feuTemps) {
			if(etat) {
				startRouge();
			}
			else {
				startVert();
			}	
		};
	};
	 
}
