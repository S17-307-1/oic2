package gui;

import java.awt.geom.Point2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.gui.MouseOverArea;

public class Button extends GuiElement {
  private MouseOverArea clickableArea;
  private VoidLambdaNoArgs clickEvent;
  private ButtonGroupRadio buttonGroupRadio = null;
  private Image defaultImage;
  private Image activeImage;
  private boolean isHidden = false;
  private GameContainer gamecontainer;

  public Button(String id, MouseOverArea clickableArea, Image defaultImage, Image activeImage, 
      GameContainer gamecontainer) {
    super(id);
    this.clickableArea = clickableArea;
    this.defaultImage = defaultImage;
    clickableArea.setNormalImage(defaultImage);
    clickableArea.setMouseOverImage(defaultImage);
    this.activeImage = activeImage;
    this.gamecontainer = gamecontainer;
    origin = new Point2D.Double(clickableArea.getX(), clickableArea.getY());
  }
  
  public void addToRadioGroup(ButtonGroupRadio buttonGroupRadio) {
    this.buttonGroupRadio = buttonGroupRadio;
    buttonGroupRadio.addButton(this);
  }

  public void setClickEvent(VoidLambdaNoArgs clickEvent) {
    this.clickEvent = clickEvent;
  }

  private boolean isClicked() {
    if (isHidden) {
      return false;
    }
    return clickableArea.isMouseOver();
  }

  private void callClickEvent() {
    if (!isHidden) {
      clickEvent.fn();
      activate();
    }
  }

  public void activate() {
    if (buttonGroupRadio != null) {
      buttonGroupRadio.deselectButtons();
    }
    clickableArea.setNormalImage(activeImage);
    clickableArea.setMouseOverImage(activeImage);
  }

  void deactivate() {
    clickableArea.setNormalImage(defaultImage);
    clickableArea.setMouseOverImage(defaultImage);
  }

  void setIsHidden(boolean isHidden) {
    this.isHidden = isHidden;
  }

  @Override
  public void render(Graphics graphics) {
    if (!isHidden) {
      clickableArea.render(gamecontainer, graphics);
    }
  }
  
  @Override
  public void shift(int deltaX, int deltaY) {
    int x = clickableArea.getX();
    int y = clickableArea.getY();
    clickableArea.setLocation(x + deltaX, y + deltaY);
  }

  @Override
  public void restoreOrigin() {
    clickableArea.setLocation((float)origin.getX(), (float)origin.getY());
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
    if (isLeftMousePressed) {
      if (isClicked()) {
        callClickEvent();
      }
    }
  }

  @Override
  public void setValue(String value) {
  }

  @Override
  public void setColor(Color color) {
  }
}
