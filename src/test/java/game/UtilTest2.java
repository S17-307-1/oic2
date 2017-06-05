package game;

import static org.junit.Assert.*;

import org.junit.Test;

//Collin Dutter
public class UtilTest2 {

  @Test
  public void testConstrain3() {
    float actual = Util.constrain(105, 0, 100);

    assertEquals(100f, actual, 0);
  }

}
