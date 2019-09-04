package controller;

import java.util.ArrayList;

import interfaces.ICommand;
import interfaces.IShape;
import interfaces.IUndoRedo;
import model.ShapeList;

public class DeleteShapeCommand implements ICommand, IUndoRedo {
	private ShapeList list;
	private ArrayList<IShape> temp;

	DeleteShapeCommand(ShapeList selectedList) {
		this.list = selectedList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		temp = new ArrayList<IShape>();
		for (IShape shape : list.getSelectedShapesList()) {
			temp.add(shape);
			list.delete(shape);
		}
		list.clearSelectedShapeList();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for (IShape shape : temp) {
			list.add(shape);
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for (IShape shape : temp) {
			list.delete(shape);
		}
	}

}
