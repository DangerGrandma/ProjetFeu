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

// Paneau affichant la moyenne du nombre de voitures sur un élément de la route

public class PaneauMoyennes extends JPanel {
	
// Initialisation des Jlabels sur lesquels les moyennes sont affichées	
	
	public static JLabel lblMoyBret = new JLabel("Bretelle : ");
	public static JLabel lblMoyTron1 = new JLabel("Tronçon 1 : ");
	public static JLabel lblMoyTron2 = new JLabel("Tronçon 2 : ");
	public static JLabel lblMoyTron3 = new JLabel("Tronçon 3 : ");
	public static JLabel lblMoyRP = new JLabel("Rondpoint : ");
	public static JLabel lblMoyennes = new JLabel("<html>" + "Moyennes des voitures" + "<br>" +  "<span>" + "sur l'élément :" + "</html>");
	public PaneauMoyennes() {
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		// Création de boutons qui permettent d'ajouter et d'enlever des voitures des éléments de la route
		
		JButton plusBret = new JButton("+");
		plusBret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bretelle.ajoutVoitures();
			}
		});
		plusBret.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusBret.setBounds(20, 85, 41, 18);
		add(plusBret);
		
		JButton moinsBret = new JButton("-");
		moinsBret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bretelle.retraitVoiture();
			}	
		});
		moinsBret.setFont(new Font("Tahoma", Font.PLAIN, 10));
		moinsBret.setBounds(69, 85, 41, 18);
		add(moinsBret);

		
		JButton plusTron1 = new JButton("+");
		plusTron1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Troncon1.ajoutVoitures();
			}
		});
		plusTron1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusTron1.setBounds(20, 141, 41, 18);
		add(plusTron1);
		
		JButton moinsTron1 = new JButton("-");
		moinsTron1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Troncon1.retraitVoiture();
			}	
		});
		moinsTron1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		moinsTron1.setBounds(69, 141, 41, 18);
		add(moinsTron1);

		
		JButton plusTron2 = new JButton("+");
		plusTron2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Troncon2.ajoutVoitures();
			}
		});
		plusTron2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusTron2.setBounds(20, 197, 41, 18);
		add(plusTron2);
		
		JButton moinsTron2 = new JButton("-");
		moinsTron2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Troncon2.retraitVoiture();
			}	
		});
		moinsTron2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		moinsTron2.setBounds(69, 197, 41, 18);
		add(moinsTron2);
		
		JButton plusTron3 = new JButton("+");
		plusTron3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Troncon3.ajoutVoitures();
			}
		});
		plusTron3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusTron3.setBounds(20, 253, 41, 18);
		add(plusTron3);
		
		JButton moinsTron3 = new JButton("-");
		moinsTron3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Troncon3.retraitVoiture();
			}	
		});
		moinsTron3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		moinsTron3.setBounds(69, 253, 41, 18);
		add(moinsTron3);
		
		JButton plusRP = new JButton("+");
		plusRP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rondpoint.ajoutVoitures();
			}
		});
		plusRP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plusRP.setBounds(20, 309, 41, 18);
		add(plusRP);
		
		JButton moinsRP = new JButton("-");
		moinsRP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rondpoint.retraitVoiture();
			}	
		});
		moinsRP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		moinsRP.setBounds(69, 309, 41, 18);
		add(moinsRP);
		

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

	/* Initialisation des variables d'éléments de la route : moyenne des voitures sur l'élément en question, total utilisé pour calculer la moyenne,
	 * ainsi qu'un compteur également utiliser pour calculer les moyennes.
	 */
	
	private static double moyenneBretelle;
	private static double totalBretelle;
	private static int compteurBretelle = 0;
	private static double moyenneTron1;
	private static double totalTron1;
	private static int compteurTron1 = 0;
	private static double moyenneTron2;
	private static double totalTron2;
	private static int compteurTron2 = 0;
	private static double moyenneTron3;
	private static double totalTron3;
	private static int compteurTron3 = 0;
	private static double moyenneRondpoint;
	private static double totalRondpoint;
	private static int compteurRondpoint = 0;

	

	public static void setMoyenneBretelle() {
		compteurBretelle++;
		totalBretelle = totalBretelle + Bretelle.getVoituresSize();
		moyenneBretelle = totalBretelle/compteurBretelle;
	};
	
	public static double getMoyenneBretelle() {
		return (int) Math.round(moyenneBretelle);
	};
	
	public static void setMoyenneTron1() {
		compteurTron1++;
		totalTron1 = totalTron1 + Troncon1.getVoituresSize();
		moyenneTron1 = totalTron1/compteurTron1;
	};
	
	public static double getMoyenneTron1() {
		return (int) Math.round(moyenneTron1);
	};
	
	public static void setMoyenneTron2() {
		compteurTron2++;
		totalTron2 = totalTron2 + Troncon2.getVoituresSize();
		moyenneTron2 = totalTron2/compteurTron2;
	};
	
	public static double getMoyenneTron2() {
		return (int) Math.round(moyenneTron2);
	};
	
	public static void setMoyenneTron3() {
		compteurTron3++;
		totalTron3 = totalTron3 + Troncon3.getVoituresSize();
		moyenneTron3 = totalTron3/compteurTron3;
	};
	
	public static double getMoyenneTron3() {
		return (int) Math.round(moyenneTron3);
	};
	
	public static void setMoyenneRondpoint() {
		compteurRondpoint++;
		totalRondpoint = totalRondpoint + Rondpoint.getVoituresSize();
		moyenneRondpoint = totalRondpoint/compteurRondpoint;
	};
	
	public static double getMoyenneRondpoint() {
		return (int) Math.round(moyenneRondpoint);
	}
	
	// Méthode pour réinitialiser les valeurs des variables et des affichages
	
	public static void resetValeurs() {
		moyenneBretelle = 0;
		totalBretelle = 0;
		compteurBretelle = 0;
		moyenneTron1 = 0;
		totalTron1 = 0;
		compteurTron1 = 0;
		moyenneTron2 = 0;
		totalTron2 = 0;
		compteurTron2 = 0;
		moyenneTron3 = 0;
		totalTron3 = 0;
		compteurTron3 = 0;
		moyenneRondpoint = 0;
		totalRondpoint = 0;
		compteurRondpoint = 0;
		
		lblMoyBret.setText("Bretelle : ");
		lblMoyTron1.setText("Tronçon 1 : ");
		lblMoyTron2.setText("Tronçon 2 : ");
		lblMoyTron3.setText("Tronçon 3 : ");
		lblMoyRP.setText("Rondpoint : ");
	}
}
