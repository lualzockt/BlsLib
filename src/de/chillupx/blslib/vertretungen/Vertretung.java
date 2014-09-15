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
	
	public String getVertreteneStunde() {
		return this.zuVertreten;
	}
	
	public String getVertretungsStunde() {
		return this.vertretung;
	}
	
	public String getKommentar() {
		return this.status;
	}
}