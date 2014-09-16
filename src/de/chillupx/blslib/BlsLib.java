package de.chillupx.blslib;

import de.chillupx.blslib.handlers.Tag;
import de.chillupx.blslib.handlers.VertretungsplanHandler;

public class BlsLib {
	
	/** 
	 * This method is used to get the VertretungsplanHandler for de.chillupx.blslib.handlers.Tag.HEUTE
	 * 
	 * @return VertretungsplanHandler - Handler for all Vertretungsplan-Actions
	 */
	public VertretungsplanHandler getVertretungsplan() {
		return new VertretungsplanHandler();
	}
	
	/**
	 * This method is used to get the VertretungsplanHandler for the given de.chillupx.blslib.handlers.Tag
	 * 
	 * @param tag - VertretungsplanHandler for this day
	 * @return VertretungsplanHandler - Handler for all Vertretungsplan-Actions
	 */
	public VertretungsplanHandler getVertretungsplan(Tag tag) {
		return new VertretungsplanHandler(tag);
	}
}