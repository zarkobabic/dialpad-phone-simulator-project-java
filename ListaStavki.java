package domaciZadatak3ZarkoBabic;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

public class ListaStavki extends Panel{
	protected ArrayList<Stavka> stavke = new ArrayList();
	
	
	
	
	
	
	public ListaStavki() {
		setLayout(new GridLayout(0,1));
	}
	
	
	
	public void dodajStavku(Stavka s) {
		stavke.add(s);
		this.add(s);
	}
}
