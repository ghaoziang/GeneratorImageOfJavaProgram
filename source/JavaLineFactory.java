package com.source;

import java.util.ArrayList;

public class JavaLineFactory {
	ArrayList<String[]> tokensList;
	
	public JavaLineFactory(CodeTokens tokens) {
		tokensList = tokens.getTokenArrays();
	}
	
	public ProgramCodeLine match(String[] tokens) {
		for(int i=0;i<tokensList.size();i++) {
			int form = codeForm(tokens);
			switch(form) {
			case 1:
				return new PrimitiveVariable(tokens);
			case 2:
				return new ClassReference(tokens);
			case 3:
				return new ValueAssign(tokens);
			case 4:
				return new MethodExecute(tokens);
			case 5:
				return new ConditionGenerator(tokens);
			case 6:
				return new LoopGenerator(tokens);
			case 7:
				return null;
			}
		}
		return null;
	}
	
	private int codeForm(String[] tokens) {
		if(     (tokens[0] == "int")     && 
				(tokens[0] == "float")   && 
				(tokens[0] == "double")  && 
				(tokens[0] == "boolean") && 
				(tokens[0] == "long")    && 
				(tokens[0] == "short")   && 
				(tokens[0] == "byte")    && 
				(tokens[0] == "char")) 
		{
			return 1;
		}
		else if( tokens[0].substring(0, 1).toCharArray()[0]>='A' && tokens[0].substring(0, 1).toCharArray()[0]<='Z') 
		{
			return 2;
		}
		else if( checkEqualSimbol(tokens) ) {
			return 3;
		}
		else if( checkDotSimbol(tokens) ) {
			return 4;
		}
		else if( tokens[0].contains("if")) {
			return 5;
		}
		else if( (tokens[0].contains("for")) && (tokens[0].contains("while")) ) {
			return 6;
		}
		return 7;
	}
	
	private boolean checkEqualSimbol(String[] tokens) {
		for(String str : tokens) {
			if(str == "=") {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDotSimbol( String[] tokens) {
		for(String str : tokens) {
			if(str.contains(".")) {
				return true;
			}
		}
		return false;
	}
}
