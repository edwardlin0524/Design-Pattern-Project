package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import model.ShapeConfig;
import model.ShapeList;
import model.interfaces.IApplicationState;

public class MouseSelectObserver extends MouseAdapter {
	private Point startPoint;
	private Point endPoint;
	private ShapeList list;
	private ShapeConfig config = new ShapeConfig();

	MouseSelectObserver(IApplicationState appstate, ShapeList list) {
		this.list = list;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		endPoint = new Point(e.getX(), e.getY());
		config.setStartPoint(startPoint);
		config.setEndPoint(endPoint);
		SelectShapeCommand selectCmd = new SelectShapeCommand(list, config);
		selectCmd.run();
	}

}
