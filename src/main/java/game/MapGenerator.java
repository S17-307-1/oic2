package game;

import java.util.Iterator;

import org.newdawn.slick.geom.Vector2f;

public class MapGenerator {

  public static final int GENERATOR_RADIUS = 512; // radius * 2 needs to be
                                                  // larger than biggest
  // tile or else it'll spawn offscreen and then
  // die :(
  private World world;

  public MapGenerator(World map) {
    this.world = map;
    BackgroundTile firstTile = new BackgroundTile();
    firstTile.setPosition(new Vector2f(512, 512));
    System.out.println(firstTile.getPosition());
    map.addTile(firstTile);
  }

  public void generate() {
    generateBackgroundTiles();
  }

  private void generateBackgroundTiles() {
    for (int i = 0; i < world.getNumTiles(); i++) {
      BackgroundTile currBackgroundTile = world.getTile(i);

      if (!currBackgroundTile.update(world.getCamera())) {
        world.removeTile(currBackgroundTile, i--);
      }

      if (world.getPlayer().getCenter()
          .distance(currBackgroundTile.getCenter()) <= GENERATOR_RADIUS) {
        attemptToGenerateTile(currBackgroundTile, TileDirection.LEFT);
        attemptToGenerateTile(currBackgroundTile, TileDirection.UP);
        attemptToGenerateTile(currBackgroundTile, TileDirection.DOWN);
        attemptToGenerateTile(currBackgroundTile, TileDirection.RIGHT);
        attemptToGenerateTile(currBackgroundTile, TileDirection.TOP_LEFT);
      }
    }
  }

  private void attemptToGenerateTile(BackgroundTile currBackgroundTile, TileDirection dir) {
    BackgroundTile newBackgroundTile = new BackgroundTile();
    Vector2f newTilePos = null;

    switch (dir) {
      case LEFT:
        newTilePos =
            new Vector2f(currBackgroundTile.getPosition().getX() - newBackgroundTile.getWidth(),
                currBackgroundTile.getPosition().getY());
        break;
      case RIGHT:
        newTilePos =
            new Vector2f(currBackgroundTile.getPosition().getX() + currBackgroundTile.getWidth(),
                currBackgroundTile.getPosition().getY());
        break;
      case UP:
        newTilePos = new Vector2f(currBackgroundTile.getPosition().getX(),
            currBackgroundTile.getPosition().getY() - newBackgroundTile.getHeight());
        break;
      case DOWN:
        newTilePos = new Vector2f(currBackgroundTile.getPosition().getX(),
            currBackgroundTile.getPosition().getY() + currBackgroundTile.getHeight());
        break;
      case TOP_LEFT:
        newTilePos =
            new Vector2f(currBackgroundTile.getPosition().getX() - newBackgroundTile.getWidth(),
                currBackgroundTile.getPosition().getY() - newBackgroundTile.getHeight());
        break;
      default:
        break;
    }
    newBackgroundTile.setPosition(newTilePos);

    if (world.isTileSpotFree(newBackgroundTile)) {
      world.addTile(newBackgroundTile);
    }
  }

  private enum TileDirection {
    LEFT, RIGHT, UP, DOWN, TOP_LEFT
  }
}
