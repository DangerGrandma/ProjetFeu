// Classe PaneauEtat, versions 2.1.3, 22 avril 2019

package com.objet;

import javax.swing.JPanel;

import com.zone.*;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

// Paneau de l'état de la congestion du rondpoint

public class PaneauEtat extends Mecanisme {
	
	protected static JLabel labelneutre = new JLabel(""); // JLabel utilisé pour illustrer une image
	
	// Configuration dy Paneau
	
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));
		labelneutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_eneqiulibre.png")));
		add(labelneutre);

	}

	static class ImageChange extends TimerTask {
		public void run() {
			
			//print pour tester la fonction

			if (Rondpoint.VtrRondpoint.size() >= 0 && Rondpoint.VtrRondpoint.size() < 10) {
				labelneutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_eneqiulibre.png")));
			} else if (Rondpoint.VtrRondpoint.size() >= 10 && Rondpoint.VtrRondpoint.size() < 25) {
				labelneutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_risque.png")));
			} else {
				labelneutre.setIcon(new ImageIcon(getClass().getResource("/com/images/etat_congestion.png")));
			}
		}

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
