package controller;

import java.awt.event.MouseAdapter;

public interface IMouseSubject {
	
	void registerObserver(MouseAdapter mouseEvent);
	void removeObserver(MouseAdapter mouseEvent);
	
	void notifyObserver();
}
