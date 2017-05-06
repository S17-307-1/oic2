package view;

import gui.Button;
import gui.GraphicalString;
import gui.GuiDivision;

import java.awt.geom.Point2D;

import org.newdawn.slick.Color;

public class MainMenuView extends View {
  
  public MainMenuView() {
    scene = new GuiDivision("main-menu-view");
  }

  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    titleBar.addComponent(new GraphicalString("title", "Main Menu", 
        GraphicalString.ALIGN_CENTER, 20, 
        GraphicalString.HEADER_FONT));
    scene.addComponent(titleBar);
    
    GuiDivision options = new GuiDivision("options");
    options.addComponent(new Button("sample-button", "SAMPLE BUTTON", 
        GraphicalString.BUTTON_FONT, new Point2D.Double(100, 100), Button.DEFAULT_CURVE, 
        Color.darkGray, Color.darkGray, gamecontainer));
    options.addComponent(new Button("sample-button2", "BUTTON2", 
        GraphicalString.DEFAULT_FONT, new Point2D.Double(100, 160), Button.DEFAULT_CURVE, 
        Color.darkGray, Color.darkGray, gamecontainer));
    scene.addComponent(options);
  }

}
