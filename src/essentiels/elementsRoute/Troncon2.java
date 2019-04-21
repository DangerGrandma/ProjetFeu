package essentiels.elementsRoute;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//Objet pour le tron�on2 qui connecte au rondpoint

public class Troncon2 extends JPanel implements Route {
	
	// Objets voitures figurant sur le tron�on2, ajustement du nombre de voitures sur le tron�on2 et JLabel qui affiche ce nombre de voitures
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsTroncon = new JLabel("Voitures sur le rondpoint : "+Voitures);
	
	// Initialisation de la repr�sentation graphique 
	
	public Troncon2() {
		setLayout(null);		
		VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon.setBounds(100, 100, 140, 14);
		add(VtrsTroncon);	
	}
	
	// Fonction pour mettre � jour le nombre de voitures sur le tron�on2. Ajustement au hasard, entre -2 voitures et + 2 voitures
	
	public static void MAJVoitures() {
		Troncon2.modVoitures+= ThreadLocalRandom.current().nextInt(-2, 3);
        Troncon2.VtrsTroncon.setText("Voitures sur le troncon2 : "+ (Troncon2.Voitures + Troncon2.modVoitures));
	}
	
	// Fonction pour r�initialiser le nombre de voitures sur le tron�on2. Au hasard, entre 3 et 10 voitures.
	
	public static void ResetVoitures() {	
        Troncon2.modVoitures = ThreadLocalRandom.current().nextInt(3, 11);
        Troncon2.VtrsTroncon.setText("Voitures sur le troncon2 : ");
		
	};

}
