package controller;

import java.awt.Graphics2D;
import model.Point;
import model.ShapeColor;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {

	void draw(Graphics2D g);

	Point getStartPoint();

	Point getEndPoint();

	ShapeType getShapeType();

	ShapeShadingType getShadingType();

	void setAdjustedEnd(Point adjustedEnd);

	void setAdjustedStart(Point adjustedStart);
	
	ShapeColor getPrimaryColor();
	ShapeColor getSecondaryColor();

	Point getAdjustedStart();

	Point getAdjustedEnd();

	void addX(int dx);

	void addY(int dy);

	boolean contains(Point start_Point);

	ShapeConfig getConfig();

	int getWidth();

	int getHeight();

//	void outlineSelected(Graphics2D g);
}