package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class FreePlayConfigureView extends View {
  
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Free Play", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    Button tempButton = new Button("back-btn", "res/back.png", null, 10, 10);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAME_MODE_SELECT);
    });
    titleBar.addComponent(tempButton);
    scene.addComponent(titleBar);
    
    GuiDivision options = new GuiDivision("options");

    tempButton = new Button("btn-1", "PLAY", 0, 0, 250);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.IN_GAME);
    });
    options.addComponent(tempButton);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 500);
    scene.addComponent(options);
  }

}
