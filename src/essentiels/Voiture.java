package essentiels;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Voiture {
	
	private int Destination;
	private int TimeStamp;		
	
	public void setDestination() {
		this.Destination = ThreadLocalRandom.current().nextInt(0, 6);		
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
