package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.EnumColor;
import model.Point;
import model.ShapeColor;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;

public class Ellipse implements IShape {
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
	public void draw(Graphics2D g) {
		this.str = new DrawEllStrategy(width, height, adjustedStart.getX(), adjustedStart.getY(), primaryColor,
				secondaryColor, g);
		if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
			str.outline();
		} else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
			str.fillIn();
		} else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			str.outFill();
		}
	}

//	@Override
//	public void outlineSelected(Graphics2D g) {
//		// dashed outline setting
//		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0);
//		g.setStroke(stroke);
//
//		this.str = new DrawEllStrategy(width + 10, height + 10, adjustedStart.getX() - 5, adjustedStart.getY() - 5,
//				primaryColor, secondaryColor, g);
//		str.outline();
//	}

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
