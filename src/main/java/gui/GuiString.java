package gui;

import java.awt.Font;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class GuiString extends GuiElement {
  public static final TrueTypeFont DEFAULT_FONT =
      new TrueTypeFont(new Font("Dialog", Font.PLAIN, 14), true);
  public static final TrueTypeFont HEADER_FONT =
      new TrueTypeFont(new Font("Dialog", Font.BOLD, 32), true);
  public static final TrueTypeFont BUTTON_FONT =
      new TrueTypeFont(new Font("Dialog", Font.BOLD, 28), true);

  private String[] content;
  private Color color = Color.black;
  private double maxWidth;
  private boolean isAligned = false;
  TrueTypeFont font = DEFAULT_FONT;

  public GuiString(String id, String content, int x, int y) {
    super(id);
    this.content = splitIntoLines(content);
    location = new Point2D.Double(x, y);
    origin = new Point2D.Double(x, y);

    maxWidth = getBoundingBox().getWidth();
  }

  public void setFont(TrueTypeFont font) {
    this.font = font;
  }

  public void setIsAligned(boolean isAligned) {
    this.isAligned = isAligned;
  }

  private String[] splitIntoLines(String raw) {
    return raw.split("\\r?\\n");
  }

  @Override
  public void setValue(String content) {
    this.content = splitIntoLines(content);
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public void shift(int deltaX, int deltaY) {
    location.setLocation(location.getX() + deltaX, location.getY() + deltaY);
    if (parent != null) {
      parent.stateChanged();
    }
  }

  @Override
  public void render(Graphics graphics) {
    final Color saveColor = graphics.getColor();

    graphics.setColor(color);
    graphics.setFont(font);

    int lineHeight = font.getLineHeight();
    int line = 0;
    float width;
    for (String str : content) {
      if (isAligned && line > 0) {
        width = font.getWidth(str);
        graphics.drawString(str, (float) (location.getX() + (maxWidth - width)),
            (float) location.getY() + line * lineHeight);
      } else {
        graphics.drawString(str, (float) location.getX(),
            (float) location.getY() + line * lineHeight);
      }
      line += 1;
    }

    graphics.setColor(saveColor);
  }

  @Override
  public void restoreOrigin() {
    location.setLocation(origin.getX(), origin.getY());
    if (parent != null) {
      parent.stateChanged();
    }
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {}

  @Override
  public Rectangle2D getBoundingBox() {
    maxWidth = 0;
    for (String str : content) {
      maxWidth = Math.max(maxWidth, font.getWidth(str));
    }

    return new Rectangle2D.Double(location.getX(), location.getY(), maxWidth,
        font.getHeight() * content.length);
  }

}
