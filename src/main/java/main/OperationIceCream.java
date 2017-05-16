package main;

import org.apache.log4j.PropertyConfigurator;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import screen.*;

public class OperationIceCream extends StateBasedGame {
	public static final String GAME_NAME = "Operation Ice Cream";
	public static final int MAIN_MENU = 0;
	public static final int AUDIO_SETTINGS = 1;
	public static final int CAMPAIGN_CONFIG = 2;
	public static final int CHARACTER_CUST = 3;
	public static final int CONTROL_SETTINGS = 4;
	public static final int FREEPLAY_CONFIG = 5;
	public static final int GAME_MODE_SELECT = 6;
	public static final int IN_GAME = 7;
	public static final int LEADERBOARDS = 8;
	public static final int MULTIPLAYER_CONFIG = 9;
	public static final int PAUSED = 10;
	public static final int POST_GAME_STATS = 11;
	public static final int VIDEO_SETTINGS = 12;
	public static final int GAMEPLAY_SETTINGS = 13;

	public static final int WINDOW_SIZE_X = 1600;
	public static final int WINDOW_SIZE_Y = 900;

	public OperationIceCream(String name) {
		super(name);
		addState(new AudioSettings());
		addState(new CampaignConfigure());
		addState(new CharacterCustomization());
		addState(new ControlSettings());
		addState(new FreePlayConfigure());
		addState(new GameModeSelect());
		addState(new GameplaySettings());
		addState(new InGame());
		addState(new Leaderboards());
		addState(new MainMenu());
		addState(new MultiplayerConfigure());
		addState(new Paused());
		addState(new PostGameStatistics());
		addState(new VideoSettings());
	}

	private static void configureLogger() {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public static void main(String[] args) {
		configureLogger();
		AppGameContainer appGameContainer;
		try {
			appGameContainer = new AppGameContainer(new OperationIceCream(GAME_NAME));
			appGameContainer.setDisplayMode(WINDOW_SIZE_X, WINDOW_SIZE_Y, false);
			appGameContainer.setTargetFrameRate(60);
			appGameContainer.setShowFPS(false);
			appGameContainer.start();

		} catch (SlickException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		enterState(FREEPLAY_CONFIG);
	}
}
