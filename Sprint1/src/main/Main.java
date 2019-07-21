package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseHandler;
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
        //appState represents the state of this application, ex:choose mode
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        
        //Make cursor show on the screen
        paintCanvas.setCursor((new Cursor(Cursor.HAND_CURSOR)));
        
       MouseHandler mouseHandler = new MouseHandler(paintCanvas,appState);
        mouseHandler.update();
        //paintCanvas.addMouseListener(mouseHandler);
        //System.out.println(appState.getActiveStartAndEndPointMode());
        controller.setup();
        
    }

}

