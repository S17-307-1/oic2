package gui;

import java.awt.geom.Point2D;

public abstract class GuiElement implements GuiComponent {
  protected Point2D origin;
  protected String id;
  
  GuiElement(String id) {
    this.id = id;
  }
  
  public String getId() {
    return id;
  }
  
  // You cannot add elements to an element
  public void addComponent(GuiComponent other) {
  }
  
  public void removeComponent(String otherId) {
  }
  
  public GuiComponent getComponentById(String otherId) {
    return null;
  }
  
  public void clear() {
  }
  

  @Override
  public boolean renderLast() {
    // TODO Auto-generated method stub
    return false;
  }
}
