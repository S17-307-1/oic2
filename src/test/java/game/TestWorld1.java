package game;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

//John Bradbury
public class TestWorld1 {

  @Test
  public void testUpdate() {
    World world = new World();
    
    //loop body does not run
    assertFalse(world.update(0));
    
    //loop runs once
    world.addEntity(new Icecream(new Vector2f(0,0), 0));
    assertFalse(world.update(1));
    
    //loop runs twice
    world.addEntity(new Icecream(new Vector2f(10,0), 0));
    assertFalse(world.update(1));
    
    //no upper bound, so test 10
    for (int i = 1; i <= 8; i++) {
      world.addEntity(new Icecream(new Vector2f(10 * i,0), 0));
    }
    assertFalse(world.update(1));
  }

}
