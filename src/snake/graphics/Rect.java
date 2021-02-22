package snake.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Rect extends Drawable {

	private Rectangle rectangle;
	
	public Rect() {
		rectangle = new Rectangle(0, 0, 0, 0);
	}

	public Rect(Point location, Dimension dimension) {
		rectangle = new Rectangle(location, dimension);
	}

	public Rect(int x, int y, int width, int height) {

		rectangle = new Rectangle(x, y, width, height);

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect((int) getPoint().getX(), (int) getPoint().getY(), (int) getDimension().getWidth(),
				(int) getDimension().getHeight());

	}

	public Point getPoint() {
		return rectangle.getLocation();
	}

	public Dimension getDimension() {
		return rectangle.getSize();
	}
	
	public void setDimension(int width, int height) {
		rectangle.setSize(width, height);
	}

	public void setLocation(Point location) {
		rectangle.setLocation(location);
	}

	public boolean intersects(Rect r) {

		return rectangle.intersects(r.rectangle);
	}

	public double getMinX() {
		return rectangle.getMinX();
	}

	public double getMaxX() {
		return rectangle.getMaxX();
	}

	public double getMinY() {
		return rectangle.getMinY();
	}

	public double getMaxY() {
		return rectangle.getMaxY();
	}

}
