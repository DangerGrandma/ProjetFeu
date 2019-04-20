package essentiels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaneauFeu extends JPanel {

	private static boolean clrFeu = false;
	private static int statusRoad = 0;
	/**
	 * Create the panel.
	 */
	public PaneauFeu() {
		setLayout(null);
		
		JLabel feuRouge = new JLabel("");
		if(clrFeu) {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/feuvert.png")));
		}
		else {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/feurouge.png")));

		}
		feuRouge.setBounds(13, 0, 30, 65);
		add(feuRouge);
		
		JButton btnFeu = new JButton("Feu");
		btnFeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(clrFeu) {
					clrFeu = false;
					feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/feurouge.png")));
				}
				
				else {
					clrFeu = true;
					feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/feuvert.png")));
					
				}
			}
		});
		btnFeu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFeu.setBounds(0, 68, 50, 18);
		add(btnFeu);

	}
}
