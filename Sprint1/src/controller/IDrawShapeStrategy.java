package controller;

import view.interfaces.PaintCanvasBase;

public interface IDrawShapeStrategy{
	public void draw(int x, int y, int width, int height, PaintCanvasBase paintCanvas);
}
