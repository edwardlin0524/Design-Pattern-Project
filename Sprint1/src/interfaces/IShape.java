package interfaces;

import model.Point;
import model.ShapeColor;
import model.ShapeConfig;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface IShape {

	void draw(PaintCanvasBase paintCanvas);

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
}