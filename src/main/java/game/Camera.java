package game;

import org.newdawn.slick.geom.Vector2f;

import main.OperationIceCream;

public class Camera {

  private Vector2f position = new Vector2f(-OperationIceCream.WINDOW_SIZE_X / 2, -OperationIceCream.WINDOW_SIZE_Y / 2);
  private float scale = 1.0f;

  public void update(Player player) {
    System.out.println("Hello");
    getPosition().add(player.getVelocity());
  }

  public Vector2f getPosition() {
    return position;
  }

  public void setPosition(Vector2f position) {
    this.position = position;
  }
  
  public float getScale() {
    return scale;
  }
}
