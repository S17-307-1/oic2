package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

  @Test
  public void testConstrain1() {
    float actual = Util.constrain(5, 0, 100);

    assertEquals(5f, actual, 0);
  }

  @Test
  public void testConstrain2() {
    float actual = Util.constrain(-5, 0, 100);

    assertEquals(0f, actual, 0);
  }

  @Test
  public void testConstrain3() {
    float actual = Util.constrain(105, 0, 100);

    assertEquals(100f, actual, 0);
  }

}
