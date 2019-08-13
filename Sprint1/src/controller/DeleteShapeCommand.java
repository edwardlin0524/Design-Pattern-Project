package controller;

import model.ShapeList;

public class DeleteShapeCommand implements ICommand {
	private ShapeList list;
	DeleteShapeCommand(ShapeList selectedList){
		this.list = selectedList;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		for(IShape shape:list.getSelectedShapesList()) {
			list.delete(shape);
		}
		list.clearSelectedShapeList();
	}

}
