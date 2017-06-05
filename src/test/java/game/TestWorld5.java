package game;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

//Stephanie Lascola
public class TestWorld5 {

  @Test
  public void testRemoveTile() {
    BackgroundTile tile = new BackgroundTile();
    World world = new World();
    List<BackgroundTile> lst = new LinkedList<>();
    ListIterator<BackgroundTile> iter = lst.listIterator();
    
    //don't run the loop body
    tile.setSize(0);
    lst.add(tile);
    iter = lst.listIterator();
    iter.next();
    
    world.removeTile(tile, iter);
    assertEquals(0, lst.size());
    
    //run loop once
    tile.setSize(tile.TILE_SIZE);
    lst.add(tile);
    iter = lst.listIterator();
    iter.next();
    
    world.removeTile(tile, iter);
    assertEquals(0, lst.size());
    
    //run loop 4 times
    tile.setSize(tile.TILE_SIZE * 2);
    lst.add(tile);
    iter = lst.listIterator();
    iter.next();
    
    world.removeTile(tile, iter);
    assertEquals(0, lst.size());
  }

}
