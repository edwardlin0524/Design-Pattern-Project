package controller;

import java.awt.Shape;

import model.ShapeList;

public class CopyShapeCommand implements ICommand {
	private final ShapeList selectlist;
	CopyShapeCommand(ShapeList selectedList){
		selectlist = selectedList;
		if(!selectlist.getSelectedShapesList().isEmpty()) {
			System.out.print("I do have something: "+selectedList.getSelectedShapesList()+"\n");
		}
		else {System.out.print("I got nothing \n");}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(IShape shape:selectlist.getSelectedShapesList()) {
			selectlist.addClipboard(shape);
			
		}
		
	}

}
