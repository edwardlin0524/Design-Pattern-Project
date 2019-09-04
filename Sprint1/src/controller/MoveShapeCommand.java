package controller;

import java.util.ArrayList;

import interfaces.ICommand;
import interfaces.IShape;
import interfaces.IUndoRedo;
import model.ShapeConfig;
import model.ShapeList;

public class MoveShapeCommand implements ICommand, IUndoRedo {
	private ShapeList list;
	private ShapeConfig config = new ShapeConfig();
	private IShape before;
	private ArrayList<IShape> temp;
	private int dx, dy;

	MoveShapeCommand(ShapeList SelectList, ShapeList list, ShapeConfig config) {
		this.config = config;
		this.list = list;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		temp = new ArrayList<IShape>();
		dx = config.getEndPoint().getX() - config.getStartPoint().getX();
		dy = config.getEndPoint().getY() - config.getStartPoint().getY();

		for (IShape selected : list.getSelectedShapesList()) {
			before = selected;
			temp.add(before);
			list.delete(selected);
			selected.addX(dx);
			selected.addY(dy);
			list.add(selected);

		}
		CommandHistory.add(this);

	}

	@Override
	public void undo() {
		System.out.print("Shape has been deleted \n" + temp);
		// TODO Auto-generated method stub
		for (IShape selected : temp) {
			list.delete(selected);
			selected.getAdjustedStart().setX(selected.getAdjustedStart().getX() - dx);
			selected.getAdjustedEnd().setX(selected.getAdjustedEnd().getX() - dx);
			selected.getAdjustedStart().setY(selected.getAdjustedStart().getY() - dy);
			selected.getAdjustedEnd().setY(selected.getAdjustedEnd().getY() - dy);
			list.add(selected);
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for (IShape selected : temp) {
			list.delete(selected);
			selected.addX(dx);
			selected.addY(dy);
			list.add(selected);
		}
	}

}
