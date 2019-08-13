package controller;

import java.awt.Color;
import java.awt.Graphics2D;


public class DrawRecStrategy implements IDrawShapeStrategy {
	private int width,height,x,y;
	private Color primaryColor;
	private Color secondaryColor;
	private Graphics2D g;
	DrawRecStrategy(int width,int height,int x,int y,Color primaryColor,Color secondaryColor,Graphics2D g){
		this.width=width;
		this.height = height;
		this.x=x;
		this.y = y;		
		this.primaryColor = primaryColor;
		this.g = g;
		this.secondaryColor = secondaryColor;
	}

	@Override
	public void outline() {
		// TODO Auto-generated method stub
		g.setColor(primaryColor);
		g.drawRect(x, y, width, height);
	}

	@Override
	public void fillIn() {
		// TODO Auto-generated method stub
		g.setColor(primaryColor);
		g.fillRect(x, y, width, height);
	}
	@Override
	public void outFill() {
		// TODO Auto-generated method stub
		g.setColor(secondaryColor);
		g.drawRect(x, y, width, height);
		g.setColor(primaryColor);
		g.fillRect(x, y, width, height);
	}

}
