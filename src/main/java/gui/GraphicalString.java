package gui;

import java.awt.Font;
import java.awt.geom.Point2D;

import main.OperationIceCream;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class GraphicalString extends GuiElement {
  public static final int ALIGN_CENTER = -1;
  public static final String DEFAULT_FONT = "Verdana";
  public static final int FONTSIZE_HEADER = 32;
  public static final int FONTSIZE_NORMAL = 24;
  
  private String content;
  private Point2D location;
  private Color color = Color.white;
  private TrueTypeFont font;

  public GraphicalString(String id, String content, int x, int y, String fontName, int fontSize) {
    super(id);
    this.content = content;
    location = new Point2D.Double(x, y);
    origin = new Point2D.Double(x, y);
    
    font = new TrueTypeFont(new Font(fontName, Font.BOLD, fontSize), true);
    
    if (x == ALIGN_CENTER) {
      this.location.setLocation(
          (OperationIceCream.WINDOW_SIZE_X - font.getWidth(content)) / 2.0, y);
    }
  }

  @Override
  public void setValue(String content) {
    this.content = content;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }
  
  @Override
  public void shift(int deltaX, int deltaY) {
    location.setLocation(location.getX() + deltaX, location.getY() + deltaY);
  }

  @Override
  public void render(Graphics graphics) {
    Color saveColor = graphics.getColor();
    org.newdawn.slick.Font saveFont = graphics.getFont();
    graphics.setColor(color);
    graphics.setFont(font);
    graphics.drawString(content, (float)location.getX(), (float)location.getY());
    graphics.setColor(saveColor);
    graphics.setFont(saveFont);
  }

  @Override
  public void restoreOrigin() {
    location.setLocation(origin.getX(), origin.getY());
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
  }

}
