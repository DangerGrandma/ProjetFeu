package com.zone;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.objet.ChoixVoitures;
import com.objet.Chrono;
import com.objet.ComboBoxTrafic;
import com.objet.Voiture;

import java.awt.Font;

//Objet pour le Tron�on3

public class Troncon3 extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le Tron�on3, ajustement du nombre de voitures sur le Tron�on3 et JLabel qui affiche ce nombre de voitures

	private static int voitures; 
	public static JLabel vtrsTroncon3 = new JLabel("voitures sur le Troncon3 : " + voitures); 
	
	// @param VtrTroncon3 sert � contenir les voitures situ�es dans la ligne d'attente du tron�on2.

	public static ArrayList<Voiture> vtrTroncon3 = new ArrayList<Voiture>(); 

	// Initialisation de la repr�sentation graphique

	public Troncon3() {
		setLayout(null);
		vtrsTroncon3.setFont(new Font("Tahoma", Font.PLAIN, 10)); 
		vtrsTroncon3.setHorizontalAlignment(SwingConstants.CENTER); 
		vtrsTroncon3.setBounds(11, 9, 140, 14); 
		add(vtrsTroncon3);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition
	
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
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		vtrTroncon3.clear(); 
		Troncon3.vtrsTroncon3.setText("voitures sur le Troncon3 : "); 
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le Tron�on3. Ajustement au hasard, selon l'heure du jour.

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
	
	// �tablit le nombre de voiture au d�marrage du chrono
	
	public static void getVoitureDebut() {
		Troncon3.vtrsTroncon3.setText("Voitures sur le Troncon3 : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return vtrTroncon3.size();	  
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
		return vtrTroncon3.get(i).getDestination(); 
	};
	
	/* V�rifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon3 peu y transf�rer une de ses voitures. Si oui, le listArray pour Troncon3
	   est r�duit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
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