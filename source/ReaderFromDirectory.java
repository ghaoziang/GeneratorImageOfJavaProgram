package com.source;

import java.io.File;
import java.util.ArrayList;

public class ReaderFromDirectory {
	private ArrayList<String> listfilenames;
	private String mainMethodRead;

	public ReaderFromDirectory(String path) {
		setListNames();
		readDirectory(path);
		printInfo();
	}
	
	public void readDirectory(String path) {
		File file = new File(path);
		File[] fileList = file.listFiles();
		for(int i=0;i<fileList.length;i++) {
			if( fileList[i].isDirectory()) {
				readDirectory(path + "\\" + fileList[i].getName());
			}
			else if(fileList[i].getName().contains(".java")){
				listfilenames.add(fileList[i].getName());
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
		return mainMethodRead;
	}
	
	private void setMainMethodFileName(String thefile) {
		this.mainMethodRead = thefile;
	}
}
