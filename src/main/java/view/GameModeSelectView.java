package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class GameModeSelectView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Game Mode Select", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    Button tempButton = new Button("back-btn", "res/back.png", null, 10, 10);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.MAIN_MENU);
    });
    titleBar.addComponent(tempButton);
    scene.addComponent(titleBar);

    GuiDivision options = new GuiDivision("options");

    tempButton = new Button("btn-1", "CAMPAIGN", 0, 0, 250);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.CAMPAIGN_CONFIG);
    });
    options.addComponent(tempButton);

    tempButton =
        new Button("btn-2", "FREE PLAY", 0, (int) (options.getBoundingBox().getHeight() + 10), 250);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.FREEPLAY_CONFIG);
    });
    options.addComponent(tempButton);

    tempButton = new Button("btn-3", "MULTIPLAYER", 0,
        (int) (options.getBoundingBox().getHeight() + 10), 250);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.MULTIPLAYER_CONFIG);
    });
    options.addComponent(tempButton);

    tempButton =
        new Button("btn-4", "TUTORIAL", 0, (int) (options.getBoundingBox().getHeight() + 10), 250);
    tempButton.setClickEvent(() -> {
      // TODO set up tutorial game
      stateBasedGame.enterState(OperationIceCream.IN_GAME);
    });
    options.addComponent(tempButton);

    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 500);
    scene.addComponent(options);
  }
}
