import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This class represents a single room within a larger building.
 * Each room has a (x,y) position, as well as links to other rooms
 * to the north, east, south, and west.
 */
public class Room {
	private Point pos;
	private Room exitEast;
	private Room exitWest;
	private Room exitNorth;
	private Room exitSouth;
		
	public Room(int x, int y) {
		pos = new Point(x,y);
		exitEast = null;
		exitWest = null;
		exitNorth = null;
		exitSouth = null;
	}
	
	/**
	 * Each of these set*Exit methods work pretty much the same.
	 * Create a link from the current room to the other room,
	 * then create a link from the other room to the current room.
	 * @param r the "other" room to connect to
	 */
	public void setEastExit(Room r) {
		exitEast = r;
		r.exitWest = this;
	}
	
	public void setNorthExit(Room r) {
		exitNorth = r;
		r.exitSouth = this;
	}
	
	public void setWestExit(Room r) {
		exitWest = r;
		r.exitEast = this;
	}
	
	public void setSouthExit(Room r) {
		exitSouth = r;
		r.exitNorth = this;
	}
	
	/**
	 * This method is in charge of rendering the room, and its doorways, at its
	 * correct location.
	 */
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		
		if  (exitNorth == null) {
			g.drawLine(pos.x, pos.y, pos.x+50, pos.y);
		} else {
			g.drawLine(pos.x, pos.y, pos.x+50/2-5, pos.y);
			g.drawLine(pos.x+50/2+5, pos.y, pos.x+50, pos.y);
			g.drawLine(pos.x+50/2+5, pos.y, pos.x+50/2+5, pos.y-5);
			g.drawLine(pos.x+50/2-5, pos.y, pos.x+50/2-5, pos.y-5);
		}
		
		if  (exitSouth == null) {
			g.drawLine(pos.x, pos.y+50, pos.x+50, pos.y+50);
		} else {
			g.drawLine(pos.x, pos.y+50, pos.x+50/2-5, pos.y+50);
			g.drawLine(pos.x+50/2+5, pos.y+50, pos.x+50, pos.y+50);
			g.drawLine(pos.x+50/2+5, pos.y+50, pos.x+50/2+5, pos.y+50+5);
			g.drawLine(pos.x+50/2-5, pos.y+50, pos.x+50/2-5, pos.y+50+5);
		}
		
		if (exitEast == null) {
			g.drawLine(pos.x+50, pos.y, pos.x+50, pos.y+50);
		} else {
			g.drawLine(pos.x+50, pos.y, pos.x+50, pos.y+50/2-5);
			g.drawLine(pos.x+50, pos.y+50/2+5, pos.x+50, pos.y+50);
			g.drawLine(pos.x+50, pos.y+50/2+5, pos.x+50+5, pos.y+50/2+5);
			g.drawLine(pos.x+50, pos.y+50/2-5, pos.x+50+5, pos.y+50/2-5);
		}

		if (exitWest == null) {
			g.drawLine(pos.x, pos.y, pos.x, pos.y+50);
		} else {
			g.drawLine(pos.x, pos.y, pos.x, pos.y+50/2-5);
			g.drawLine(pos.x, pos.y+50/2+5, pos.x, pos.y+50);
			g.drawLine(pos.x, pos.y+50/2+5, pos.x-5, pos.y+50/2+5);
			g.drawLine(pos.x, pos.y+50/2-5, pos.x-5, pos.y+50/2-5);
		}
	}
}
