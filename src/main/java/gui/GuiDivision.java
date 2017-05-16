package gui;

import java.awt.geom.Point2D;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GuiDivision extends GuiContainer {

  public GuiDivision(String id) {
    super(id);
    location = new Point2D.Double(0.0, 0.0);
    origin = new Point2D.Double(0.0, 0.0);
  }

  @Override
  public void render(Graphics graphics) {
    if (!isHidden) {
      for (GuiComponent component : components) {
        component.render(graphics);
      }
    }
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
    if (!isHidden) {
      for (GuiComponent component : components) {
        component.update(input, isLeftMousePressed);
      }
    }
  }

}
