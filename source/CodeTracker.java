package com.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.UI.ShapeFactory;

public class CodeTracker {

	private ArrayList<String> listJAVACode;
	private String main;
	
	public CodeTracker(ArrayList<String> list, String mainPath) {
		this.listJAVACode = list;
		this.main = mainPath;
		startTrack();
	}
	
	public void startTrack() {
		File file = new File(main);
		CodeTokens tokenMachine = new CodeTokens();
		JavaLineFactory codeFactory = new JavaLineFactory(tokenMachine);
		try {
			FileInputStream input = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = reader.readLine();
			while(line!=null) {
				if(line.contains("	public static void main")) {
					line = reader.readLine();
					break;
				}
				line = reader.readLine();
			}
			int count = 0;
			while(!line.equals("	}")) {
				count++;
				tokenMachine.transferLineToTokens(line);
				line = reader.readLine();
			}
			ArrayList<String[]> lineTokens = tokenMachine.getTokenArrays();
			ArrayList<ProgramCodeLine> typeList = new ArrayList<ProgramCodeLine>();
			for(int i=0;i<lineTokens.size();i++) {
				typeList.add(codeFactory.match(lineTokens.get(i)));
			}
			ShapeFactory sF = new ShapeFactory(typeList);
			for(int i=0;i<typeList.size();i++) {
				sF.produceShape();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
