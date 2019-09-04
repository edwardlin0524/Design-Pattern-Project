package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import interfaces.IDrawShapeStrategy;
import interfaces.IShape;
import model.EnumColor;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class SelectShapeDecorator extends ShapeDecorator {
	private int width, height, x, y;
	private Color primaryColor;
	private Color secondaryColor;
	private ShapeType type;
	private IDrawShapeStrategy str;
	private int[] xTri = new int[3];
	private int[] yTri = new int[3];

	private int[] temp = new int[3];
	private int[] temp1 = new int[3];
	private IShape tempshape;

	public SelectShapeDecorator(IShape decoratedShape) {
		super(decoratedShape);
		this.width = decoratedShape.getWidth() + 10;
		this.height = decoratedShape.getHeight() + 10;
		this.x = decoratedShape.getAdjustedStart().getX() - 5;
		this.y = decoratedShape.getAdjustedStart().getY() - 5;
		this.primaryColor = EnumColor.getColor(decoratedShape.getPrimaryColor());
		this.secondaryColor = EnumColor.getColor(decoratedShape.getSecondaryColor());
		this.type = decoratedShape.getShapeType();
		tempshape = decoratedShape;

		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PaintCanvasBase paintCanvas) {
		Graphics2D g = paintCanvas.getGraphics2D();
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0);
		g.setStroke(stroke);
		switch (type) {
		case RECTANGLE:
			str = new DrawRecStrategy(width, height, x, y, this.primaryColor, this.secondaryColor, g);
			break;
		case TRIANGLE:
			this.temp[0] = tempshape.getAdjustedStart().getX() - 5;
			this.temp[1] = tempshape.getAdjustedEnd().getX() + 20;
			this.temp[2] = tempshape.getAdjustedStart().getX() - 5;
			this.temp1[0] = tempshape.getAdjustedStart().getY() - 15;
			this.temp1[1] = tempshape.getAdjustedEnd().getY() + 5;
			this.temp1[2] = tempshape.getAdjustedEnd().getY() + 5;
			this.xTri = this.temp;
			this.yTri = this.temp1;
			str = new DrawTriStrategy(xTri, yTri, this.primaryColor, this.secondaryColor, g);
			break;
		case ELLIPSE:
			// tempshape.setAdjustedStart(newStart);
			str = new DrawEllStrategy(width, height, x, y, this.primaryColor, this.secondaryColor, g);
			break;
		}
		str.outline();
	}
}
