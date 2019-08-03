package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import model.ShapeConfig;
import model.ShapeList;

public class MouseMoveObserver extends MouseAdapter {
	private Point startPoint;
	private Point endPoint;
	private ShapeList list;
	private ShapeList SelectList;
	private ShapeConfig config = new ShapeConfig();

	MouseMoveObserver(ShapeList list, ShapeList selectlist) {
		this.list = list;
		this.SelectList = selectlist;

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
		MoveShapeCommand moveCmd = new MoveShapeCommand(SelectList, list, config);
		moveCmd.run();
	}

}
