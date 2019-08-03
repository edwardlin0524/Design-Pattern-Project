package controller;

import java.awt.Graphics2D;

import model.Point;
import model.ShapeConfig;

public interface IShape {

	void draw(Graphics2D g);

	Point getStartPoint();

	Point getEndPoint();

	void setAdjustedEnd(Point adjustedEnd);

	void setAdjustedStart(Point adjustedStart);

	Point getAdjustedStart();

	Point getAdjustedEnd();

	void addX(int dx);

	void addY(int dy);

	boolean contains(Point start_Point);

	ShapeConfig getShapeConfiguration();

	int getWidth();

	int getHeight();

	//void draw(PaintCanvasBase paintCanvas);

	// void paint(Graphics2D g);

	// void draw(Graphics2D g, IDrawShapeStrategy strategy);
}