package essentiels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Paneau du feu intelligent

public class PaneauFeu extends JPanel {

	private static boolean clrFeu = false;
	private static int statusRoad = 0;

	public PaneauFeu() {
		setLayout(null);

		// Initialisation du paneau

		JLabel feuRouge = new JLabel("");

		// Changement de couleur du feu selon une valeur booléenne

		if (clrFeu) {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png")));
		} else {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png")));
		}
		feuRouge.setBounds(13, 0, 30, 65);
		add(feuRouge);

		// Bouton pour ajuster manuellement la couleur du feu

		JButton btnFeu = new JButton("Feu");
		btnFeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clrFeu) {
					clrFeu = false;
					feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png")));
				}

				else {
					clrFeu = true;
					feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png")));

				}
			}
		});
		btnFeu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFeu.setBounds(0, 68, 50, 18);
		add(btnFeu);

	}
}
