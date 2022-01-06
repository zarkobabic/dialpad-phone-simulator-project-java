package domaciZadatak3ZarkoBabic;

import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Broj {
	private int drzcode;
	private int pozivni;
	private int broj;
	private String pomocni = new String();
	
	
	
	
	
	
	
	
	public Broj(int drzcode, int pozivni, int broj) {
		this.drzcode = drzcode;
		this.pozivni = pozivni;
		this.broj = broj;
	}
	
	
	
	public Broj(String s) {
		String pomo = new String();
		StringCharacterIterator c = new StringCharacterIterator(s);
		for(int i = 0; i < 3; i++) {
			pomo = Character.toString(c.next());
			drzcode = drzcode * 10 + Integer.parseInt(pomo); 
		}
		for(int i = 0; i < 2; i++) {
			pomo = Character.toString(c.next());
			pozivni = pozivni * 10 + Integer.parseInt(pomo); 
		}
		while((c.getEndIndex()-1) != c.getIndex()) {
			pomo = Character.toString(c.next());
			broj = broj * 10 + Integer.parseInt(pomo);
			pomocni += pomo;
		}
	}
	
	
	
	public static boolean istaDrzava(Broj br1, Broj br2) {
		if(br1.drzcode == br2.drzcode) return true;
		else return false;
	}
	
	
	
	public static boolean istaMreza(Broj br1, Broj br2) {
		if(istaDrzava(br1,br2)) {
			if(br1.pozivni == br2.pozivni) return true;
			else return false;
		}
		else return false;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Broj other = (Broj) obj;
		if (broj != other.broj)
			return false;
		if (drzcode != other.drzcode)
			return false;
		if (pomocni == null) {
			if (other.pomocni != null)
				return false;
		} else if (!pomocni.equals(other.pomocni))
			return false;
		if (pozivni != other.pozivni)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "+" + String.format("%03d", drzcode) + " " + String.format("%02d", pozivni)  + " " + pomocni;
	}
}
