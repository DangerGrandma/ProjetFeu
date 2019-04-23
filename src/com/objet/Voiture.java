// Classe voiture, version 1.1.2, 21 avril 2019

package com.objet;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Objet voiture. Utilisée par tous les éléments de la route

public class Voiture {
	
	/* @param Destination détermine le nombre de temps que passera une voiture sur le rondpoint avant de le quitter.
	 * @param TimeStamp sert d'empreinte. Une empreinte globale du temps écoulé est appliquée à la voiture. On compare
	 * @param TimeStamp d'une voiture à l'empreinte globale, et si la différence est supérieure ou égale à @param Destination,
	 * la voiture est retirée du rondpoint.
	 */
	
	private int destination;
	private int timeStamp;		
	
	// Le nombre de temps nécessaire pour quitter la route. Valeur aléatoire entre 2 et 5 secondes.
	
	public void setDestination() {
		this.destination = ThreadLocalRandom.current().nextInt(2, 6);		
	};
	
	public int getDestination() {
		return this.destination;
	};	
	
	public void setTimeStamp() {
		this.timeStamp = Chrono.secondes;
	};
	
	public int getTimeStamp() {
		return this.timeStamp;
	};

}
