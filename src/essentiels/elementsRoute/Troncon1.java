package essentiels.elementsRoute;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import essentiels.ChoixVoitures;
import essentiels.Chrono;
import essentiels.ComboBoxTrafic;
import essentiels.Voiture;

import java.awt.Font;

//Objet pour le Tronçon1

public class Troncon1 extends JPanel implements Route {

	// Objets voitures figurant sur le Tronçon1, ajustement du nombre de voitures sur le Tronçon1 et JLabel qui affiche ce nombre de voitures

	private static int voitures;
	public static JLabel vtrsTroncon1 = new JLabel("voitures sur le troncon1 : " + voitures);
	
	// @param vtrTroncon1 sert à contenir les voitures situées dans la ligne d'attente du tronçon1.

	public static ArrayList<Voiture> vtrTroncon1 = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Troncon1() {
		setLayout(null);
		vtrsTroncon1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		vtrsTroncon1.setHorizontalAlignment(SwingConstants.CENTER);
		vtrsTroncon1.setBounds(11, 9, 140, 14);
		add(vtrsTroncon1);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		final int VOITURES_MIN;
		final int VOITURES_MAX;
		if (ChoixVoitures.getTron1Debut() != 0) {
			VOITURES_MIN = ChoixVoitures.getTron1Debut();
			VOITURES_MAX = ChoixVoitures.getTron1Debut();
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1);
		}
		else {
			VOITURES_MIN = ComboBoxTrafic.getTronDebutMin();
			VOITURES_MAX = ComboBoxTrafic.getTronDebutMax();
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1);
		}
		for (int i = 1; i <= voitures; i++) {
			vtrTroncon1.add(new Voiture());
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			vtrTroncon1.add(0, new Voiture());
			vtrsTroncon1.setText("voitures sur la troncon1 : " + (vtrTroncon1.size()));
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(vtrTroncon1.size() > 0) {
			vtrTroncon1.remove(0);
			vtrsTroncon1.setText("voitures sur la troncon1 : " + (vtrTroncon1.size()));
			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		vtrTroncon1.clear();
		vtrsTroncon1.setText("voitures sur le troncon1 : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon1. Ajustement au hasard, selon l'heure du jour.

	public static void majVoitures() {
		
		int nvlvoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlvoitures != 0) {
		for (int i = 1; i <= nvlvoitures; i++) {
			vtrTroncon1.add(0,new Voiture());
		};
		}
		
		Troncon1.vtrsTroncon1.setText("voitures sur le troncon1 : " + (vtrTroncon1.size()));
		checkRondpoint();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return vtrTroncon1.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return vtrTroncon1.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le troncon1 peu y transférer une de ses voitures. Si oui, le listArray pour troncon1
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && vtrTroncon1.size() >= 1) {
			destroyVoiture();
			Rondpoint.vtrRondpoint.add(0, new Voiture());
			Rondpoint.vtrRondpoint.get(0).setDestination();
			Rondpoint.vtrRondpoint.get(0).setTimeStamp();
			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		vtrTroncon1.remove(0);
	
  }
	
}