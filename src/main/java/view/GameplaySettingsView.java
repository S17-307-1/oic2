package view;

import gui.GuiDivision;

public class GameplaySettingsView extends View {
  public GameplaySettingsView() {
    scene = new GuiDivision("gameplay-settings-view");
  }

  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    
    scene.addComponent(titleBar);
  }
}
