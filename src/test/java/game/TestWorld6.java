package game;

import static org.junit.Assert.*;

import org.junit.Test;

//Anthony Delgado
public class TestWorld6 {

  @Test
  public void testIsTileSpotFree() {
    BackgroundTile tile = new BackgroundTile();
    World world = new World();
    
    //don't run the loop body
    tile.setSize(0);
    assertTrue(world.isTileSpotFree(tile));
    
    //run loop once
    tile.setSize(tile.TILE_SIZE);
    assertFalse(world.isTileSpotFree(tile));
    
    //run loop 4 times
    tile.setSize(tile.TILE_SIZE * 2);
    assertFalse(world.isTileSpotFree(tile));
  }

}
