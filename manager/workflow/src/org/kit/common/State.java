package org.kit.common;

public abstract class State {

	public State() {
		
	}
	
	public abstract String action(Object arg);
	
	//public abstract void exitGuards () ;
}
