package controller;

import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;

public class DrawEllStrategy implements IDrawShapeStrategy {

	@Override
	public void draw(int x, int y, int width, int height, PaintCanvasBase paintCanvas) {
		// TODO Auto-generated method stub
		Graphics2D g = paintCanvas.getGraphics2D();
		 g.fillOval(x, y, width, height);
		
	}

}
