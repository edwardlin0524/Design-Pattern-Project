package controller;

public interface IDrawShapeStrategy{
//	void fillIn(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config);
	void outFill();
	//void outline(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config);
	void outline();
	//void outline(PaintCanvasBase paintCanvas, ShapeConfig config);
	//void fillIn(PaintCanvasBase paintCanvas, ShapeConfig config);
	void fillIn();
}
