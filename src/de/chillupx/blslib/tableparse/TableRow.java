package de.chillupx.blslib.tableparse;

import java.util.ArrayList;
import java.util.List;


public class TableRow {

	private final String line;
	public TableRow(String input) {
		this.line = input;
	}
	
	public List<TableData> getTableDatas() {
		List<TableData> td = new ArrayList<TableData>();
		for(String data : TableData.getNextData(line)) { td.add(new TableData(data)); }
		
		return td;
	}	
	
	public TableData getTableData(int index) {
		return getTableDatas().get(index);
	}
}