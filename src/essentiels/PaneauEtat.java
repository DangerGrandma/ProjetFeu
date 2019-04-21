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

public class PaneauEtat extends JPanel {
    public PaneauEtat() {
        setBackground(new Color(44, 44, 44));

        Random generator = new Random();
        int rand = generator.nextInt(101);

        JLabel labelneutre = new JLabel("");
        labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/etat_neutre.png")));
        add(labelneutre);

        JButton button = new JButton(String.format("Switch", rand));
        add(button);
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int rand = generator.nextInt(101);
                System.out.println("the random number is:" + rand);
                if (rand == 0) {
                    labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/etat_neutre.png")));
                } else if (isBetween(rand, 1, 32)) {
                    labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/etat_eneqiulibre.png")));

                } else if (isBetween(rand, 33, 65)) {
                    labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/etat_risque.png")));
                } else {
                    labelneutre.setIcon(new ImageIcon(getClass().getResource("/essentiels/etat_congestion.png")));
                }
            }
        });

    }

    private boolean isBetween(int rand, int i, int j) {
        return i <= rand && rand <= j;

    }

}