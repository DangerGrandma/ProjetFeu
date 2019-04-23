package com.objet;

import javax.swing.JPanel;

abstract class EquipementIntelligent extends JPanel {

	protected static int 	timeStamp;
	protected static boolean 	etat;
	
	public static int getTimeStamp() {
		return timeStamp;
	};
	
	public static void setTimeStamp() {
		
	};
	
	public static boolean setEtat(boolean b) {
		return etat == b;
	}
	
	public static boolean getEtat() {
		return etat;
	}; 
	
	public static int checkTime() {
		return Chrono.getTimestamp();
		
	};

	
}
