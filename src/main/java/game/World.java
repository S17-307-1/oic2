package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import main.OperationIceCream;

public class World {
  private Player player;
  private Camera camera = new Camera();
  private ArrayList<Entity> entities = new ArrayList<Entity>();
  private ArrayList<Icecream> icecreams = new ArrayList<Icecream>();
  private List<BackgroundTile> backgroundTiles = new ArrayList<BackgroundTile>();
  private HashSet<Vector2f> tilesPositionSet = new HashSet<Vector2f>();
  private MapGenerator mapGenerator = new MapGenerator(this);
  private long lastEnemySpawnTime = 0;

  public World() {
    player = new Player();
    player.init();

  }

  public void render(Graphics g) {
    g.translate(-camera.getPosition().getX(), -camera.getPosition().getY()); 
    for (BackgroundTile bt : backgroundTiles) {
      bt.render(g);
    }
    for (Entity e : entities) {
      e.render(g);
    }
    
    for (Icecream ice : icecreams) {
      ice.render(g);
    }
    if (player != null) {
      player.render(g);
    }
  }

  public boolean update(int delta) {
    boolean playerDead = player.update(delta, this);
    if (playerDead) {
      return true;
    }
    camera.update(player);
    mapGenerator.generate();

    if (System.currentTimeMillis() - lastEnemySpawnTime > 1000f) {
      lastEnemySpawnTime = System.currentTimeMillis();
      Random rand = new Random();

      Vector2f posOffset = new Vector2f(rand.nextInt(1000) - 500, rand.nextInt(1000) - 500);

      Enemy e = new Enemy(new Vector2f(0, 0));
      e.setPosition(new Vector2f(player.getPosition().getX() + posOffset.getX(),
          player.getPosition().getY() + posOffset.getY()));
      e.init();
      entities.add(e);
    }
    
    for (Iterator<Entity> iter = entities.iterator(); iter.hasNext();) {
      Entity e = iter.next();

      boolean shouldRemove = e.update(delta, this);
      if (shouldRemove) {
        iter.remove();
      }
    }
    
    for (Iterator<Icecream> iter = icecreams.iterator(); iter.hasNext();) {
      Icecream ice = iter.next();

      boolean shouldRemove = ice.update(delta, this);
      if (shouldRemove) {
        iter.remove();
      }
    }
    return false;
  }

  public void removeTile(BackgroundTile backgroundTile, int ndx) {
    backgroundTiles.remove(ndx);

    int width = backgroundTile.getWidth() / BackgroundTile.TILE_SIZE;
    int height = backgroundTile.getHeight() / BackgroundTile.TILE_SIZE;

    for (int i = 0; i < width * height; i++) {
      int col = i % width;
      int row = i / height;

      int x = (int) (backgroundTile.getPosition().getX() / BackgroundTile.TILE_SIZE) + col;
      int y = (int) (backgroundTile.getPosition().getY() / BackgroundTile.TILE_SIZE) + row;

      Vector2f intPos = new Vector2f(x, y);

      tilesPositionSet.remove(intPos);
    }
  }

  public void addTile(BackgroundTile backgroundTile) {
    backgroundTiles.add(backgroundTile);

    int width = backgroundTile.getWidth() / BackgroundTile.TILE_SIZE;
    int height = backgroundTile.getHeight() / BackgroundTile.TILE_SIZE;

    for (int i = 0; i < width * height; i++) {
      int col = i % width;
      int row = i / height;

      int x = (int) (backgroundTile.getPosition().getX() / BackgroundTile.TILE_SIZE) + col;
      int y = (int) (backgroundTile.getPosition().getY() / BackgroundTile.TILE_SIZE) + row;

      Vector2f intPos = new Vector2f(x, y);

      tilesPositionSet.add(intPos);
    }
  }

  public boolean isTileSpotFree(BackgroundTile backgroundTile) {
    int width = backgroundTile.getWidth() / BackgroundTile.TILE_SIZE;
    int height = backgroundTile.getHeight() / BackgroundTile.TILE_SIZE;

    for (int i = 0; i < width * height; i++) {
      int col = i % width;
      int row = i / height;

      int x = (int) (backgroundTile.getPosition().getX() / BackgroundTile.TILE_SIZE) + col;
      int y = (int) (backgroundTile.getPosition().getY() / BackgroundTile.TILE_SIZE) + row;

      Vector2f intPos = new Vector2f(x, y);

      if (tilesPositionSet.contains(intPos)) {
        return false;
      }
    }
    return true;
  }
  
  public void addIcecream(Icecream icecream) {
    icecreams.add(icecream);
  }

  public void addEntity(Entity e) {
    entities.add(e);
  }
  
  public List<Icecream> getIcecreams() {
    return icecreams;
  }

  public Camera getCamera() {
    return camera;
  }

  public Player getPlayer() {
    return player;
  }

  public BackgroundTile getTile(int ndx) {
    return backgroundTiles.get(ndx);
  }

  public int getNumTiles() {
    return backgroundTiles.size();
  }

  public List<BackgroundTile> getBackgroundTiles() {
    return backgroundTiles;
  }

}
