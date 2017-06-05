package game;

import static org.junit.Assert.*;

import org.junit.Test;

//Sean Slater
public class TestUtil3 {

  @Test
  public void testConstrain1() {
    float actual = Util.constrain(5, 0, 100);

    assertEquals(5f, actual, 0);
  }

}
