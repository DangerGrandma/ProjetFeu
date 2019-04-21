package essentiels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBoxTrafic extends JPanel implements ActionListener {
	
	String[] messageStrings = {"Heure de pointe", "Milieu de journ�e", "Soir et nuit"};
	JComboBox menuList;
	
	int maxTron = 1; // Nombre maximum de voitures ajout�es aux tron�ons du rond-point
	int minTron = 0; // Nombre minimum de voitures ajout�es aux tron�ons du rond-point
	int maxAut = 3; // Nombre maximum de voitures provenant de l'autoroute ajout�es � la bretelle
	int minAuto = 1; // Nombre minimum de voitures provenant de l'autoroute ajout�es � la bretelle
	int temps = 1;  // Temps avant d'ajouter d'autres voitures
	
	public int getMaxTron() {
		return maxTron;
	}

	public int getMinTron() {
		return minTron;
	}

	public int getMaxAut() {
		return maxAut;
	}


	public int getMinAuto() {
		return minAuto;
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

	// Chaque fois qu'on change le temps de la journ�e, les nombres sont mis � jour
	// selon les donn�es de simulation d�termin�es
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
				break;
			case "Milieu de journ�e": 
				maxTron = 1;
				minTron = 0;
				maxAut = 2;
				minAuto = 1;
				temps = 4;
				break;
			case "Soir et nuit":
				maxTron = 1;
				minTron = 0;
				maxAut = 2;
				minAuto = 0;
				temps = 8;
				break;
			}
		}
		
	}

	
}
