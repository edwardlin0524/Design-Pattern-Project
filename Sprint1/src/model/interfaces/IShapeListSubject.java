package model.interfaces;

import java.util.ArrayList;

import controller.IShape;


public interface IShapeListSubject {
    void add(IShape shape);

    void remove(IShape shape);

    ArrayList<IShape> getShapeList();

    void unsubscribe(IShapeListObserver paintCanvas);

    void notifyObserver();

    void addSelectedList(IShape shapes);

    ArrayList<IShape> getSelectedShapesList();

    void removeSelectedList();

    void clearSelectedShapeList();

	void registerObserver(IShapeListObserver observer);

}
