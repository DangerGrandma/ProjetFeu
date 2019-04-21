package essentiels;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import essentiels.elementsRoute.Bretelle;
import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Troncon1;
import essentiels.elementsRoute.Troncon2;
import essentiels.elementsRoute.Troncon3;

public class MainFrame extends JFrame {


	// Frame sur lequel toutes les composantes graphiques sont affichées pour l'application
	
	public MainFrame() {
		
		
		// Titre de la fenêtre d'application et initialisation du frame
		
		super("Feu Intelligent");
		setResizable(false);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		// Initialisation du paneau du feu intelligent
		
		PaneauFeu test = new PaneauFeu();
		test.setBackground(new Color(47, 79, 79));
		test.setBounds(677, 20, 58, 89);
		
		// Initialisation du menu du moment du jour
		
		ComboBoxTrafic menuTrafic = new ComboBoxTrafic();
		menuTrafic.setBackground(new Color(47, 79, 79));
		menuTrafic.setBounds(514, 12, 133, 40);
		getContentPane().add(menuTrafic);
		
		// Initialisation du conteneur des composantes visuelles
		
		Container c = getContentPane();
		c.add(test);
		
		// JLabel ayant pour texte "Chronomètre"
		
		JLabel lblChronomtre = new JLabel("Chronom\u00E8tre");
		lblChronomtre.setForeground(Color.BLACK);
		lblChronomtre.setBounds(784, 0, 120, 52);
		getContentPane().add(lblChronomtre);
		lblChronomtre.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		
		// Initialisation du chronomètre
		
		Chrono caca = new Chrono();
		caca.setBackground(new Color(47, 79, 79));
		caca.setBounds(764, 28, 170, 81);
		getContentPane().add(caca);
		
		// Initialisation du panneau d'état des routes
		
		PaneauEtat status = new PaneauEtat();
		status.setBounds(652, 127, 270, 237);
		c.add(status);
		
		// Initialisation de la brettelle qui connecte l'autoroute au rondpoint
		
		Bretelle bretelle = new Bretelle();
		bretelle.VtrsBretelle.setText("Voitures sur la bretelle : ");
		bretelle.setBackground(Color.LIGHT_GRAY);
		bretelle.setSize(163, 40);
		bretelle.setLocation(188, 412);
		bretelle.VtrsBretelle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		bretelle.VtrsBretelle.setHorizontalAlignment(SwingConstants.CENTER);
		bretelle.VtrsBretelle.setBounds(11, 11, 140, 14);
		c.add(bretelle);
		
		// Initialisation du rondpoint
		
		Rondpoint rondpoint = new Rondpoint();
		rondpoint.VtrsRondpoint.setText("Voitures sur le rondpoint : ");
		rondpoint.VtrsRondpoint.setLocation(11, 11);
		rondpoint.setBackground(Color.LIGHT_GRAY);
		rondpoint.setBounds(188, 157, 163, 40);
		getContentPane().add(rondpoint);
		
		// Initialisation du premier tronçon
		
		Troncon1 Tr1 = new Troncon1();
		Tr1.VtrsTroncon.setText("Voitures sur le troncon1 : ");
		Tr1.setBackground(Color.LIGHT_GRAY);
		Tr1.setSize(163, 40);
		Tr1.setLocation(188, 223);
		Tr1.VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Tr1.VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		Tr1.VtrsTroncon.setBounds(11, 11, 140, 14);
		c.add(Tr1);
		
		// Initialisation du second tronçon
		
		Troncon2 Tr2 = new Troncon2();
		Tr2.VtrsTroncon.setText("Voitures sur le troncon2 : ");
		Tr2.setBackground(Color.LIGHT_GRAY);
		Tr2.setSize(163, 40);
		Tr2.setLocation(188, 284);
		Tr2.VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Tr2.VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		Tr2.VtrsTroncon.setBounds(10, 11, 140, 14);
		c.add(Tr2);
		
		// Initialisation du troisième tronçon
		
		Troncon3 Tr3 = new Troncon3();
		Tr3.VtrsTroncon.setText("Voitures sur le troncon3 : ");
		Tr3.setBackground(Color.LIGHT_GRAY);
		Tr3.setSize(163, 40);
		Tr3.setLocation(188, 348);
		Tr3.VtrsTroncon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Tr3.VtrsTroncon.setHorizontalAlignment(SwingConstants.CENTER);
		Tr3.VtrsTroncon.setBounds(10, 11, 140, 14);
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
		editorPane_1.setBounds(0, 114, 154, 557);
		getContentPane().add(editorPane_1);
		
		// Dimensions du JFrame
		
		setSize(950, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
