package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.FastTrig;

public class Icecream extends Entity {
	private static final int SPRITE_WIDTH = 12;
	private static final int SPRITE_HEIGHT = 12;

	public Icecream(Vector2f startPos, double rotation) {
		float startX = (float) (startPos.getX() + FastTrig.cos(rotation + Math.PI / 2) * 10);
		float startY = (float) (startPos.getY() + FastTrig.sin(rotation + Math.PI / 2) * 10);
		setPosition(new Vector2f(new Vector2f(startX, startY)));

		float velX = (float) FastTrig.cos(rotation) * 30f;
		float velY = (float) FastTrig.sin(rotation) * 30f;
		setVelocity(new Vector2f(velX, velY));

		setBoundingBox(new Circle(getCenter().getX(), getCenter().getX(), SPRITE_HEIGHT / 2));

	}

	public Vector2f getCenter() {
		return new Vector2f(getPosition().getX() + SPRITE_WIDTH / 2, getPosition().getY() + SPRITE_HEIGHT / 2);
	}

	@Override
	public boolean update(int delta, World world) {
		getPosition().add(getVelocity());

		getBoundingBox().setCenterX(getCenter().x);
		getBoundingBox().setCenterY(getCenter().y);
		return false;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fill(getBoundingBox());
		g.setColor(Color.white);
	}
}
