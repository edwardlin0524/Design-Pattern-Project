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

public class Ellipse implements IShape {
	private final ShapeConfig config;
	private final ShapeShadingType shapeShadingType;
	private final ShapeType shapeType;
	private final Color primaryColor;
	private final Color secondaryColor;
	private final ShapeColor primaryShapeColor;
	private final ShapeColor secondaryShapeColor;

	private int width;
	private int height;

	private Point adjustedStart;
	private Point adjustedEnd;
	private final Point startPoint;
	private DrawEllStrategy str;

	public Ellipse(ShapeConfig config) {
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
		this.startPoint = config.getStartPoint();
		this.adjustedEnd = config.getEndPointForDraw();
	}

	@Override
	public void draw(PaintCanvasBase paintCanvas) {// Graphics2D g
		Graphics2D g = paintCanvas.getGraphics2D();
		this.str = new DrawEllStrategy(width, height, adjustedStart.getX(), adjustedStart.getY(), this.primaryColor,
				this.secondaryColor, g);// width, height, adjustedStart.getX(), adjustedStart.getY(), this.primaryColor,
										// this.secondaryColor
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

	@Override
	public void setAdjustedStart(Point adjustedStart) {
		this.adjustedStart = adjustedStart;
	}

	@Override
	public void setAdjustedEnd(Point adjustedEnd) {
		this.adjustedEnd = adjustedEnd;
	}

	@Override
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
		adjustedStart.setX(adjustedStart.getX() + dx);
		adjustedEnd.setX(adjustedEnd.getX() + dx);
	}

	@Override
	public void addY(int dy) {
		adjustedStart.setY(adjustedStart.getY() + dy);
		adjustedEnd.setY(adjustedEnd.getY() + dy);

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public ShapeConfig getConfig() {
		// TODO Auto-generated method stub
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
