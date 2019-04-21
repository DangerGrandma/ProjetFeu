package essentiels.elementsRoute;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//Objet pour le tronçon3 qui connecte au rondpoint

public class Troncon3 extends JPanel implements Route {
	
	// Objets voitures figurant sur le tronçon3, ajustement du nombre de voitures sur le tronçon3 et JLabel qui affiche ce nombre de voitures
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsTroncon = new JLabel("Voitures sur le rondpoint : "+Voitures);

	// Initialisation de la représentation graphique
	
	public Troncon3() {
		setLayout(null);		
		VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon.setBounds(150, 150, 140, 14);
		add(VtrsTroncon);	
	}
	
	// Fonction pour mettre à jour le nombre de voitures sur le tronçon3. Ajustement au hasard, entre -2 voitures et + 2 voitures

	public static void MAJVoitures() {
		Troncon3.modVoitures+= ThreadLocalRandom.current().nextInt(-2, 3);
        Troncon3.VtrsTroncon.setText("Voitures sur le troncon3 : "+ (Troncon3.Voitures + Troncon3.modVoitures));
	}

	// Fonction pour réinitialiser le nombre de voitures sur le tronçon3. Au hasard, entre 3 et 10 voitures.
	
	public static void ResetVoitures() {
		Troncon3.VtrsTroncon.setText("Voitures sur le troncon3 : ");
        Troncon3.modVoitures = ThreadLocalRandom.current().nextInt(3, 11);
	}
}
