package game;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Graphics;

public class World {
	private Player player = new Player();
	private Camera camera = new Camera();
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public void render(Graphics g) {
//	    g.translate(-camera.getPosition().getX(), -camera.getPosition().getY());
		player.render(g);
	}
	
	public void update(int delta) {
		player.update(delta);
		camera.update(player);
		
		for (Iterator<Entity> iter = entities.iterator(); iter.hasNext();) {
			Entity e = iter.next();
			
			boolean shouldRemove = e.update(delta);
			if (shouldRemove) {
				iter.remove();
			}
		}
	}

}
