package controller;

import model.ShapeConfig;
import model.ShapeFactory;
//import model.persistence.ApplicationState;
//import view.interfaces.PaintCanvasBase;
import model.ShapeList;

public class DrawShapeCommand implements ICommand {
	private ShapeConfig config;
	private ShapeList list;
	private ShapeFactory factory = new ShapeFactory();

	DrawShapeCommand(ShapeConfig config, ShapeList list) {
		this.config = config;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		IShape shape = factory.createShape(config);
		this.list.add(shape);

	}

}
