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

//Objet pour le Tronçon1

public class Troncon1 extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le Tronçon1, ajustement du nombre de voitures sur le Tronçon1 et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel VtrsTroncon1 = new JLabel("Voitures sur le Troncon1 : " + Voitures);
	
	// @param VtrTroncon1 sert à contenir les voitures situées dans la ligne d'attente du tronçon1.

	public static ArrayList<Voiture> VtrTroncon1 = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Troncon1() {
		setLayout(null);
		VtrsTroncon1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon1.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon1.setBounds(11, 9, 140, 14);
		add(VtrsTroncon1);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		int voituresMin;
		int voituresMax;
		if (ChoixVoitures.getTron1Debut() != 0) {
			voituresMin = ChoixVoitures.getTron1Debut();
			voituresMax = ChoixVoitures.getTron1Debut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		else {
			voituresMin = ComboBoxTrafic.getTronDebutMin();
			voituresMax = ComboBoxTrafic.getTronDebutMax();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		for (int i = 1; i <= Voitures; i++) {
			VtrTroncon1.add(new Voiture());
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			VtrTroncon1.add(0, new Voiture());
			VtrsTroncon1.setText("Voitures sur la Troncon1 : " + (VtrTroncon1.size()));
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(VtrTroncon1.size() > 0) {
			VtrTroncon1.remove(0);
			VtrsTroncon1.setText("Voitures sur la Troncon1 : " + (VtrTroncon1.size()));
			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		VtrTroncon1.clear();
		VtrsTroncon1.setText("Voitures sur le Troncon1 : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon1. Ajustement au hasard, selon l'heure du jour.

	public static void MAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			VtrTroncon1.add(0,new Voiture());
		};
		}
		
		Troncon1.VtrsTroncon1.setText("Voitures sur le Troncon1 : " + (VtrTroncon1.size()));
		checkRondpoint();
	}	
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Troncon1.VtrsTroncon1.setText("Voitures sur le Troncon1 : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return VtrTroncon1.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return VtrTroncon1.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon1 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon1
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && VtrTroncon1.size() >= 1) {
			destroyVoiture();
			Rondpoint.VtrRondpoint.add(0, new Voiture());
			Rondpoint.VtrRondpoint.get(0).setDestination();
			Rondpoint.VtrRondpoint.get(0).setTimeStamp();
			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		VtrTroncon1.remove(0);
	
  }
	
}