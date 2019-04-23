/** 
 * Classe Chrono, version 3.4.1, 22 avril 2019.
 * 
 * Il s'agit du chronom�tre en haut � droite de l'interface. Lorsqu'on le d�marre,
 * les voitures des zones sont g�n�r�es au hasard. Il se met � jour au 8 millisecondes,
 * et � chaque seconde �coul�e, met � jour le nombre de voitures sur les zones. On peut
 * r�initialiser toutes les zones et reprendre de nouveaux tests. Fonction d'arr�t disponible.
 */

package com.objet;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.zone.Bretelle;
import com.zone.Rondpoint;
import com.zone.Troncon1;
import com.zone.Troncon2;
import com.zone.Troncon3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class Chrono extends JPanel {

	/** Param�tres de temps. @param timestamp est utilis� pour comparer le moment
	 *  de cr�ation d'objects au moment actuel.
	 */
	

	protected static int	secondes = 0;
	protected static int	minutes = 0;
	protected static int	millisecondes = 0;
	protected static int	timestamp = 0;
	protected boolean	chronoOff = true;
	protected boolean	firstIteration = true;

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
				
				if (firstIteration) {
					Bretelle.getVoitureDebut();
					Rondpoint.getVoitureDebut();
					Troncon1.getVoitureDebut();
					Troncon2.getVoitureDebut();
					Troncon3.getVoitureDebut();
					firstIteration = false;
				}

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
					Statistiques.setMoyenneBretelle();
					Statistiques.lblMoyBret.setText("Bretelle : " + String.format("%.0f", Statistiques.getMoyenneBretelle()));
					Statistiques.setMoyenneTron1();
					Statistiques.lblMoyTron1.setText("Tron�on1 : " + String.format("%.0f", Statistiques.getMoyenneTron1()));
					Statistiques.setMoyenneTron2();
					Statistiques.lblMoyTron2.setText("Tron�on2 : " + String.format("%.0f", Statistiques.getMoyenneTron2()));
					Statistiques.setMoyenneTron3();
					Statistiques.lblMoyTron3.setText("Tron�on3 : " + String.format("%.0f", Statistiques.getMoyenneTron3()));
					Statistiques.setMoyenneRondpoint();
					Statistiques.lblMoyRP.setText("Rondpoint : " + String.format("%.0f", Statistiques.getMoyenneRondpoint()));

					if (timestamp % ComboBoxTrafic.getTemps() == 0) {
						
						// Mise � jour du nombre de voiture sur les �l�ments de la route en fonction du moment de la journ�e

						Bretelle.majVoitures(); 
						Rondpoint.mAJVoitures(); 
						Troncon1.mAJVoitures(); 
						Troncon2.mAJVoitures(); 
						Troncon3.mAJVoitures(); 
					}
					
					PaneauFeu.checkTimer();
					
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
				T.start();;
				if (chronoOff) {

					// G�n�ration au hasard des voitures sur les �l�ments de la route
					PaneauFeu.startVert();
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

				Statistiques.resetValeurs();
				
				firstIteration = true;
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
				System.out.println("Chronom�tre arr�t�");
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
	
	public static int getSecondes() {
		return secondes + 60 * minutes;	
	}
	
}
