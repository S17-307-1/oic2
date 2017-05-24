package game;

import org.newdawn.slick.geom.Vector2f;

public class Util {

  private Util() {

  }
  
  public static float distSquared(Vector2f v1, Vector2f v2) {
    float distX = v1.getX() - v2.getX();
    float distY = v1.getY() - v2.getY();
    
    return distX * distX + distY * distY;
  }

  public static float constrain(float value, float min, float max) {
    if (value <= min) {
      return min;
    } else if (value >= max) {
      return max;
    } else {
      return value;
    }
  }
}
