package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.EnumColor;
import model.Point;
import model.ShapeColor;
import model.ShapeType;

public class SelectedShapeDecorator implements IDrawShapeStrategy {
	private int width,height,x,y;
	private Color primaryColor;
	private Color secondaryColor;
	private Graphics2D g;
	private ShapeType type;
	private IDrawShapeStrategy str;
	private int[] xTri = new int[3];
	private int[] yTri = new int[3];
	
	SelectedShapeDecorator(ShapeType type,int width,int height,Point startpoint,Point endpoint,ShapeColor primaryColor,ShapeColor secondaryColor,Graphics2D g){
		this.width=width;
		this.height = height;
		this.x= startpoint.getX();
		this.y = startpoint.getY();		
		this.primaryColor = EnumColor.getColor( primaryColor);
		this.g = g;
		this.secondaryColor = EnumColor.getColor( secondaryColor);
		this.type= type;
		
		this.xTri[0] = startpoint.getX()-5;
		this.xTri[1] = endpoint.getX()+20;
		this.xTri[2] = startpoint.getX()-5;

		this.yTri[0] = startpoint.getY()-15;
		this.yTri[1] = endpoint.getY()+5;
		this.yTri[2] = endpoint.getY()+5;
		switch(type){
		case RECTANGLE:
			str = new DrawRecStrategy(width+10, height+10, x-5, y-5, this.primaryColor, this.secondaryColor, g);
			break;
		case TRIANGLE:
			str = new DrawTriStrategy(xTri, yTri,this.primaryColor, this.secondaryColor, g);
			break;
		case ELLIPSE:
			str = new DrawEllStrategy(width+10, height+10, x-5, y-5, this.primaryColor, this.secondaryColor, g);
			break;
		}
		
	}
	@Override
	public void outFill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void outline() {
		// TODO Auto-generated method stub
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0);
		g.setStroke(stroke);
		//right way
		str.outline();
	}

	@Override
	public void fillIn() {
		// TODO Auto-generated method stub

	}

}
