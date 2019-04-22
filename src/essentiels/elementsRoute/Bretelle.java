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
	
	// Variable du nombre de voitures g�n�r�es au lancement du programme, et un ArrayList pour les contenir

	public static ArrayList<Voiture> VtrBretelle = new ArrayList<Voiture>();

	// Initialisation de la repr�sentation graphique

	public Bretelle() {
		setLayout(null);
		VtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsBretelle.setBounds(11, 9, 140, 14);
		add(VtrsBretelle);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		int voituresMin = ComboBoxTrafic.getAutDebutMin();
		int voituresMax = ComboBoxTrafic.getAutDebutMax();
		 Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		for (int i = 1; i <= Voitures; i++) {
			VtrBretelle.add(new Voiture());
			VtrBretelle.get(i-1).setDestination();
			VtrBretelle.get(i-1).setTimeStamp();
		};
	}
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		VtrBretelle.clear();
		Bretelle.VtrsBretelle.setText("Voitures sur le Bretelle : ");
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le Bretelle. Ajustement au hasard, entre -2 voitures et + 2 voitures

	public static void MAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinAuto(), ComboBoxTrafic.getMaxAuto()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			VtrBretelle.add(0,new Voiture());
			VtrBretelle.get(0).setDestination();
			VtrBretelle.get(0).setTimeStamp();
		};
		}
		Bretelle.VtrsBretelle.setText("Voitures sur le Bretelle : " + (VtrBretelle.size()));
		checkRondpoint();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrBretelle.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
			return VtrBretelle.get(i).getDestination();
	};
	
	// V�rifie si le temps n�cessaire pour une voiture de se rendre � destination est �coul�. Si oui, la voiture est retir�e de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < VtrBretelle.size(); p++) {
		int x = VtrBretelle.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = VtrBretelle.get(p).getTimeStamp();
		if(y-z >= x) {
			VtrBretelle.remove(p);
		};
	}
			
	};
	
	/* V�rifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon1 peu y transf�rer une de ses voitures. Si oui, le listArray pour Troncon1
	   est r�duit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
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
	
	// Application de la destruction de voitures pour usage manuel	
	
	public static void destroyVoiture() {
		VtrBretelle.remove(0);
	
  }
}