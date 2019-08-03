package controller;

import model.ShapeConfig;
import model.ShapeFactory;
//import model.persistence.ApplicationState;
//import view.interfaces.PaintCanvasBase;
import model.ShapeList;

public class DrawShapeCommand implements ICommand {
	// private ApplicationState appstate;
	private ShapeConfig config;
	private ShapeList list;
	// private PaintCanvasBase paintCanvas;
	private ShapeFactory factory = new ShapeFactory();

	DrawShapeCommand(ShapeConfig config, ShapeList list) {
		// this.appstate = appstate;
		this.config = config;
		this.list = list;
		// this.paintCanvas = paintCanvas;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// new ShapesDrawer(config, paintCanvas, appstate, list);
		IShape shape = factory.createShape(config);
		this.list.add(shape);

	}

}
