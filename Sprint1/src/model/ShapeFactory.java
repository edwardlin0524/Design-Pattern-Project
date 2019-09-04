package model;

import controller.Rectangle;
import controller.Triangle;
import interfaces.IShape;
import controller.Ellipse;

public class ShapeFactory {
	public IShape createShape(ShapeConfig shapeConfig) {
		ShapeType shapeType = shapeConfig.getShapeType();
		IShape shape = null;
		switch (shapeType) {
		case RECTANGLE:
			shape = new Rectangle(shapeConfig);
			break;
		case ELLIPSE:
			shape = new Ellipse(shapeConfig);
			break;
		case TRIANGLE:
			shape = new Triangle(shapeConfig);
		default:
			break;
		}

		return shape;
	}
}
