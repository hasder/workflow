package org.kit.common.data;

import java.util.ArrayList;
import java.util.List;

import org.kit.common.data.workinstruction.EquipmentParameter;
import org.kit.common.senml.SenMLPack;
import org.kit.common.senml.SenMLRecord;

public class ParameterGroup {
	String id;
	List<EquipmentParameter> parameters;
	
	
	public String toSenMLString() {

		SenMLPack senMLPack = new SenMLPack();
		ArrayList<SenMLRecord> records = new ArrayList<SenMLRecord>();
		
		records.add(new SenMLRecord("id", id));
		
//		for(Parameter param : parameters) {
//			records.add(new SenMLRecord(fromJSON(param.toSenMLString())));
//		}
		
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
			System.err.println("ERR: Invalid Parameter!");
			return false;
		}
		
		return true;
	}
}
