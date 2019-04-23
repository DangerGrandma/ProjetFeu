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

//Objet pour le rondpoint

public class Rondpoint extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le rondpoint, ajustement du nombre de voitures sur le rondpoint et JLabel qui affiche ce nombre de voitures


	private static int Voitures;
	public static JLabel lblVoituresRP = new JLabel("Voitures sur le rondpoint : " + Voitures);

	
	// @param vtrRondpoint sert à contenir les voitures situées dans la ligne d'attente du rondpoint.
	

	public static ArrayList<Voiture> FilAttente = new ArrayList<Voiture>();


	// Initialisation de la représentation graphique

	public Rondpoint() {
		setLayout(null);
		lblVoituresRP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVoituresRP.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoituresRP.setBounds(11, 9, 140, 14);
		add(lblVoituresRP);

	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition. Les intervalles de création dépendent du moment du jour
	
	public static void genVoitures() {
		
		int voituresMin;
		int voituresMax;
		if (ConfigurationVoitures.getRondpointDebut() != 0) {
			voituresMin = ConfigurationVoitures.getRondpointDebut();
			voituresMax = ConfigurationVoitures.getRondpointDebut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		else {
			int VOITURES_MIN = ComboBoxTrafic.getRondpointDebutMin(); 
			int VOITURES_MAX = ComboBoxTrafic.getRondpointDebutMax(); 
			Voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1); 
		}
		for (int i = 1; i <= Voitures; i++) {
			FilAttente.add(new Voiture());
			FilAttente.get(i-1).setDestination();
			FilAttente.get(i-1).setTimeStamp();
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			FilAttente.add(0, new Voiture());
			FilAttente.get(0).setDestination();
			FilAttente.get(0).setTimeStamp();
			checkDest();
			lblVoituresRP.setText("Voitures sur le Rondpoint : " + (FilAttente.size()));
			
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(FilAttente.size() > 0) {
			FilAttente.remove(0);
			checkDest();
			lblVoituresRP.setText("Voitures sur le Rondpoint : " + (FilAttente.size()));
			
			}
		};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		FilAttente.clear();
		Rondpoint.lblVoituresRP.setText("Voitures sur le rondpoint : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur le rondpoint.

	public static void mAJVoitures() {
		
		Rondpoint.lblVoituresRP.setText("Voitures sur le rondpoint : " + (FilAttente.size()));
		destroyVoiture();
	}	
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Rondpoint.lblVoituresRP.setText("Voitures sur la rondpoint : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return FilAttente.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return FilAttente.get(i).getDestination();
	};
	
	// Vérifie si le temps nécessaire pour une voiture de se rendre à destination est écoulé. Si oui, la voiture est retirée de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < FilAttente.size(); p++) {
		int x = FilAttente.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = FilAttente.get(p).getTimeStamp();
		if(y-z >= x) {
			FilAttente.remove(p);
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
	

