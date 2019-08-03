package model;

import java.util.ArrayList;

import controller.IShape;
import model.interfaces.IShapeListObserver;
import model.interfaces.IShapeListSubject;




public class ShapeList implements IShapeListSubject{
	public ArrayList<IShape> internalShapesList;
	public ArrayList<IShapeListObserver> observers;
	public ArrayList<IShape> SelectList;
	public ArrayList<IShape> clipboard;
	public ShapeList(){//ShapesDrawer drawer
		//this.drawer = drawer;
		internalShapesList = new ArrayList<IShape>();
		observers = new ArrayList<IShapeListObserver>();
		SelectList = new ArrayList<IShape>();
		clipboard = new ArrayList<IShape>();
	}

		@Override
		public void add(IShape shape) {
			// TODO Auto-generated method stub
			internalShapesList.add(shape);
			notifyObserver();
			//drawer.draw(this);
		}
		@Override
		public void remove(IShape shape) {
			// TODO Auto-generated method stub
			internalShapesList.remove(shape);
		}
		@Override
		public ArrayList<IShape> getShapeList() {
			// TODO Auto-generated method stub
			return internalShapesList;
		}
		@Override
		public void registerObserver(IShapeListObserver observer) {
			// TODO Auto-generated method stub
			observers.add(observer);
		}
		@Override
		public void unsubscribe(IShapeListObserver paintCanvas) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void notifyObserver() {
			// TODO Auto-generated method stub
			for(IShapeListObserver o: observers) {
				//System.out.print(o);
				o.update(this);
			}
		}
		@Override
		public void addSelectedList(IShape shapes) {
			// TODO Auto-generated method stub
			SelectList.add(shapes);
		}
		@Override
		public ArrayList<IShape> getSelectedShapesList() {
			// TODO Auto-generated method stub
			return SelectList;
		}
		@Override
		public void removeSelectedList() {
			// TODO Auto-generated method stub
			SelectList.removeAll(SelectList);
		}
		@Override
		public void clearSelectedShapeList() {
			// TODO Auto-generated method stub
			SelectList.clear();
		}
		public void addClipboard(IShape shape) {
			clipboard.add(shape);
			
		}
		public ArrayList<IShape> getCliboard() {
			return clipboard;
			
		}


		
}
