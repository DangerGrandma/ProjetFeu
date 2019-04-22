package essentiels;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Objet voiture

public class Voiture {
	
	/* @param Destination d�termine le nombre de temps que passera une voiture sur le rondpoint avant de le quitter.
	 * @param TimeStamp sert d'empreinte. Une empreinte globale du temps �coul� est appliqu�e � la voiture. On compare
	 * @param TimeStamp d'une voiture � l'empreinte globale, et si la diff�rence est sup�rieure ou �gale � @param Destination,
	 * la voiture est retir�e du rondpoint.
	 */
	
	private int Destination;
	private int TimeStamp;		
	
	// Le nombre de temps n�cessaire pour quitter la route. Valeur al�atoire entre 2 et 5 secondes.
	
	public void setDestination() {
		this.Destination = ThreadLocalRandom.current().nextInt(2, 6);		
	};
	
	public int getDestination() {
		return this.Destination;
	};	
	
	public void setTimeStamp() {
		this.TimeStamp = Chrono.secondes;
	};
	
	public int getTimeStamp() {
		return this.TimeStamp;
	};

}
