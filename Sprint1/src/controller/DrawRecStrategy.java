package controller;

import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;

public class DrawRecStrategy implements IDrawShapeStrategy {

	@Override
	public void draw(int x, int y, int width, int height, PaintCanvasBase paintCanvas) {
		Graphics2D g = paintCanvas.getGraphics2D();
		 g.fillRect(x,y,width,height);
		 System.out.println("Mouse Released");
	}

}
