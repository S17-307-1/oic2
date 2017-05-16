package gui;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GuiImage extends GuiElement {
	private static final Logger LOGGER = Logger.getLogger(GuiImage.class.getName());

	private Point2D location;
	private Image image;

	public GuiImage(String id, String imageName, double coordX, double coordY) {
		super(id);
		try {
			image = new Image(imageName);
		} catch (SlickException e) {
			LOGGER.log(Level.FATAL, e.toString(), e);
		}

		location = new Point2D.Double(coordX, coordY);
		origin = new Point2D.Double(coordX, coordY);
	}

	@Override
	public void shift(int deltaX, int deltaY) {
		location.setLocation(location.getX() + deltaX, location.getY() + deltaY);
	}

	@Override
	public void restoreOrigin() {
		location.setLocation(origin.getX(), origin.getY());
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(image, (float) location.getX(), (float) location.getY());
	}

	@Override
	public void update(Input input, boolean isLeftMousePressed) {
	}

	@Override
	public void setValue(String value) {
	}

	@Override
	public void setColor(Color color) {
	}

	@Override
	public Rectangle2D getBoundingBox() {
		return new Rectangle2D.Double(location.getX(), location.getY(), image.getWidth(), image.getHeight());
	}
}
