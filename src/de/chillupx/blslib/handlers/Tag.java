package de.chillupx.blslib.handlers;

public enum Tag {

	HEUTE("http://www.bls-eschweiler.de/stupas/vp-heute.html"),
	MORGEN("http://www.bls-eschweiler.de/stupas/vp-morgen.html");
	
	final String url;
	Tag(String url) {
		this.url = url;
	}
	
	public String getURL() {
		return this.url;
	}
}