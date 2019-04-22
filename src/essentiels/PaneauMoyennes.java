package essentiels;

import javax.swing.JPanel;

import essentiels.elementsRoute.Bretelle;
import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Troncon1;
import essentiels.elementsRoute.Troncon2;
import essentiels.elementsRoute.Troncon3;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Paneau affichant la moyenne du nombre de voitures sur un �l�ment de la route

public class PaneauMoyennes extends JPanel {
	
// Initialisation des Jlabels sur lesquels les moyennes sont affich�es	
	
	public static JLabel lblMoyBret = new JLabel("Bretelle : ");
	public static JLabel lblMoyTron1 = new JLabel("Tron�on 1 : ");
	public static JLabel lblMoyTron2 = new JLabel("Tron�on 2 : ");
	public static JLabel lblMoyTron3 = new JLabel("Tron�on 3 : ");
	public static JLabel lblMoyRP = new JLabel("Rondpoint : ");
	public static JLabel lblMoyennes = new JLabel("<html>" + "Moyennes des voitures" + "<br>" +  "<span>" + "sur l'�l�ment :" + "</html>");
	public PaneauMoyennes() {
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		// Cr�ation de boutons qui permettent d'ajouter et d'enlever des voitures des �l�ments de la route
		
		JButton PlusBret = new JButton("+");
		PlusBret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bretelle.ajoutVoitures();
			}
		});
		PlusBret.setFont(new Font("Tahoma", Font.PLAIN, 10));
		PlusBret.setBounds(20, 85, 41, 18);
		add(PlusBret);
		
		JButton MoinsBret = new JButton("-");
		MoinsBret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bretelle.retraitVoiture();
			}	
		});
		MoinsBret.setFont(new Font("Tahoma", Font.PLAIN, 10));
		MoinsBret.setBounds(69, 85, 41, 18);
		add(MoinsBret);

		
		JButton PlusTron1 = new JButton("+");
		PlusTron1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Troncon1.ajoutVoitures();
			}
		});
		PlusTron1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		PlusTron1.setBounds(20, 141, 41, 18);
		add(PlusTron1);
		
		JButton MoinsTron1 = new JButton("-");
		MoinsTron1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Troncon1.retraitVoiture();
			}	
		});
		MoinsTron1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		MoinsTron1.setBounds(69, 141, 41, 18);
		add(MoinsTron1);

		
		JButton PlusTron2 = new JButton("+");
		PlusTron2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Troncon2.ajoutVoitures();
			}
		});
		PlusTron2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		PlusTron2.setBounds(20, 197, 41, 18);
		add(PlusTron2);
		
		JButton MoinsTron2 = new JButton("-");
		MoinsTron2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Troncon2.retraitVoiture();
			}	
		});
		MoinsTron2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		MoinsTron2.setBounds(69, 197, 41, 18);
		add(MoinsTron2);
		
		JButton PlusTron3 = new JButton("+");
		PlusTron3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Troncon3.ajoutVoitures();
			}
		});
		PlusTron3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		PlusTron3.setBounds(20, 253, 41, 18);
		add(PlusTron3);
		
		JButton MoinsTron3 = new JButton("-");
		MoinsTron3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Troncon3.retraitVoiture();
			}	
		});
		MoinsTron3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		MoinsTron3.setBounds(69, 253, 41, 18);
		add(MoinsTron3);
		
		JButton PlusRP = new JButton("+");
		PlusRP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rondpoint.ajoutVoitures();
			}
		});
		PlusRP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		PlusRP.setBounds(20, 309, 41, 18);
		add(PlusRP);
		
		JButton MoinsRP = new JButton("-");
		MoinsRP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rondpoint.retraitVoiture();
			}	
		});
		MoinsRP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		MoinsRP.setBounds(69, 309, 41, 18);
		add(MoinsRP);
		

		// Configuration des JLabels
		
		lblMoyennes.setBounds(10, 0, 161, 73);
		add(lblMoyennes);
		lblMoyennes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		lblMoyBret.setFont(new Font("Tahoma", Font.PLAIN, 10));	
		lblMoyBret.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyBret.setBounds(0, 55, 85, 43);
		add(lblMoyBret);
		
		lblMoyTron1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMoyTron1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyTron1.setBounds(0, 110, 85, 43);
		add(lblMoyTron1);		

		lblMoyTron2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMoyTron2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyTron2.setBounds(0, 165, 85, 43);
		add(lblMoyTron2);
		
		lblMoyTron3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMoyTron3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyTron3.setBounds(0, 220, 85, 43);
		add(lblMoyTron3);
		
		lblMoyRP.setFont(new Font("Tahoma", Font.PLAIN, 10));	
		lblMoyRP.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyRP.setBounds(0, 275, 85, 43);
		add(lblMoyRP);
	}

	/* Initialisation des variables d'�l�ments de la route : moyenne des voitures sur l'�l�ment en question, total utilis� pour calculer la moyenne,
	 * ainsi qu'un compteur �galement utiliser pour calculer les moyennes.
	 */
	
	private static double MoyenneBretelle;
	private static double totalBretelle;
	private static int compteurBretelle = 0;
	private static double MoyenneTron1;
	private static double totalTron1;
	private static int compteurTron1 = 0;
	private static double MoyenneTron2;
	private static double totalTron2;
	private static int compteurTron2 = 0;
	private static double MoyenneTron3;
	private static double totalTron3;
	private static int compteurTron3 = 0;
	private static double MoyenneRondpoint;
	private static double totalRondpoint;
	private static int compteurRondpoint = 0;

	

	public static void setMoyenneBretelle() {
		compteurBretelle++;
		totalBretelle = totalBretelle + Bretelle.getVoituresSize();
		MoyenneBretelle = totalBretelle/compteurBretelle;
	};
	
	public static double getMoyenneBretelle() {
		return (int) Math.round(MoyenneBretelle);
	};
	
	public static void setMoyenneTron1() {
		compteurTron1++;
		totalTron1 = totalTron1 + Troncon1.getVoituresSize();
		MoyenneTron1 = totalTron1/compteurTron1;
	};
	
	public static double getMoyenneTron1() {
		return (int) Math.round(MoyenneTron1);
	};
	
	public static void setMoyenneTron2() {
		compteurTron2++;
		totalTron2 = totalTron2 + Troncon2.getVoituresSize();
		MoyenneTron2 = totalTron2/compteurTron2;
	};
	
	public static double getMoyenneTron2() {
		return (int) Math.round(MoyenneTron2);
	};
	
	public static void setMoyenneTron3() {
		compteurTron3++;
		totalTron3 = totalTron3 + Troncon3.getVoituresSize();
		MoyenneTron3 = totalTron3/compteurTron3;
	};
	
	public static double getMoyenneTron3() {
		return (int) Math.round(MoyenneTron3);
	};
	
	public static void setMoyenneRondpoint() {
		compteurRondpoint++;
		totalRondpoint = totalRondpoint + Rondpoint.getVoituresSize();
		MoyenneRondpoint = totalRondpoint/compteurRondpoint;
	};
	
	public static double getMoyenneRondpoint() {
		return (int) Math.round(MoyenneRondpoint);
	}
	
	// M�thode pour r�initialiser les valeurs des variables et des affichages
	
	public static void resetValeurs() {
		MoyenneBretelle = 0;
		totalBretelle = 0;
		compteurBretelle = 0;
		MoyenneTron1 = 0;
		totalTron1 = 0;
		compteurTron1 = 0;
		MoyenneTron2 = 0;
		totalTron2 = 0;
		compteurTron2 = 0;
		MoyenneTron3 = 0;
		totalTron3 = 0;
		compteurTron3 = 0;
		MoyenneRondpoint = 0;
		totalRondpoint = 0;
		compteurRondpoint = 0;
		
		lblMoyBret.setText("Bretelle : ");
		lblMoyTron1.setText("Tron�on 1 : ");
		lblMoyTron2.setText("Tron�on 2 : ");
		lblMoyTron3.setText("Tron�on 3 : ");
		lblMoyRP.setText("Rondpoint : ");
	}
}
