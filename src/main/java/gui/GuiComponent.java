package gui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public interface GuiComponent {

  public String getId();

  public void setParent(GuiComponent parent);

  public void addComponent(GuiComponent other);

  public void removeComponent(String otherId);

  public GuiComponent getComponentById(String otherId);

  public void shift(int deltaX, int deltaY);

  public void restoreOrigin();

  public void render(Graphics graphics);

  public boolean renderLast();

  public void update(Input input, boolean isLeftMousePressed);

  public void setValue(String value);

  public void setColor(Color color);

  public void clear();

  public void stateChanged();

  public Rectangle2D getBoundingBox();

  public Point2D getRelativeShift();

  public void hide();

  public void show();

  public boolean isHidden();
}
