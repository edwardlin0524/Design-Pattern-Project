package controller;

import java.awt.Graphics2D;

import model.Point;
import model.ShapeList;
import view.interfaces.PaintCanvasBase;

public class PasteShapeCommand implements ICommand{
	private final ShapeList clipboard;
	private final Point startpoint = new Point(0,0);
    private final PaintCanvasBase paint;
	PasteShapeCommand(ShapeList clipboard, PaintCanvasBase paint){
		this.clipboard = clipboard;
		this.paint = paint;
		if(!clipboard.getCliboard().isEmpty()) {
			System.out.print("I do have something: "+clipboard.getCliboard()+"\n");
		}
		else {System.out.print("I got nothing \n");}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Graphics2D g = paint.getGraphics2D();
		for(IShape shape:clipboard.getCliboard()) {
			shape.setAdjustedStart(startpoint);
			shape.setAdjustedEnd(startpoint);
			shape.draw(g);
		}
		
	}
}
