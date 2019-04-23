/**
 *  Classe Bretelle, version 2.4.3, 22 avril 2019
 *  
 *  Il s'agit de la modélisation de la bretelle qui connecte l'autoroute au rondpoint.
 */

package com.zone;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.objet.ConfigurationVoitures;
import com.objet.Chrono;
import com.objet.ComboBoxTrafic;
import com.objet.PaneauFeu;
import com.objet.Voiture;

import java.awt.Font;

public class Bretelle extends JPanel implements ElementRoute {

	// Objets voitures figurant sur la bretelle, ajustement du nombre de voitures sur la bretelle et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel lblVoituresBret = new JLabel("Voitures sur la Bretelle : " + Voitures);

	
	// @param vtrBretelle sert à contenir les voitures situées dans la ligne d'attente de la bretelle. 

	public static ArrayList<Voiture> FilAttente = new ArrayList<Voiture>();

	// Initialisation de la représentation graphique

	public Bretelle() {
		setLayout(null);
		lblVoituresBret.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVoituresBret.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoituresBret.setBounds(11, 9, 140, 14);
		add(lblVoituresBret);
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		int voituresMin;
		int voituresMax;
		if (ConfigurationVoitures.getBretelleDebut() != 0) {
			voituresMin = ConfigurationVoitures.getBretelleDebut();
			voituresMax = ConfigurationVoitures.getBretelleDebut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		
		else {
			int voitures_MIN = ComboBoxTrafic.getAutDebutMin(); 
			int voitures_MAX = ComboBoxTrafic.getAutDebutMax(); 
			Voitures = ThreadLocalRandom.current().nextInt(voitures_MIN, voitures_MAX+1); 
		}
		
		for (int i = 1; i <= Voitures; i++) {
			FilAttente.add(new Voiture());
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
	public static void ajoutVoitures() {
		Bretelle.FilAttente.add(0, new Voiture());
		Bretelle.lblVoituresBret.setText("Voitures sur la Bretelle : " + (FilAttente.size()));
	};
	
	// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
	
	public static void retraitVoiture() {
		if(FilAttente.size() > 0) {
		Bretelle.FilAttente.remove(0);
		Bretelle.lblVoituresBret.setText("Voitures sur la Bretelle : " + (FilAttente.size()));
		}
	};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		FilAttente.clear();
		Bretelle.lblVoituresBret.setText("Voitures sur la Bretelle : ");
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur la bretelle. Ajustement au hasard, selon l'heure du jour. 

	public static void majVoitures() { 

		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinAuto(), ComboBoxTrafic.getMaxAuto()+1);
		if (nvlVoitures != 0) {
			for (int i = 1; i <= nvlVoitures; i++) {
				FilAttente.add(0,new Voiture());
			};
		}
		
		Bretelle.lblVoituresBret.setText("Voitures sur la bretelle : " + (FilAttente.size()));
		checkRondpoint();
	}
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Bretelle.lblVoituresBret.setText("Voitures sur la Bretelle : " + FilAttente.size());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return FilAttente.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return FilAttente.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon1 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon1
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	
public static void checkRondpoint() {
	int hasard = ThreadLocalRandom.current().nextInt(1, 3);
	for(int i = 0; i <= hasard; i++ ) {
	if(PaneauFeu.getEtat()) {
	int totalRondpoint = Rondpoint.getVoituresSize();
	if(totalRondpoint < 20 && FilAttente.size() >= 1) {
		destroyVoiture();
		Rondpoint.FilAttente.add(0, new Voiture());
		Rondpoint.FilAttente.get(0).setDestination();
		Rondpoint.FilAttente.get(0).setTimeStamp();		
		};
	};
  }
}
	// Application de la destruction de voitures.
	
	public static void destroyVoiture() {
		FilAttente.remove(0);

	
  }
}