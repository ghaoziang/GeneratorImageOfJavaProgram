package com.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
				if(line.contains("	private void planRoutes")) {
					line = reader.readLine();
					break;
				}
				line = reader.readLine();
				System.out.println(line);
			}
			int count = 0;
			while(!line.equals("	}")) {
				count++;
				tokenMachine.transferLineToTokens(line);
				line = reader.readLine();
			}
			ArrayList<String[]> lineTokens = tokenMachine.getTokenArrays();
			for(int i=0;i<lineTokens.size();i++) {
				for(int j=0;j<lineTokens.get(i).length;j++) {
					System.out.print(lineTokens.get(i)[j] + " ");
				}
				System.out.println();
			}
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
