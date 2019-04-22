package essentiels.elementsRoute;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import essentiels.Chrono;
import essentiels.Voiture;

import java.awt.Font;

//Objet pour le Bretelle

public class Bretelle extends JPanel implements Route {

	// Objets voitures figurant sur le Bretelle, ajustement du nombre de voitures sur le Bretelle et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel VtrsBretelle = new JLabel("Voitures sur le Bretelle : " + Voitures);
	
	// Variable du nombre de voitures générées au lancement du programme, et un ArrayList pour les contenir

	public static ArrayList<Voiture> VtrBretelle = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Bretelle() {
		setLayout(null);
		VtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsBretelle.setBounds(11, 9, 140, 14);
		add(VtrsBretelle);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		 Voitures = ThreadLocalRandom.current().nextInt(1, 6);
		for (int i = 1; i <= Voitures; i++) {
			VtrBretelle.add(new Voiture());
			VtrBretelle.get(i-1).setDestination();
			VtrBretelle.get(i-1).setTimeStamp();
		};
	}
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		VtrBretelle.clear();
		Bretelle.VtrsBretelle.setText("Voitures sur le Bretelle : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Bretelle. Ajustement au hasard, entre -2 voitures et + 2 voitures

	public static void MAJVoitures() {
		Bretelle.VtrsBretelle.setText("Voitures sur le Bretelle : " + (VtrBretelle.size()));
		destroyVoiture();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrBretelle.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return VtrBretelle.get(i).getDestination();
	};
	
	// Vérifie si le temps nécessaire pour une voiture de se rendre à destination est écoulé. Si oui, la voiture est retirée de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < VtrBretelle.size(); p++) {
		int x = VtrBretelle.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = VtrBretelle.get(p).getTimeStamp();
		if(y-z >= x) {
			VtrBretelle.remove(p);
		};
	}
	
	// Application de la destruction de voitures pour usage manuel	
		
	};
	public static void destroyVoiture() {
	for(int i = 0; i < Bretelle.getVoituresSize(); i++) {
		Bretelle.checkDest();	
	};
	
  }
}