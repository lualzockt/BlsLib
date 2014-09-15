package de.chillupx.blslib;

import de.chillupx.blslib.handlers.VertretungsplanHandler;

public class BlsLib {

	private static VertretungsplanHandler vtpHandler;
	
	public static void init() {
		vtpHandler = new VertretungsplanHandler();
	}
	
	public static void main(String[] args) {
		init();
		
		System.out.println(getVertretungsplan().getTitle());
		System.out.println("Tables: " + getVertretungsplan().getTables().size());
		System.out.println("----");
		//System.out.println("Fehlende Räume: " + getVertretungsplan().getFehlendeRaeume().getTableRow(0).getTableDatas().size());
		System.out.println("Vertretene Klassen insgesamt: " + getVertretungsplan().getVertreteneKlassen().size());
		System.out.println("Vertretene Stunden: " + (getVertretungsplan().getVertretungenAsTable().getTableRows().size() - getVertretungsplan().getVertreteneKlassen().size()));
		System.out.println("----");
		if(getVertretungsplan().getVertretungen().containsKey("EF")) {
			System.out.println("Anzahl Vertretungsstunden für EF: " + getVertretungsplan().getVertretungen().get("EF").size());
		}
		System.out.println("----");
		for(String klasse : getVertretungsplan().getVertretungen().keySet()) {
			System.out.println(klasse + " hat Vertretung.");
		}
	}
	
	public static VertretungsplanHandler getVertretungsplan() {
		return vtpHandler;
	}
}