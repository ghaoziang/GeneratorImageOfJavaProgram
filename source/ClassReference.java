package com.source;

public class ClassReference extends ProgramCodeLine {
	String classType;
	String instanceName;
	
	public ClassReference(String[] tokens) {
		this.classType = tokens[0];
		this.instanceName = tokens[1];
	}
	
	public String toString() {
		return null;
		
	}
	
	public void toImage() {
		
	}
}
