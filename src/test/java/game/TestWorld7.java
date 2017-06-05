package game;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

//Arya Karnik
public class TestWorld7 {

  @Test
  public void testAddTile() {
    BackgroundTile tile = new BackgroundTile();
    World world = new World();
    List<BackgroundTile> lst = new LinkedList<>();
    ListIterator<BackgroundTile> iter = lst.listIterator();
    
    //don't run the loop body
    tile.setSize(0);
    world.addTile(tile, iter);
    assertEquals(1, lst.size());
    
    //run loop once
    tile.setSize(tile.TILE_SIZE);
    world.addTile(tile, iter);
    assertEquals(2, lst.size());
    
    //run loop 4 times
    tile.setSize(tile.TILE_SIZE * 2);
    world.addTile(tile, iter);
    assertEquals(3, lst.size());
  }

}
