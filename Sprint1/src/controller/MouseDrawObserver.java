package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseDrawObserver extends MouseAdapter {

	private PaintCanvasBase paintCanvas;
	private Point startPoint;
	private Point endPoint;
	private int width;
	private int height;
	private ShapeConfig config = new ShapeConfig();
	private ApplicationState appstate;
	
	//take paintCanvas and user's config as parameter
	public MouseDrawObserver(PaintCanvasBase paintCanvas,ApplicationState appstate) {
		this.appstate = appstate;
		this.paintCanvas = paintCanvas;
    }
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("Mouse pressed!");
	    startPoint = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		 
		 System.out.println(appstate.getActiveStartAndEndPointMode());
		 endPoint = new Point(e.getX(), e.getY());
		 config.setStartPoint(startPoint); 
		 config.setEndPoint(endPoint);
		 width = config.getWidth();
		 height = config.getHeight();
		 //graphic.fillRect(config.getStartPointForDraw().getX(),config.getStartPointForDraw().getY(),width,height);
		 //ShapeDrawer drawer = new ShapeDrawer(config.getStartPointForDraw().getX(),config.getStartPointForDraw().getY(),width,height,paintCanvas);
		 IDrawShapeStrategy strategy=null; 
		 switch(appstate.getActiveShapeType()){
		 case RECTANGLE: strategy = new DrawRecStrategy();break;
		 case ELLIPSE: strategy = new DrawEllStrategy();break;
		 default:
			break;
		 }
		 strategy.draw(config.getStartPointForDraw().getX(),config.getStartPointForDraw().getY(),width,height,paintCanvas);
	}
}
