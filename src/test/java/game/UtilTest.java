package game;

import org.newdawn.slick.geom.Vector2f;

import junit.framework.TestCase;

public class UtilTest extends TestCase {

  public void testDistSquared() {
    Vector2f v1 = new Vector2f(0, 0);
    Vector2f v2 = new Vector2f(5, 0);
    
    assertEquals(25f, Util.distSquared(v1, v2));
  }

  public void testConstrain() {
    assertEquals(0f, Util.constrain(-5f, 0f, 5f));
  }

}
