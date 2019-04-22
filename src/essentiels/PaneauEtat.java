package essentiels;

import javax.swing.JPanel;
import essentiels.elementsRoute.*;
import essentiels.elementsRoute.Route;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PaneauEtat extends JPanel implements Route {
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));

		JLabel labelneutre = new JLabel("");
		labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));
		add(labelneutre);

	}

	static class ImageChange extends TimerTask {
		@Override
		public void run() {
			//print pour tester la fonction
			//System.out.println(Bretelle.VtrBretelle.size());
			
			
			/**
			 * PROBLEME PCQ ON NE PEUT PAS ACCEDER A LABELNEUTRE DU CONSTRUCTOR
			 */
//			if (Bretelle.VtrBretelle.size() >= 0 && Bretelle.VtrBretelle.size() < 10) {
//				labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));
//			} else if (Bretelle.VtrBretelle.size() >= 10 && Bretelle.VtrBretelle.size() < 25) {
//				labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_risque.png")));
//			} else {
//				labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_congestion.png")));
//			}
		}

		public static void timeEtat() {
			timer = new Timer();
			timer.schedule(new PaneauEtat.ImageChange(), 0, 8);
		}

		public static void timeCancel() {
			timer.cancel();
		}

	}
	/*
	 *ici le probleme, on ne veut pas utiliser ce labelneutre la
	 */
	protected static JLabel labelneutre;
	static Timer timer;

}
