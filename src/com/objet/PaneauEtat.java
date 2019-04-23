/** 
 * Classe PaneauEtat, versions 2.1.3, 22 avril 2019
 * 
 * Il s'agit du paneau d'état de congestion de la route. Il est
 * mis-à-jour à chaque seconde et vérifie le nombre de voitures à
 * l'intérieur du rondpoint. 
 */

package com.objet;

import javax.swing.JPanel;

import com.zone.*;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

// Paneau de l'état de la congestion du rondpoint

public class PaneauEtat extends EquipementIntelligent {
	
	protected static JLabel labelNeutre = new JLabel("");  // JLabel utilisé pour illustrer une image
	
	// Configuration dy Paneau
	
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));
		labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_eneqiulibre.png")));
		add(labelNeutre);

	}

	static class ImageChange extends TimerTask {
		public void run() {
			
			// Paramètres de congestion. L'image du paneau change en conséquence de son état

			if (Rondpoint.FilAttente.size() >= 0 && Rondpoint.FilAttente.size() < 10) {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_eneqiulibre.png")));
			} else if (Rondpoint.FilAttente.size() >= 10 && Rondpoint.FilAttente.size() < 21) {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_risque.png")));
			} else {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_congestion.png")));
			}
		}

		// Chronomètre personalisé pour @class PaneauEtat et son affichage
		
		public static void timeEtat() {
			timer = new Timer();
			timer.schedule(new PaneauEtat.ImageChange(), 0, 8);
		}

		public static void timeCancel() {
			timer.cancel();
		}

	}

	static Timer timer;
}
