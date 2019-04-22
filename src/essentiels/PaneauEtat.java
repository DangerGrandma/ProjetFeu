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
	
	protected static JLabel labelneutre = new JLabel("");
	
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));

	
		labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));
		add(labelneutre);

	}

	static class ImageChange extends TimerTask {
		@Override
		public void run() {
			//print pour tester la fonction

			if (Rondpoint.VtrRondpoint.size() >= 0 && Rondpoint.VtrRondpoint.size() < 10) {
				labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));
			} else if (Rondpoint.VtrRondpoint.size() >= 10 && Rondpoint.VtrRondpoint.size() < 25) {
				labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_risque.png")));
			} else {
				labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_congestion.png")));
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
