package essentiels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets; 
import java.util.Timer; 
import java.util.TimerTask; 

// Paneau du feu intelligent

public class PaneauFeu extends JPanel {

	private static boolean clrFeu = false;
	private static int statusRoad = 0;
	private JLabel feuRouge; 
	private int dureeFeuVert = 1000 * 3; 
	private Timer timerFeuVert; 
	private JButton switchMode; 

	public PaneauFeu() {
		setLayout(null);

		// Initialisation du paneau

		feuRouge = new JLabel(""); 

		// Changement de couleur du feu selon une valeur booléenne

		if (clrFeu) {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png")));
		} else {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png")));
		}
		feuRouge.setBounds(14, 0, 30, 65); 
		add(feuRouge);

		// Bouton pour ajuster manuellement la couleur du feu

		JButton btnFeu = new JButton("Switch");
		btnFeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (switchMode.getText().equals("Manuel")) { 

					if (clrFeu) {
						clrFeu = false;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png")));
					}
	
					else {
						clrFeu = true;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png")));
	
					}
				}
			}
		});
		btnFeu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFeu.setBounds(0, 68, 58, 20); 
		btnFeu.setMargin(new Insets(0, 0, 0, 0)); 
		btnFeu.setBackground(Color.GRAY); 
		add(btnFeu);
		
		switchMode = new JButton("Intelligent"); 
		switchMode.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				if (switchMode.getText().equals("Intelligent")) { 
					switchMode.setText("Manuel"); 
					btnFeu.setBackground(new JButton().getBackground()); 
				} 
				else { 
					switchMode.setText("Intelligent"); 
					btnFeu.setBackground(Color.GRAY); 
				} 
			} 
		}); 
		switchMode.setFont(new Font("Tahoma", Font.PLAIN, 9)); 
		switchMode.setBounds(0, 88, 58, 20); 
		switchMode.setMargin(new Insets(0, 0, 0, 0)); 
		add(switchMode); 

	}
}
