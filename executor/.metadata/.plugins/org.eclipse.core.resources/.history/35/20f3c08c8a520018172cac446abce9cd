package org.hasder.workflowexecutor;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SenMLPack {
	
	private List<SenMLRecord> records;
	
	public SenMLPack() {
		records = new ArrayList<SenMLRecord>();
	}
	
	public SenMLPack(ArrayList<SenMLRecord> records) {
		this.records = records;
	}
	
	public SenMLRecord getRecordByName(String name) {
		for(SenMLRecord record : this.records) {
			if(record.getN().equals(name)) {
				return record;
			}
		}
		
		return null;
	}

	public List<SenMLRecord> getRecords() {
		return records;
	}

	public void setRecords(List<SenMLRecord> records) {
		this.records = records;
	}
	
	public void addRecords(List<SenMLRecord> records) {
		this.records.addAll(records);
	}

	public void removeRecords(List<SenMLRecord> records) {
		this.records.removeAll(records);
	}
	public void addRecord(SenMLRecord record) {
		records.add(record);
	}
	
	public void removeRecord(SenMLRecord record) {
		records.remove(record);
	}

	public String toJSON() {
		return new Gson().toJson(this.records);
	}
	
	public static SenMLPack fromJSON(String json) {
		SenMLPack senMLPack = null;
		boolean valid = true;
		
		try {
			senMLPack = new SenMLPack(new Gson().fromJson(json, new TypeToken<List<SenMLRecord>>(){}.getType()));
		} catch(Exception e) {
			// e.printStackTrace();
			System.err.println("ERR: Unable to deserialze SenML!");
			return null;
		}
		
		for(SenMLRecord record : senMLPack.getRecords()) {
			if(record.getN() == null
					|| (record.getV() == null && record.getVs() == null && record.getVb() == null)) {
				valid = false;
			}
		}
		if(valid) {
			return senMLPack;
		} else {
			return null;
		}
	}

}