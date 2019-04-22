package essentiels;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Objet voiture

public class Voiture {
	
	/* @param Destination détermine le nombre de temps que passera une voiture sur le rondpoint avant de le quitter.
	 * @param TimeStamp sert d'empreinte. Une empreinte globale du temps écoulé est appliquée à la voiture. On compare
	 * @param TimeStamp d'une voiture à l'empreinte globale, et si la différence est supérieure ou égale à @param Destination,
	 * la voiture est retirée du rondpoint.
	 */
	
	private int Destination;
	private int TimeStamp;		
	
	// Le nombre de temps nécessaire pour quitter la route. Valeur aléatoire entre 2 et 5 secondes.
	
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
