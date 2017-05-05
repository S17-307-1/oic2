package view;

import gui.GuiDivision;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/*
 * This class is to stay as separate from Slick2D as possible and to
 * facilitate MVC design
 */
public abstract class View {
  StateBasedGame stateBasedGame;
  GameContainer gamecontainer;
  
  GuiDivision scene = new GuiDivision("default-scene");
  
  public void init(GameContainer gamecontainer, StateBasedGame stateBasedGame) {
    this.stateBasedGame = stateBasedGame;
    this.gamecontainer = gamecontainer;
    
    initContinue();
  }
  
  abstract void initContinue();
  
  public void render(Graphics graphics) {
    scene.render(graphics);
  }
  
  /*
   * We send left mouse presses due to past issues where you
   * can only call input.isMousePressed(...) once
   */
  public void update(Input input, boolean isLeftMousePressed) {
    scene.update(input, isLeftMousePressed);
  }
}
