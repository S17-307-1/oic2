package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Circle;

//Sean Slater
public class EntityTest3 {

  @Test
  public void testGetWidth() {
    Entity e = new Player();
    e.setBoundingBox(new Circle(0, 0, 32));

    assertEquals(64, e.getWidth());
  }

}
