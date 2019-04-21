package essentiels.elementsRoute;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Objet pour la bretelle qui connecte l'autoroute au rond point

public class Bretelle extends JPanel implements Route {

	// Objets voitures figurant sur la bretelle, ajustement du nombre de voitures sur la bretelle et JLabel qui affiche ce nombre de voitures
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsBretelle = new JLabel("Voitures sur la bretelle : "+Voitures);
		
	// Initialisation de la représentation graphique 
	
	public Bretelle() {
		setLayout(null);		
		VtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsBretelle.setBounds(50, 50, 140, 14);
		add(VtrsBretelle);	
	}
	
	// Fonction pour mettre à jour le nombre de voitures sur la bretelle. Ajustement au hasard, entre -2 voitures et + 2 voitures
	
	public static void MAJVoitures() {
		Bretelle.modVoitures+= ThreadLocalRandom.current().nextInt(-2, 3);
		Bretelle.VtrsBretelle.setText("Voitures sur la bretelle : "+ (Bretelle.Voitures + Bretelle.modVoitures));
	}
	
	// Fonction pour réinitialiser le nombre de voitures sur la bretelle. Au hasard, entre 3 et 10 voitures.
	
	public static void ResetVoitures() {
		Bretelle.VtrsBretelle.setText("Voitures sur la bretelle : ");
        Bretelle.modVoitures = ThreadLocalRandom.current().nextInt(3, 11);
		
	}

}
