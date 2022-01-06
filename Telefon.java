package domaciZadatak3ZarkoBabic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Telefon extends Panel{
	private Broj brTel;
	private Color boja;
	private Imenik imenik;
	private Tastatura tastatura;
	private String pomocniBr;
	private int stanje = 1; //ukljucen 1 iskljucen 0

	
	
	
	
	
	public Telefon(Broj brTe, Color boja) {
		this.brTel = brTe;
		this.boja = boja;
		Label labelaTastatura = new Label();
		
		
		tastatura = new Tastatura(labelaTastatura);
		imenik = new Imenik();
		
		setLayout(new GridLayout(2,1,0,0));
		setBackground(boja);
		
		
		
																										//LISTENER ZA DODAVANJE KONTAKTA
		Button dodajK = new Button("Dodaj kontakt");
		dodajK.addActionListener(e->{
			if(tastatura.getRezim() == tastatura.BROJEVI) {
				this.pomocniBr = labelaTastatura.getText();
				labelaTastatura.setText("");
			}
			else {
				imenik.dodajStavku(new Kontakt(labelaTastatura.getText(), pomocniBr));
				labelaTastatura.setText("");
				revalidate();
			}
			tastatura.promeniRezimRada();
		});
		
		
		
		
																										//LISTENER ZA ISKLJUCIVANJE TELEFONA
		Button iskljuciTel = new Button("Iskljuci telefon");
		iskljuciTel.addActionListener(e->{
			if(stanje == 1) {
				iskljuciTel.setBackground(Color.red);
				iskljuciTel.setLabel("Ukljuci telefon");
				stanje = 0;
			}
			else {
				iskljuciTel.setBackground(Color.LIGHT_GRAY);
				iskljuciTel.setLabel("Iskljuci telefon");
				stanje = 1;
			}
		});
		
		
		
		iskljuciTel.setBackground(Color.LIGHT_GRAY);
		Label labelaBr = new Label(brTel.toString()); 
		labelaBr.setAlignment(WIDTH);
		labelaBr.setFont(new Font("Lucida", Font.BOLD ,15));
		
		
		Panel labelaidugmici = new Panel(new GridLayout(2,1,0,0));
		
		Panel imenikidugmici = new Panel(new BorderLayout());
		Panel dugmici = new Panel(new GridLayout(1,2));
		dugmici.add(dodajK);
		dugmici.add(iskljuciTel);
		dugmici.setPreferredSize(new Dimension(240, 25));
		
		imenikidugmici.add(imenik, BorderLayout.NORTH);
		
		labelaidugmici.add(dugmici);
		labelaidugmici.add(labelaBr);
		
		imenikidugmici.add(labelaidugmici, BorderLayout.SOUTH);
		
		add(tastatura);
		add(imenikidugmici);
	}
	
	
	
	public Tastatura getTastatura() {
		return tastatura;
	}



	public Broj dohvatiBrTel() {
		return brTel;
	}
}
