package screen;

import main.OperationIceCream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CharacterCustomization extends BasicGameState {

  @Override
  public void init(GameContainer gamecontainer, StateBasedGame stateBasedGame)
      throws SlickException {

  }

  @Override
  public void render(GameContainer gamecontainer, StateBasedGame stateBasedGame, Graphics graphics)
      throws SlickException {
  }

  @Override
  public void update(GameContainer gamecontainer, StateBasedGame stateBasedGame, int delta)
      throws SlickException {
  }

  @Override
  public int getID() {
    return OperationIceCream.CHARACTER_CUST;
  }

}
