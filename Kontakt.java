package domaciZadatak3ZarkoBabic;

public class Kontakt extends Stavka{

	public Kontakt(String korisnik, String broj) {
		super(korisnik, (new Broj(broj)).toString());
	}
}
