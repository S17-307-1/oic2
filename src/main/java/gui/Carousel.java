package gui;

import java.awt.geom.Rectangle2D;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Carousel extends GuiElement {
  private static final Logger LOGGER = Logger.getLogger(Carousel.class.getName());
  
  private static Image leftArrow = null;
  private static Image rightArrow = null;
  
  Button decreaseBtn;
  Button increaseBtn;
  GuiString label;
  GuiDivision scene = new GuiDivision("carousel-scene");
  
  String[] options = null;
  
  int rangeFrom;
  int rangeTo;
  int increment;
  
  int current; //for options, this is the index
  
  //width is the space inside the arrows
  Carousel(String id, String[] options, int coordX, int coordY, int width) {
    super(id);
    loadImages();
    
    Shape tempMouseArea = new Rectangle(coordX, coordY, 
        leftArrow.getWidth(), leftArrow.getHeight());
    decreaseBtn = new Button("", tempMouseArea, leftArrow, leftArrow);
    
    tempMouseArea = new Rectangle(coordX + leftArrow.getWidth() + width, coordY, 
        rightArrow.getWidth(), rightArrow.getHeight());
    increaseBtn = new Button("", tempMouseArea, rightArrow, rightArrow);
    
    int totalWidth = width + 2 * leftArrow.getWidth();
    label = new GuiString("", options[0], 0, 0);
    label.shift((int) ((totalWidth - label.getBoundingBox().getWidth()) / 2.0), 
        (int) ((leftArrow.getHeight() - label.getBoundingBox().getHeight()) / 2.0));
    
    scene.addComponent(decreaseBtn);
    scene.addComponent(increaseBtn);
    scene.addComponent(label);
  }
  
  Carousel(String id, int rangeFrom, int rangeTo, int increment, String suffix, 
      int coordX, int coordY, int width) {
    super(id);
    loadImages();
    
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
  public void setValue(String value) {
  }

  @Override
  public void setColor(Color color) {
  }

  @Override
  public Rectangle2D getBoundingBox() {
    return scene.getBoundingBox();
  }

}
