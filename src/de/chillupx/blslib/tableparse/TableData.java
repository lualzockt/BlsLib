package de.chillupx.blslib.tableparse;

import java.util.ArrayList;
import java.util.List;

public class TableData {
	
	private final String input;
	public TableData(String input) {
		this.input = input;
	}
	
	public String getContent() {
		return input;
	}
	
	public TableData getSubData() {
		if(!hasSubData())
			return null;
		
		return new TableData(getNextData(input).get(0));
	}
	
	public boolean hasSubData() {
		System.out.println(input);
		
		if(getNextData(input).size() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * This method is used to get the next TD and its content
	 * 
	 * @param row - Input for the parser
	 * @return List<String> - Content of each TD given in row
	 */
	public static List<String> getNextData(String row) {
		List<String> datas = new ArrayList<String>();

		//IS SEARCHING FOR ENDIT </TD>?
		boolean searching = false;
		//SAVE TO STRINGBUILDER?
		boolean save = false;
		//COUNT TDs IN TD
		int cnt = 0;

		StringBuilder sb = new StringBuilder();
		String[] rows = row.split(" ");
		
		for(String splt : rows) {
			if(splt.contains("<TD>") && !searching) {
				searching = true; save = true; continue;
			}
			else if(splt.contains("<TD>") && searching) {
				cnt++;
			}
			
			if(splt.contains("</TD>") && searching) {
				if(cnt == 0) {
					datas.add(sb.toString()); sb = new StringBuilder(); searching = false; save = false; continue;
				} else {
					cnt--;
				}
			}
			
			//SAVE LINE
			if(save) 
				sb.append(splt + " ");
		}
		
		return datas;
	}
}