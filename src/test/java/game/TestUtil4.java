package game;

import static org.junit.Assert.*;

import org.junit.Test;

//Megan Pieczynski
public class TestUtil4 {

  @Test
  public void testConstrain2() {
    float actual = Util.constrain(-5, 0, 100);

    assertEquals(0f, actual, 0);
  }

}
