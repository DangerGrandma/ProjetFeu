// Classe Bretelle, version 2.4.3, 22 avril 2019

package com.zone;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.objet.ChoixVoitures;
import com.objet.Chrono;
import com.objet.ComboBoxTrafic;
import com.objet.PaneauFeu;
import com.objet.Voiture;

import java.awt.Font;

// Modélisation de la brettelle

public class Bretelle extends JPanel implements ElementRoute {

	// Objets voitures figurant sur la bretelle, ajustement du nombre de voitures sur la bretelle et JLabel qui affiche ce nombre de voitures

	private static int voitures; 
	public static JLabel vtrsBretelle = new JLabel("voitures sur la Bretelle : " + voitures); 
	
	// @param vtrBretelle sert à contenir les voitures situ�es dans la ligne d'attente de la bretelle. 

	public static ArrayList<Voiture> vtrBretelle = new ArrayList<Voiture>(); 

	// Initialisation de la représentation graphique

	public Bretelle() {
		setLayout(null);
		vtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10)); 
		vtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER); 
		vtrsBretelle.setBounds(11, 9, 140, 14); 
		add(vtrsBretelle); 
	}

	// Génération des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		final int voitures_MIN; 
		final int voitures_MAX; 
		if (ChoixVoitures.getBretelleDebut() != 0) {
			voitures_MIN = ChoixVoitures.getBretelleDebut(); 
			voitures_MAX = ChoixVoitures.getBretelleDebut(); 
			voitures = ThreadLocalRandom.current().nextInt(voitures_MIN, voitures_MAX+1); 
		}
		
		else {
			voitures_MIN = ComboBoxTrafic.getAutDebutMin(); 
			voitures_MAX = ComboBoxTrafic.getAutDebutMax(); 
			voitures = ThreadLocalRandom.current().nextInt(voitures_MIN, voitures_MAX+1); 
		}
		
		for (int i = 1; i <= voitures; i++) { 
			vtrBretelle.add(new Voiture()); 
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
	public static void ajoutVoitures() {
		Bretelle.vtrBretelle.add(0, new Voiture()); 
		Bretelle.vtrsBretelle.setText("voitures sur la Bretelle : " + (vtrBretelle.size())); 
	};
	
	// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
	
	public static void retraitVoiture() {
		if(vtrBretelle.size() > 0) { 
		Bretelle.vtrBretelle.remove(0); 
		Bretelle.vtrsBretelle.setText("voitures sur la Bretelle : " + (vtrBretelle.size())); 
		}
	};
	
	// Ré-initialisation des voitures
	
	public static void resetVoitures() {
		vtrBretelle.clear(); 
		Bretelle.vtrsBretelle.setText("voitures sur la Bretelle : "); 
	};
	
	// Fonction pour mettre à jour le nombre de voitures sur la bretelle. Ajustement au hasard, selon l'heure du jour. 

	public static void majVoitures() { 

		int nvlvoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinAuto(), ComboBoxTrafic.getMaxAuto()+1); 
		if (nvlvoitures != 0) { 
		for (int i = 1; i <= nvlvoitures; i++) { 
			vtrBretelle.add(0,new Voiture()); 
			};
		}
		
		Bretelle.vtrsBretelle.setText("voitures sur le Bretelle : " + (vtrBretelle.size()));
		checkRondpoint();
	}
	
	// Établit le nombre de voiture au démarrage du chrono
	
	public static void getVoitureDebut() {
		Bretelle.vtrsBretelle.setText("Voitures sur la Bretelle : " + vtrBretelle.size());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return vtrBretelle.size();	 
	}

	// Donne la destination en secondes d'une voiture désignée
	
	public static int getVoitureArray(int i) {	
			return vtrBretelle.get(i).getDestination();
	};
	
	/* Vérifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon1 peu y transférer une de ses voitures. Si oui, le listArray pour Troncon1
	   est réduit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	
public static void checkRondpoint() {
	if(PaneauFeu.getEtatFeu()) {
	int totalRondpoint = Rondpoint.getVoituresSize();
	if(totalRondpoint < 30 && vtrBretelle.size() >= 1) {
		destroyVoiture();
		Rondpoint.vtrRondpoint.add(0, new Voiture());
		Rondpoint.vtrRondpoint.get(0).setDestination();
		Rondpoint.vtrRondpoint.get(0).setTimeStamp();		
		};
	};
}
	// Application de la destruction de voitures.
	
	public static void destroyVoiture() {
		vtrBretelle.remove(0);
	
  }
}