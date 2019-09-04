package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import interfaces.IShape;
import model.EnumColor;
import model.Point;
import model.ShapeColor;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class Rectangle implements IShape {
	private ShapeConfig config;
	private ShapeShadingType shapeShadingType;
	private ShapeType shapeType;

	private Color primaryColor;
	private Color secondaryColor;
	private ShapeColor primaryShapeColor;
	private ShapeColor secondaryShapeColor;
	private int width;
	private int height;

	private Point adjustedStart;
	private Point adjustedEnd;
	private Point startPoint;
	private DrawRecStrategy str;

	public Rectangle(ShapeConfig config) {
		this.config = config;
		this.shapeShadingType = config.getShadingType();
		this.shapeType = config.getShapeType();
		this.primaryColor = EnumColor.getColor(config.getPrimaryColor());
		this.secondaryColor = EnumColor.getColor(config.getSecondaryColor());
		this.primaryShapeColor = config.getPrimaryColor();
		this.secondaryShapeColor = config.getSecondaryColor();
		this.width = config.getWidth();
		this.height = config.getHeight();
		this.adjustedStart = config.getStartPointForDraw();
		this.adjustedEnd = config.getEndPointForDraw();
		this.startPoint = config.getStartPoint();

	}

	@Override
	public void draw(PaintCanvasBase paintCanvas) {
		Graphics2D g = paintCanvas.getGraphics2D();
		this.str = new DrawRecStrategy(width, height, adjustedStart.getX(), adjustedStart.getY(), primaryColor,
				secondaryColor, g);
		if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
			str.outline();
		} else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
			str.fillIn();
		} else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			str.outFill();
		}
	}

	@Override
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

	@Override
	public ShapeConfig getConfig() {
		return this.config;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return shapeType;
	}

	@Override
	public ShapeShadingType getShadingType() {
		// TODO Auto-generated method stub
		return shapeShadingType;
	}

	@Override
	public ShapeColor getPrimaryColor() {
		// TODO Auto-generated method stub
		return primaryShapeColor;
	}

	@Override
	public ShapeColor getSecondaryColor() {
		// TODO Auto-generated method stub
		return secondaryShapeColor;
	}

}
