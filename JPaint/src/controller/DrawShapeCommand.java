package controller;

import interfaces.ICommand;
import interfaces.IShape;
import interfaces.IUndoRedo;
import model.ShapeConfig;
import model.ShapeFactory;
//import model.persistence.ApplicationState;
//import view.interfaces.PaintCanvasBase;
import model.ShapeList;

public class DrawShapeCommand implements ICommand, IUndoRedo {
	private ShapeConfig config;
	private ShapeList list;
	private ShapeFactory factory = new ShapeFactory();
	private IShape shape;

	DrawShapeCommand(ShapeConfig config, ShapeList list) {
		this.config = config;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		shape = factory.createShape(config);
		this.list.add(shape);
		CommandHistory.add(this);

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.list.delete(shape);

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.list.add(shape);

	}

}
