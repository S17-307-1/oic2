package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.FastTrig;

import game.AssetLoader.AssetName;
import main.OperationIceCream;

public class Enemy extends Entity {
  private float rotation = 0f;
  private static final int SPRITE_WIDTH = 64;
  private static final int SPRITE_HEIGHT = 64;

  public Enemy(Vector2f startPos) {
    setSprite(AssetLoader.getAsset(AssetName.ENEMY));
    setPosition(new Vector2f(startPos));
    setVelocity(new Vector2f(0, 0));
    setMaxVelocity(new Vector2f(1f, 1f));

    setBoundingBox(new Circle(getCenter().getX(), getCenter().getY(), SPRITE_WIDTH / 2));
  }

  @Override
  public boolean update(int delta, World world) {
    Vector2f playerCenter = world.getPlayer().getCenter();
    Vector2f posDiff = playerCenter.sub(getCenter());
    rotation = (float) Math.atan2(posDiff.getY(), posDiff.getX());

    float xVel = (float) (getVelocity().getX() + 50f * FastTrig.cos(rotation) * delta / 1000f);
    float yVel = (float) (getVelocity().getY() + 50f * FastTrig.sin(rotation) * delta / 1000f);
    getVelocity().x = Util.constrain(xVel, -getMaxVelocity().getX(), getMaxVelocity().getX());
    getVelocity().y = Util.constrain(yVel, -getMaxVelocity().getY(), getMaxVelocity().getY());

    getBoundingBox().setCenterX(getCenter().x);
    getBoundingBox().setCenterY(getCenter().y);
    getPosition().add(getVelocity());
    return false;
  }

  @Override
  public void render(Graphics g) {
    g.pushTransform();
    g.rotate(getCenter().getX(), getCenter().getY(), (float) (Math.toDegrees(rotation) + 90f));
    g.drawImage(getSprite(), getPosition().getX(), getPosition().getY());
    g.popTransform();
  }

  @Override
  public Vector2f getCenter() {
    return new Vector2f(getPosition().getX() + 33, getPosition().getY() + 44);
  }
}
