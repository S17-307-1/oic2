package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiImage;
import gui.GuiString;
import main.OperationIceCream;

public class MainMenuView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Operation Ice-Cream", 0, 50);
    tempString.setFont(GuiString.TITLE_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);
    scene.addComponent(titleBar);

    GuiDivision options = new GuiDivision("options");
    
    GuiImage tempImage  = new GuiImage("left-cone", "res/cone-left.png", 0, 20);

    int tempWidth = (int) (tempImage.getBoundingBox().getWidth() + 20);
    Button tempButton = new Button("btn-1", "PLAY", tempWidth, 0, 250, false);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAME_MODE_SELECT);
    });
    options.addComponent(tempButton);

    tempButton = new Button("btn-2", "SETTINGS", tempWidth, 
            (int) (options.getBoundingBox().getHeight() + 10), 250, false);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAMEPLAY_SETTINGS);
    });
    options.addComponent(tempButton);

    tempButton = new Button("btn-3", "LEADERBOARDS", tempWidth,
        (int) (options.getBoundingBox().getHeight() + 10), 250, false);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.LEADERBOARDS);
    });
    options.addComponent(tempButton);
    
    tempButton = new Button("btn-4", "EXIT", tempWidth,
        (int) (options.getBoundingBox().getHeight() + 10), 250, false);
    tempButton.setClickEvent(() -> {
      gamecontainer.exit();
    });
    options.addComponent(tempButton);
    
    options.addComponent(tempImage);
    tempImage  = new GuiImage("right-cone", "res/cone-right.png", 0, 20);
    tempImage.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(tempImage);

    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 500);
    scene.addComponent(options);
  }

}
