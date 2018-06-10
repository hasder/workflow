package org.kit.common.data.workinstruction;

import java.util.ArrayList;

import org.kit.common.senml.SenMLPack;
import org.kit.common.senml.SenMLRecord;

import com.google.gson.Gson;

public class WorkInstruction {

	String id;
	int type;
	int quantity;
	String description;
	EquipmentSpecification specification;


	public String toJsonString() {
		return new Gson().toJson(this);
	}
	
	public boolean fromJsonString(String json) {
		
		if(json != null) {
			WorkInstruction temp = new Gson().fromJson(json, WorkInstruction.class);
			this.id = temp.getId();
			this.type = temp.getType();
			this.quantity = temp.getQuantity();
			this.description = temp.getDescription();
			this.specification = temp.getSpecification();
		}
		
		return true;
	}
	
	
	
	@SuppressWarnings("unused")
	private String toSenMLString() {
		
		SenMLPack senMLPack = new SenMLPack();
		ArrayList<SenMLRecord> records = new ArrayList<SenMLRecord>();

		records.add(new SenMLRecord("id", id));
		records.add(new SenMLRecord("type", type));
		
		//records.add(new SenMLRecord("specification", specification));
		records.add(new SenMLRecord("quantity", quantity));
		
		senMLPack.addRecords(records);
		
		return senMLPack.toJSON();

	}
	
	@SuppressWarnings("unused")
	private boolean fromSenMLPack(String senMLString) {
		return fromSenMLPack(SenMLPack.fromJSON(senMLString));
	}

	private boolean fromSenMLPack(SenMLPack senMLPack) {
		try {
			if(senMLPack != null) {
				id = senMLPack.getRecordByName("id").getVs();
				type = senMLPack.getRecordByName("type").getV();
				//specification = senMLPack.getRecordByName("specification").getVs();
				quantity = senMLPack.getRecordByName("quantity").getV();
			} else {
				return false;
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println("ERR: Invalid WorkInstruction!");
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public EquipmentSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(EquipmentSpecification specification) {
		this.specification = specification;
	}
}
