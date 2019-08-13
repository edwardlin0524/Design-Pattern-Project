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

public class Triangle implements IShape {
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
	private int[] x = new int[3];
	private int[] y = new int[3];
	private DrawTriStrategy str;

	public Triangle(ShapeConfig config) {
		this.config = config;
		this.shapeShadingType = config.getShadingType();
		this.shapeType = config.getShapeType();
		this.primaryColor = EnumColor.getColor(config.getPrimaryColor());
		this.primaryShapeColor = config.getPrimaryColor();
		this.secondaryShapeColor = config.getSecondaryColor();
		this.secondaryColor = EnumColor.getColor(config.getSecondaryColor());
		this.adjustedStart = config.getStartPointForDraw();
		this.adjustedEnd = config.getEndPointForDraw();
		this.startPoint = config.getStartPoint();
		this.x[0] = config.getStartPointForDraw().getX();
		this.x[1] = config.getEndPointForDraw().getX();
		this.x[2] = config.getStartPointForDraw().getX();

		this.y[0] = config.getStartPointForDraw().getY();
		this.y[1] = config.getEndPointForDraw().getY();
		this.y[2] = config.getEndPointForDraw().getY();
	
		//These are for outline dashed shape
       
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		this.str = new DrawTriStrategy(x, y, primaryColor, secondaryColor, g);
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
//		this.str = new DrawTriStrategy(x, y, primaryColor, secondaryColor, g);
//		str.outline();
//	}

	double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {

		double A = area(x1, y1, x2, y2, x3, y3);
		double A1 = area(x, y, x2, y2, x3, y3);
		double A2 = area(x1, y1, x, y, x3, y3);
		double A3 = area(x1, y1, x2, y2, x, y);

		return (A == A1 + A2 + A3);
	}
	@Override
	public boolean contains(Point startPoint) {
		if (isInside(x[0], y[0], x[1], y[1], x[2], y[2], startPoint.getX(), startPoint.getY())) {
			return true;
		} else {
			return false;
		}
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
		this.x[0] = adjustedStart.getX() + dx;
		this.x[1] = adjustedEnd.getX() + dx;
		this.x[2] = adjustedStart.getX() + dx;
	}

	@Override
	public void addY(int dy) {
		this.y[0] = adjustedStart.getY() + dy;
		this.y[1] = adjustedEnd.getY() + dy;
		this.y[2] = adjustedEnd.getY() + dy;
	}

	@Override
	public ShapeConfig getConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
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
