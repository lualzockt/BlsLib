package de.chillupx.blslib.tableparse;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private final String input;
	public Table(String input) {
		this.input = input;
	}
	
	public List<TableRow> getTableRows() {
		List<TableRow> tr = new ArrayList<TableRow>();
		
		for(String str : getRawTableRows()){ tr.add(new TableRow(str)); }
		return tr;
	}
	
	public TableRow getTableRow(int index) {
		return getTableRows().get(index);
	}
	
	public int getSize() {
		return getRawTableRows().size();
	}
	
	private List<String> getRawTableRows() {
		List<String> rows = new ArrayList<String>();
		
		String[] split = input.split("<TR>");
		for(String row : split) {
			if(row.contains("<TD>"))
				rows.add(row.replaceAll("</TR>", "").replaceFirst(" ", ""));
		}
		
		return rows;
	}
}