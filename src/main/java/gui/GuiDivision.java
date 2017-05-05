package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GuiDivision extends GuiContainer {

  public GuiDivision(String id) {
    super(id);
  }
  
  @Override
  public void render(Graphics graphics) {
    for (GuiComponent component : components) {
      component.render(graphics);
    }
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
    for (GuiComponent component : components) {
      component.update(input, isLeftMousePressed);
    }
  }

}
