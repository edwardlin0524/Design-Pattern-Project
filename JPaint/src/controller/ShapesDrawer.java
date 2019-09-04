package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import interfaces.IShape;
import model.ShapeList;
import model.interfaces.IShapeListObserver;
import view.interfaces.PaintCanvasBase;

public class ShapesDrawer implements IShapeListObserver {
	private PaintCanvasBase paintCanvas;

	public ShapesDrawer(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void update(ShapeList shapeList) {
		Graphics2D g = paintCanvas.getGraphics2D();

		// make a huge white rectangle to have a clean screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());

		for (IShape shape : shapeList.getShapeList()) {
			shape.draw(paintCanvas);
			// if selected shapes are selected, draw an outline dashed outside
			if (shapeList.getSelectedShapesList().contains(shape)) {

				IShape selectShape = new SelectShapeDecorator(shape);
				selectShape.draw(paintCanvas);
			}
		}

	}

}
