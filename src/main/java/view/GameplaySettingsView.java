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
        GraphicalString.DEFAULT_FONT, GraphicalString.FONTSIZE_HEADER));
    scene.addComponent(titleBar);
  }
}
