package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Circle;

//Stephanie Lascola
public class TestEntity5 {

  @Test
  public void testGetHeight() {
    Entity e = new Player();
    e.setBoundingBox(new Circle(0, 0, 32));

    assertEquals(64, e.getHeight());
  }

}
