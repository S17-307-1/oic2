package game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

//Collin Dutter
public class EntityTest2 {

  @Test
  public void testGetBoundingBox() {
    Entity e = new Player();
    Shape testBox =  new Circle(0, 0, 32);
    e.setBoundingBox(testBox);

    assertEquals(testBox, e.getBoundingBox());
  }

  @Test
  public void testSetBoundingBox() {
    Entity e = new Player();
    Shape s = new Circle(34, 23, 33);
    e.setBoundingBox(s);

    assertEquals(s, e.getBoundingBox());
  }

  @Test
  public void testGetVelocity() throws Exception {
    Entity e = new Player();

    assertEquals(new Vector2f(0,0), e.getVelocity());
  }

  @Test
  public void testSetVelocity() throws Exception {
    Entity e = new Player();
    e.setVelocity(new Vector2f(50f, 50f));

    assertEquals(new Vector2f(50f, 50f), e.getVelocity());
  }

  @Test
  public void testGetMaxVelocity() throws Exception {
    Entity e = new Player();
    e.setMaxVelocity(new Vector2f(100, 100));

    assertEquals(new Vector2f(100, 100), e.getMaxVelocity());
  }

  @Test
  public void testSetMaxVelocity() throws Exception {
    Entity e = new Player();
    e.setMaxVelocity(new Vector2f(50f, 50f));

    assertEquals(new Vector2f(50f, 50f), e.getMaxVelocity());
  }

  @Test
  public void testGetRotation() {
    Entity e = new Player();

    assertEquals(0, e.getRotation(), 0);
  }

  @Test
  public void testSetRotation() {
    Entity e = new Player();
    e.setRotation(-70);

    assertEquals(-70, e.getRotation(), 0);
  }

  @Test
  public void testGetShouldBeRemoved() {
    Entity e = new Player();

    assertFalse(e.getShouldBeRemoved());
  }

  @Test
  public void testSetShouldBeRemoved() {
    Entity e = new Player();
    e.setShouldBeRemoved(true);

    assertTrue(e.getShouldBeRemoved());
  }

}
