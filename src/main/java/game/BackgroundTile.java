package game;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import game.AssetLoader.AssetName;
import main.OperationIceCream;

public class BackgroundTile {
  private Image sprite;
  private Vector2f position = new Vector2f(0, 0);
  public static final int TILE_SIZE = 64;
  private int size = 64;

  public BackgroundTile() {
    Random rand = new Random();

    int num = rand.nextInt(6);
    Image img;
    if (num == 0) {
      img = AssetLoader.getAsset(AssetName.TILE_1);
    } else if (num == 1) {
      img = AssetLoader.getAsset(AssetName.TILE_2);
    } else if (num == 2) {
      img = AssetLoader.getAsset(AssetName.TILE_3);
    } else if (num == 3) {
      img = AssetLoader.getAsset(AssetName.TILE_4);
    } else if (num == 4) {
      img = AssetLoader.getAsset(AssetName.TILE_5);
    } else {
      img = AssetLoader.getAsset(AssetName.TILE_6);
    }
    sprite = scrambleImage(img);
  }

  public void render(Graphics g) {
    g.drawImage(sprite, position.getX(), position.getY());
  }

  public boolean update(Camera camera) {
    boolean offScreenLeft =
        position.getX() < camera.getPosition().getX() - MapGenerator.GENERATOR_RADIUS * 2;
    boolean offScreenRight = position.getX() > camera.getPosition().getX()
        + OperationIceCream.WINDOW_SIZE_X + MapGenerator.GENERATOR_RADIUS * 2;
    boolean offScreenUp =
        position.getY() < camera.getPosition().getY() - MapGenerator.GENERATOR_RADIUS * 2;
    boolean offScreenDown = position.getY() > camera.getPosition().getY()
        + OperationIceCream.WINDOW_SIZE_Y + MapGenerator.GENERATOR_RADIUS * 2;

    return !(offScreenLeft || offScreenRight || offScreenUp || offScreenDown);
  }

  private Image scrambleImage(Image sp) {
    double rand = Math.random();

    if (sp == null) {
      return null;
    }
    if (rand <= .25) {
      return sp.getFlippedCopy(false, false);
    } else if (rand > .25 && rand < .5) {
      return sp.getFlippedCopy(true, false);
    } else if (rand >= .5 && rand < .75) {
      return sp.getFlippedCopy(false, true);
    } else {
      return sp.getFlippedCopy(true, true);
    }
  }

  public int getWidth() {
    return size;
  }

  public int getHeight() {
    return size;
  }
  
  public void setSize(int size) {
    this.size = size;
  }

  public Vector2f getCenter() {
    return new Vector2f(position.getX() + getWidth() / 2f, position.getY() + getHeight() / 2f);
  }

  public Vector2f getPosition() {
    return position;
  }

  public void setPosition(Vector2f position) {
    this.position = position;
  }
}
