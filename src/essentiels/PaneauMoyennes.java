package essentiels;

import javax.swing.JPanel;

import essentiels.elementsRoute.Bretelle;
import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Troncon2;
import essentiels.elementsRoute.Troncon3;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PaneauMoyennes extends JPanel {
	public static JLabel lblMoyBret = new JLabel("Bretelle : ");
	public static JLabel lblMoyTron1 = new JLabel("Tron�on 1 : ");
	public static JLabel lblMoyTron2 = new JLabel("Tron�on 2 : ");
	public static JLabel lblMoyTron3 = new JLabel("Tron�on 3 : ");
	public static JLabel lblMoyRP = new JLabel("Rondpoint : ");
	
	public PaneauMoyennes() {
		setBackground(new Color(95, 158, 160));
		setLayout(null);

		lblMoyBret.setFont(new Font("Tahoma", Font.PLAIN, 10));	
		lblMoyBret.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyBret.setBounds(0, 0, 85, 43);
		add(lblMoyBret);
		
		lblMoyTron1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMoyTron1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyTron1.setBounds(0, 55, 85, 43);
		add(lblMoyTron1);		

		lblMoyTron2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMoyTron2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyTron2.setBounds(0, 110, 85, 43);
		add(lblMoyTron2);
		
		lblMoyTron3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMoyTron3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyTron3.setBounds(0, 165, 85, 43);
		add(lblMoyTron3);
		
		lblMoyRP.setFont(new Font("Tahoma", Font.PLAIN, 10));	
		lblMoyRP.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoyRP.setBounds(0, 220, 85, 43);
		add(lblMoyRP);
	}
	
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
		return MoyenneBretelle;
	};
	
	public static void setMoyenneTron1() {
		compteurTron1++;
		totalTron1 = totalTron1 + Bretelle.getVoituresSize();
		MoyenneTron1 = totalTron1/compteurTron1;
	};
	
	public static double getMoyenneTron1() {
		return MoyenneTron1;
	};
	
	public static void setMoyenneTron2() {
		compteurTron2++;
		totalTron2 = totalTron2 + Troncon2.getVoituresSize();
		MoyenneTron2 = totalTron2/compteurTron2;
	};
	
	public static double getMoyenneTron2() {
		return MoyenneTron2;
	};
	
	public static void setMoyenneTron3() {
		compteurTron3++;
		totalTron3 = totalTron3 + Troncon3.getVoituresSize();
		MoyenneTron3 = totalTron3/compteurTron3;
	};
	
	public static double getMoyenneTron3() {
		return MoyenneTron3;
	};
	
	public static void setMoyenneRondpoint() {
		compteurRondpoint++;
		totalRondpoint = totalRondpoint + Rondpoint.getVoituresSize();
		MoyenneRondpoint = totalRondpoint/compteurRondpoint;
	};
	
	public static double getMoyenneRondpoint() {
		return MoyenneRondpoint;
	}
	
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
	};
}
