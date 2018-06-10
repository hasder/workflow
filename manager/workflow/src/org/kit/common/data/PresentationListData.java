package org.kit.common.data;

import java.util.ArrayList;
import java.util.LinkedList;

import org.kit.common.senml.SenMLPack;
import org.kit.common.senml.SenMLRecord;

public class PresentationListData {

	LinkedList<PresentationData> dataList = new LinkedList<PresentationData>();
	
	public String toSenMLString() {

		SenMLPack senMLPack = new SenMLPack();
		ArrayList<SenMLRecord> records = new ArrayList<SenMLRecord>();
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("[");
		for (PresentationData data : dataList) {
//			strBuilder.append(data.toSenMLString());
			strBuilder.append(",");
			System.out.println(strBuilder.toString());
		}
		
		if(strBuilder.length() > 1) {
			strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
		}
		strBuilder.append("]");
		
		records.add(new SenMLRecord("data",strBuilder.toString()));
		senMLPack.addRecords(records);
		
		return senMLPack.toJSON();
	}
	
	public boolean fromSenMLPack(SenMLPack senMLPack) {
		try {
			if(senMLPack != null) {
				
			} else {
				return false;
			}
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println("ERR: Invalid PresentationData!");
			return false;
		}
		
		return true;
	}
	
	public void addToPresentatioNList(PresentationData e) {
		dataList.add(e);
	}
}
