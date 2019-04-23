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

//Objet pour le Tronçon3

public class Troncon3 extends JPanel implements Route {

	// Objets voitures figurant sur le Tronçon3, ajustement du nombre de voitures sur le Tronçon3 et JLabel qui affiche ce nombre de voitures

	private static int voitures;
	public static JLabel vtrsTroncon3 = new JLabel("voitures sur le Troncon3 : " + voitures);
	
	// @param vtrTroncon3 sert à contenir les voitures situées dans la ligne d'attente du tronçon2.

	public static ArrayList<Voiture> vtrTroncon3 = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Troncon3() {
		setLayout(null);
		vtrsTroncon3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		vtrsTroncon3.setHorizontalAlignment(SwingConstants.CENTER);
		vtrsTroncon3.setBounds(11, 9, 140, 14);
		add(vtrsTroncon3);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		final int VOITURES_MIN;
		final int VOITURES_MAX;
		if (ChoixVoitures.getTron3Debut() != 0) {
			VOITURES_MIN = ChoixVoitures.getTron3Debut();
			VOITURES_MAX = ChoixVoitures.getTron3Debut();
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1);
		}
		else {
			VOITURES_MIN = ComboBoxTrafic.getTronDebutMin();
			VOITURES_MAX = ComboBoxTrafic.getTronDebutMax();
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1);
		}
		for (int i = 1; i <= voitures; i++) {
			vtrTroncon3.add(new Voiture());
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			vtrTroncon3.add(0, new Voiture());
			vtrsTroncon3.setText("voitures sur le Troncon3 : " + (vtrTroncon3.size()));
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(vtrTroncon3.size() > 0) {
			vtrTroncon3.remove(0);
			vtrsTroncon3.setText("voitures sur le Troncon3 : " + (vtrTroncon3.size()));
			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		vtrTroncon3.clear();
		Troncon3.vtrsTroncon3.setText("voitures sur le Troncon3 : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon3. Ajustement au hasard, selon l'heure du jour.

	public static void majVoitures() {
		
		int nvlvoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlvoitures != 0) {
		for (int i = 1; i <= nvlvoitures; i++) {
			vtrTroncon3.add(0,new Voiture());
		};
		}
		
		Troncon3.vtrsTroncon3.setText("voitures sur le Troncon3 : " + (vtrTroncon3.size()));
		checkRondpoint();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return vtrTroncon3.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return vtrTroncon3.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon3 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon3
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && vtrTroncon3.size() >= 1) {
			destroyVoiture();
			Rondpoint.vtrRondpoint.add(0, new Voiture());
			Rondpoint.vtrRondpoint.get(0).setDestination();
			Rondpoint.vtrRondpoint.get(0).setTimeStamp();			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		vtrTroncon3.remove(0);
	
  }
	
}