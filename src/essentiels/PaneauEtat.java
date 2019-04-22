package essentiels;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

// Le paneau d'état de fluidité de la route

public class PaneauEtat extends JPanel {
	public PaneauEtat() {
		setBackground(new Color(44, 44, 44));

		// Création d'un chiffre au hasard

		Random generator = new Random();
		int rand = generator.nextInt(101);

		// Initialisation de l'état de base du paneau

		JLabel labelneutre = new JLabel("");
		labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_neutre.png")));
		add(labelneutre);

		// Bouton pour générer le chiffre au hasard

		JButton button = new JButton(String.format("Switch", rand));
		add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rand = generator.nextInt(101);
				System.out.println("the random number is:" + rand);

				// Dépendement du chiffre généré, l'état du paneau change pour afficher la
				// fluidité actuelle

				if (rand == 0) {
					labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_neutre.png")));
				} else if (isBetween(rand, 1, 32)) {
					labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_eneqiulibre.png")));

				} else if (isBetween(rand, 33, 65)) {
					labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_risque.png")));
				} else {
					labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/images/etat_congestion.png")));
				}
			}
		});

	}

	private boolean isBetween(int rand, int i, int j) {
		return i <= rand && rand <= j;

	}

}