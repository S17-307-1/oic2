package view;

import gui.GraphicalString;
import gui.GuiDivision;

public class MainMenuView extends View {
  
  public MainMenuView() {
    scene = new GuiDivision("main-menu-view");
  }

  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    titleBar.addComponent(new GraphicalString("title", "Main Menu", 
        GraphicalString.ALIGN_CENTER, 20, 
        GraphicalString.DEFAULT_FONT, GraphicalString.FONTSIZE_HEADER));
    scene.addComponent(titleBar);
  }

}
