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

//Objet pour le rondpoint

public class Rondpoint extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le rondpoint, ajustement du nombre de voitures sur le rondpoint et JLabel qui affiche ce nombre de voitures

	private static int voitures;;
	public static JLabel vtrsRondpoint = new JLabel("Voitures sur le rondpoint : " + voitures);
	
	// @param vtrRondpoint sert � contenir les voitures situ�es dans la ligne d'attente du rondpoint.
	
	public static ArrayList<Voiture> vtrRondpoint = new ArrayList<Voiture>();

	// Initialisation de la repr�sentation graphique

	public Rondpoint() {
		setLayout(null);
		vtrsRondpoint.setFont(new Font("Tahoma", Font.PLAIN, 10));
		vtrsRondpoint.setHorizontalAlignment(SwingConstants.CENTER);
		vtrsRondpoint.setBounds(11, 9, 140, 14);
		add(vtrsRondpoint);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition. Les intervalles de cr�ation d�pendent du moment du jour
	
	public static void genVoitures() {
		
		final int VOITURES_MIN; 
		final int VOITURES_MAX; 
		if (ChoixVoitures.getRondpointDebut() != 0) {
			VOITURES_MIN = ChoixVoitures.getRondpointDebut(); 
			VOITURES_MAX = ChoixVoitures.getRondpointDebut(); 
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1); 
		}
		else {
			VOITURES_MIN = ComboBoxTrafic.getRondpointDebutMin(); 
			VOITURES_MAX = ComboBoxTrafic.getRondpointDebutMax(); 
			voitures = ThreadLocalRandom.current().nextInt(VOITURES_MIN, VOITURES_MAX+1); 
		}
		for (int i = 1; i <= voitures; i++) { 
			vtrRondpoint.add(new Voiture()); 
			vtrRondpoint.get(i-1).setDestination(); 
			vtrRondpoint.get(i-1).setTimeStamp(); 
		};
	}
	
	// Fonction qui ajoute une voiture au array de voitures
	
		public static void ajoutVoitures() {
			vtrRondpoint.add(0, new Voiture());
			vtrRondpoint.get(0).setDestination();
			vtrRondpoint.get(0).setTimeStamp();
			checkDest();
			vtrsRondpoint.setText("Voitures sur le Rondpoint : " + (vtrRondpoint.size()));
			
		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {
			if(vtrRondpoint.size() > 0) {
			vtrRondpoint.remove(0);
			checkDest();
			vtrsRondpoint.setText("Voitures sur le Rondpoint : " + (vtrRondpoint.size()));
			
			}
		};
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		vtrRondpoint.clear();
		Rondpoint.vtrsRondpoint.setText("Voitures sur le rondpoint : ");
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le rondpoint.

	public static void mAJVoitures() {
		
		Rondpoint.vtrsRondpoint.setText("Voitures sur le rondpoint : " + (vtrRondpoint.size()));
		destroyVoiture();
	}	
	
	// �tablit le nombre de voiture au d�marrage du chrono
	
	public static void getVoitureDebut() {
		Rondpoint.vtrsRondpoint.setText("Voitures sur la rondpoint : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return vtrRondpoint.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
			return vtrRondpoint.get(i).getDestination();
	};
	
	// V�rifie si le temps n�cessaire pour une voiture de se rendre � destination est �coul�. Si oui, la voiture est retir�e de son tableau
	
	public static void checkDest() {
		for (int p = 0; p < vtrRondpoint.size(); p++) {
		int x = vtrRondpoint.get(p).getDestination();
		int y = Chrono.getTimestamp();
		int z = vtrRondpoint.get(p).getTimeStamp();
		if(y-z >= x) {
			vtrRondpoint.remove(p);
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
	

