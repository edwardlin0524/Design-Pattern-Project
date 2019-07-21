package controller;

import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;

public class ShapeDrawer {
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private PaintCanvasBase paintCanvas;
	ShapeDrawer(int x, int y, int width, int height, PaintCanvasBase paintCanvas){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.paintCanvas = paintCanvas;
	}
	void draw(IDrawShapeStrategy strategy) {
		strategy.draw(x, y, width, height, paintCanvas);
	};
}
