package org.kit.common.datav2;

import java.util.List;

/*
 * The OrderProcessStep class is a sub class of Process Step
 * is linked to a workcell resource
 * and composed of an Operation list
 */
public class OrderProcessStep {

	String id;
	String Name;
	
	String SequenceNumber;
	String PlannedProductionTime;
	String SequenceOfOperations;
	
	WorkCellResource workCellResource;
	List<Operation> BillofOperations;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
