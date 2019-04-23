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
	
	protected static JLabel labelNeutre = new JLabel("");
	
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));

	
		labelNeutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));
		add(labelNeutre);

	}

	static class ImageChange extends TimerTask {
		@Override
		public void run() {
			//print pour tester la fonction

			if (Bretelle.vtrBretelle.size() >= 0 && Bretelle.vtrBretelle.size() < 10) {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));
			} else if (Bretelle.vtrBretelle.size() >= 10 && Bretelle.vtrBretelle.size() < 25) {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_risque.png")));
			} else {
				labelNeutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_congestion.png")));
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
