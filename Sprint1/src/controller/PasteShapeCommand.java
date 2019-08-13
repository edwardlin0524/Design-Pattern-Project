package controller;

import model.Point;
import model.ShapeConfig;
import model.ShapeList;

public class PasteShapeCommand implements ICommand {
	private final ShapeList clipboard;
	private Point newstartpoint;
	private Point newendpoint;
	private ShapeConfig config;

	PasteShapeCommand(ShapeList clipboard) {
		this.clipboard = clipboard;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.print("The clipboard you have now is: " + clipboard.getCliboard() + "\n");
		for (IShape shape : clipboard.getCliboard()) {
			config = new ShapeConfig();
			newstartpoint = new Point((shape.getAdjustedStart().getX() - 100), (shape.getAdjustedStart().getY() - 100));
			newendpoint = new Point((shape.getAdjustedEnd().getX() - 100), (shape.getAdjustedEnd().getY() - 100));
			
			config.setStartPoint(newstartpoint);
			config.setEndPoint(newendpoint);
			config.setShapeType(shape.getShapeType());
			config.setShadingType(shape.getShadingType());
			config.setPrimaryColor(shape.getPrimaryColor());
			config.setSecondaryColor(shape.getSecondaryColor());
			
			DrawShapeCommand draw = new DrawShapeCommand(config, clipboard);
			draw.run();

		}

	}
}
