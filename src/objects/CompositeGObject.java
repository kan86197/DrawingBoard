package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompositeGObject extends GObject {

	private List<GObject> gObjects;

	public CompositeGObject() {
		super(0, 0, 0, 0);
		gObjects = new ArrayList<GObject>();
	}

	public void add(GObject gObject) {
		// TODO: Implement this method.
		gObjects.add(gObject);
	}

	public void remove(GObject gObject) {
		// TODO: Implement this method.
		gObjects.remove(gObject);
	}

	@Override
	public void move(int dX, int dY) {
		// TODO: Implement this method.
		
		for(GObject g : gObjects){
			g.x += dX - x;
			g.y += dY - y;
		}
		x = dX; 
		y = dY;
		
	}
	
	public void recalculateRegion() {
		// TODO: Implement this method.
		int maxX = 0;
		int maxY = 0;
		int minX = gObjects.get(0).x, minY = gObjects.get(0).y;
		for(GObject g : gObjects){
			if(g.x + g.width > maxX) maxX = g.x + g.width;
			if(g.y + g.height > maxY) maxY = g.y + g.height;
			if(g.x < minX) minX = g.x;
			if(g.y < minY) minY = g.y; 
		}
		x = minX;
		y = minY;
		width = maxX - minX ;
		height = maxY - minY ;
	}

	@Override
	public void paintObject(Graphics g) {
		// TODO: Implement this method.
		for(GObject i : gObjects){
			i.paintObject(g);
		}
	}

	@Override
	public void paintLabel(Graphics g) {
		// TODO: Implement this method.
		g.drawString("Composite", x, y + height + 20);
	}
	
	
	
}
