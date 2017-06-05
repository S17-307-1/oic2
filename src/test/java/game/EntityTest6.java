package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

//Anthony Delgado
public class EntityTest6 {

  @Test
  public void testGetPosition() {
    Entity e = new Player();
    Vector2f testPos = new Vector2f(0, 0);

    assertEquals(testPos, e.getPosition());
  }

}
