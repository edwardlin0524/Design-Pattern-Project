package model.interfaces;

import model.Point;
import model.ShapeColor;
import controller.IMouseObserver;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;


public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    void registerObserver(IMouseObserver o);

    void notifyObservers();
}
