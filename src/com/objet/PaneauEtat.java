/** 
 * Classe PaneauEtat, versions 2.1.3, 22 avril 2019
 * 
 * Il s'agit du paneau d'�tat de congestion de la route. Il est
 * mis-�-jour � chaque seconde et v�rifie le nombre de voitures �
 * l'int�rieur du rondpoint. 
 */

package com.objet;

import javax.swing.JPanel;

import com.zone.*;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

// Paneau de l'�tat de la congestion du rondpoint

public class PaneauEtat extends EquipementIntelligent {
	
	protected static JLabel labelNeutre = new JLabel("");  // JLabel utilis� pour illustrer une image
	
	// Configuration dy Paneau
	
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));
		labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_eneqiulibre.png")));
		add(labelNeutre);

	}

	static class ImageChange extends TimerTask {
		public void run() {
			
			// Param�tres de congestion. L'image du paneau change en cons�quence de son �tat

			if (Rondpoint.FilAttente.size() >= 0 && Rondpoint.FilAttente.size() < 10) {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_eneqiulibre.png")));
			} else if (Rondpoint.FilAttente.size() >= 10 && Rondpoint.FilAttente.size() < 21) {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_risque.png")));
			} else {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_congestion.png")));
			}
		}

		// Chronom�tre personalis� pour @class PaneauEtat et son affichage
		
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
