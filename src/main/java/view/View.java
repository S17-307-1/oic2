package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/*
 * This class is to stay as separate from Slick2D as possible and to facilitate MVC design
 */
public abstract class View {
  StateBasedGame stateBasedGame;
  GameContainer gamecontainer;

  GuiDivision scene = new GuiDivision("default-scene");

  public void init(GameContainer gamecontainer, StateBasedGame stateBasedGame) {
    this.stateBasedGame = stateBasedGame;
    this.gamecontainer = gamecontainer;

    initContinue();
  }

  abstract void initContinue();

  public void render(Graphics graphics) {
    graphics.setBackground(Color.white);
    scene.render(graphics);
  }

  public void update(int delta) {
    Input input = gamecontainer.getInput();
    scene.update(input, input.isMousePressed(Input.MOUSE_LEFT_BUTTON));
  }
  
  void initTitleBar(String title) {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", title, 0, 0);
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
  }
  
  private int getEnterState(String name) {
    switch (name) {
      case "control":
        return OperationIceCream.CONTROL_SETTINGS;
      case "audio":
        return OperationIceCream.AUDIO_SETTINGS;
      case "video":
        return OperationIceCream.VIDEO_SETTINGS;
      case "gameplay":
        return OperationIceCream.GAMEPLAY_SETTINGS;
    }
    return 0;
  }
  void initTitleBar(String title, String[] others) {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", title, 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    Button tempButton = new Button("back-btn", "res/back.png", null, 10, 10);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.MAIN_MENU);
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/" + others[0] + "Settings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(getEnterState(others[0]));
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/" + others[1] + "Settings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(getEnterState(others[1]));
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/" + others[2] + "Settings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(getEnterState(others[2]));
    });
    titleBar.addComponent(tempButton);
    scene.addComponent(titleBar);
  }
}
