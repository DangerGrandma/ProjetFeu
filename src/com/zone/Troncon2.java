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

//Objet pour le Tron�on2

public class Troncon2 extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le Tron�on2, ajustement du nombre de voitures sur le Tron�on2 et JLabel qui affiche ce nombre de voitures

	private static int Voitures;
	public static JLabel lblVoituresTR2 = new JLabel("Voitures sur le Troncon2 : " + Voitures);
	
	// @param VtrTroncon2 sert � contenir les voitures situ�es dans la ligne d'attente du tron�on2.

	public static ArrayList<Voiture> FilAttente = new ArrayList<Voiture>();

	// Initialisation de la repr�sentation graphique

	public Troncon2() {
		setLayout(null);
		lblVoituresTR2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVoituresTR2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoituresTR2.setBounds(11, 9, 140, 14);
		add(lblVoituresTR2);
	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition
	
	public static void genVoitures() {
		int voituresMin;
		int voituresMax;
		if (ConfigurationVoitures.getTron2Debut() != 0) {
			voituresMin = ConfigurationVoitures.getTron2Debut();
			voituresMax = ConfigurationVoitures.getTron2Debut();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
		}
		else {
			voituresMin = ComboBoxTrafic.getTronDebutMin();
			voituresMax = ComboBoxTrafic.getTronDebutMax();
			Voitures = ThreadLocalRandom.current().nextInt(voituresMin, voituresMax+1);
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
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {
		FilAttente.clear();
		Troncon2.lblVoituresTR2.setText("Voitures sur le Troncon2 : ");
	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le Tron�on2. Ajustement au hasard, selon l'heure du jour.

	public static void MAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			FilAttente.add(0,new Voiture());
		};
		}
		
		Troncon2.lblVoituresTR2.setText("Voitures sur le Troncon2 : " + (FilAttente.size()));
		checkRondpoint();
	}
	
	// �tablit le nombre de voiture au d�marrage du chrono
	
	public static void getVoitureDebut() {
		Troncon2.lblVoituresTR2.setText("Voitures sur le Troncon2 : " + getVoituresSize());
	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {
		return FilAttente.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	
			return FilAttente.get(i).getDestination();
	};
	
	/* V�rifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon2 peu y transf�rer une de ses voitures. Si oui, le listArray pour Troncon2
	   est r�duit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
	*/
	public static void checkRondpoint() {
		int totalRondpoint = Rondpoint.getVoituresSize();
		if(totalRondpoint < 30 && FilAttente.size() >= 1) {
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