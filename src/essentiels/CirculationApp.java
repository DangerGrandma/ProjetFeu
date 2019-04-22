package essentiels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import essentiels.elementsRoute.Rondpoint;
import essentiels.elementsRoute.Route;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.Timer;
import java.awt.Color;

// L'application en tant que telle pour la simulation

public class CirculationApp {
		
	public static void main(String[] args) {
 /*
		
	Rondpoint.genVoitures();
	
	
	for(int i = 0; i < Rondpoint.getVoituresSize(); i++) {
		System.out.println(""+Rondpoint.VtrRondpoint.get(i));
	};
	System.out.println("avant");
	for(int i = 0; i < Rondpoint.getVoituresSize(); i++) {
			System.out.println(i);	
	};
	
	for(int i = 0; i < Rondpoint.getVoituresSize(); i++) {
		Rondpoint.checkDest();	

	};
	System.out.println("apres");
	for(int i = 0; i < Rondpoint.getVoituresSize(); i++) {
		System.out.println(i);	
};
	System.out.println("temps = " + Chrono.getTimestamp());	
		*/	
	

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {			
				new MainFrame();
			}
		});

	}
}
