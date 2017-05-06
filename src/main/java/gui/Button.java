package gui;

import java.awt.geom.Point2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.gui.MouseOverArea;

public class Button extends GuiElement {
  private static Image NULL_IMAGE = null;
  private static final int MARGIN_X = 10;
  private static final int MARGIN_Y = 10;
  private static final float BORDER_WIDTH = 4f;
  public static final float DEFAULT_CURVE = 10f;
  
  private MouseOverArea clickableArea;
  private VoidLambdaNoArgs clickEvent;
  private ButtonGroupRadio buttonGroupRadio = null;
  private Image defaultImage;
  private Image activeImage;
  private boolean isHidden = false;
  private GameContainer gamecontainer;
  private GraphicalString label;
  private RoundedRectangle border = null;
  private Color borderColor = Color.black;

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
  
  public Button(String id, String label, TrueTypeFont font, Point2D location, float cornerRadius, 
      Color borderColor, Color color, GameContainer gamecontainer) {
    super(id);
    int labelX = (int) location.getX() + MARGIN_X;
    int labelY = (int) location.getY() + MARGIN_Y;
    this.label = new GraphicalString("", label, labelX, labelY, font);
    this.label.setColor(color);
    this.borderColor = borderColor;
    
    border = new RoundedRectangle((float) location.getX(), (float) location.getY(),
        (float) (font.getWidth(label) + 2 * MARGIN_X), 
        (float) (font.getHeight() + 2 * MARGIN_Y), cornerRadius, 15);
    
    clickableArea = new MouseOverArea(gamecontainer, nullImage(), border);
  }
  
  private Image nullImage() {
    if (NULL_IMAGE == null) {
      try {
        NULL_IMAGE = new Image("res/invisible.png");
      } catch (SlickException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    return NULL_IMAGE;
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
  
  private void drawBorder(Graphics graphics) {
    final Color saveColor = graphics.getColor();
    final float saveLineWidth = graphics.getLineWidth();
    graphics.setColor(borderColor);
    graphics.setLineWidth(BORDER_WIDTH);
    graphics.draw(border);
    graphics.setColor(saveColor);
    graphics.setLineWidth(saveLineWidth);
  }

  @Override
  public void render(Graphics graphics) {
    if (!isHidden) {
      clickableArea.render(gamecontainer, graphics);
      if (border != null) {
        drawBorder(graphics);
        label.render(graphics);
      }
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
