package com.objet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigurationVoitures extends JPanel {
	
	private static int tron1Debut;
	private static int tron2Debut;
	private static int tron3Debut;
	private static int bretelleDebut;
	private static int rondpointDebut;
	
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

	public static void setBretelleDebut(int bretelleDebut) {
		ConfigurationVoitures.bretelleDebut = bretelleDebut;
	}

	public ConfigurationVoitures() {

		setLayout(null);
		
		JTextField jtRondpoint = new JTextField();
		jtRondpoint.setText("0");
		jtRondpoint.setBounds(128, 5, 30, 20);
		add(jtRondpoint);
		jtRondpoint.setColumns(3);
		
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
		
		JLabel lblDpartTronon = new JLabel("D\u00E9part Tron\u00E7on 1");
		lblDpartTronon.setForeground(Color.WHITE);
		lblDpartTronon.setBounds(184, 8, 102, 14);
		add(lblDpartTronon);
		
		JTextField jtTron2 = new JTextField();
		jtTron2.setText("0");
		jtTron2.setBounds(296, 30, 30, 20);
		add(jtTron2);
		jtTron2.setColumns(10);
		
		JLabel lblDpartTronon_1 = new JLabel("D\u00E9part Tron\u00E7on 2");
		lblDpartTronon_1.setForeground(Color.WHITE);
		lblDpartTronon_1.setBounds(184, 33, 102, 14);
		add(lblDpartTronon_1);
		
		JTextField jtTron3 = new JTextField();
		jtTron3.setText("0");
		jtTron3.setBounds(296, 57, 30, 20);
		add(jtTron3);
		jtTron3.setColumns(10);
		
		JTextField jtBretelle = new JTextField();
		jtBretelle.setText("0");
		jtBretelle.setBounds(128, 30, 30, 20);
		add(jtBretelle);
		jtBretelle.setColumns(10);
		
		JLabel lblDpartTronon_2 = new JLabel("D\u00E9part Tron\u00E7on 3");
		lblDpartTronon_2.setForeground(Color.WHITE);
		lblDpartTronon_2.setBounds(184, 58, 102, 14);
		add(lblDpartTronon_2);
		
		JLabel lblNewLabel_1 = new JLabel("Voitures de d\u00E9part. 0 = Valeurs al\u00E9atoires");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 85, 276, 14);
		add(lblNewLabel_1);
		
		JButton modifierDonnees = new JButton("Modifier");
		modifierDonnees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					rondpointDebut = Integer.parseInt(jtRondpoint.getText());
				}
				catch (Exception e1) {
					rondpointDebut = 0;
					jtRondpoint.setText("0");
				}
				
				try {
					tron1Debut = Integer.parseInt(jtTron1.getText());
				}
				catch (Exception e1) {
					tron1Debut = 0;
					jtTron1.setText("0");
				}
				
				try {
					tron2Debut = Integer.parseInt(jtTron2.getText());
				}
				catch (Exception e1) {
					tron2Debut = 0;
					jtTron2.setText("0");
				}

				try {
					tron3Debut = Integer.parseInt(jtTron3.getText());
				}
				catch (Exception e1) {
					tron3Debut = 0;
					jtTron3.setText("0");
				}
				
				try {
					bretelleDebut = Integer.parseInt(jtBretelle.getText());
				}
				catch (Exception e1) {
					bretelleDebut = 0;
					jtBretelle.setText("0");
				}
				
				JOptionPane.showMessageDialog(null, "Données de départ modifiée!");
			}
		});
		modifierDonnees.setBounds(351, 24, 89, 23);
		add(modifierDonnees);
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
