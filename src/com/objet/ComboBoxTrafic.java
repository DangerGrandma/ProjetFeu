/** 
 * Classe ComboBoxTrafic version 3.2.0, 22 avril 2019.
 * 
 *  Il s'agit de param�tres utilis�s pour la g�n�ration de voitures.
 *  Cela concerne tant la g�n�ration initiale que celle appliqu�e
 *  r�guli�rement.
 */

package com.objet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBoxTrafic extends JPanel implements ActionListener {
	
	private String[] messageStrings = {"Heure de pointe", "Milieu de journ�e", "Soir et nuit"};
	private JComboBox menuList;
	
	private static int	maxTron = 1; // Nombre maximum de voitures ajout�es aux tron�ons du rond-point
	private static int	minTron = 0; // Nombre minimum de voitures ajout�es aux tron�ons du rond-point
	private static int	maxAut = 2; // Nombre maximum de voitures provenant de l'autoroute ajout�es � la bretelle
	private static int	minAuto = 0; // Nombre minimum de voitures provenant de l'autoroute ajout�es � la bretelle
	private static int	temps = 1;  // Temps avant d'ajouter d'autres voitures
	
	private static int tronDebutMax = 6; // Nombre maximum de voitures au d�part aux tron�ons du rond-point
	private static int tronDebutMin = 4; // Nombre minimum de voitures au d�part aux tron�ons du rond-point
	private static int autDebutMax = 15; // Nombre maximum de voitures au d�but � la bretelle de l'autoroute
	private static int autDebutMin = 10; // Nombre minimum de voitures au d�but � la bretelle de l'autoroute
	
	private static int	rondpointDebutMax = 8;
	private static int	rondpointDebutMin = 4;
	
	//Getters
	
	public static int getMaxTron() {
		return maxTron;
	}

	public static int getMinTron() {
		return minTron;
	}

	public static int getMaxAuto() {
		return maxAut;
	}

	public static int getMinAuto() {
		return minAuto;
	}
	
	public static int getTronDebutMax() {
		return tronDebutMax;
	}

	public static int getTronDebutMin() {
		return tronDebutMin;
	}

	public static int getAutDebutMax() {
		return autDebutMax;
	}

	public static int getAutDebutMin() {
		return autDebutMin;
	}
	
	public static int getRondpointDebutMax() {
		return rondpointDebutMax;
	}

	public static int getRondpointDebutMin() {
		return rondpointDebutMin;
	}
	
	public static int getTemps() {
		return temps;
	}
	
	// Setters
	
	public static void setTronDebutMax(int tronDebutMax) {
		ComboBoxTrafic.tronDebutMax = tronDebutMax;
	}

	public static void setTronDebutMin(int tronDebutMin) {
		ComboBoxTrafic.tronDebutMin = tronDebutMin;
	}

	public static void setAutDebutMax(int autDebutMax) {
		ComboBoxTrafic.autDebutMax = autDebutMax;
	}

	public static void setAutDebutMin(int autDebutMin) {
		ComboBoxTrafic.autDebutMin = autDebutMin;
	}

	public static void setRondpointDebutMax(int rondpointDebutMax) {
		ComboBoxTrafic.rondpointDebutMax = rondpointDebutMax;
	}

	public static void setRondpointDebutMin(int rondpointDebutMin) {
		ComboBoxTrafic.rondpointDebutMin = rondpointDebutMin;
	}

	public ComboBoxTrafic() {
		
		menuList = new JComboBox(messageStrings);
		menuList.setSelectedIndex(0);
		menuList.setBounds(100,100,90,120);
		add(menuList);
		
		menuList.addActionListener(this);
		
	}

	// Chaque fois qu'on change le temps de la journ�e, les nombres sont mis � jour selon les donn�es de simulation d�termin�es
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuList) {
			
			JComboBox cb = (JComboBox) e.getSource();
			
			String msg = (String) cb.getSelectedItem();
			
			switch (msg) {
			case "Heure de pointe": 
				maxTron = 2;
				minTron = 0;
				maxAut = 2;
				minAuto = 0;
				temps = 1;
				tronDebutMax = 6;
				tronDebutMin = 4;
				autDebutMax = 15;
				autDebutMin = 10;
				rondpointDebutMax = 8;
				rondpointDebutMin = 4;
				break;
				
			case "Milieu de journ�e": 
				maxTron = 2;
				minTron = 0;
				maxAut = 2;
				minAuto = 1;
				temps = 3;
				tronDebutMax = 4;
				tronDebutMin = 1;
				autDebutMax = 10;
				autDebutMin = 5;
				rondpointDebutMax = 4;
				rondpointDebutMin = 1;
				break;
				
			case "Soir et nuit":
				maxTron = 1;
				minTron = 0;
				maxAut = 2;
				minAuto = 0;
				temps = 5;
				tronDebutMax = 2;
				tronDebutMin = 0;
				autDebutMax = 5;
				autDebutMin = 0;
				rondpointDebutMax = 3;
				rondpointDebutMin = 0;
				break;
			}
		}
		
	}

	
}
