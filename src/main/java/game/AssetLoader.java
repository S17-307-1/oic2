package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AssetLoader {
  private static Image player;
  private static Image enemy;
  private static Image tile1;
  private static Image tile2;
  private static Image tile3;
  private static Image tile4;
  private static Image tile5;
  private static Image tile6;

  public enum AssetName {
    PLAYER, ENEMY, TILE_1, TILE_2, TILE_3, TILE_4, TILE_5, TILE_6
  }

  public static void loadAssets() {
    try {
      player = new Image("res/player/manOld_gun.png");
    } catch (SlickException e) {
      e.printStackTrace();
    }

    try {
      enemy = new Image("res/enemy/robot1_hold.png");
    } catch (SlickException e) {
      e.printStackTrace();
    }

    try {
      tile1 = new Image("res/tile/tile_01.png");
      tile2 = new Image("res/tile/tile_02.png");
      tile3 = new Image("res/tile/tile_03.png");
      tile4 = new Image("res/tile/tile_04.png");
      tile5 = new Image("res/tile/tile_05.png");
      tile6 = new Image("res/tile/tile_06.png");
    } catch (SlickException e) {
      e.printStackTrace();
    }
  }

  public static Image getAsset(AssetName name) {
    switch (name) {
      case PLAYER:
        return player;
      case ENEMY:
        return enemy;
      case TILE_1:
        return tile1;
      case TILE_2:
        return tile2;
      case TILE_3:
        return tile3;
      case TILE_4:
        return tile4;
      case TILE_5:
        return tile5;
      case TILE_6:
        return tile6;
    }
    return null;
  }
}
