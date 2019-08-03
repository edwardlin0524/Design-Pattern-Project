package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseHandler;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;
import java.awt.*;



public class Main {
    public static void main(String[] args){
        
		PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        
        //appState represents the state of this application, i.e. the options that user has chosen
        ApplicationState appState = new ApplicationState(uiModule);

        
        //initiate the list
        ShapeList list = new ShapeList();
        IJPaintController controller = new JPaintController(uiModule, appState,list,paintCanvas);
        //Make cursor show on the screen
        paintCanvas.setCursor((new Cursor(Cursor.HAND_CURSOR)));
        
        MouseHandler mouseHandler = new MouseHandler(paintCanvas,appState,list);
        mouseHandler.update();
        controller.setup();
    }

}

