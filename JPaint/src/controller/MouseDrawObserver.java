package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import model.ShapeConfig;
import model.ShapeList;
import model.persistence.ApplicationState;
//import view.interfaces.PaintCanvasBase;

public class MouseDrawObserver extends MouseAdapter {

	//private PaintCanvasBase paintCanvas;
	private ShapeConfig config;
	private ApplicationState appstate;
	private ShapeList list;
	
	private Point startPoint;
	private Point endPoint;
	
	
	public MouseDrawObserver(ApplicationState appstate, ShapeList list) {
		this.appstate = appstate;
		this.list = list;
		this.config =new ShapeConfig();
    }
	@Override
	public void mousePressed(MouseEvent e) {
	    startPoint = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		 System.out.println(appstate.getActiveStartAndEndPointMode());
		 endPoint = new Point(e.getX(), e.getY());
		 //config setting
		 config.setStartPoint(startPoint); 
		 config.setEndPoint(endPoint);
		 config.setShapeType(appstate.getActiveShapeType());
		 config.setPrimaryColor(appstate.getActivePrimaryColor());
		 config.setSecondaryColor(appstate.getActiveSecondaryColor());
		 config.setShadingType(appstate.getActiveShapeShadingType());
		 
		 DrawShapeCommand drawCmd = new DrawShapeCommand(config,list);
		 drawCmd.run();
		
	}
}
