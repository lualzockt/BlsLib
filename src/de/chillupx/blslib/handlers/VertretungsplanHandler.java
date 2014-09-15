package de.chillupx.blslib.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.chillupx.blslib.tableparse.Table;
import de.chillupx.blslib.tableparse.TableRow;
import de.chillupx.blslib.vertretungen.Klasse;
import de.chillupx.blslib.vertretungen.Vertretung;

public class VertretungsplanHandler {
	
	private Tag tag;
	
	public VertretungsplanHandler() {
		this.tag = Tag.HEUTE;
	}
	
	public VertretungsplanHandler(Tag tag) {
		this.tag = tag;
	}
	
	
	private List<String> getRawLines() {
		try {
			URL url = new URL(tag.getURL());
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			//StringBuilder lines = new StringBuilder();
			List<String> ls = new ArrayList<String>();
			
			String buffer;
			while((buffer = br.readLine()) != null) {
				
				
				//lines.append(buffer + " ");
				ls.add(buffer.replaceAll("<TD COLSPAN=5 BGCOLOR=\"#E2E2E2\">", "<TD>"));
			}
			
			//return lines.toString();
			return ls;
		} 
		catch (MalformedURLException e) { e.printStackTrace(); } 
		catch (IOException e) { e.printStackTrace(); }	
		
		return null;
	}
	
	public String getTitleLine() {
		for(String line : getRawLines()) {
			if(line.contains("<CENTER>Vertretungsplan")) return line.split("<CENTER>")[1].replaceAll("</CENTER></H3></FONT>", "").replaceAll("&uuml;", "ü");
		}
		
		return "none";
	}
	
	public List<Table> getTables() {
		List<Table> tables = new ArrayList<Table>();
		
		boolean searching = false;
		boolean save = false;
		StringBuilder sb = new StringBuilder();
		
		for(String line : getRawLines()) {			
			if(!searching && line.contains("TABLE") && !line.contains("/")) {
				searching = true; save = true; continue;
			}
			
			if(line.contains("</TABLE>") && searching) {
				tables.add(new Table(sb.toString())); sb = new StringBuilder(); searching = false; save = false; continue;
			}
			
			if(save) {
				sb.append(line.replaceAll("><", "> <") + " ");
			}
		}
		
		return tables;
	}
	
	public List<String> getVertreteneKlassen() {
		List<String> klassen = new ArrayList<String>();
		for(TableRow row : getVertretungenAsTable().getTableRows()) {
			if(row.getTableDatas().size() == 1) klassen.add(row.getTableData(0).getContent().replaceAll("<CENTER> <B> <FONT FACE=\"Arial\" SIZE=\"0\">", "").replaceAll("</FONT> </B> </CENTER>", "").replaceAll(" ", ""));
		}		
		
		return klassen;
	}
	
	public Map<String, List<Vertretung>> getVertretungen() {
		Map<String, List<Vertretung>> verts = new HashMap<String, List<Vertretung>>();
		
		Klasse lastKlasse = null;
		for(TableRow row : getVertretungenAsTable().getTableRows()) {
			if(row.getTableDatas().size() == 1) {
				lastKlasse = new Klasse(row.getTableData(0).getContent().replaceAll("<CENTER> <B> <FONT FACE=\"Arial\" SIZE=\"0\">", "").replaceAll("</FONT> </B> </CENTER>", "").replaceAll(" ", ""));
			}
			else {
				Vertretung newVert = new Vertretung(lastKlasse, row.getTableData(0).getContent(), row.getTableData(1).getContent(), row.getTableData(3).getContent(), row.getTableData(4).getContent());
				
				if(verts.containsKey(lastKlasse.getName())) {
					List<Vertretung> currVerts = verts.get(lastKlasse.getName());
					currVerts.add(newVert);
					
					verts.remove(lastKlasse.getName());
					verts.put(lastKlasse.getName(), currVerts);
				}
				else {
					List<Vertretung> currVerts = new ArrayList<Vertretung>();
					currVerts.add(newVert);
					
					verts.put(lastKlasse.getName(), currVerts);
				}
			}
		}
		
		return verts;
	}
	
	public Table getVertretungenAsTable() {
		if(getTables().size() == 2) {
			return getTables().get(1);
		}
		else if(getTables().size() == 1) {
			return getTables().get(0);
		}
		else {
			return null;
		}
	}
	
	public Table getFehlendeRaeume() {
		if(getTables().size() > 1) {
			return getTables().get(0);
		}
		
		return null;
	}
}