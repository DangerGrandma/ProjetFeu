package essentiels.elementsRoute;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import essentiels.Chrono;
import essentiels.Voiture;

import java.awt.Font;

//Objet pour le Tronçon3

public class Troncon3 extends JPanel implements Route {

	// Objets voitures figurant sur le Tronçon3, ajustement du nombre de voitures sur le Tronçon3 et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel VtrsTroncon3 = new JLabel("Voitures sur le Troncon3 : " + Voitures);
	
	// Variable du nombre de voitures générées au lancement du programme, et un ArrayList pour les contenir

	public static ArrayList<Voiture> VtrTroncon3 = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Troncon3() {
		setLayout(null);
		VtrsTroncon3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon3.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon3.setBounds(11, 9, 140, 14);
		add(VtrsTroncon3);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		 Voitures = ThreadLocalRandom.current().nextInt(1, 6);
		for (int i = 1; i <= Voitures; i++) {
			VtrTroncon3.add(new Voiture());
			VtrTroncon3.get(i-1).setDestination();
			VtrTroncon3.get(i-1).setTimeStamp();
		};
	}
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		VtrTroncon3.clear();
		Troncon3.VtrsTroncon3.setText("Voitures sur le Troncon3 : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon3. Ajustement au hasard, entre -2 voitures et + 2 voitures

	public static void MAJVoitures() {
		Troncon3.VtrsTroncon3.setText("Voitures sur le Troncon3 : " + (VtrTroncon3.size()));
		destroyVoiture();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrTroncon3.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return VtrTroncon3.get(i).getDestination();
	};
	
	// Vérifie si le temps nécessaire pour une voiture de se rendre à destination est écoulé. Si oui, la voiture est retirée de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < VtrTroncon3.size(); p++) {
		int x = VtrTroncon3.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = VtrTroncon3.get(p).getTimeStamp();
		if(y-z >= x) {
			VtrTroncon3.remove(p);
		};
	}
	
	// Application de la destruction de voitures pour usage manuel	
		
	};
	public static void destroyVoiture() {
	for(int i = 0; i < Troncon3.getVoituresSize(); i++) {
		Troncon3.checkDest();	
	};
	
  }
}