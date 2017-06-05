package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

//John Bradbury
public class TestEnemy1 {

  @Test
  public void testUpdateLoop() {
    
    Enemy enemy = new Enemy();
    assertFalse(enemy.update(0, null));
    
    //loop body is not executed
    World world = new World();
    assertFalse(enemy.update(1, world));
    
    //loop runs once
    world.addIcecream(new Icecream(new Vector2f(0,0), 0));
    assertFalse(enemy.update(1, world));
    
    //loop runs twice
    world.addIcecream(new Icecream(new Vector2f(10,0), 0));
    assertFalse(enemy.update(1, world));
    
    //typically no more than 5 ice creams at a time, but no upper bound
    world.addIcecream(new Icecream(new Vector2f(20,0), 0));
    world.addIcecream(new Icecream(new Vector2f(30,0), 0));
    world.addIcecream(new Icecream(new Vector2f(40,0), 0));
    assertFalse(enemy.update(1, world));
    
    enemy.setPosition(new Vector2f(0,0));
    enemy.setBoundingBox(new Rectangle(-5, -5, 5, 5));
    assertTrue(enemy.update(1, world));
  }

}
