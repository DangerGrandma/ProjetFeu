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

	private static int Voitures;
	public static JLabel VtrsTroncon3 = new JLabel("Voitures sur le Troncon3 : " + Voitures);
	
	// @param VtrTroncon3 sert à contenir les voitures situées dans la ligne d'attente du tronçon2.

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
		int voituresMin;
		int voituresMax;
		if (ChoixVoitures.getTron3Debut() != 0) {
			voituresMin = ChoixVoitures.getTron3Debut();
			voituresMax = ChoixVoitures.getTron3Debut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		else {
			voituresMin = ComboBoxTrafic.getTronDebutMin();
			voituresMax = ComboBoxTrafic.getTronDebutMax();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		for (int i = 1; i <= Voitures; i++) {
			VtrTroncon3.add(new Voiture());
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			VtrTroncon3.add(0, new Voiture());
			VtrsTroncon3.setText("Voitures sur le Troncon3 : " + (VtrTroncon3.size()));
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(VtrTroncon3.size() > 0) {
			VtrTroncon3.remove(0);
			VtrsTroncon3.setText("Voitures sur le Troncon3 : " + (VtrTroncon3.size()));
			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		VtrTroncon3.clear();
		Troncon3.VtrsTroncon3.setText("Voitures sur le Troncon3 : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon3. Ajustement au hasard, selon l'heure du jour.

	public static void MAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			VtrTroncon3.add(0,new Voiture());
		};
		}
		
		Troncon3.VtrsTroncon3.setText("Voitures sur le Troncon3 : " + (VtrTroncon3.size()));
		checkRondpoint();
	}	
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Troncon3.VtrsTroncon3.setText("Voitures sur le Troncon3 : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrTroncon3.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return VtrTroncon3.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon3 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon3
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && VtrTroncon3.size() >= 1) {
			destroyVoiture();
			Rondpoint.VtrRondpoint.add(0, new Voiture());
			Rondpoint.VtrRondpoint.get(0).setDestination();
			Rondpoint.VtrRondpoint.get(0).setTimeStamp();			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		VtrTroncon3.remove(0);
	
  }
	
}