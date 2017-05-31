package gui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Carousel extends GuiElement {
  private static final Logger LOGGER = Logger.getLogger(Carousel.class.getName());
  
  public static final int HEIGHT = 40;
  
  private static Image leftArrow = null;
  private static Image rightArrow = null;
  
  Button decreaseBtn;
  Button increaseBtn;
  GuiString label;
  int shiftedLabelX = 0;
  GuiDivision scene = new GuiDivision("carousel-scene");
  int totalWidth;
  
  String[] options = null;
  
  int rangeFrom;
  int rangeTo;
  int increment;
  String suffix;
  
  int current; //for options, this is the index
  
  //width is the space inside the arrows
  public Carousel(String id, String[] options, int coordX, int coordY, int width) {
    super(id);
    genericConstructor(coordX, coordY, width);
    this.options = options;
    this.current = 0;
    shiftCurrent(true);
    shiftCurrent(false);
  }
  
  public Carousel(int rangeFrom, int rangeTo, int increment, String suffix, 
      int coordX, int coordY, int width) {
    super("");
    genericConstructor(coordX, coordY, width);
    this.rangeFrom = rangeFrom;
    this.rangeTo = rangeTo;
    this.increment = increment;
    this.current = rangeFrom;
    this.suffix = suffix;
    shiftCurrent(true);
    shiftCurrent(false);
  }
  
  private void genericConstructor(int coordX, int coordY, int width) {
    loadImages();
    location = new Point2D.Double(coordX, coordY);
    origin = new Point2D.Double(coordX, coordY);
    
    Shape tempMouseArea = new Rectangle(coordX, coordY, 
        leftArrow.getWidth(), leftArrow.getHeight());
    decreaseBtn = new Button("", tempMouseArea, leftArrow, leftArrow);
    decreaseBtn.setClickEvent(() -> shiftCurrent(false));
    
    tempMouseArea = new Rectangle(coordX + leftArrow.getWidth() + width, coordY, 
        rightArrow.getWidth(), rightArrow.getHeight());
    increaseBtn = new Button("", tempMouseArea, rightArrow, rightArrow);
    increaseBtn.setClickEvent(() -> shiftCurrent(true));
    
    totalWidth = width + 2 * leftArrow.getWidth();
    label = new GuiString("", "", 0, 0);
    label.shift(0, 
        (int) ((leftArrow.getHeight() - label.getBoundingBox().getHeight()) / 2.0));
    
    scene.addComponent(decreaseBtn);
    scene.addComponent(increaseBtn);
    scene.addComponent(label);
  }
  
  private static void loadImages() {
    if (leftArrow == null || rightArrow == null) {
      try {
        leftArrow = new Image("res/arrow-left.png");
        rightArrow = new Image("res/arrow-right.png");
      } catch (SlickException e) {
        LOGGER.log(Level.FATAL, e.toString(), e);
      }
    }
  }
  
  private void shiftCurrentInteger(boolean isIncrement) {
    if (isIncrement) {
      current += increment;
      if (current > rangeTo) {
        current = rangeFrom;
      }
    } else {
      current -= increment;
      if (current < rangeFrom) {
        current = rangeTo;
      }
    }
  }
  
  private void shiftCurrentString(boolean isIncrement) {
    if (isIncrement) {
      current += 1;
      if (current >= options.length) {
        current = 0;
      }
    } else {
      current -= 1;
      if (current < 0) {
        current = options.length - 1;
      }
    }
  }
  
  public void shiftCurrent(boolean isIncrement) {
    if (options == null) {
      shiftCurrentInteger(isIncrement);
      label.setValue(current + suffix);
    } else {
      shiftCurrentString(isIncrement);
      label.setValue(options[current]);
    }
    label.shift(-shiftedLabelX, 0);
    shiftedLabelX = (int) ((totalWidth - label.getBoundingBox().getWidth()) / 2.0);
    label.shift(shiftedLabelX, 0);
  }

  @Override
  public void shift(int deltaX, int deltaY) {
    location.setLocation(location.getX() + deltaX, location.getY() + deltaY);
    scene.shift(deltaX, deltaY);
  }

  @Override
  public void restoreOrigin() {
    location.setLocation(origin.getX(), origin.getY());
  }

  @Override
  public void render(Graphics graphics) {
    scene.render(graphics);
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
    scene.update(input, isLeftMousePressed);
  }

  @Override
  public Rectangle2D getBoundingBox() {
    return scene.getBoundingBox();
  }

}
