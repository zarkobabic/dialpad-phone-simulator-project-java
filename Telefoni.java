package domaciZadatak3ZarkoBabic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Telefoni extends Frame{
	
	
	
	public Telefoni(Broj prviTel, Broj drugiTel, Color boja1, Color boja2) {
		setBounds(400,400,1600,800);
		setVisible(true);
		setResizable(true);
		setTitle("Telefoni");
		populateWindow(prviTel, drugiTel, Color.GREEN, Color.YELLOW);
		pack();
	}
	
	
	private void populateWindow(Broj prviTel, Broj drugiTel,  Color boja1, Color boja2) {
		Telefon tel1 = new Telefon(prviTel, boja1);
		Telefon tel2 = new Telefon(drugiTel, boja2);
		Panel drzac = new Panel(new GridLayout(1,0));
		add(drzac, BorderLayout.CENTER);
		drzac.add(tel1);
		drzac.add(tel2);
		
																										//WINDOW CLOSING LISTENER
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(tel1.getTastatura().getNit() != null) {
					tel1.getTastatura().getNit().interrupt();
				}
				if(tel2.getTastatura().getNit() != null) {
					tel2.getTastatura().getNit().interrupt();
				}
				dispose();
			}
		});
	}
	
	

	public static void main(String[] args) {
		Broj prvi = new Broj("+8125462");
		Broj drugi = new Broj("+6725149");
		new Telefoni(prvi, drugi, Color.GREEN, Color.YELLOW);
	}
}
