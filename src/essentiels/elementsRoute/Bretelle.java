package essentiels.elementsRoute;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import essentiels.Chrono;
import essentiels.ComboBoxTrafic;
import essentiels.Voiture;

import java.awt.Font;

//Objet pour le Bretelle

public class Bretelle extends JPanel implements Route {

	// Objets voitures figurant sur le Bretelle, ajustement du nombre de voitures sur le Bretelle et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel VtrsBretelle = new JLabel("Voitures sur le Bretelle : " + Voitures);
	
	// @param VtrBretelle sert à contenir les voitures situées dans la ligne d'attente de la bretelle.

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
		int voituresMin = ComboBoxTrafic.getAutDebutMin();
		int voituresMax = ComboBoxTrafic.getAutDebutMax();
		 Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		for (int i = 1; i <= Voitures; i++) {
			VtrBretelle.add(new Voiture());

		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
	public static void ajoutVoitures() {
		Bretelle.VtrBretelle.add(0, new Voiture());
		Bretelle.VtrsBretelle.setText("Voitures sur la Bretelle : " + (VtrBretelle.size()));
	};
	
	// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
	
	public static void retraitVoiture() {
		if(VtrBretelle.size() > 0) {
		Bretelle.VtrBretelle.remove(0);
		Bretelle.VtrsBretelle.setText("Voitures sur la Bretelle : " + (VtrBretelle.size()));
		}
	};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		VtrBretelle.clear();
		Bretelle.VtrsBretelle.setText("Voitures sur la Bretelle : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Bretelle. Ajustement au hasard, selon l'heure du jour. 

	public static void MAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinAuto(), ComboBoxTrafic.getMaxAuto()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			VtrBretelle.add(0,new Voiture());

		};
		}
		Bretelle.VtrsBretelle.setText("Voitures sur le Bretelle : " + (VtrBretelle.size()));
		checkRondpoint();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrBretelle.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return VtrBretelle.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon1 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon1
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
public static void checkRondpoint() {
	int totalRondpoint = Rondpoint.getVoituresSize();
	if(totalRondpoint < 30 && VtrBretelle.size() >= 1) {
		destroyVoiture();
		Rondpoint.VtrRondpoint.add(0, new Voiture());
		Rondpoint.VtrRondpoint.get(0).setDestination();
		Rondpoint.VtrRondpoint.get(0).setTimeStamp();
			
		};
	};
	
	// Application de la destruction de voitures.
	
	public static void destroyVoiture() {
		VtrBretelle.remove(0);
	
  }
}