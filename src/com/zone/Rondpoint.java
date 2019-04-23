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
	
	// @param VtrRondpoint sert � contenir les voitures situ�es dans la ligne d'attente du rondpoint.
	
	public static ArrayList<Voiture> FilAttente = new ArrayList<Voiture>();

	// Initialisation de la repr�sentation graphique

	public Rondpoint() {
		setLayout(null);
		lblVoituresRP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVoituresRP.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoituresRP.setBounds(11, 9, 140, 14);
		add(lblVoituresRP);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition. Les intervalles de cr�ation d�pendent du moment du jour
	
	public static void genVoitures() {
		
		int voituresMin;
		int voituresMax;
		if (ConfigurationVoitures.getRondpointDebut() != 0) {
			voituresMin = ConfigurationVoitures.getRondpointDebut();
			voituresMax = ConfigurationVoitures.getRondpointDebut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		else {
			voituresMin = ComboBoxTrafic.getRondpointDebutMin();
			voituresMax = ComboBoxTrafic.getRondpointDebutMax();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
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
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		FilAttente.clear();
		Rondpoint.lblVoituresRP.setText("Voitures sur le rondpoint : ");
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le rondpoint.

	public static void MAJVoitures() {
		
		Rondpoint.lblVoituresRP.setText("Voitures sur le rondpoint : " + (FilAttente.size()));
		destroyVoiture();
	}	
	
	// �tablit le nombre de voiture au d�marrage du chrono
	
	public static void getVoitureDebut() {
		Rondpoint.lblVoituresRP.setText("Voitures sur la rondpoint : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return FilAttente.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
			return FilAttente.get(i).getDestination();
	};
	
	// V�rifie si le temps n�cessaire pour une voiture de se rendre � destination est �coul�. Si oui, la voiture est retir�e de son tableau
	
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
	

