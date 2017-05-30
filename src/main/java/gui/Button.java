package gui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;

public class Button extends GuiElement {
  private static final Logger LOGGER = Logger.getLogger(Button.class.getName());

  private Shape clickableArea;
  private VoidLambdaNoArgs clickEvent;
  private ButtonGroupRadio buttonGroupRadio = null;
  private Image defaultImage;
  private Image activeImage;
  private Image currentImage;

  public Button(String id, Shape clickableArea, Image defaultImage, Image activeImage) {
    super(id);
    this.clickableArea = clickableArea;
    this.defaultImage = defaultImage;
    this.activeImage = activeImage;
    currentImage = defaultImage;
    location = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
    origin = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
  }

  public void setVisibleLocation(int coordX, int coordY) {
    location = new Point2D.Double(coordX, coordY);
  }

  public Button(String id, String defaultImageName, String activeImageName, int coordX,
      int coordY) {
    super(id);
    try {
      defaultImage = new Image(defaultImageName);
      if (activeImageName == null) {
        activeImage = defaultImage;
      } else {
        activeImage = new Image(activeImageName);
      }
      currentImage = defaultImage;
    } catch (SlickException e) {
      LOGGER.log(Level.FATAL, e.toString(), e);
    }

    clickableArea =
        new Rectangle(coordX, coordY, defaultImage.getWidth(), defaultImage.getHeight());
    location = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
    origin = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
  }

  public Button(String id, String label, int coordX, int coordY, int minWidth, 
      boolean changeActive) {
    super(id);
    int labelWidth = Math.max(GuiString.BUTTON_FONT.getWidth(label), minWidth);
    int labelHeight = GuiString.BUTTON_FONT.getHeight();
    try {
      defaultImage = new Image(labelWidth + 20, labelHeight + 20);
      Graphics graphics = defaultImage.getGraphics();
      graphics.setColor(Color.black);
      graphics.setFont(GuiString.BUTTON_FONT);
      graphics.drawString(label, (float) (labelWidth - GuiString.BUTTON_FONT.getWidth(label) + 20) / 2f, 8f);
      graphics.setLineWidth(4f);
      RoundedRectangle rect = new RoundedRectangle(2, 2, labelWidth + 16, labelHeight + 16, 10f);
      graphics.draw(rect);
      graphics.flush();
      
      activeImage = defaultImage;
      if (changeActive) {
        activeImage = new Image(labelWidth + 20, labelHeight + 20);
        graphics = activeImage.getGraphics();
        graphics.setColor(Color.black);
        graphics.setFont(GuiString.BUTTON_FONT);
        graphics.drawString(label, 
            (float) (labelWidth - GuiString.BUTTON_FONT.getWidth(label) + 20) / 2f, 8f);
        graphics.setLineWidth(8f);
        rect = new RoundedRectangle(4, 4, labelWidth + 12, labelHeight + 12, 10f);
        graphics.draw(rect);
        graphics.flush();
      }
    } catch (SlickException e) {
      LOGGER.log(Level.FATAL, e.toString(), e);
    }
    currentImage = defaultImage;

    clickableArea =
        new Rectangle(coordX, coordY, defaultImage.getWidth(), defaultImage.getHeight());
    location = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
    origin = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
  }

  public void addToRadioGroup(ButtonGroupRadio buttonGroupRadio) {
    this.buttonGroupRadio = buttonGroupRadio;
    buttonGroupRadio.addButton(this);
  }

  public void setClickEvent(VoidLambdaNoArgs clickEvent) {
    this.clickEvent = clickEvent;
  }

  private boolean isClicked(float mouseX, float mouseY) {
    if (isHidden) {
      return false;
    }
    return clickableArea.contains(mouseX, mouseY);
  }

  private void callClickEvent() {
    if (!isHidden && clickEvent != null) {
      clickEvent.fn();
      activate();
    }
  }

  public void activate() {
    if (buttonGroupRadio != null) {
      buttonGroupRadio.deselectButtons();
    }
    currentImage = activeImage;
  }

  void deactivate() {
    currentImage = defaultImage;
  }

  public void setIsHidden(boolean isHidden) {
    this.isHidden = isHidden;
  }

  @Override
  public void render(Graphics graphics) {
    if (!isHidden) {
      graphics.drawImage(currentImage, (float) location.getX(), (float) location.getY());
    }
  }

  @Override
  public void shift(int deltaX, int deltaY) {
    clickableArea.setLocation(clickableArea.getX() + deltaX, clickableArea.getY() + deltaY);
    location.setLocation(clickableArea.getX(), clickableArea.getY());
  }

  @Override
  public void restoreOrigin() {
    clickableArea.setLocation((float) origin.getX(), (float) origin.getY());
    location.setLocation(clickableArea.getX(), clickableArea.getY());
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
    if (isLeftMousePressed) {
      Point2D temp = getRelativeShift();
      if (isClicked((float) (input.getMouseX() - temp.getX()),
          (float) (input.getMouseY() - temp.getY()))) {
        callClickEvent();
      }
    }
  }

  @Override
  public void setValue(String value) {}

  @Override
  public void setColor(Color color) {}

  @Override
  public Rectangle2D getBoundingBox() {
    return new Rectangle2D.Double(clickableArea.getX(), clickableArea.getY(),
        clickableArea.getWidth(), clickableArea.getHeight());
  }
}
