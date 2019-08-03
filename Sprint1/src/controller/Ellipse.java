package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import model.EnumColor;
import model.Point;
import model.ShapeConfig;
import model.ShapeShadingType;

public class Ellipse implements IShape {
	private ShapeConfig shapeConfig;
	private ShapeShadingType shapeShadingType;

	private Color primaryColor;
	private Color secondaryColor;

	private int width;
	private int height;

	private Point adjustedStart;
	private Point adjustedEnd;
	private Point startPoint;

	public Ellipse(ShapeConfig shapeConfig) {
		this.shapeConfig = shapeConfig;
		this.shapeShadingType = shapeConfig.getShadingType();
		this.primaryColor = EnumColor.getColor(shapeConfig.getPrimaryColor());
		this.secondaryColor = EnumColor.getColor(shapeConfig.getSecondaryColor());
		this.width = shapeConfig.getWidth();
		this.height = shapeConfig.getHeight();
		this.adjustedStart = shapeConfig.getStartPointForDraw();
		this.startPoint = shapeConfig.getStartPoint();
		this.adjustedEnd = shapeConfig.getEndPointForDraw();
	}

	@Override
	public void draw(Graphics2D g) {
		if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
			g.setColor(primaryColor);
			g.drawOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
		} else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
			g.setColor(primaryColor);
			g.fillOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
		} else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			g.setColor(primaryColor);
			g.drawOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
			g.setColor(secondaryColor);
			g.fillOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
		}
	}

	public boolean contains(Point startPoint) {
		return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
				&& adjustedStart.getX() + width > startPoint.getX()
				&& adjustedStart.getY() + height > startPoint.getY());
	}

	@Override
	public void setAdjustedStart(Point adjustedStart) {
		this.adjustedStart = adjustedStart;
	}

	@Override
	public void setAdjustedEnd(Point adjustedEnd) {
		this.adjustedEnd = adjustedEnd;
	}

	public Point getAdjustedStart() {
		return adjustedStart;
	}

	@Override
	public Point getAdjustedEnd() {
		return adjustedEnd;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public Point getEndPoint() {
		return adjustedEnd;
	}

	@Override
	public void addX(int dx) {
		System.out.print("x was :" + adjustedStart.getX());
		adjustedStart.setX(adjustedStart.getX() + dx);
		adjustedEnd.setX(adjustedEnd.getX() + dx);
		System.out.print("x now is :" + adjustedStart.getX());
	}

	@Override
	public void addY(int dy) {
		adjustedStart.setY(adjustedStart.getY() + dy);
		adjustedEnd.setY(adjustedEnd.getY() + dy);

	}

	public ShapeConfig getShapeConfiguration() {
		return shapeConfig;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
