package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

//Megan Pieczynski
public class EntityTest4 {

  @Test
  public void testGetCenter() {
    Entity e = new Player();
    Vector2f expected = new Vector2f(33, 44);
    assertEquals(e.getCenter(), expected);
  }

}
