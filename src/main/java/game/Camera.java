package game;

import org.newdawn.slick.geom.Vector2f;

public class Camera {

  private Vector2f position = new Vector2f(0, 0);

  public void update(Player player) {
    getPosition().add(player.getVelocity());
  }

  public Vector2f getPosition() {
    return position;
  }

  public void setPosition(Vector2f position) {
    this.position = position;
  }
}
