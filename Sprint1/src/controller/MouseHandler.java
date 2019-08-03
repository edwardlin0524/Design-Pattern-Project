package controller;

import java.awt.event.MouseListener;

import model.ShapeList;
import model.StartAndEndPointMode;
import model.persistence.ApplicationState;

import view.interfaces.PaintCanvasBase;

public class MouseHandler implements IMouseObserver {
	private PaintCanvasBase paintCanvas;
	private ApplicationState appstate;
	private ShapeList list;
	private ShapeList SelectList;

	// take paintCanvas and user's config as parameter
	public MouseHandler(PaintCanvasBase paintCanvas, ApplicationState appstate, ShapeList list) {
		this.appstate = appstate;
		this.paintCanvas = paintCanvas;
		this.list = list;
		appstate.registerObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		MouseListener[] mouseListeners = paintCanvas.getMouseListeners();
		for (MouseListener mouseListener : mouseListeners) {
			paintCanvas.removeMouseListener(mouseListener);
		}

		StartAndEndPointMode startAndEndPointMode = appstate.getActiveStartAndEndPointMode();

		switch (startAndEndPointMode) {
		case DRAW:
			System.out.println("Hi, you are now in " + appstate.getActiveStartAndEndPointMode() + " mode.");
			//initiate drawer, which is a observer of shape list
			ShapesDrawer drawer = new ShapesDrawer(paintCanvas);
			list.registerObserver(drawer);
			paintCanvas.addMouseListener(new MouseDrawObserver(appstate, list));//paintCanvas, 
			break;
		case SELECT:
			System.out.println("Hi, you are now in " + appstate.getActiveStartAndEndPointMode() + " mode.");
			paintCanvas.addMouseListener(new MouseSelectObserver(appstate, list));
			break;
		case MOVE:
			System.out.println("Hi, you are now in " + appstate.getActiveStartAndEndPointMode() + " mode.");
			paintCanvas.addMouseListener(new MouseMoveObserver(list, SelectList));
			break;
		default:
			break;
		}

	}

}
