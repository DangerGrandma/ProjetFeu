package essentiels.elementsRoute;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Troncon2 extends JPanel implements Route {
	
	public static int Voitures;
	public static int modVoitures;
	public static JLabel VtrsTroncon = new JLabel("Voitures sur le rondpoint : "+Voitures);
	
	
	public Troncon2() {
		setLayout(null);
		
		VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		VtrsTroncon.setBounds(100, 100, 140, 14);
		add(VtrsTroncon);
		
	}

	@Override
	public void caca() {
		// TODO Auto-generated method stub
		
	}

}
