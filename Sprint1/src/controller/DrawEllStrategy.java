package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import model.EnumColor;
import model.ShapeConfig;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawEllStrategy implements IDrawShapeStrategy {

		
	@Override
	public void outline(Graphics2D g, ShapeConfig config) {
		// TODO Auto-generated method stub
		
		int width = config.getWidth();
		int height = config.getHeight();
		int x = config.getStartPointForDraw().getX();
		int y = config.getStartPointForDraw().getY();
		Color primaryColor =EnumColor.getColor(config.getPrimaryColor());
		g.setColor(primaryColor);
        g.drawOval(x, y, width, height);
	}

	@Override
	public void fillIn(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config) {
		// TODO Auto-generated method stub
		Graphics2D g = paintCanvas.getGraphics2D();
		int width = config.getWidth();
		int height = config.getHeight();
		int x = config.getStartPointForDraw().getX();
		int y = config.getStartPointForDraw().getY();
		Color primaryColor =EnumColor.getColor(appstate.getActivePrimaryColor());
		g.setColor(primaryColor);
        g.fillOval(x, y, width, height);
	}

	@Override
	public void outFill(PaintCanvasBase paintCanvas,ApplicationState appstate, ShapeConfig config) {
		// TODO Auto-generated method stub
		Graphics2D g = paintCanvas.getGraphics2D();
		int width = config.getWidth();
		int height = config.getHeight();
		int x = config.getStartPointForDraw().getX();
		int y = config.getStartPointForDraw().getY();
		Color secondColor =EnumColor.getColor(appstate.getActiveSecondaryColor());
		outline(g,config);
		g.setColor(secondColor);
        g.fillOval(x, y, width, height);
	}
		 

}