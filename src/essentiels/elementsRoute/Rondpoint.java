package essentiels.elementsRoute;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;


public class Rondpoint extends JPanel implements Route {
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsRondpoint = new JLabel("Voitures sur le rondpoint : "+Voitures);
	
	
	public Rondpoint() {
		setLayout(null);
		
		VtrsRondpoint.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsRondpoint.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsRondpoint.setBounds(11, 9, 140, 14);
		add(VtrsRondpoint);
		
	}



	public void caca() {

	}
}
