package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiImage;
import main.OperationIceCream;

public class GameModeSelectView extends View {
  @Override
  void initContinue() {
    initTitleBar("Game Mode Select");

    GuiImage tempImage = new GuiImage("single-player", "res/single-player.png", 0, 0);
    Button tempButton = new Button("btn-1", "CAMPAIGN", 
        (int) (tempImage.getBoundingBox().getWidth() + 10), 0, 250, false);
    tempButton.shift(0, (int) ((tempImage.getBoundingBox().getHeight() 
        - tempButton.getBoundingBox().getHeight()) / 2.0));
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.CAMPAIGN_CONFIG);
    });
    GuiDivision tempRow = new GuiDivision("row");
    tempRow.addComponent(tempImage);
    tempRow.addComponent(tempButton);
    
    GuiDivision options = new GuiDivision("options");
    options.addComponent(tempRow);

    tempImage = new GuiImage("single-player", "res/single-player.png", 0, 0);
    tempButton = new Button("btn-2", "FREEPLAY", 
        (int) (tempImage.getBoundingBox().getWidth() + 10), 0, 250, false);
    tempButton.shift(0, (int) ((tempImage.getBoundingBox().getHeight() 
        - tempButton.getBoundingBox().getHeight()) / 2.0));
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.FREEPLAY_CONFIG);
    });
    tempRow = new GuiDivision("row");
    tempRow.addComponent(tempImage);
    tempRow.addComponent(tempButton);
    tempRow.shift(0, (int) (options.getBoundingBox().getHeight() + 10));
    options.addComponent(tempRow);

    tempImage = new GuiImage("multi-player", "res/multi-player.png", 0, 0);
    tempButton = new Button("btn-2", "MULTIPLAYER", 
        (int) (tempImage.getBoundingBox().getWidth() + 10), 0, 250, false);
    tempButton.shift(0, (int) ((tempImage.getBoundingBox().getHeight() 
        - tempButton.getBoundingBox().getHeight()) / 2.0));
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.MULTIPLAYER_CONFIG);
    });
    tempRow = new GuiDivision("row");
    tempRow.addComponent(tempImage);
    tempRow.addComponent(tempButton);
    tempRow.shift(0, (int) (options.getBoundingBox().getHeight() + 10));
    options.addComponent(tempRow);

    tempImage = new GuiImage("tutorial", "res/tutorial.png", 0, 0);
    tempButton = new Button("btn-2", "TUTORIAL", 
        (int) (tempImage.getBoundingBox().getWidth() + 10), 0, 250, false);
    tempButton.shift(0, (int) ((tempImage.getBoundingBox().getHeight() 
        - tempButton.getBoundingBox().getHeight()) / 2.0));
    tempButton.setClickEvent(() -> {
      //TODO tutorial setup
      stateBasedGame.enterState(OperationIceCream.IN_GAME);
    });
    tempRow = new GuiDivision("row");
    tempRow.addComponent(tempImage);
    tempRow.addComponent(tempButton);
    tempRow.shift(0, (int) (options.getBoundingBox().getHeight() + 10));
    options.addComponent(tempRow);

    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 500);
    scene.addComponent(options);
  }
}
