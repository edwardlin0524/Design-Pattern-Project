package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.List;
import controller.Point;
import model.StartAndEndPointMode;
import model.persistence.ApplicationState;
//import view.gui.MouseDrawAdapter;
//import view.gui.MouseMoveAdapter;
//import view.gui.MouseSelectAdapter;

import view.interfaces.PaintCanvasBase;


public class MouseHandler implements IMouseObserver {
	private PaintCanvasBase paintCanvas;
	private ApplicationState appstate;
	
	//take paintCanvas and user's config as parameter
	public MouseHandler(PaintCanvasBase paintCanvas,ApplicationState appstate) {
		this.appstate = appstate;
		this.paintCanvas = paintCanvas;
		appstate.registerObserver(this);
    }
	//Make sure every time code run here, it have the right listener
	//MouseListener[] mouseListeners = paintCanvas.getMouseListeners();
  
    


	@Override
	public void update() {
		// TODO Auto-generated method stub
//		MouseListener[] mouseListeners = paintCanvas.getMouseListeners();
//	    for (MouseListener mouseListener : mouseListeners) {
//	    	 System.out.println(appstate.getActiveStartAndEndPointMode());
//        }
		 StartAndEndPointMode startAndEndPointMode = appstate.getActiveStartAndEndPointMode();

	        if (startAndEndPointMode.equals(StartAndEndPointMode.DRAW)) {
	            System.out.println(appstate.getActiveStartAndEndPointMode());
	            paintCanvas.addMouseListener(new MouseDrawObserver(paintCanvas, appstate));

	        } else if (startAndEndPointMode.equals(StartAndEndPointMode.SELECT)) {
	        	System.out.println(appstate.getActiveStartAndEndPointMode());
	            //paintCanvas.addMouseListener(new MouseSelectAdapter(applicationState, shapeList, shapeConfiguration));
	        } else if (startAndEndPointMode.equals(StartAndEndPointMode.MOVE)) {
	        	System.out.println(appstate.getActiveStartAndEndPointMode());
	            //paintCanvas.addMouseListener(new MouseMoveAdapter(applicationState, shapeList, shapeConfiguration));
	        } else {
	        }
		
	}

	}

