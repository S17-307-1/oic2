package screen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.AssetLoader;
import main.OperationIceCream;
import view.FreePlayConfigureView;
import view.View;

public class FreePlayConfigure extends BasicGameState {

	View view;

	@Override
	public void init(GameContainer gamecontainer, StateBasedGame stateBasedGame) throws SlickException {
		AssetLoader.loadAssets();
		view = new FreePlayConfigureView();
		view.init(gamecontainer, stateBasedGame);
	}

	@Override
	public void render(GameContainer gamecontainer, StateBasedGame stateBasedGame, Graphics graphics)
			throws SlickException {
		view.render(graphics);
	}

	@Override
	public void update(GameContainer gamecontainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
		view.update(delta);
	}

	@Override
	public int getID() {
		return OperationIceCream.FREEPLAY_CONFIG;
	}

}
