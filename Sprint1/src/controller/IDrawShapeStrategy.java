package controller;


import java.awt.Graphics2D;

import model.ShapeConfig;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;



public interface IDrawShapeStrategy{
	void fillIn(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config);
	void outFill(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config);
	//void outline(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config);
	void outline(Graphics2D g, ShapeConfig config);
	//void outline(PaintCanvasBase paintCanvas, ShapeConfig config);
}
