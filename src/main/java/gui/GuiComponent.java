package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public interface GuiComponent {
  
  public String getId();

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
}
