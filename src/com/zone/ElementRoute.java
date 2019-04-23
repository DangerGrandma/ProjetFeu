/**
 *  Interface ElementRoute, version 2.1.0, 21 avril 2019
 *  
 *  L'interface des m�thodes propres aux zones de circulation
 */

package com.zone;

public interface ElementRoute {
	
public static void mAJVoitures() {
	
	// Fonction de mise � jour des voitures sur l'autoroute
	
};	
	
public static void resetVoitures() {
	
	// R�initialisation des voitures sur la route
	
};

public static void ajoutVoitures() {
	
	// Ajoute de voiture � la zone (bouton)
	
};

public static void retraitVoiture() {
	
	// Retrait de voiture � la zone (bouton)
	
};

public static void genVoitures() {
	
	// G�n�ration des voitures sur la route
	
};

public static void getVoitureDebut() {
	
	// Donne l'empreinte de temps o� la voiture s'est ajout�e � l'Arraylist
	
};

public static int getVoitureArray(int i) {
	
	// Donne le nombre de voitures dans la zone
	
	return i;	
}

public static void checkRondpoint() {
	
	// V�rifie si le rondpoint peux accueillir de nouvelles voitures
	
 };
 
 public static void destroyVoiture() {
	
	// Retrait de voitures de la zone (mise � jour) 
	 
 }
 
}
