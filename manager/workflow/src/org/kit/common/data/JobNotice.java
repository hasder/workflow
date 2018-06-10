package org.kit.common.data;

import java.util.ArrayList;

import org.kit.common.senml.SenMLPack;
import org.kit.common.senml.SenMLRecord;

public class JobNotice {

	String name = "uri:example";
	int batchSize = 5;
	int batchCounter = 0;
	int torque = 85;
	int torqueFinalTarget = 85;
	int torqueMax = 360;
	int torqueMin = 360;
	int angle = 5;
	int angleFinalTarget = 360;
	int angleMax = 85;
	int angleMin = 85;
	
	public JobNotice() { }
	public JobNotice(JobData job) {

		this.setName(job.getName());
		this.setBatchSize(job.getBatchSize());
		
		this.setAngleFinalTarget(job.getAngleFinalTarget());
		this.setAngleMax(job.getAngleMax());
		this.setAngleMin(job.getAngleMin());
		
		this.setTorqueFinalTarget(job.getTorqueFinalTarget());
		this.setTorqueMax(job.getTorqueMax());
		this.setTorqueMin(job.getTorqueMin());
	}
	
	
	public String toSenMLString() {
		
		SenMLPack senMLPack = new SenMLPack();
		ArrayList<SenMLRecord> records = new ArrayList<SenMLRecord>();

		records.add(new SenMLRecord("name", name));
		records.add(new SenMLRecord("batchSize", batchSize));
		records.add(new SenMLRecord("batchCounter", batchCounter));

		records.add(new SenMLRecord("torque", torque, "Nm"));
		records.add(new SenMLRecord("torqueMax", torqueMax, "Nm"));
		records.add(new SenMLRecord("torqueMin", torqueMin, "Nm"));
		records.add(new SenMLRecord("torqueFinalTarget", torqueFinalTarget, "Nm"));

		records.add(new SenMLRecord("angle", angle, "rad"));
		records.add(new SenMLRecord("angleMax", angleMax, "rad"));
		records.add(new SenMLRecord("angleMin", angleMin, "rad"));
		records.add(new SenMLRecord("angleFinalTarget", angleFinalTarget, "rad"));
		
		senMLPack.addRecords(records);
		
		return senMLPack.toJSON();

	}
	
	public boolean fromSenMLPack(String senMLString) {
		return fromSenMLPack(SenMLPack.fromJSON(senMLString));
	}
	
	
	public boolean fromSenMLPack(SenMLPack senMLPack) {
		try {
			if(senMLPack != null) {
				name = senMLPack.getRecordByName("name").getVs();
				batchSize = senMLPack.getRecordByName("batchSize").getV();
				batchCounter = senMLPack.getRecordByName("batchCounter").getV();
				torque = senMLPack.getRecordByName("torque").getV();
				torqueFinalTarget = senMLPack.getRecordByName("torqueFinalTarget").getV();
				torqueMax = senMLPack.getRecordByName("torqueMax").getV();
				torqueMin = senMLPack.getRecordByName("torqueMin").getV();
				angle = senMLPack.getRecordByName("angle").getV();
				angleFinalTarget = senMLPack.getRecordByName("angleFinalTarget").getV();
				angleMax = senMLPack.getRecordByName("angleMax").getV();
				angleMin = senMLPack.getRecordByName("angleMin").getV();
			} else {
				return false;
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println("ERR: Invalid JobData!");
			return false;
		}
		
		return true;
	}

	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public int getAngleFinalTarget() {
		return angleFinalTarget;
	}
	public void setAngleFinalTarget(int angleFinalTarget) {
		this.angleFinalTarget = angleFinalTarget;
	}
	public int getTorqueFinalTarget() {
		return torqueFinalTarget;
	}
	public void setTorqueFinalTarget(int torqueFinalTarget) {
		this.torqueFinalTarget = torqueFinalTarget;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public int getTorqueMax() {
		return torqueMax;
	}

	public void setTorqueMax(int torqueMax) {
		this.torqueMax = torqueMax;
	}

	public int getTorqueMin() {
		return torqueMin;
	}

	public void setTorqueMin(int torqueMin) {
		this.torqueMin = torqueMin;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getAngleMax() {
		return angleMax;
	}

	public void setAngleMax(int angleMax) {
		this.angleMax = angleMax;
	}

	public int getAngleMin() {
		return angleMin;
	}

	public void setAngleMin(int angleMin) {
		this.angleMin = angleMin;
	}

	public int getBatchCounter() {
		return batchCounter;
	}

	public void setBatchCounter(int batchCounter) {
		this.batchCounter = batchCounter;
	}
	public void incrementBatchCounter(int amount) {
		this.batchCounter = batchCounter + amount;
	}
	
}
