package controller;

import interfaces.IShape;
import model.Point;
import model.ShapeColor;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public abstract class ShapeDecorator implements IShape {
	protected IShape decoratedshape;
	
	public ShapeDecorator(IShape decoratedShape) {
		this.decoratedshape = decoratedShape;	
	}
	@Override
	public void draw(PaintCanvasBase paintCanvas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getStartPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getEndPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeShadingType getShadingType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdjustedEnd(Point adjustedEnd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAdjustedStart(Point adjustedStart) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShapeColor getPrimaryColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeColor getSecondaryColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getAdjustedStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getAdjustedEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addX(int dx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addY(int dy) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Point start_Point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShapeConfig getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
