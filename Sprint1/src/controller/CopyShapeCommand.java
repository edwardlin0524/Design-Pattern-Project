package controller;

import interfaces.ICommand;
import interfaces.IShape;
import model.ShapeList;

public class CopyShapeCommand implements ICommand {
	private final ShapeList selectlist;

	CopyShapeCommand(ShapeList selectedList) {
		selectlist = selectedList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// clean clipboard list every time when user re-copy shapes
		selectlist.clearClipboard();
		for (IShape shape : selectlist.getSelectedShapesList()) {
			selectlist.addClipboard(shape);
		}

	}

}
