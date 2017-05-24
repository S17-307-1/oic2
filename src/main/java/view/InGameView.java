package view;

import game.World;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class InGameView extends View {
  private World world;

  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Playing Game", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    scene.addComponent(titleBar);
  }

  @Override
  public void update(int delta) {
    if (world == null) {
      world = new World();
    }
    boolean gameOver = world.update(delta);
    if (gameOver) {
      world = null;
      stateBasedGame.enterState(OperationIceCream.MAIN_MENU);
    }
    super.update(delta);
  }

  @Override
  public void render(Graphics graphics) {
    graphics.setBackground(Color.white);
    if (world != null) {
      world.render(graphics);
    }
    scene.render(graphics);
  }
}
