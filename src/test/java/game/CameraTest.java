package game;

import org.newdawn.slick.geom.Vector2f;

import junit.framework.TestCase;

public class CameraTest extends TestCase {

  public void testGetWidth() {
    Camera c = new Camera();
    
    assertEquals(new Vector2f(0, 0), c.getPosition());
  }

  public void testSetPosition() {
    Camera c = new Camera();
    
    Vector2f newPos = new Vector2f(50, 50);
    c.setPosition(newPos);
    
    assertEquals(newPos, c.getPosition());
  }

}
