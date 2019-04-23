/** 
 * Classe abstraite Equipement intelligent, version 2.0.1
 * 
 * Utilisée par les objets illustratifs, comme les paneaux
 */

package com.objet;

import javax.swing.JPanel;

abstract class EquipementIntelligent extends JPanel {

	protected static boolean 	etat;
	
	public static boolean getEtat() {
		return etat;
	}; 
	
	public static int checkTime() {
		return Chrono.getTimestamp();
		
	};

	
}
