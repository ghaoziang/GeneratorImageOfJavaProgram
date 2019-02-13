package com.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class ReaderFromDirectory {
	private ArrayList<String> listfilenames;

	public ReaderFromDirectory(String path) {
		setListNames();
		readDirectory(path);
		System.out.println(getMainMethodFileName());
		CodeTracker cT = new CodeTracker(listfilenames, getMainMethodFileName());
	}
	
	public void readDirectory(String path) {
		File file = new File(path);
		File[] fileList = file.listFiles();
		for(int i=0;i<fileList.length;i++) {
			if( fileList[i].isDirectory()) {
				readDirectory(path + "\\" + fileList[i].getName());
			}
			else if(fileList[i].getName().contains(".java")){
				listfilenames.add(fileList[i].getPath());
			}
		}
	}
	
	private void printInfo() {
		System.out.println(listfilenames.size());
		for(int i=0;i<listfilenames.size();i++) {
			System.out.println(listfilenames.get(i));
		}
	}
	
	public ArrayList<String> getListNames(){
		return listfilenames;
	}
	
	private void setListNames() {
		listfilenames = new ArrayList<String>();
	}
	
	public String getMainMethodFileName() {
		File file;
		for(int i=0;i<listfilenames.size();i++){
			file = new File(listfilenames.get(i));
			try {
				FileInputStream input = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				String line = reader.readLine();
				while(line!=null) {
					if(line.contains("public static void main")) {
						return listfilenames.get(i);
					}
					line = reader.readLine();
				}
				input.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
