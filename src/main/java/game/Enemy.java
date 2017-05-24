package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.FastTrig;

import game.AssetLoader.AssetName;

public class Enemy extends Entity {
  public Enemy(Vector2f startPos) {
    setPosition(new Vector2f(startPos));
    setVelocity(new Vector2f(0, 0));
    setMaxVelocity(new Vector2f(1f, 1f));
  }

  public Enemy() {
    this(new Vector2f(0, 0));
  }

  @Override
  public void init() {
    setSprite(AssetLoader.getAsset(AssetName.ENEMY));
    setBoundingBox(new Circle(getCenter().getX(), getCenter().getY(), getSprite().getWidth() / 2));
  }

  @Override
  public boolean update(int delta, World world) {
    Vector2f playerCenter = world.getPlayer().getCenter();
    Vector2f posDiff = playerCenter.sub(getCenter());
    setRotation((float) Math.atan2(posDiff.getY(), posDiff.getX()));

    float xVel = (float) (getVelocity().getX() + 50f * FastTrig.cos(getRotation()) * delta / 1000f);
    float yVel = (float) (getVelocity().getY() + 50f * FastTrig.sin(getRotation()) * delta / 1000f);
    getVelocity().x = Util.constrain(xVel, -getMaxVelocity().getX(), getMaxVelocity().getX());
    getVelocity().y = Util.constrain(yVel, -getMaxVelocity().getY(), getMaxVelocity().getY());

    getPosition().add(getVelocity());
    getBoundingBox().setLocation(getPosition());
    
    for (Icecream ic : world.getIcecreams()) {
      if (this.intersects(ic)) {
        ic.setShouldBeRemoved(true);
        return true;
      }
    }
    if (this.intersects(world.getPlayer())) {
     world.getPlayer().setShouldBeRemoved(true);
    }
    
    return false;
  }

  @Override
  public void render(Graphics g) {
    g.pushTransform();
    g.rotate(getCenter().getX(), getCenter().getY(), (float) (Math.toDegrees(getRotation()) + 90f));
    g.drawImage(getSprite(), getPosition().getX(), getPosition().getY());
    g.popTransform();
  }

  @Override
  public Vector2f getCenter() {
    return new Vector2f(getPosition().getX() + 33, getPosition().getY() + 44);
  }

}
