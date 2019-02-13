package com.source;

import java.util.ArrayList;

public class CodeTokens {
	public ArrayList<String[]> tokenArrays = new ArrayList<String[]>();
	
	
	public void transferLineToTokens(String line) {
		String[] tokens = line.split("\\s+");
		if(tokens.length==0) {
			return;
		}
		String lastToken = tokens[tokens.length-1];
		char last = lastToken.charAt(lastToken.length()-1);
		if(last==';') {
			String newLast = lastToken.substring(0, lastToken.length()-1);
			tokens[tokens.length-1] = newLast;
			addTokens(tokens);
		}
		else if(last=='{') {
			String newLast = lastToken.substring(0, lastToken.length()-1);
			tokens[tokens.length-1] = newLast;
			addTokens(tokens);
			String[] bracketToken = new String[1];
			bracketToken[0] = "{";
			addTokens(bracketToken);
		}
		else if(last=='}') {
			String[] bracketToken = new String[1];
			bracketToken[0] = "}";
			addTokens(bracketToken);
		}
		
	}
	
	public void addTokens(String[] tokens) {
		this.tokenArrays.add(tokens);
	}
	
	public ArrayList<String[]> getTokenArrays(){
		return tokenArrays;
	}
}
