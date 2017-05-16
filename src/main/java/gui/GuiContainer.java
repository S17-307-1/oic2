package gui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Color;

public abstract class GuiContainer implements GuiComponent {
  protected List<GuiComponent> components = new LinkedList<>();
  protected String id;
  protected GuiComponent parent;
  protected Point2D location;
  protected Point2D origin;
  protected boolean isHidden = false;

  public GuiContainer(String id) {
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

  public void addComponent(GuiComponent other) {
    components.add(other);
    other.setParent(this);
  }

  public void removeComponent(String otherId) {
    for (GuiComponent component : components) {
      if (component.getId().equals(otherId)) {
        components.remove(component);
        break;
      }
    }
    if (parent != null) {
      parent.stateChanged();
    }
  }

  public GuiComponent getComponentById(String otherId) {
    for (GuiComponent component : components) {
      if (component.getId().equals(otherId)) {
        return component;
      }
    }
    return null;
  }

  public void shift(int deltaX, int deltaY) {
    for (GuiComponent component : components) {
      component.shift(deltaX, deltaY);
    }
  }

  public void restoreOrigin() {
    for (GuiComponent component : components) {
      component.restoreOrigin();
    }
  }

  public void setValue(String value) {}

  public void setColor(Color color) {}

  public void clear() {
    components.clear();
    if (parent != null) {
      parent.stateChanged();
    }
  }

  @Override
  public boolean renderLast() {
    return false;
  }

  @Override
  public Rectangle2D getBoundingBox() {
    Rectangle2D box = new Rectangle2D.Double(location.getX(), location.getY(), 0.0, 0.0);
    Rectangle2D temp;
    double farX = 0;
    double farY = 0;

    for (GuiComponent component : components) {
      // adjust box to contain both old and new box
      temp = component.getBoundingBox();
      farX = Math.max(farX, temp.getWidth() + temp.getX());
      farY = Math.max(farY, temp.getHeight() + temp.getY());

      box = new Rectangle2D.Double(Math.min(box.getX(), temp.getX()),
          Math.min(box.getY(), temp.getY()), farX, farY);
    }
    return new Rectangle2D.Double(box.getX(), box.getY(), box.getWidth() - box.getX(),
        box.getHeight() - box.getY());
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
      return new Point2D.Double(location.getX(), location.getY());
    }
    Point2D temp = parent.getRelativeShift();
    return new Point2D.Double(temp.getX() + location.getX(), temp.getY() + location.getY());
  }

  @Override
  public void hide() {
    isHidden = true;
    for (GuiComponent component : components) {
      component.hide();
    }
  }

  @Override
  public void show() {
    isHidden = false;
    for (GuiComponent component : components) {
      component.show();
    }
  }

  @Override
  public boolean isHidden() {
    return isHidden;
  }
}
