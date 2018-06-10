package org.kit.common.data.workinstruction;

import java.util.ArrayList;

import org.kit.common.data.PresentationData;
import org.kit.common.senml.SenMLPack;
import org.kit.common.senml.SenMLRecord;

import com.google.gson.Gson;

public class EquipmentParameter {
	String id;
	int value;
	int max;
	int min;
	
	public String toJsonString() {
		return new Gson().toJson(this);
	}
	
	public boolean fromJsonString(String jsonString) {
		try {
			if(jsonString != null) {

				EquipmentParameter temp = new Gson().fromJson(jsonString, this.getClass());
				
				id = temp.getId();
				value = temp.getValue();
				max = temp.getMax();
				min = temp.getMin();
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
	
	
	@SuppressWarnings("unused")
	private String toSenMLString() {
		
		SenMLPack senMLPack = new SenMLPack();
		ArrayList<SenMLRecord> records = new ArrayList<SenMLRecord>();

		records.add(new SenMLRecord("id", id));
		records.add(new SenMLRecord("value", value));
		records.add(new SenMLRecord("max", max));
		records.add(new SenMLRecord("min", min));
		
		
		senMLPack.addRecords(records);
		
		return senMLPack.toJSON();

	}
	
	@SuppressWarnings("unused")
	private boolean fromSenMLPack(SenMLPack senMLPack) {
		try {
			if(senMLPack != null) {
				id = senMLPack.getRecordByName("id").getVs();
				value = senMLPack.getRecordByName("value").getV();
				max = senMLPack.getRecordByName("max").getV();
				min = senMLPack.getRecordByName("min").getV();
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}
}
