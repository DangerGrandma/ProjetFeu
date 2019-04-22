package essentiels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChoixVoitures extends JPanel {
	
	static int tron1Debut;
	static int tron2Debut;
	static int tron3Debut;
	static int bretelleDebut;
	static int rondpointDebut;
	
	
	
	public static int getTron1Debut() {
		return tron1Debut;
	}

	public static int getTron2Debut() {
		return tron2Debut;
	}

	public static int getTron3Debut() {
		return tron3Debut;
	}

	public static int getBretelleDebut() {
		return bretelleDebut;
	}

	public static int getRondpointDebut() {
		return rondpointDebut;
	}

	public ChoixVoitures() {

		setLayout(null);
		
		JTextField jtRondpoint = new JTextField();
		jtRondpoint.setText("0");
		jtRondpoint.setBounds(128, 5, 30, 20);
		add(jtRondpoint);
		jtRondpoint.setColumns(3);
		rondpointDebut = Integer.parseInt(jtRondpoint.getText());
		
		JLabel lblDpartRondpoint = new JLabel("D\u00E9part Rondpoint");
		lblDpartRondpoint.setForeground(Color.WHITE);
		lblDpartRondpoint.setBounds(10, 8, 108, 14);
		add(lblDpartRondpoint);
		
		JLabel lblDpartBretelle = new JLabel("D\u00E9part Bretelle");
		lblDpartBretelle.setForeground(Color.WHITE);
		lblDpartBretelle.setBounds(12, 33, 106, 14);
		add(lblDpartBretelle);
		
		JTextField jtTron1 = new JTextField();
		jtTron1.setText("0");
		jtTron1.setBounds(296, 5, 30, 20);
		add(jtTron1);
		jtTron1.setColumns(10);
		tron1Debut = Integer.parseInt(jtTron1.getText());
		
		JLabel lblDpartTronon = new JLabel("D\u00E9part Tron\u00E7on 1");
		lblDpartTronon.setForeground(Color.WHITE);
		lblDpartTronon.setBounds(184, 8, 102, 14);
		add(lblDpartTronon);
		
		JTextField jtTron2 = new JTextField();
		jtTron2.setText("0");
		jtTron2.setBounds(296, 30, 30, 20);
		add(jtTron2);
		jtTron2.setColumns(10);
		tron2Debut = Integer.parseInt(jtTron2.getText());
		
		JLabel lblDpartTronon_1 = new JLabel("D\u00E9part Tron\u00E7on 2");
		lblDpartTronon_1.setForeground(Color.WHITE);
		lblDpartTronon_1.setBounds(184, 33, 102, 14);
		add(lblDpartTronon_1);
		
		JTextField jtTron3 = new JTextField();
		jtTron3.setText("0");
		jtTron3.setBounds(296, 57, 30, 20);
		add(jtTron3);
		jtTron3.setColumns(10);
		tron3Debut = Integer.parseInt(jtTron3.getText());
		
		JTextField jtBretelle = new JTextField();
		jtBretelle.setText("0");
		jtBretelle.setBounds(128, 30, 30, 20);
		add(jtBretelle);
		jtBretelle.setColumns(10);
		bretelleDebut = Integer.parseInt(jtBretelle.getText());
		
		JLabel lblDpartTronon_2 = new JLabel("D\u00E9part Tron\u00E7on 3");
		lblDpartTronon_2.setForeground(Color.WHITE);
		lblDpartTronon_2.setBounds(184, 58, 102, 14);
		add(lblDpartTronon_2);
		
		JLabel lblNewLabel_1 = new JLabel("Voitures de d\u00E9part. 0 = Valeurs al\u00E9atoires");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 85, 276, 14);
		add(lblNewLabel_1);
	}
	
	/*
	 * Vérifie les valeurs de départ des voitures et modifies les données en conséquence
	 */
	public static void checkJT(String text) {
		if (text != "0") {
			ComboBoxTrafic.setTronDebutMax(Integer.parseInt(text));
			ComboBoxTrafic.setTronDebutMin(Integer.parseInt(text));
			ComboBoxTrafic.setAutDebutMax(Integer.parseInt(text));
			ComboBoxTrafic.setAutDebutMin(Integer.parseInt(text));
			ComboBoxTrafic.setRondpointDebutMax(Integer.parseInt(text));
			ComboBoxTrafic.setRondpointDebutMin(Integer.parseInt(text));
		}
	}
	
}
