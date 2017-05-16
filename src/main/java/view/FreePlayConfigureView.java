package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import game.World;
import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class FreePlayConfigureView extends View {
  private World world = new World();

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
  }

  @Override
  public void update(int delta) {
    world.update(delta);

  }

  @Override
  public void render(Graphics graphics) {
    graphics.setBackground(Color.white);
    scene.render(graphics);
    world.render(graphics);
  }
}
