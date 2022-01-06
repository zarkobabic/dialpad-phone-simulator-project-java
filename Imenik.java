package domaciZadatak3ZarkoBabic;

public class Imenik extends ListaStavki{
	
	
	@Override
	public void dodajStavku(Stavka s) {
		if(s instanceof Kontakt) {
			super.dodajStavku(s);
			//revalidate();
		}
	}
	
	
	
	public String dohvatiKorisnika(String tel) throws GNePostoji {
		for(Stavka i:stavke) {
			if(tel == ((Kontakt)i).getTekst().getText()) {
				return ((Kontakt)i).getNaslov().getText();
			}
		}
		throw new GNePostoji();
	}
	
	
	
	public String dohvatiTelefon(String korisnik) throws GNePostoji {
		for(Stavka i:stavke) {
			if(korisnik == ((Kontakt)i).getNaslov().getText()) {
				return ((Kontakt)i).getTekst().getText();
			}
		}
		throw new GNePostoji();
	}
}
