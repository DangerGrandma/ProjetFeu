/**
 *  Interface ElementRoute, version 2.1.0, 21 avril 2019
 *  
 *  L'interface des méthodes propres aux zones de circulation
 */

package com.zone;

public interface ElementRoute {
	
public static void mAJVoitures() {
	
	// Fonction de mise à jour des voitures sur l'autoroute
	
};	
	
public static void resetVoitures() {
	
	// Réinitialisation des voitures sur la route
	
};

public static void ajoutVoitures() {
	
	// Ajoute de voiture à la zone (bouton)
	
};

public static void retraitVoiture() {
	
	// Retrait de voiture à la zone (bouton)
	
};

public static void genVoitures() {
	
	// Génération des voitures sur la route
	
};

public static void getVoitureDebut() {
	
	// Donne l'empreinte de temps où la voiture s'est ajoutée à l'Arraylist
	
};

public static int getVoitureArray(int i) {
	
	// Donne le nombre de voitures dans la zone
	
	return i;	
}

public static void checkRondpoint() {
	
	// Vérifie si le rondpoint peux accueillir de nouvelles voitures
	
 };
 
 public static void destroyVoiture() {
	
	// Retrait de voitures de la zone (mise à jour) 
	 
 }
 
}
