package essentiels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBoxTrafic extends JPanel implements ActionListener {
	
	String[] messageStrings = {"Heure de pointe", "Milieu de journée", "Soir et nuit"};
	JComboBox menuList;
	
	int maxTron = 6; // Nombre maximum de voitures aux tronçons du rond-point
	int minTron = 4; // Nombre minimum de voitures aux tronçons du rond-point
	int maxAut = 20; // Nombre maximjm de voitures provenant de l'autoroute
	int minAuto = 15; // Nombre minimum de voitures provenant de l'autoroute
	
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
	
	public ComboBoxTrafic() {
		
		menuList = new JComboBox(messageStrings);
		menuList.setSelectedIndex(0);
		menuList.setBounds(100,100,90,120);
		add(menuList);
		
		menuList.addActionListener(this);
		
	}

	// Chaque fois qu'on change le temps de la journée, les nombres sont mis à jour
	// selon les données de simulation déterminées
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuList) {
			JComboBox cb = (JComboBox) e.getSource();
			String msg = (String) cb.getSelectedItem();
			switch (msg) {
			case "Heure de pointe": 
				maxTron = 6;
				minTron = 4;
				maxAut = 20;
				minAuto = 15;
				break;
			case "Milieu de journée": 
				maxTron = 4;
				minTron = 1;
				maxAut = 10;
				minAuto = 5;
				break;
			case "Soir et nuit":
				maxTron = 2;
				minTron = 0;
				maxAut = 5;
				minAuto = 0;
				break;
			}
		}
		
	}

	
}
