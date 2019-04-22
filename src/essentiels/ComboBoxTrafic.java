package essentiels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBoxTrafic extends JPanel implements ActionListener {
	
	String[] messageStrings = {"Heure de pointe", "Milieu de journée", "Soir et nuit"};
	JComboBox menuList;
	
	static int maxTron = 1; // Nombre maximum de voitures ajoutées aux tronçons du rond-point
	static int minTron = 0; // Nombre minimum de voitures ajoutées aux tronçons du rond-point
	static int maxAut = 3; // Nombre maximum de voitures provenant de l'autoroute ajoutées à la bretelle
	static int minAuto = 1; // Nombre minimum de voitures provenant de l'autoroute ajoutées à la bretelle
	int temps = 1;  // Temps avant d'ajouter d'autres voitures
	
	static int tronDebutMax = 6; // Nombre maximum de voitures au départ aux tronçons du rond-point
	static int tronDebutMin = 4; // Nombre minimum de voitures au départ aux tronçons du rond-point
	static int autDebutMax = 20; // Nombre maximum de voitures au début à la bretelle de l'autoroute
	static int autDebutMin = 15; // Nombre minimum de voitures au début à la bretelle de l'autoroute
	
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

	public int getTemps() {
		return temps;
	}

	public ComboBoxTrafic() {
		
		menuList = new JComboBox(messageStrings);
		menuList.setSelectedIndex(0);
		menuList.setBounds(100,100,90,120);
		add(menuList);
		
		menuList.addActionListener(this);
		
	}

	// Chaque fois qu'on change le temps de la journée, les nombres sont mis à jour selon les données de simulation déterminées
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuList) {
			JComboBox cb = (JComboBox) e.getSource();
			String msg = (String) cb.getSelectedItem();
			switch (msg) {
			case "Heure de pointe": 
				maxTron = 1;
				minTron = 0;
				maxAut = 3;
				minAuto = 1;
				temps = 1;
				tronDebutMax = 6;
				tronDebutMin = 4;
				autDebutMax = 20;
				autDebutMin = 15;
				break;
			case "Milieu de journée": 
				maxTron = 1;
				minTron = 0;
				maxAut = 2;
				minAuto = 1;
				temps = 4;
				tronDebutMax = 4;
				tronDebutMin = 1;
				autDebutMax = 10;
				autDebutMin = 5;
				break;
			case "Soir et nuit":
				maxTron = 1;
				minTron = 0;
				maxAut = 2;
				minAuto = 0;
				temps = 8;
				tronDebutMax = 2;
				tronDebutMin = 0;
				autDebutMax = 5;
				autDebutMin = 0;
				break;
			}
		}
		
	}

	
}
