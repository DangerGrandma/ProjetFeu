/**
 * Classe voiture, version 1.1.2, 21 avril 2019
 * 
 * Il s'agit de l'objet emmagasin� dans un Arraylist par toutes les zones.
 */

package com.objet;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Voiture {
	
	/* @param Destination d�termine le nombre de temps que passera une voiture sur le rondpoint avant de le quitter.
	 * @param TimeStamp sert d'empreinte. Une empreinte globale du temps �coul� est appliqu�e � la voiture. On compare
	 * @param TimeStamp d'une voiture � l'empreinte globale, et si la diff�rence est sup�rieure ou �gale � @param Destination,
	 * la voiture est retir�e du rondpoint.
	 */
	
	private int destination;
	private int timeStamp;		
	
	// Le nombre de temps n�cessaire pour quitter la route. Valeur al�atoire entre 2 et 5 secondes.
	
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
