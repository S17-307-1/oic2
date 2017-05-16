package screen;

import main.OperationIceCream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.AudioSettingsView;
import view.View;

public class AudioSettings extends BasicGameState {

  View view = new AudioSettingsView();

  @Override
  public void init(GameContainer gamecontainer, StateBasedGame stateBasedGame)
      throws SlickException {
    view.init(gamecontainer, stateBasedGame);
  }

  @Override
  public void render(GameContainer gamecontainer, StateBasedGame stateBasedGame, Graphics graphics)
      throws SlickException {
    view.render(graphics);
  }

  @Override
  public void update(GameContainer gamecontainer, StateBasedGame stateBasedGame, int delta)
      throws SlickException {
    view.update(delta);
  }

  @Override
  public int getID() {
    return OperationIceCream.AUDIO_SETTINGS;
  }

}
