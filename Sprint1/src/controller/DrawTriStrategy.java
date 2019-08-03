package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import model.EnumColor;
import model.ShapeConfig;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawTriStrategy implements IDrawShapeStrategy {

	@Override
	public void fillIn(PaintCanvasBase paintCanvas, ApplicationState appstate, ShapeConfig config) {
		// TODO Auto-generated method stub
		Graphics2D g = paintCanvas.getGraphics2D();
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = config.getStartPointForDraw().getX();
		x[1] = config.getEndPointForDraw().getX();
		x[2] = config.getStartPointForDraw().getX();

		y[0] = config.getStartPointForDraw().getY();
		y[1] = config.getEndPointForDraw().getY();
		y[2] = config.getEndPointForDraw().getY();

		Color primaryColor = EnumColor.getColor(appstate.getActivePrimaryColor());
		Color secondColor = EnumColor.getColor(appstate.getActiveSecondaryColor());
		g.setColor(primaryColor);
		g.fillPolygon(x, y, 3);
	}

	@Override
	public void outFill(PaintCanvasBase paintCanvas, ApplicationState appstate, ShapeConfig config) {
		// TODO Auto-generated method stub
		Graphics2D g = paintCanvas.getGraphics2D();
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = config.getStartPointForDraw().getX();
		x[1] = config.getEndPointForDraw().getX();
		x[2] = config.getStartPointForDraw().getX();

		y[0] = config.getStartPointForDraw().getY();
		y[1] = config.getEndPointForDraw().getY();
		y[2] = config.getEndPointForDraw().getY();

		Color primaryColor = EnumColor.getColor(appstate.getActivePrimaryColor());
		Color secondColor = EnumColor.getColor(appstate.getActiveSecondaryColor());
		g.setColor(primaryColor);
		g.fillPolygon(x, y, 3);
		g.setColor(primaryColor);
		g.drawPolygon(x, y, 3);
		g.setColor(secondColor);
		g.fillPolygon(x, y, 3);
	}

	@Override
	public void outline(Graphics2D g, ShapeConfig config) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void outline(PaintCanvasBase paintCanvas, ApplicationState appstate, ShapeConfig config) {
//		// TODO Auto-generated method stub
//		Graphics2D g = paintCanvas.getGraphics2D();
//		int[] x = new int[3];
//		int[] y = new int[3];
//		x[0] = config.getStartPointForDraw().getX();
//		x[1] = config.getEndPointForDraw().getX();
//		x[2] = config.getStartPointForDraw().getX();
//
//		y[0] = config.getStartPointForDraw().getY();
//		y[1] = config.getEndPointForDraw().getY();
//		y[2] = config.getEndPointForDraw().getY();
//
//		Color primaryColor = EnumColor.getColor(appstate.getActivePrimaryColor());
//		Color secondColor = EnumColor.getColor(appstate.getActiveSecondaryColor());
//		g.setColor(primaryColor);
//		g.drawPolygon(x, y, 3);
//	}

}
