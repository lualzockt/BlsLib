package de.chillupx.blslib.vertretungen;

public class Raum {
	
	private final String raum;
	public Raum(String raum) {
		this.raum = raum;
	}
	
	public String getName() {
		return this.raum;
	}
	
	public boolean isKursRaum() {
		if(raum.contains("KR"))
			return false;
		else
			return true;
	}
}