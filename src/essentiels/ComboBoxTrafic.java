package essentiels;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBoxTrafic extends JPanel {
	
	String[] messageStrings = {"Heure de pointe", "Milieu de journée", "Soir et nuit"};
	
	public ComboBoxTrafic() {
		
		JPanel p = new JPanel();
		JComboBox menuList = new JComboBox(messageStrings);
		menuList.setSelectedIndex(0);
		menuList.setBounds(100,100,90,120);
		add(menuList);
		
	}

	
}
