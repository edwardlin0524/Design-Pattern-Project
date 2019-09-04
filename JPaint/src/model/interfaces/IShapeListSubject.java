package model.interfaces;

import java.util.ArrayList;

import interfaces.IShape;


public interface IShapeListSubject {
    void add(IShape shape);

	void delete(IShape shape);

    ArrayList<IShape> getShapeList();

    void notifyObserver();

    void addSelectedList(IShape shapes);

    ArrayList<IShape> getSelectedShapesList();

    void removeSelectedList();

    void clearSelectedShapeList();

	void registerObserver(IShapeListObserver observer);



}
