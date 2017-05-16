package gui;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

// One per window (rendering this wipes out all else on screen)
// Exists to allow showing only part of the board and allowing scrolling (fully ui)
public class IFrame extends GuiContainer {
  private static final Logger LOGGER = Logger.getLogger(IFrame.class.getName());

  private Image canvas = null;
  private Graphics canvasGraphics;

  private int shiftedX = 0;
  private int shiftedY = 0;
  private double width;
  private double height;
  private double innerWidth = 0;
  private double innerHeight = 0;

  private Color borderColor;
  private boolean canScrollX = true;
  private boolean canScrollY = true;
  private boolean invertY = false;

  public IFrame(String id, int x, int y, int width, int height, Color backgroundColor) {
    super(id);
    location = new Point2D.Double(x, y);
    origin = new Point2D.Double(x, y);
    this.width = width;
    this.height = height;
    this.borderColor = backgroundColor;
  }

  public void setInvertY(boolean invertY) {
    this.invertY = invertY;
  }

  private Point validateUpdateDelta(int deltaX, int deltaY) {
    int x = deltaX;
    int y = deltaY;

    if (shiftedX + x < width - innerWidth) {
      x = (int) (width - innerWidth - shiftedX);
    }
    if (shiftedX + x > 0) {
      x = 0;
    }

    if (invertY) {
      if (shiftedY + y > innerHeight - height) {
        y = (int) (innerHeight - height - shiftedY);
      }
      if (shiftedY + y < 0) {
        y = 0;
      }
    } else {
      if (shiftedY + y < height - innerHeight) {
        y = (int) (height - innerHeight - shiftedY);
      }
      if (shiftedY + y > 0) {
        y = 0;
      }
    }

    shiftedX += x;
    shiftedY += y;

    return new Point(x, y);
  }

  private Point getUpdateDelta(Input input) {
    int deltaX = 0;
    int deltaY = 0;

    if (input.isKeyDown(Input.KEY_A) && canScrollX) {
      deltaX = 10;
    } else if (input.isKeyDown(Input.KEY_D) && canScrollX) {
      deltaX = -10;
    } else if (input.isKeyDown(Input.KEY_W) && canScrollY) {
      deltaY = 10;
    } else if (input.isKeyDown(Input.KEY_S) && canScrollY) {
      deltaY = -10;
    }

    return validateUpdateDelta(deltaX, deltaY);
  }

  private boolean inBounds(Input input) {
    final int mouseX = input.getMouseX();
    final int mouseY = input.getMouseY();
    if (location.getX() <= mouseX && mouseX <= location.getX() + width && location.getY() <= mouseY
        && mouseY <= location.getY() + width) {
      return true;
    }
    return false;
  }

  @Override
  public void render(Graphics graphics) {
    if (!isHidden) {
      if (canvas == null) {
        try {
          canvas = new Image((int) width, (int) height);
          canvasGraphics = canvas.getGraphics();
          canvasGraphics.setBackground(new Color(0, 0, 0, 0));
        } catch (SlickException e) {
          LOGGER.log(Level.FATAL, e.toString(), e);
        }
      }

      canvasGraphics.clear();
      canvasGraphics.setColor(Color.black);
      canvasGraphics.fillRect(0f, 0f, (float) width, (float) height);

      for (GuiComponent component : components) {
        component.render(canvasGraphics);
      }

      canvasGraphics.flush();

      float coordX = (float) location.getX();
      float coordY = (float) location.getY();

      graphics.drawImage(canvas, coordX, coordY);

      graphics.setColor(borderColor);
      graphics.drawRect(coordX, coordY, (float) width, (float) height);
    }
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
    if (!isHidden) {
      Point delta = getUpdateDelta(input);
      if (delta.x != 0 || delta.y != 0) {
        for (GuiComponent component : components) {
          component.shift(delta.x, delta.y);
        }
      }
      if (inBounds(input)) {
        for (GuiComponent component : components) {
          component.update(input, isLeftMousePressed);
        }
      }
    }
  }

  @Override
  public void stateChanged() {
    Rectangle2D temp = getBoundingBox();
    if (temp != null) {
      innerWidth = temp.getWidth();
      innerHeight = temp.getHeight();
    } else {
      innerWidth = 0;
      innerHeight = 0;
    }

    if (parent != null) {
      parent.stateChanged();
    }
  }

}
