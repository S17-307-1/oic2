package gui;

import java.awt.geom.Point2D;

import org.newdawn.slick.Color;

public abstract class GuiElement implements GuiComponent {
  protected Point2D location;
  protected Point2D origin;
  protected String id;
  protected GuiComponent parent;
  protected boolean isHidden = false;

  GuiElement(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public void setParent(GuiComponent parent) {
    this.parent = parent;
    if (parent != null) {
      parent.stateChanged();
    }
  }

  // You cannot add elements to an element
  public void addComponent(GuiComponent other) {}

  public void removeComponent(String otherId) {}

  public GuiComponent getComponentById(String otherId) {
    return null;
  }

  public void clear() {}

  @Override
  public boolean renderLast() {
    return false;
  }

  @Override
  public void stateChanged() {
    if (parent != null) {
      parent.stateChanged();
    }
  }

  @Override
  public Point2D getRelativeShift() {
    if (parent == null) {
      return new Point2D.Double(0.0, 0.0);
    }
    return parent.getRelativeShift();
  }

  @Override
  public void hide() {
    isHidden = true;
  }

  @Override
  public void show() {
    isHidden = false;
  }

  @Override
  public boolean isHidden() {
    return isHidden;
  }
  
  @Override
  public void setValue(String value) {
    //by default, no action
  }

  @Override
  public void setColor(Color color) {
    //by default, no action
  }
}
