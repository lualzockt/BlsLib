package de.chillupx.blslib;

import de.chillupx.blslib.handlers.Tag;
import de.chillupx.blslib.handlers.VertretungsplanHandler;

public class BlsLib {
	
	public VertretungsplanHandler getVertretungsplan() {
		return new VertretungsplanHandler();
	}
	
	public VertretungsplanHandler getVertretungsplan(Tag tag) {
		return new VertretungsplanHandler(tag);
	}
}