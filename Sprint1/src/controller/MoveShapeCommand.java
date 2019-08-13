package controller;

import model.ShapeConfig;
import model.ShapeList;

public class MoveShapeCommand implements ICommand {
	private ShapeList list;
	private ShapeConfig config = new ShapeConfig();
	
	
	MoveShapeCommand(ShapeList SelectList, ShapeList list, ShapeConfig config)
	{
		this.config = config;
		this.list = list;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int dx = config.getEndPoint().getX() - config.getStartPoint().getX();
        int dy = config.getEndPoint().getY() - config.getStartPoint().getY();
      
        for(IShape selected:list.getSelectedShapesList()) {
        	list.delete(selected);
            selected.addX(dx);
            selected.addY(dy);
            list.add(selected);
            
        }
        
	}

}
