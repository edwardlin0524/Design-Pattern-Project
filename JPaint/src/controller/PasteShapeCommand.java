package controller;

import java.util.ArrayList;

import interfaces.ICommand;
import interfaces.IShape;
import interfaces.IUndoRedo;
import model.Point;
import model.ShapeConfig;
import model.ShapeFactory;
import model.ShapeList;

public class PasteShapeCommand implements ICommand, IUndoRedo {
	private final ShapeList clipboard;
	private Point newstartpoint;
	private Point newendpoint;
	private ShapeConfig config;
	private ShapeFactory factory=new ShapeFactory();;
	private IShape shape;
	private ShapeList list = new ShapeList();
	private ArrayList<IShape> temp = new ArrayList<>();
	PasteShapeCommand(ShapeList clipboard) {
		this.clipboard = clipboard;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (IShape selectedShape : clipboard.getCliboard()) {
			config = new ShapeConfig();			
			
			newstartpoint = new Point((selectedShape.getAdjustedStart().getX() - 50), (selectedShape.getAdjustedStart().getY() - 50));
			newendpoint = new Point((selectedShape.getAdjustedEnd().getX() - 50), (selectedShape.getAdjustedEnd().getY() - 50));
			
			config.setStartPoint(newstartpoint);
			config.setEndPoint(newendpoint);
			config.setShapeType(selectedShape.getShapeType());
			config.setShadingType(selectedShape.getShadingType());
			config.setPrimaryColor(selectedShape.getPrimaryColor());
			config.setSecondaryColor(selectedShape.getSecondaryColor());

			shape = factory.createShape(config);
			temp.add(shape);
			clipboard.add(shape);
			
		}
		System.out.print("The shapelist you have now is: " +list.getShapeList() + "\n");
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(IShape shape: temp) {
			
			clipboard.delete(shape);	
		}
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(IShape shape: temp) {
			
		clipboard.add(shape);}
	}
}
