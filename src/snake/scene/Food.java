package snake.scene;

import static snake.util.Constants.FOOD_COLOR;
import static snake.util.Constants.FOOD_SIZE;
import java.awt.Point;
import snake.graphics.Rect;
import snake.util.GameUtils;

public class Food extends Rect {

	private int eatenTimes;

	public Food (Snake snake, Rect drawningArea) {
		setRandomLocation(snake, drawningArea);
		setDimension(FOOD_SIZE, FOOD_SIZE);
		setColor(FOOD_COLOR);
	}

	public void setRandomLocation(Snake snake, Rect drawningArea) {
		Point p = new Point();
		int x, y;

		do {
			x = GameUtils.random(
					(int) drawningArea.getMinX() + FOOD_SIZE, 
					(int) drawningArea.getMaxX() - FOOD_SIZE);
			y = GameUtils.random(
					(int) drawningArea.getMinY(), 
					(int) drawningArea.getMaxY() - FOOD_SIZE);

			x = (x / FOOD_SIZE) * FOOD_SIZE;
			
			y = (y / FOOD_SIZE) * FOOD_SIZE;
	
			p.setLocation(x, y);
			setLocation(p);
		} while (snake.intersects(this));

	}

	public void checkIfEaten(Snake snake, Rect drawningArea) {
		if (snake.getFirsRect().intersects(this)) {
			eatenTimes++;
			snake.elongate();
			setRandomLocation(snake, drawningArea);
		}
	}

	public int getEatenTimes() {
		return eatenTimes;
	}
}
