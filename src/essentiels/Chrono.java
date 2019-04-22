package essentiels;

import javax.swing.JPanel;
import javax.swing.Timer;

import essentiels.elementsRoute.Bretelle;
import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Troncon1;
import essentiels.elementsRoute.Troncon2;
import essentiels.elementsRoute.Troncon3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class Chrono extends JPanel {

	// Param�tres de temps

	protected static int secondes = 0;
	protected static int minutes = 0;
	protected static int millisecondes = 0;
	protected static int timestamp = 0;
	protected boolean chronoOff = true;

	// Le chronom�tre est un objet JPanel � placer sur un interface graphique

	public Chrono() {

		setLayout(null);

		// Texte affichant les millisecondes au chronom�tre

		JLabel Bt_Millis = new JLabel("0");
		Bt_Millis.setForeground(Color.BLACK);
		Bt_Millis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Millis.setBounds(100, 11, 46, 14);
		add(Bt_Millis);

		// Texte affichant les minutes au chronom�tre

		JLabel Bt_Mins = new JLabel("0 :");
		Bt_Mins.setForeground(Color.BLACK);
		Bt_Mins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Mins.setBounds(20, 11, 46, 14);
		add(Bt_Mins);

		// Texte affichant les secondes au chronom�tre

		JLabel Bt_Secs = new JLabel("0 :");
		Bt_Secs.setForeground(Color.BLACK);
		Bt_Secs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bt_Secs.setBounds(60, 11, 46, 14);
		add(Bt_Secs);

		// Cr�ation d'un objet Timer. Il se met � jour au 8 millisecondes

		Timer T = new Timer(8, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 8 millisecondes sont ajout�es � l'entier @param millisecondes, � toutes les 8
				// millisecondes

				millisecondes += 8;

				// Mise � jour du chronom�tre et son texte � toutes les 8 millisecondes

				Bt_Millis.setText("" + millisecondes);
				if (millisecondes >= 1000) // Une seconde �coul�e
				{
					// Cette fonction r�initialise les millisecondes � 0 puis ajoute 1 seconde au
					// chronom�tre et � la marque de temps globale
					millisecondes = 0;
					Bt_Millis.setText("" + 0);
					secondes++;
					timestamp++;
					Bt_Secs.setText("" + secondes + "s :");

					// � chaque seconde, les paneaux d'affichage ont leur moyenne mise � jour
					PaneauMoyennes.setMoyenneBretelle();
					PaneauMoyennes.lblMoyBret.setText("Bretelle " + PaneauMoyennes.getMoyenneBretelle());
					PaneauMoyennes.setMoyenneTron1();
					PaneauMoyennes.lblMoyTron1.setText("Tron�on1 " + PaneauMoyennes.getMoyenneTron1());
					PaneauMoyennes.setMoyenneTron2();
					PaneauMoyennes.lblMoyTron2.setText("Tron�on2 " + PaneauMoyennes.getMoyenneTron2());
					PaneauMoyennes.setMoyenneTron3();
					PaneauMoyennes.lblMoyTron3.setText("Tron�on3 " + PaneauMoyennes.getMoyenneTron3());
					PaneauMoyennes.setMoyenneRondpoint();
					PaneauMoyennes.lblMoyRP.setText("Rondpoint " + PaneauMoyennes.getMoyenneRondpoint());

					// Mise � jour du nombre de voiture sur les �l�ments de la route

					Bretelle.MAJVoitures();
					Rondpoint.MAJVoitures();
					Troncon1.MAJVoitures();
					Troncon2.MAJVoitures();
					Troncon3.MAJVoitures();
				}
				if (secondes >= 60) // Une minute �coul�e
				{
					secondes = 0;
					Bt_Secs.setText("" + 0);
					minutes++;
					Bt_Mins.setText("" + minutes + "m :");
				}
			}
		});

		// Bouton pour d�marrer le chronom�tre

		JButton Btn_Start = new JButton("Lancer");
		Btn_Start.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Start.setBounds(10, 36, 63, 18);
		Btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T.start();
				if (chronoOff) {

					// G�n�ration au hasard des voitures sur les �l�ments de la route

					Rondpoint.genVoitures();
					Bretelle.genVoitures();
					Troncon1.genVoitures();
					Troncon2.genVoitures();
					Troncon3.genVoitures();

					// Commence la loop infinie du PanneauEtat
					PaneauEtat.ImageChange.timeEtat();
					chronoOff = false;
				}
			}
		});
		add(Btn_Start);

		// Bouton pour recommencer le chronom�tre

		JButton Btn_Reset = new JButton("Recommencer");
		Btn_Reset.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Reset.setBounds(24, 58, 107, 18);
		Btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T.stop();

				// Les voitures sur les �l�ments de la route sont aussi r�initialis�es

				Bretelle.resetVoitures();
				Rondpoint.resetVoitures();
				Troncon1.resetVoitures();
				Troncon2.resetVoitures();
				Troncon3.resetVoitures();

				// Termine la loop infinie de PanneauEtat
				PaneauEtat.ImageChange.timeCancel();

				PaneauMoyennes.resetValeurs();

				millisecondes = 0;
				minutes = 0;
				secondes = 0;
				timestamp = 0;
				Bt_Millis.setText("" + millisecondes + " :");
				Bt_Mins.setText("" + minutes + " :");
				Bt_Secs.setText("" + secondes + " :");
				chronoOff = true;
			}
		});
		add(Btn_Reset);

		// Bouton pour arr�ter le chronom�tre

		JButton Btn_Stop = new JButton("Arreter");
		Btn_Stop.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Btn_Stop.setBounds(80, 36, 63, 18);
		Btn_Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T.stop();

				// Termine la loop infinie de PanneauEtat
				PaneauEtat.ImageChange.timeCancel();
			}
		});
		add(Btn_Stop);

	}

	// Prend l'empreinte de temps globale. Appliqu�e aux voitures du rondpoint pour
	// savoir combien de temps avant qu'elles le quitte

	public static int getTimestamp() {
		return timestamp;
	};
}
