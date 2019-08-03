package controller;

import model.ShapeConfig;
import model.ShapeList;

public class SelectShapeCommand implements ICommand {
	private ShapeList list;
	private ShapeConfig config;

	SelectShapeCommand(ShapeList shapeList, ShapeConfig config) {
		this.list = shapeList;
		this.config = config;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		list.clearSelectedShapeList();
		for (IShape shape : list.getShapeList()) {
			if (shape.getAdjustedStart().getX() < config.getStartPointForDraw().getX() + config.getWidth()
					&& shape.getAdjustedStart().getX() + shape.getWidth() > config.getStartPointForDraw().getX()
					&& shape.getAdjustedStart().getY() < config.getStartPointForDraw().getY() + config.getHeight()
					&& shape.getAdjustedStart().getY() + shape.getHeight() > config.getStartPointForDraw().getY()) {
				if (list.getSelectedShapesList().contains(shape))
					continue;
				list.addSelectedList(shape);

			}
		}
		System.out.print("The Select List you've chosen is: " + list.getSelectedShapesList() + "\n");
	}

}
