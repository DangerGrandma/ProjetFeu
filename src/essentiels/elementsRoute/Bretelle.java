package essentiels.elementsRoute;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Bretelle extends JPanel implements Route {

	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsBretelle = new JLabel("Voitures sur la bretelle : "+Voitures);
	
	
	public Bretelle() {
		setLayout(null);
		
		VtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsBretelle.setBounds(50, 50, 140, 14);
		add(VtrsBretelle);
		
	}
	
	public void caca() {
		// TODO Auto-generated method stub
		
	}

}
