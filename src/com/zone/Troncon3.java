/**
 * Class Troncon3, version 2.3.2, 22 avril 2019
 * 
 * Il s'agit de la mod�lisation du tron�on 3 qui est connect� au rondpoint.
 * Les voitures y sont g�n�r�es au hasard selon le moment de la journ�e,
 * puis transf�r�es au rondpoint selon un rythme qui d�pend de l'heure du jour.
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
import com.objet.Voiture;

import java.awt.Font;

//Objet pour le Tron�on3

public class Troncon3 extends JPanel implements ElementRoute {

	// Objets voitures figurant sur le Tron�on3, ajustement du nombre de voitures sur le Tron�on3 et JLabel qui affiche ce nombre de voitures


	private static int Voitures;
	public static JLabel lblVoituresTR3 = new JLabel("Voitures sur le Troncon3 : " + Voitures);
	
	// @param VtrTroncon3 sert � contenir les voitures situ�es dans la ligne d'attente du tron�on2.

	public static ArrayList<Voiture> FilAttente = new ArrayList<Voiture>();


	// Initialisation de la repr�sentation graphique

	public Troncon3() {
		setLayout(null);
		lblVoituresTR3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVoituresTR3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoituresTR3.setBounds(11, 9, 140, 14);
		add(lblVoituresTR3);

	}

	// G�n�ration des voitures, de leur destination et de leur empreinte de temps d'apparition
	
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
			lblVoituresTR3.setText("Voitures sur le Troncon3 : " + (FilAttente.size()));

		};
		
		// Fonction qui retire une voiture du array de voitures, si il y en a au moins une
		
		public static void retraitVoiture() {

			if(FilAttente.size() > 0) {
			FilAttente.remove(0);
			lblVoituresTR3.setText("Voitures sur le Troncon3 : " + (FilAttente.size()));

			}
		};
	
	// R�-initialisation des voitures
	
	public static void resetVoitures() {

		FilAttente.clear();
		Troncon3.lblVoituresTR3.setText("Voitures sur le Troncon3 : ");

	};
	
	// Fonction pour mettre � jour le nombre de voitures sur le Tron�on3. Ajustement au hasard, selon l'heure du jour.


	public static void mAJVoitures() {
		
		int nvlVoitures = ThreadLocalRandom.current().nextInt(ComboBoxTrafic.getMinTron(), ComboBoxTrafic.getMaxTron()+1);
		if (nvlVoitures != 0) {
		for (int i = 1; i <= nvlVoitures; i++) {
			FilAttente.add(0,new Voiture());
		};
		}
		
		Troncon3.lblVoituresTR3.setText("Voitures sur le Troncon3 : " + (FilAttente.size()));

		checkRondpoint();
	}	
	
	// �tablit le nombre de voiture au d�marrage du chrono
	
	public static void getVoitureDebut() {

		Troncon3.lblVoituresTR3.setText("Voitures sur le Troncon3 : " + getVoituresSize());

	}
	
	// Donne la grosseur de l'array de voitures
	
	public static int getVoituresSize() {

		return FilAttente.size();	 
	}

	// Donne la destination en secondes d'une voiture d�sign�e
	
	public static int getVoitureArray(int i) {	

			return FilAttente.get(i).getDestination();

	};
	
	/* V�rifie si le rondpoint est assez libre (moins de 30 voitures), si le Troncon3 peu y transf�rer une de ses voitures. Si oui, le listArray pour Troncon3
	   est r�duit de un, et le listeArray du rondpoint gagne une nouvelle voiture avec des attributs
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