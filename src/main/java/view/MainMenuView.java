package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class MainMenuView extends View {
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
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAME_MODE_SELECT);
    });
    options.addComponent(tempButton);
    
    tempButton = new Button("btn-2", "SETTINGS", 0,
        (int) (options.getBoundingBox().getHeight() + 10), 250);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAMEPLAY_SETTINGS);
    });
    options.addComponent(tempButton);
    
    tempButton = new Button("btn-3", "LEADERBOARDS", 0,
        (int) (options.getBoundingBox().getHeight() + 10), 250);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.LEADERBOARDS);
    });
    options.addComponent(tempButton);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 500);
    scene.addComponent(options);
  }

}
