package org.kit.workflow;

import java.util.LinkedList;

import org.kit.common.data.workinstruction.EquipmentParameter;
import org.kit.common.data.workinstruction.EquipmentSpecification;
import org.kit.common.data.workinstruction.WorkInstruction;

public class TestData {

	public static LinkedList<WorkInstruction> getStaticWorkOrderData() {
		LinkedList<WorkInstruction> workInstructions = new LinkedList<WorkInstruction>();
		WorkInstruction work = new WorkInstruction();
		EquipmentSpecification specification = new EquipmentSpecification();
		LinkedList<EquipmentParameter> parameters = new LinkedList<EquipmentParameter>();
		EquipmentParameter parameter = new EquipmentParameter();
		
		specification.setInstruction(44);
		specification.setInstructionType("nutrunner");
		
		parameter.setId("torque");
		parameter.setMax(5);
		parameter.setMin(3);
		parameter.setValue(4);
		parameters.add(parameter);
		
		parameter.setId("angle");
		parameter.setMax(75);
		parameter.setMin(45);
		parameter.setValue(65);
		parameters.add(parameter);
		
		specification.setParameters(parameters);
		
		work.setId("nutrunner");
		work.setQuantity(5);
		work.setDescription("nutrunner");
		work.setType(44);			
		work.setSpecification(specification);
		
		workInstructions.add(work);
		
		work = new WorkInstruction();
		
		work.setId("quality");
		work.setQuantity(5);
		work.setDescription("Material Quality check");
		work.setType(50);			
		work.setSpecification(null);
		
		workInstructions.add(work);
		
		work = new WorkInstruction();
		
		work.setId("completed");
		work.setQuantity(5);
		work.setDescription("Work complete");
		work.setType(40);			
		work.setSpecification(null);
		
		workInstructions.add(work);
		
		return workInstructions;
	}
}
