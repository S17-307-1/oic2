package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class MainMenuView extends View {
  
  public MainMenuView() {
  }

  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Operation Ice-Cream", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);
    scene.addComponent(titleBar);
    
    GuiDivision options = new GuiDivision("options");
    Button tempButton = new Button("btn-1", "PLAY", 0, 0, 250);
    options.addComponent(tempButton);
    tempButton = new Button("btn-1", "SETTINGS", 0,
        (int) (options.getBoundingBox().getHeight() + 10), 250);
    options.addComponent(tempButton);
    tempButton = new Button("btn-1", "LEADERBOARDS", 0,
        (int) (options.getBoundingBox().getHeight() + 10), 250);
    options.addComponent(tempButton);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 500);
    scene.addComponent(options);
  }

}
