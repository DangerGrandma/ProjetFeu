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
		menuTrafic.setBounds(601, 12, 133, 40);
		getContentPane().add(menuTrafic);

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
		
		jtRondpoint = new JTextField();
		jtRondpoint.setText("0");
		jtRondpoint.setBounds(301, 20, 33, 20);
		getContentPane().add(jtRondpoint);
		jtRondpoint.setColumns(3);
		
		JLabel lblDpartRondpoint = new JLabel("D\u00E9part Rondpoint");
		lblDpartRondpoint.setForeground(Color.WHITE);
		lblDpartRondpoint.setBounds(189, 23, 102, 14);
		getContentPane().add(lblDpartRondpoint);
		
		jtBretelle = new JTextField();
		jtBretelle.setText("0");
		jtBretelle.setBounds(301, 54, 33, 20);
		getContentPane().add(jtBretelle);
		jtBretelle.setColumns(10);
		
		JLabel lblDpartBretelle = new JLabel("D\u00E9part Bretelle");
		lblDpartBretelle.setForeground(Color.WHITE);
		lblDpartBretelle.setBounds(189, 57, 102, 14);
		getContentPane().add(lblDpartBretelle);
		
		jtTron1 = new JTextField();
		jtTron1.setText("0");
		jtTron1.setBounds(478, 12, 33, 20);
		getContentPane().add(jtTron1);
		jtTron1.setColumns(10);
		
		JLabel lblDpartTronon = new JLabel("D\u00E9part Tron\u00E7on 1");
		lblDpartTronon.setForeground(Color.WHITE);
		lblDpartTronon.setBounds(359, 12, 109, 20);
		getContentPane().add(lblDpartTronon);
		
		jtTron2 = new JTextField();
		jtTron2.setText("0");
		jtTron2.setBounds(478, 43, 33, 20);
		getContentPane().add(jtTron2);
		jtTron2.setColumns(10);
		
		JLabel lblDpartTronon_1 = new JLabel("D\u00E9part Tron\u00E7on 2");
		lblDpartTronon_1.setForeground(Color.WHITE);
		lblDpartTronon_1.setBounds(359, 43, 109, 14);
		getContentPane().add(lblDpartTronon_1);
		
		jtTron3 = new JTextField();
		jtTron3.setText("0");
		jtTron3.setBounds(478, 74, 33, 20);
		getContentPane().add(jtTron3);
		jtTron3.setColumns(10);
		
		JLabel lblDpartTronon_2 = new JLabel("D\u00E9part Tron\u00E7on 3");
		lblDpartTronon_2.setForeground(Color.WHITE);
		lblDpartTronon_2.setBounds(359, 74, 109, 14);
		getContentPane().add(lblDpartTronon_2);
		
		JLabel lblNewLabel_1 = new JLabel("Choisir un nombre de voiture au d\u00E9part. \r\n\u00C0 0, le programme utilise des valeurs al\u00E9atoires.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(84, 70, 310, 39);
		getContentPane().add(lblNewLabel_1);

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
