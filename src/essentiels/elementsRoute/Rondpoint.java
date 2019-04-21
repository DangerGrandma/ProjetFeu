package essentiels.elementsRoute;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

//Objet pour le rondpoint

public class Rondpoint extends JPanel implements Route {
	
	// Objets voitures figurant sur le rondpoint, ajustement du nombre de voitures sur le rondpoint et JLabel qui affiche ce nombre de voitures
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsRondpoint = new JLabel("Voitures sur le rondpoint : "+Voitures);
		
	// Initialisation de la représentation graphique 
	
	public Rondpoint() {
		setLayout(null);		
		VtrsRondpoint.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsRondpoint.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsRondpoint.setBounds(11, 9, 140, 14);
		add(VtrsRondpoint);	
	}

	// Fonction pour mettre à jour le nombre de voitures sur le rondpoint. Ajustement au hasard, entre -2 voitures et + 2 voitures
	
	public static void MAJVoitures() {
		Rondpoint.modVoitures+= ThreadLocalRandom.current().nextInt(-2, 3);
        Rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : "+ (Rondpoint.Voitures + Rondpoint.modVoitures));
	}

	// Fonction pour réinitialiser le nombre de voitures sur le rondpoint. Au hasard, entre 3 et 10 voitures.
	
	public static void ResetVoitures() {
		Rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : ");
        Rondpoint.modVoitures = ThreadLocalRandom.current().nextInt(3, 11);	
	};
}
