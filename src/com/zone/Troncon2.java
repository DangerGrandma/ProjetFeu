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

//Objet pour le Tronçon2

public class Troncon2 extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le Tronçon2, ajustement du nombre de voitures sur le Tronçon2 et JLabel qui affiche ce nombre de voitures

	private static int voitures; 
	public static JLabel vtrsTroncon2 = new JLabel("voitures sur le Troncon2 : " + voitures); 
	
	// @param VtrTroncon2 sert à contenir les voitures situées dans la ligne d'attente du tronçon2.

	public static ArrayList<Voiture> vtrTroncon2 = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Troncon2() {
		setLayout(null);
		vtrsTroncon2.setFont(new Font("Tahoma", Font.PLAIN, 10)); 
		vtrsTroncon2.setHorizontalAlignment(SwingConstants.CENTER); 
		vtrsTroncon2.setBounds(11, 9, 140, 14); 
		add(vtrsTroncon2); 
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		final int VOITURES_MIN; 
		final int VOITURES_MAX; 
		if (ChoixVoitures.getTron2Debut() != 0) {
			VOITURES_MIN = ChoixVoitures.getTron2Debut(); 
			VOITURES_MAX = ChoixVoitures.getTron2Debut(); 
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1);
		}
		else {
			VOITURES_MIN = ComboBoxTrafic.getTronDebutMin(); 
			VOITURES_MAX = ComboBoxTrafic.getTronDebutMax(); 
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1); 
		}
		for (int i = 1; i <= voitures; i++) { 
			vtrTroncon2.add(new Voiture()); 
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
	public static void ajoutVoitures() {
		vtrTroncon2.add(0, new Voiture()); 
		vtrsTroncon2.setText("voitures sur le Troncon2 : " + (vtrTroncon2.size())); 
	};
	
	// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
	
	public static void retraitVoiture() {
		if(vtrTroncon2.size() > 0) { 
		vtrTroncon2.remove(0); 
		vtrsTroncon2.setText("voitures sur le Troncon2 : " + (vtrTroncon2.size()));
		}
	};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		vtrTroncon2.clear(); 
		Troncon2.vtrsTroncon2.setText("voitures sur le Troncon2 : ");;
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon2. Ajustement au hasard, selon l'heure du jour.

	public static void majVoitures() { 
		
		int nvlvoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1); 
		if (nvlvoitures != 0) { 
		for (int i = 1; i <= nvlvoitures; i++) { 
			vtrTroncon2.add(0,new Voiture()); 
		};
		}
		
		Troncon2.vtrsTroncon2.setText("voitures sur le Troncon2 : " + (vtrTroncon2.size()));
		checkRondpoint();
	}
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Troncon2.vtrsTroncon2.setText("Voitures sur le Troncon2 : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return vtrTroncon2.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
		return vtrTroncon2.get(i).getDestination(); 
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon2 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon2
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && vtrTroncon2.size() >= 1) { 
			destroyVoiture();
			Rondpoint.vtrRondpoint.add(0, new Voiture()); 
			Rondpoint.vtrRondpoint.get(0).setDestination(); 
			Rondpoint.vtrRondpoint.get(0).setTimeStamp(); 
			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		vtrTroncon2.remove(0); 
	
  }
	
}