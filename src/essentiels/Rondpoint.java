package essentiels;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Rondpoint extends JPanel {
	
	protected static int Voitures = ThreadLocalRandom.current().nextInt(3, 11);
	
	
	public Rondpoint() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voitures sur le rondpoint : "+Voitures);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(11, 9, 140, 14);
		add(lblNewLabel);
		
	}
}
