package com.zone;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.objet.ConfigurationVoitures;
import com.objet.Chrono;
import com.objet.ComboBoxTrafic;
import com.objet.Voiture;

import java.awt.Font;

//Objet pour le Tronçon3

public class Troncon2 extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le Tronçon3, ajustement du nombre de voitures sur le Tronçon3 et JLabel qui affiche ce nombre de voitures


	private static int Voitures;
	public static JLabel lblVoituresTR2 = new JLabel("Voitures sur le Troncon2 : " + Voitures);
	
	// @param VtrTroncon2 sert à contenir les voitures situées dans la ligne d'attente du tronçon2.

	public static ArrayList<Voiture> FilAttente = new ArrayList<Voiture>();


	// Initialisation de la représentation graphique

	public Troncon2() {
		setLayout(null);
		lblVoituresTR2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVoituresTR2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoituresTR2.setBounds(11, 9, 140, 14);
		add(lblVoituresTR2);

	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {

		int voituresMin;
		int voituresMax;
		if (ConfigurationVoitures.getTron3Debut() != 0) {
			voituresMin = ConfigurationVoitures.getTron3Debut();
			voituresMax = ConfigurationVoitures.getTron3Debut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		
		else {
			int VOITURES_MIN = ComboBoxTrafic.getTronDebutMin(); 
			int VOITURES_MAX = ComboBoxTrafic.getTronDebutMax(); 
			Voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1); 
		}

		for (int i = 1; i <= Voitures; i++) {
			FilAttente.add(new Voiture());

		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {

			FilAttente.add(0, new Voiture());
			lblVoituresTR2.setText("Voitures sur le Troncon2 : " + (FilAttente.size()));

		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {

			if(FilAttente.size() > 0) {
			FilAttente.remove(0);
			lblVoituresTR2.setText("Voitures sur le Troncon2 : " + (FilAttente.size()));

			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {

		FilAttente.clear();
		Troncon2.lblVoituresTR2.setText("Voitures sur le Troncon2 : ");

	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le Tronçon3. Ajustement au hasard, selon l'heure du jour.


	public static void mAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			FilAttente.add(0,new Voiture());
		};
		}
		
		Troncon2.lblVoituresTR2.setText("Voitures sur le Troncon2 : " + (FilAttente.size()));

		checkRondpoint();
	}	
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {

		Troncon2.lblVoituresTR2.setText("Voitures sur le Troncon2 : " + getVoituresSize());

	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {

		return FilAttente.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	

			return FilAttente.get(i).getDestination();

	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon2 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon2
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();

		if(totalRondpoint < 20 && FilAttente.size() >= 1) {
			destroyVoiture();
			Rondpoint.FilAttente.add(0, new Voiture());
			Rondpoint.FilAttente.get(0).setDestination();
			Rondpoint.FilAttente.get(0).setTimeStamp();			
		};
	};
	
	// Application de la destruction de voitures.
	public static void destroyVoiture() {
		FilAttente.remove(0);

	
  }
	
}