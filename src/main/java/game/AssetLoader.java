package game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AssetLoader {
	private static Image player;
	
	public enum AssetName {
		PLAYER
	}
	
	public static void loadAssets() {
		try {
			player = new Image("/res/player/manOld_gun.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Image getAsset(AssetName name) {
		if (name == AssetName.PLAYER) {
			return player;
		}
		return null;
	}
}
