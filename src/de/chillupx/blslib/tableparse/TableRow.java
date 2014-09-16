package de.chillupx.blslib.tableparse;

import java.util.ArrayList;
import java.util.List;


public class TableRow {

	private final String line;
	public TableRow(String input) {
		this.line = input;
	}
	
	/**
	 * This method returns all TDs in a TR
	 * 
	 * @return List<TableData> - List of containing TDs
	 */
	public List<TableData> getTableDatas() {
		List<TableData> td = new ArrayList<TableData>();
		for(String data : TableData.getNextData(line)) { td.add(new TableData(data)); }
		
		return td;
	}	
	
	/**
	 * This method returns a TD with the given index
	 * 
	 * @param index - Which TD
	 * @return TableData - TD with given index
	 */
	public TableData getTableData(int index) {
		return getTableDatas().get(index);
	}
}