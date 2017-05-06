package view;

import gui.GraphicalString;
import gui.GuiDivision;

public class GameplaySettingsView extends View {
  public GameplaySettingsView() {
    scene = new GuiDivision("gameplay-settings-view");
  }

  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    titleBar.addComponent(new GraphicalString("title", "Gameplay Settings", 
        GraphicalString.ALIGN_CENTER, 20, 
        GraphicalString.HEADER_FONT));
    scene.addComponent(titleBar);
  }
}
