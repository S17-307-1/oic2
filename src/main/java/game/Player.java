package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

import game.AssetLoader.AssetName;
import main.OperationIceCream;

public class Player extends Entity {
	private static final int SPRITE_WIDTH = 64;
	private static final int SPRITE_HEIGHT = 64;
	private float rotation = 0f;
	private Vector2f acceleration = new Vector2f(15f, 15f);
	private Input input = new Input(OperationIceCream.WINDOW_SIZE_Y);
	private long lastTimeFired = -1;

	public Player() {
		setSprite(AssetLoader.getAsset(AssetName.PLAYER));
		setPosition(new Vector2f(OperationIceCream.WINDOW_SIZE_X / 2 - SPRITE_WIDTH / 2,
				OperationIceCream.WINDOW_SIZE_Y / 2 - SPRITE_HEIGHT / 2));
		setVelocity(new Vector2f(0, 0));
		setMaxVelocity(new Vector2f(5f, 5f));

		setBoundingBox(new Circle(getCenter().getX(), getCenter().getY(), getSprite().getWidth() / 2));
	}

	@Override
	public boolean update(int delta, World world) {
		if (input.isKeyDown(Input.KEY_A)) {
			float xVel = (float) (getVelocity().getX() - getAcceleration().getX() * delta / 1000f);
			getVelocity().x = Util.constrain(xVel, -getMaxVelocity().getX(), getMaxVelocity().getX());
		}
		if (input.isKeyDown(Input.KEY_D)) {
			float xVel = (float) (getVelocity().getX() + getAcceleration().getX() * delta / 1000f);
			getVelocity().x = Util.constrain(xVel, -getMaxVelocity().getX(), getMaxVelocity().getX());
		}
		if (input.isKeyDown(Input.KEY_W)) {
			float yVel = (float) (getVelocity().getY() - getAcceleration().getY() * delta / 1000f);
			getVelocity().y = Util.constrain(yVel, -getMaxVelocity().getY(), getMaxVelocity().getY());
		} else if (input.isKeyDown(Input.KEY_S)) {
			float yVel = (float) (getVelocity().getY() + getAcceleration().getY() * delta / 1000f);
			getVelocity().y = Util.constrain(yVel, -getMaxVelocity().getY(), getMaxVelocity().getY());
		}

		getVelocity().x *= Math.pow(.01f, delta / 1000f);
		getVelocity().y *= Math.pow(.01f, delta / 1000f);

		getPosition().add(getVelocity());

		getBoundingBox().setCenterX(getCenter().x);
		getBoundingBox().setCenterY(getCenter().y);

		float distX = (world.getCamera().getPosition().getX() + input.getMouseX()) - getCenter().getX();
		float distY = (world.getCamera().getPosition().getY() + input.getMouseY()) - getCenter().getY();
		rotation = (float) Math.toDegrees(Math.atan2(distY, distX));

		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && System.currentTimeMillis() - lastTimeFired > 500) {
			lastTimeFired = System.currentTimeMillis();
			throwIcecream(world);
		}

		return false;
	}

	@Override
	public void render(Graphics g) {
		g.pushTransform();
		g.rotate(getCenter().getX(), getCenter().getY(), rotation + 90f);
		g.drawImage(getSprite(), getPosition().getX(), getPosition().getY());
		g.fillOval(getCenter().getX() - 8, getCenter().getY() - 8, 16, 16);
		g.popTransform();
	}

	@Override
	public Vector2f getCenter() {
		return new Vector2f(getPosition().getX() + 33, getPosition().getY() + 44);
	}

	public void throwIcecream(World world) {
		Entity e = new Icecream(getCenter(), Math.toRadians(rotation));
		world.addEntity(e);
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Vector2f getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector2f acceleration) {
		this.acceleration = acceleration;
	}
}