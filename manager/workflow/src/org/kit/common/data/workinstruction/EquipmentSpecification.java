package org.kit.common.data.workinstruction;

import java.util.LinkedList;

import com.google.gson.Gson;

public class EquipmentSpecification {

	String instructionType;
	int instruction ;
	LinkedList<EquipmentParameter> parameters;
	
	
	public String toJsonString() {		
		return new Gson().toJson(this);
	}
	
	public boolean fromJsonString(String json) {
		try {
			if(json != null) {

				EquipmentSpecification temp = new Gson().fromJson(json, this.getClass());
				
				instructionType = temp.getInstructionType();
				instruction = temp.getInstruction();
				parameters = temp.getParameters();
			} else {
				return false;
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println("ERR: Invalid EquipmentSpecification!");
			return false;
		}
		
		return true;
	}
	
	

	public String getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(String instructionType) {
		this.instructionType = instructionType;
	}

	public int getInstruction() {
		return instruction;
	}

	public void setInstruction(int instruction) {
		this.instruction = instruction;
	}

	public LinkedList<EquipmentParameter> getParameters() {
		return parameters;
	}

	public void setParameters(LinkedList<EquipmentParameter> parameters) {
		this.parameters = parameters;
	}
	
}
