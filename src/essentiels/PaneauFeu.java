package essentiels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets; 
import java.util.Timer; 
import java.util.TimerTask;
import essentiels.elementsRoute.Bretelle; 


// Paneau du feu intelligent

public class PaneauFeu extends JPanel {

	private static boolean etatFeu = true;
	private static int statusRoad = 0;
	private static JLabel feuRouge;
	private static Timer timerFeu = new Timer();  
	private JButton switchMode; 
	private static int nbAutoBretelle;	
	private static int currentNbAuto = 0;
	private static int timerTempsDepart = 0;

	public PaneauFeu() {
		
		setLayout(null);

		// Initialisation du paneau

		feuRouge = new JLabel(""); 

		// Changement de couleur du feu selon une valeur booléenne

		if (etatFeu) {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png")));
		} else {
			feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png")));
		}
		feuRouge.setBounds(14, 0, 30, 65); 
		add(feuRouge);

		// Bouton pour ajuster manuellement la couleur du feu

		JButton btnFeu = new JButton("Switch");
		btnFeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (switchMode.getText().equals("Manuel")) { 

					if (etatFeu) {
						etatFeu = false;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png")));
					}
	
					else {
						etatFeu = true;
						feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png")));
	
					}
				}
			}
		});
		btnFeu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFeu.setBounds(0, 68, 58, 20); 
		btnFeu.setMargin(new Insets(0, 0, 0, 0)); 
		btnFeu.setBackground(Color.GRAY); 
		add(btnFeu);
		
		 
	    // creation et ajustement du bouton pour alterner entre le mode manuel et automatique du feu 
		
		switchMode = new JButton("Intelligent"); 
		switchMode.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				if (switchMode.getText().equals("Intelligent")) { 
					timerFeu.cancel(); 
					timerFeu.purge(); 
					switchMode.setText("Manuel"); 
					btnFeu.setBackground(new JButton().getBackground()); 
				} 
				else { 
					switchMode.setText("Intelligent"); 
					btnFeu.setBackground(Color.GRAY);
					currentNbAuto = 0;
					timerTempsDepart = 0;
					resumeTimer();
				} 
			} 
		}); 
		switchMode.setFont(new Font("Tahoma", Font.PLAIN, 9)); 
		switchMode.setBounds(0, 88, 58, 20); 
		switchMode.setMargin(new Insets(0, 0, 0, 0)); 
		add(switchMode); 
		
		//commence le timer du feu vert au debut du programme 
		updateNbAutoBretelle();

	}
	 
	//commence le timer du feu vert et change le feu a rouge a la fin en plus de commencer le timer du feu rouge
	public static void startTimerFeuVert() { 
		 
		TimerTask changeFeu = new TimerTask() {  
	        public void run() {  
	                    
	        	if (Chrono.getSecondes() - timerTempsDepart >= 2 * currentNbAuto) {
	        		etatFeu = false; 
					feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feurouge.png"))); 
					timerFeu.cancel(); 
					timerFeu.purge(); 
					currentNbAuto = 0;
					timerTempsDepart = 0;
					resumeTimer();
	        	}
				
	        }  
	    }; 
	    updateNbAutoBretelle();
	    if (currentNbAuto == 0) {
	    	currentNbAuto = nbAutoBretelle;
			System.out.println("Timer du feu vert parti pour " + 2 * nbAutoBretelle + " secondes"); 
	    }
	    timerFeu = new Timer(); 
		timerFeu.schedule(changeFeu, 0, 1);
	} 
	 
	//commence le timer du feu rouge et change le feu a vert a la fin en plus de commencer le timer du feu vert
	public static void startTimerFeuRouge() { 
		 
		TimerTask changeFeu = new TimerTask() {  
	        public void run() {  
	                    
	        	if (Chrono.getSecondes() - timerTempsDepart >= 5) {
	        		etatFeu = true; 
					feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png"))); 
					timerTempsDepart = 0;
					timerFeu.cancel(); 
					timerFeu.purge(); 
					resumeTimer();
	        	}
	        	 
	        }  
	    }; 
		 
		timerFeu = new Timer(); 
		timerFeu.schedule(changeFeu, 0, 1); 
		System.out.println("Timer du feu rouge parti pour 5 secondes"); 
		 
	} 
	 
	 
	//retourne un boolean selon la couleur du feu: true veut dire que le feu est vert et false veut dire que le feu est rouge 
	public boolean getEtatFeu() { 
		return etatFeu; 
	} 
	
	//ajuste la variable nbAutoBretelle au nombre actuelle d'auto dans la bretelle avec un minimum de 5
	public static void updateNbAutoBretelle() {
		if (Bretelle.getVoituresSize() < 5) { 
			nbAutoBretelle = 5; 
		} 
		 
		else { 
			nbAutoBretelle = Bretelle.getVoituresSize(); 
		} 
	}
	
	public static void pauseTimer() {
		System.out.println("le timer du feu est mis en pause");
		timerFeu.cancel();
	}
	
	public static void resumeTimer() {
		if (timerTempsDepart == 0 & currentNbAuto == 0) timerTempsDepart = Chrono.getSecondes();
		if (etatFeu) {
			startTimerFeuVert();
		}
		else {
			startTimerFeuRouge();
		}
	}
	
	public static void resetTimer() {
		System.out.println("le timer du feu est mis a zero");
		
		timerFeu.cancel();
		timerFeu.purge();
		etatFeu = true; 
		feuRouge.setIcon(new ImageIcon(PaneauFeu.class.getResource("/essentiels/images/feuvert.png"))); 
		timerTempsDepart = 0;
		currentNbAuto = 0;
		
	}
	 
}
