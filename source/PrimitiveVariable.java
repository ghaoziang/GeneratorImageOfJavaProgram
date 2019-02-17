package com.source;

public class PrimitiveVariable extends ProgramCodeLine {
	String varType;
	String varName;
	
	public PrimitiveVariable(String[] tokens) {
		varType = tokens[0];
		varName = tokens[1];
	}
	
	public String toString() {
		return null;
	}
	
	public void toImage() {
		
	}
}
