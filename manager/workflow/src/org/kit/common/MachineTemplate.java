package org.kit.common;

import java.util.HashMap;
import java.util.Map;

public abstract class MachineTemplate implements Runnable{

	protected Map<String, State> states;
	protected String currentState;
	
	public MachineTemplate(String initState) {
		states = new HashMap<String, State> ();
		
		setInitState(initState);
	}
	
	public void begin () {
		//doState();
	}
	
	public void setInitState(String initState) {
		currentState = initState;
	}
	
	public void addState(String stateName, State newState, String transitionConditions) {
		states.put(stateName, newState);
	}
	
	public State getState(String stateName) {
		return states.get(stateName);
	}
	
	//public abstract void checkAction() ;
	
	public abstract void perform();
	
}
