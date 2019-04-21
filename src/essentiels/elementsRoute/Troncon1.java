package essentiels.elementsRoute;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//Objet pour la bretelle qui connecte l'autoroute au rond point

public class Troncon1 extends JPanel implements Route {
	
	// Objets voitures figurant sur la bretelle, ajustement du nombre de voitures sur la bretelle et JLabel qui affiche ce nombre de voitures
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsTroncon = new JLabel("Voitures sur le rondpoint : "+Voitures);
	
	// Initialisation de la représentation graphique 
	
	public Troncon1() {
		setLayout(null);		
		VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon.setBounds(50, 50, 140, 14);
		add(VtrsTroncon);		
	}
	
	// Fonction pour mettre à jour le nombre de voitures sur la bretelle. Ajustement au hasard, entre -2 voitures et + 2 voitures
	
	public static void MAJVoitures() {
		Troncon1.modVoitures+= ThreadLocalRandom.current().nextInt(-2, 3);
        Troncon1.VtrsTroncon.setText("Voitures sur le troncon1 : "+ (Troncon1.Voitures + Troncon1.modVoitures));
	}

	// Fonction pour réinitialiser le nombre de voitures sur la bretelle. Au hasard, entre 3 et 10 voitures.
	
	public static void ResetVoitures() {
		Troncon1.VtrsTroncon.setText("Voitures sur le troncon1 : ");
        Troncon1.modVoitures = ThreadLocalRandom.current().nextInt(3, 11);
		
	};

}
