package controller;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawTriStrategy implements IDrawShapeStrategy {
	private Color primaryColor;
	private Color secondaryColor;
	private int[] x = new int[3];
	private int[] y = new int[3];
	private Graphics2D g;

	DrawTriStrategy(int[] x, int[] y, Color primaryColor, Color secondColor, Graphics2D g) {
		this.x = x;
		this.y = y;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondColor;
		this.g = g;
	}

	@Override
	public void outFill() {
		// TODO Auto-generated method stub
		g.setColor(secondaryColor);
		g.fillPolygon(x, y, 3);
		g.setColor(secondaryColor);
		g.drawPolygon(x, y, 3);
		g.setColor(primaryColor);
		g.fillPolygon(x, y, 3);
	}

	@Override
	public void outline() {
		// TODO Auto-generated method stub
		g.setColor(primaryColor);
		g.drawPolygon(x, y, 3);
	}

	@Override
	public void fillIn() {
		// TODO Auto-generated method stub
		g.setColor(primaryColor);
		g.fillPolygon(x, y, 3);
	}

}
