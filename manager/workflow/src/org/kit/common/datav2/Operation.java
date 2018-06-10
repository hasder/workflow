package org.kit.common.datav2;


/*
 * The Operation class is a subclass of the Operation class
 * and contains parameters, product requirements, time study,
 * quality requirements, equipment requirement, instruction image, instruction text
 * and production Operation Step
 */
public class Operation {

	String id;
	String description;
	String operationType;
	
	String sequenceNumber;
	String sequenceOfOperationSteps;
	String sequenceOfInstructionText;
	
	Parameters parameters;
	//ProductRequirements productRequirements;
	//TimeStudy timeStudy;
	//QualityRequirements qualityRequirements;
	EquipmentRequirment equipmentRequirement;
	//InstructionImage instructionImage;
	InstructionText instructionText;
	ProductionOperationStep productionOperationStep;	
}
