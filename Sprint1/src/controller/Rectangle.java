package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import model.EnumColor;
import model.Point;
import model.ShapeConfig;
import model.ShapeShadingType;

public class Rectangle implements IShape {
	private ShapeConfig config;
	private ShapeShadingType shapeShadingType;
	
	private Color primaryColor;
	private Color secondaryColor;
	
	private int width;
	private int height;
	
	private Point adjustedStart;
	private Point adjustedEnd;
	private Point startPoint;

	public Rectangle(ShapeConfig config) {
		this.config = config;
		this.shapeShadingType = config.getShadingType();
		this.primaryColor = EnumColor.getColor(config.getPrimaryColor());
		this.secondaryColor = EnumColor.getColor(config.getSecondaryColor());
		this.width = config.getWidth();
		this.height = config.getHeight();
		this.adjustedStart = config.getStartPointForDraw();
		this.adjustedEnd = config.getEndPointForDraw();
		this.startPoint = config.getStartPoint();
	}

	@Override
	public void draw(Graphics2D g) {
		if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
			g.setColor(primaryColor);
			g.drawRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
		} else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
			System.out.print(secondaryColor);
			g.setColor(primaryColor);
			g.fillRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
		} else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			g.setColor(primaryColor);
			g.drawRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
			g.setColor(secondaryColor);
			g.fillRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
		}
	}

	public boolean contains(Point startPoint) {
		return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
				&& adjustedStart.getX() + width > startPoint.getX()
				&& adjustedStart.getY() + height > startPoint.getY());
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public Point getEndPoint() {
		return adjustedEnd;
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

	@Override
	public void addX(int dx) {
		adjustedStart.setX(adjustedStart.getX() + dx);
		adjustedEnd.setX(adjustedEnd.getX() + dx);

	}

	@Override
	public void addY(int dy) {
		adjustedStart.setY(adjustedStart.getY() + dy);
		adjustedEnd.setY(adjustedEnd.getY() + dy);

	}

	public ShapeConfig getconfig() {
		return config;
	}

	@Override
	public ShapeConfig getShapeConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
