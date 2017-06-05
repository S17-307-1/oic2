package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

//Arya Karnik
public class TestEntity7 {

  @Test
  public void testSetPosition() {
    Entity e = new Player();
    Vector2f newPos = new Vector2f(-52, 50);
    e.setPosition(newPos);

    assertEquals(newPos, e.getPosition());
  }

}
