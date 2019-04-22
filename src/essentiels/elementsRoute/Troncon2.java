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

//Objet pour le Tron�on2

public class Troncon2 extends JPanel implements Route {

	// Objets voitures figurant sur le Tron�on2, ajustement du nombre de voitures sur le Tron�on2 et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel VtrsTroncon2 = new JLabel("Voitures sur le Troncon2 : " + Voitures);
	
	// @param VtrTroncon2 sert � contenir les voitures situ�es dans la ligne d'attente du tron�on2.

	public static ArrayList<Voiture> VtrTroncon2 = new ArrayList<Voiture>();

	// Initialisation de la repr�sentation graphique

	public Troncon2() {
		setLayout(null);
		VtrsTroncon2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon2.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon2.setBounds(11, 9, 140, 14);
		add(VtrsTroncon2);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		int voituresMin = ComboBoxTrafic.getTronDebutMin();
		int voituresMax = ComboBoxTrafic.getTronDebutMax();
		Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		for (int i = 1; i <= Voitures; i++) {
			VtrTroncon2.add(new Voiture());
		};
	}
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		VtrTroncon2.clear();
		Troncon2.VtrsTroncon2.setText("Voitures sur le Troncon2 : ");
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le Tron�on2. Ajustement au hasard, selon l'heure du jour.

	public static void MAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			VtrTroncon2.add(0,new Voiture());
		};
		}
		
		Troncon2.VtrsTroncon2.setText("Voitures sur le Troncon2 : " + (VtrTroncon2.size()));
		checkRondpoint();
	}	
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrTroncon2.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
			return VtrTroncon2.get(i).getDestination();
	};
	
	/* V�rifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon2 peu y transf�rer une de ses voitures. Si oui, le listArray pour Troncon2
	   est r�duit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && VtrTroncon2.size() >= 1) {
			destroyVoiture();
			Rondpoint.VtrRondpoint.add(0, new Voiture());
			Rondpoint.VtrRondpoint.get(0).setDestination();
			Rondpoint.VtrRondpoint.get(0).setTimeStamp();
			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		VtrTroncon2.remove(0);
	
  }
	
}