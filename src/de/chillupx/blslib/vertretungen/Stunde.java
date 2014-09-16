package de.chillupx.blslib.vertretungen;

public class Stunde {

	private final String lehrer, kurs, fach, raum;
	
	public Stunde(String input) {
		String[] values = input.split(" ");
		if(values.length < 5) {
			lehrer = "none"; kurs = "none"; fach = "none"; raum = "none";
		} else {
			lehrer = values[0] + " " + values[1];
			kurs = values[2];
			fach = values[3];
			raum = values[4];
		}		
	}
	
	public Stunde(String lehrer, String kurs, String fach, String raum) {
		this.lehrer = lehrer; this.kurs = kurs; this.fach = fach; this.raum = raum;
	}
	
	public String getLehrer() {
		return lehrer;
	}
	
	public String getKurs() {
		return kurs;
	}
	
	public String getKlasse() {
		return kurs;
	}
	
	public String getFach() {
		return fach;
	}
	
	public String getRaum() {
		return raum;
	}
}
