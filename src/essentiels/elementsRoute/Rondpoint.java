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

//Objet pour le rondpoint

public class Rondpoint extends JPanel implements Route {

	// Objets voitures figurant sur le rondpoint, ajustement du nombre de voitures sur le rondpoint et JLabel qui affiche ce nombre de voitures

	private static int Voitures;;
	public static JLabel VtrsRondpoint = new JLabel("Voitures sur le rondpoint : " + Voitures);
	
	// Variable du nombre de voitures g�n�r�es au lancement du programme, et un ArrayList pour les contenir

	public static ArrayList<Voiture> VtrRondpoint = new ArrayList<Voiture>();

	// Initialisation de la repr�sentation graphique

	public Rondpoint() {
		setLayout(null);
		VtrsRondpoint.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsRondpoint.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsRondpoint.setBounds(11, 9, 140, 14);
		add(VtrsRondpoint);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition. Les intervalles de cr�ation d�pendent du moment du jour
	
	public static void genVoitures() {
		int voituresMin = ComboBoxTrafic.getAutDebutMin();
		int voituresMax = ComboBoxTrafic.getAutDebutMax();
		 Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		for (int i = 1; i <= Voitures; i++) {
			VtrRondpoint.add(new Voiture());
			VtrRondpoint.get(i-1).setDestination();
			VtrRondpoint.get(i-1).setTimeStamp();
		};
	}
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		VtrRondpoint.clear();
		Rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : ");
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le rondpoint. Ajustement au hasard, entre -2 voitures et + 2 voitures

	public static void MAJVoitures() {
		
		Rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : " + (VtrRondpoint.size()));
		destroyVoiture();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrRondpoint.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
			return VtrRondpoint.get(i).getDestination();
	};
	
	// V�rifie si le temps n�cessaire pour une voiture de se rendre � destination est �coul�. Si oui, la voiture est retir�e de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < VtrRondpoint.size(); p++) {
		int x = VtrRondpoint.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = VtrRondpoint.get(p).getTimeStamp();
		if(y-z >= x) {
			VtrRondpoint.remove(p);
		};
	}
	
	// Application de la destruction de voitures pour usage manuel	
		
	};
	public static void destroyVoiture() {
	for(int i = 0; i < Rondpoint.getVoituresSize(); i++) {
		Rondpoint.checkDest();	
	};
	
  }
}
	

