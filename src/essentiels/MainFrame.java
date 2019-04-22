// Classe MainFrame, version 4.0.0, 22 avril 2019

package essentiels;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import essentiels.elementsRoute.Bretelle;
import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Troncon1;
import essentiels.elementsRoute.Troncon2;
import essentiels.elementsRoute.Troncon3;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private JTextField textField;
	private JTextField jtRondpoint;
	private JTextField jtBretelle;
	private JTextField jtTron1;
	private JTextField jtTron2;
	private JTextField jtTron3;

	// Frame sur lequel toutes les composantes graphiques sont affichées pour l'application

	public MainFrame() {

		// Titre de la fenêtre d'application et initialisation du frame

		super("Feu Intelligent");
		setResizable(false);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);

		// Initialisation du paneau du feu intelligent

		PaneauFeu PanFeu = new PaneauFeu();
		PanFeu.setBackground(new Color(47, 79, 79));
		PanFeu.setBounds(748, 221, 58, 110);

		// Initialisation du menu du moment du jour

		ComboBoxTrafic menuTrafic = new ComboBoxTrafic();
		menuTrafic.setBackground(new Color(47, 79, 79));
		menuTrafic.setBounds(607, 12, 132, 40);
		getContentPane().add(menuTrafic);

		// Initialisation du nombre de voitures
		
		ChoixVoitures boitesVoitures = new ChoixVoitures();
		boitesVoitures.setBackground(new Color(47, 79, 79));
		boitesVoitures.setBounds(148, 12, 449, 97);
		getContentPane().add(boitesVoitures);

		// Initialisation du conteneur des composantes visuelles

		Container c = getContentPane();
		c.add(PanFeu);

		// JLabel ayant pour texte "Chronomètre"

		JLabel lblChronomtre = new JLabel("Chronom\u00E8tre");
		lblChronomtre.setForeground(Color.BLACK);
		lblChronomtre.setBounds(784, 0, 120, 52);
		getContentPane().add(lblChronomtre);
		lblChronomtre.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));

		// Initialisation du chronomètre

		Chrono stopwatch = new Chrono();
		stopwatch.setBackground(new Color(47, 79, 79));
		stopwatch.setBounds(764, 28, 170, 81);
		getContentPane().add(stopwatch);

		// Initialisation du panneau d'état des routes

		PaneauEtat status = new PaneauEtat();
		status.setBounds(673, 488, 271, 183);
		c.add(status);

		// Initialisation du paneau affichant les moyennes de voitures aux éléments de la route

		PaneauMoyennes panMoy = new PaneauMoyennes();
		panMoy.setBounds(10, 135, 132, 511);
		c.add(panMoy);
		


		// Initialisation de la brettelle qui connecte l'autoroute au rondpoint

		Bretelle bretelle = new Bretelle();
		bretelle.VtrsBretelle.setText("Voitures sur la bretelle : ");
		bretelle.setBackground(Color.LIGHT_GRAY);
		bretelle.setSize(163, 40);
		bretelle.setLocation(748, 361);
		bretelle.VtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		bretelle.VtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER);
		bretelle.VtrsBretelle.setBounds(11, 11, 140, 14);
		c.add(bretelle);

		// Initialisation du rondpoint

		Rondpoint rondpoint = new Rondpoint();
		rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : ");
		rondpoint.VtrsRondpoint.setLocation(10, 11);
		rondpoint.setBackground(Color.LIGHT_GRAY);
		rondpoint.setBounds(359, 361, 163, 40);
		getContentPane().add(rondpoint);

		// Initialisation du premier tronçon

		Troncon1 Tr1 = new Troncon1();
		Tr1.VtrsTroncon1.setText("Voitures sur le troncon1 : ");
		Tr1.setBackground(Color.LIGHT_GRAY);
		Tr1.setSize(163, 40);
		Tr1.setLocation(359, 590);
		Tr1.VtrsTroncon1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Tr1.VtrsTroncon1.setHorizontalAlignment(SwingConstants.CENTER);
		Tr1.VtrsTroncon1.setBounds(11, 11, 140, 14);
		c.add(Tr1);

		// Initialisation du second tronçon

		Troncon2 Tr2 = new Troncon2();
		Tr2.VtrsTroncon2.setText("Voitures sur le troncon2 : ");
		Tr2.setBackground(Color.LIGHT_GRAY);
		Tr2.setSize(163, 40);
		Tr2.setLocation(157, 373);
		Tr2.VtrsTroncon2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Tr2.VtrsTroncon2.setHorizontalAlignment(SwingConstants.CENTER);
		Tr2.VtrsTroncon2.setBounds(10, 11, 140, 14);

		c.add(Tr2);

		// Initialisation du troisième tronçon

		Troncon3 Tr3 = new Troncon3();
		Tr3.VtrsTroncon3.setText("Voitures sur le troncon3 : ");
		Tr3.setBackground(Color.LIGHT_GRAY);
		Tr3.setSize(163, 40);
		Tr3.setLocation(359, 144);
		Tr3.VtrsTroncon3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Tr3.VtrsTroncon3.setHorizontalAlignment(SwingConstants.CENTER);
		Tr3.VtrsTroncon3.setBounds(10, 11, 140, 14);
		c.add(Tr3);

		// Initialisation d'un JLabel ayant pour texte "Menu"

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(24, 28, 99, 60);
		getContentPane().add(lblNewLabel);

		// Banière turquoise foncée

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setEnabled(false);
		editorPane.setBackground(new Color(47, 79, 79));
		editorPane.setBounds(0, 0, 944, 116);
		getContentPane().add(editorPane);

		// Banière turquoise pâle

		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(new Color(95, 158, 160));
		editorPane_1.setBounds(0, 115, 154, 556);
		getContentPane().add(editorPane_1);

		// Image du rondpoint avec les tronçons et la bretelle d'autoroute

		JLabel imgRondPoint = new JLabel("");
		imgRondPoint.setBounds(152, 115, 792, 556);
		getContentPane().add(imgRondPoint);
		ImageIcon imageIcon = new ImageIcon(MainFrame.class.getResource("/essentiels/images/Rondpoint.PNG"));
		Image img = imageIcon.getImage();
		Image newImg = img.getScaledInstance(imgRondPoint.getWidth(), imgRondPoint.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon finalImage = new ImageIcon(newImg);
		imgRondPoint.setIcon(finalImage);
			
		// Dimensions du JFrame

		setSize(950, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}
