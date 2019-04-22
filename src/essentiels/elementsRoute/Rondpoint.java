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

//Objet pour le rondpoint

public class Rondpoint extends JPanel implements Route {

	// Objets voitures figurant sur le rondpoint, ajustement du nombre de voitures sur le rondpoint et JLabel qui affiche ce nombre de voitures

	private static int Voitures;;
	public static JLabel VtrsRondpoint = new JLabel("Voitures sur le rondpoint : " + Voitures);
	
	// @param VtrRondpoint sert à contenir les voitures situées dans la ligne d'attente du rondpoint.
	
	public static ArrayList<Voiture> VtrRondpoint = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Rondpoint() {
		setLayout(null);
		VtrsRondpoint.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsRondpoint.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsRondpoint.setBounds(11, 9, 140, 14);
		add(VtrsRondpoint);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition. Les intervalles de création dépendent du moment du jour
	
	public static void genVoitures() {
		
		int voituresMin;
		int voituresMax;
		if (ChoixVoitures.getRondpointDebut() != 0) {
			voituresMin = ChoixVoitures.getRondpointDebut();
			voituresMax = ChoixVoitures.getRondpointDebut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		else {
			voituresMin = ComboBoxTrafic.getRondpointDebutMin();
			voituresMax = ComboBoxTrafic.getRondpointDebutMax();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		for (int i = 1; i <= Voitures; i++) {
			VtrRondpoint.add(new Voiture());
			VtrRondpoint.get(i-1).setDestination();
			VtrRondpoint.get(i-1).setTimeStamp();
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			VtrRondpoint.add(0, new Voiture());
			VtrRondpoint.get(0).setDestination();
			VtrRondpoint.get(0).setTimeStamp();
			checkDest();
			VtrsRondpoint.setText("Voitures sur le Rondpoint : " + (VtrRondpoint.size()));
			
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(VtrRondpoint.size() > 0) {
			VtrRondpoint.remove(0);
			checkDest();
			VtrsRondpoint.setText("Voitures sur le Rondpoint : " + (VtrRondpoint.size()));
			
			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		VtrRondpoint.clear();
		Rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le rondpoint.

	public static void MAJVoitures() {
		
		Rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : " + (VtrRondpoint.size()));
		destroyVoiture();
	}	
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Rondpoint.VtrsRondpoint.setText("Voitures sur la rondpoint : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrRondpoint.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return VtrRondpoint.get(i).getDestination();
	};
	
	// Vérifie si le temps nécessaire pour une voiture de se rendre à destination est écoulé. Si oui, la voiture est retirée de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < VtrRondpoint.size(); p++) {
		int x = VtrRondpoint.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = VtrRondpoint.get(p).getTimeStamp();
		if(y-z >= x) {
			VtrRondpoint.remove(p);
		};
	}
	
	};
	
	// Application de la destruction de voitures pour usage manuel	
	
	public static void destroyVoiture() {
	for(int i = 0; i < Rondpoint.getVoituresSize(); i++) {
		Rondpoint.checkDest();	
	};
	
  }
}
	

