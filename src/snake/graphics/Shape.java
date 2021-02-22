package snake.graphics;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import snake.core.Direction;

public class Shape extends Drawable {

	private List<Rect> rects;

	public Shape() {
		this.rects = new ArrayList<>();
	}

	public void addRect(Rect rect) {

		rects.add(rect);
	}

	@Override
	public void draw(Graphics g) {

		for (Rect r : rects) {
			r.draw(g);
		}

	}

	public int size() {

		return rects.size();
	}

	public List<Rect> getRects() {
		return rects;
	}

	public Rect getRect(int i) {
		return rects.get(i);
	}

	public Rect getFirsRect() {
		return rects.get(0);
	}

	public Rect getLastRect() {
		return rects.get(size() - 1);
	}

	public Rect duplicateRect(Rect baseRect, Direction dir) {

		int baseX = (int) baseRect.getPoint().getX();
		int baseY = (int) baseRect.getPoint().getY();
		int baseWidth = (int) baseRect.getDimension().getWidth();
		int baseHeight = (int) baseRect.getDimension().getHeight();

		Point p = new Point(baseX + dir.getX() * baseWidth, baseY + dir.getY() * baseHeight);
		Rect newRect = new Rect(p, baseRect.getDimension());

		newRect.setColor(baseRect.getColor());

		return newRect;
	}

	public boolean intersects(Rect rect) {

		for (Rect r : rects) {
			if (r.intersects(rect)) {
				return true;
			}
		}

		return false;
	}

}
