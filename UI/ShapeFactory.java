package com.UI;

import java.util.ArrayList;

import com.source.ProgramCodeLine;

public class ShapeFactory {
	private ArrayList<ProgramCodeLine> shapeFrom;
	
	public ShapeFactory(ArrayList<ProgramCodeLine> shapeFrom) {
		this.shapeFrom = shapeFrom;
	}
	
	public void produceShape() {
		if(shapeFrom.size()==0) {
			return;
		}
		ProgramCodeLine tmpLine = shapeFrom.get(0);
		tmpLine.toImage();
		shapeFrom.remove(0);
	}
}
