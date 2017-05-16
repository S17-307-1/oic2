package gui;

import java.awt.Font;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;

public class GuiTextField extends GuiElement {
  public static final TrueTypeFont FONT = new TrueTypeFont(
      new Font("Verdana", Font.BOLD, 20), true);

  TextField textField;
  GameContainer gamecontainer;
  
  public GuiTextField(String id, int x, int y, int w, int h, GameContainer gamecontainer) {
    super(id);
    this.gamecontainer = gamecontainer;
    
    textField = new TextField(gamecontainer, FONT, x, y, w, h);
    textField.setBackgroundColor(Color.darkGray);
    textField.setBorderColor(Color.black);
    textField.setTextColor(Color.lightGray);
    
    location = new Point(textField.getX(), textField.getY());
    origin = new Point(textField.getX(), textField.getY());
  }
  
  @Override
  public void shift(int deltaX, int deltaY) {
    textField.setLocation(textField.getX() + deltaX, textField.getY() + deltaY);
  }

  @Override
  public void restoreOrigin() {
    textField.setLocation((int)origin.getX(), (int)origin.getY());
  }

  @Override
  public void render(Graphics graphics) {
    graphics.setColor(Color.white);
    textField.render(gamecontainer, graphics);
  }

  @Override
  public void update(Input input, boolean isLeftMousePressed) {
  }

  @Override
  public void setValue(String value) {
    textField.setText(value);
  }

  @Override
  public void setColor(Color color) {
  }

  @Override
  public Rectangle2D getBoundingBox() {
    return new Rectangle2D.Double(
        textField.getX(),
        textField.getY(),
        textField.getWidth(),
        textField.getHeight());
  }

  public TextField getTextField() {
    return textField;
  }
  
  @Override
  public void hide() {
    isHidden = true;
    textField.setAcceptingInput(false);
  }
  
  @Override
  public void show() {
    isHidden = false;
    textField.setAcceptingInput(true);
  }

}
