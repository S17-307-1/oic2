package game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {

	private Vector2f position;
	private Vector2f velocity;
	private Vector2f maxVelocity;
	private Shape boundingBox;
	private Image sprite;

	public Entity() {

	}

	public abstract boolean update(int delta);

	public abstract void render(Graphics g);

	public boolean intersects(Entity entity) {
		return this.getBoundingBox() == null && this.getBoundingBox().intersects(entity.getBoundingBox());
	}

	public int getWidth() {
		return Math.round(boundingBox.getWidth());
	}

	public int getHeight() {
		return Math.round(boundingBox.getHeight());
	}

	public Vector2f getCenter() {
		float centerX = position.getX() + boundingBox.getWidth() / 2f;
		float centerY = position.getY() + boundingBox.getHeight() / 2f;

		return new Vector2f(centerX, centerY);
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Shape getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(Shape boundingBox) {
		this.boundingBox = boundingBox;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

	public Vector2f getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(Vector2f maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

}