package gui;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Color;

public abstract class GuiContainer implements GuiComponent {
  protected List<GuiComponent> components = new LinkedList<>();
  protected String id;
  
  public GuiContainer(String id) {
    this.id = id;
  }
  
  public String getId() {
    return id;
  }
  
  public void addComponent(GuiComponent other) {
    components.add(other);
  }
  
  public void removeComponent(String otherId) {
    for (GuiComponent component : components) {
      if (component.getId().equals(otherId)) {
        components.remove(component);
        break;
      }
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
  
  public void setValue(String value) {
  }
  
  public void setColor(Color color) {
  }
  
  public void clear() {
    components.clear();
  }

  @Override
  public boolean renderLast() {
    // TODO Auto-generated method stub
    return false;
  }
}
