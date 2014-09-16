package de.chillupx.blslib.vertretungen;


public class Vertretung {
	
	private final Klasse klasse;
	private final String stunde;
	private final String zuVertreten;
	private final String vertretung;
	private final String status;
	
	public Vertretung(Klasse klasse, String stunde, String zuVertreten, String vertretung, String status) {
		this.klasse = klasse; this.stunde = stunde; this.zuVertreten = zuVertreten; this.vertretung = vertretung; this.status = status;
	}
	
	public Klasse getKlasse() {
		return this.klasse;
	}
	
	public String getStunde() {
		return this.stunde;
	}
	
	public String getZuVertreteneStundeAsString() {
		return this.zuVertreten;
	}
	
	/**
	 * This method returns the stunde which is ausgefallen/which fällt aus
	 * 
	 * @return Stunde - Stunde which is replaced with another.
	 */
	public Stunde getZuVertreteneStunde() {
		return new Stunde(this.zuVertreten);
	}
	
	public String getVertretungsStundeAsString() {
		return this.vertretung;
	}
	
	/**
	 * This method returns the stunde which replaces the other one.
	 * 
	 * @return Stunde - Stunde which replaces the other one.
	 */
	public Stunde getVertretungsStunde() {
		return new Stunde(this.vertretung);
	}
	
	public String getKommentar() {
		return this.status;
	}
}