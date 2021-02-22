package snake.scene;

import static snake.util.Constants.PIECES_TO_ELONGATE;

import java.awt.Graphics;

import snake.core.Direction;
import snake.graphics.Rect;
import snake.graphics.Shape;
import snake.util.Constants;
import snake.util.GameUtils;

public class Snake extends Shape {

	private Rect rect;
	private Direction direction;
	private int piecesToElongate;

	public Snake() {

		direction = Direction.NONE;

		rect = new Rect(Constants.SNAKE_INITIAL_X, Constants.SNAKE_INITIAL_Y, Constants.SNAKE_SIZE,
				Constants.SNAKE_SIZE);

		rect.setColor(Constants.SNAKE_COLOR);

		addRect(rect);

		for (int i = 0; i < Constants.SNAKE_INITIAL_LENGTH; i++) {
			addRect(duplicateRect(getLastRect(), Direction.LEFT));

		}
	}

	@Override
	public void draw(Graphics g) {

		super.draw(g);
	}

	public synchronized void move() {

		if (direction != Direction.NONE) {
			Rect head = getFirsRect();
			Rect tail = getLastRect();
			GameUtils.moveRect(getRects());
			Rect newHead = duplicateRect(head, direction);
			getRects().set(0, newHead);

			if (piecesToElongate > 0) {
				piecesToElongate--;
				addRect(tail);
			}
		}

	}

	public synchronized void up() {
		if (direction.canChangeTo(Direction.UP)) {
			direction = Direction.UP;
		}
	}

	public synchronized void down() {
		if (direction.canChangeTo(Direction.DOWN)) {
			direction = Direction.DOWN;
		}
	}

	public synchronized void left() {
		if (direction.canChangeTo(Direction.LEFT) && direction != Direction.NONE) {
			direction = Direction.LEFT;
		}
	}

	public synchronized void right() {
		if (direction.canChangeTo(Direction.RIGTH)) {
			direction = Direction.RIGTH;
		}
	}

	public void elongate() {
		piecesToElongate += PIECES_TO_ELONGATE;
	}

	public boolean collideWithitself() {

		Rect head = getFirsRect();

		for (int i = 1; i < size(); i++) {
			if (head.intersects(getRects().get(i))) {
				return true;
			}
		}

		return false;
	}

}
