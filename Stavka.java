package domaciZadatak3ZarkoBabic;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Stavka extends Panel{
	protected Label naslov;
	protected Label tekst;
	
	
	
	
	
	
	
	public Stavka(String nas, String txt) {
		setLayout(new GridLayout(2,1));
		
		tekst = new Label(txt);
		naslov = new Label(nas);
		naslov.setFont(new Font("Vedrana", Font.BOLD, 15));
		
		add(naslov);
		add(tekst);
	}
	
	
	
	public void promeniNaslov(String s) {
		naslov.setText(s);
	}
	
	
	
	public Label getNaslov() {
		return naslov;
	}
	
	
	
	public Label getTekst() {
		return tekst;
	}
}