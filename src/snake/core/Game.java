package snake.core;

import static snake.util.Constants.GAME_LOOP_TIME;
import static snake.util.Constants.SNAKE_SIZE;

import snake.graphics.Rect;
import snake.graphics.Renderer;
import snake.scene.Background;
import snake.scene.Food;
import snake.scene.GameOverText;
import snake.scene.Snake;
import snake.util.GameUtils;

public class Game implements Runnable {

	private GameWindow gamewindow;
	private Snake snake;
	private Food food;
	private Renderer renderer;

	public Game() {
	}

	public void start() {

		snake = new Snake();

		gamewindow = new GameWindow(snake);
		renderer = gamewindow.getRenderer();
		food = new Food(snake, gamewindow.getDrawningArea());

		setElementstoScreen();

		Thread t = new Thread(this); // Cria nova Thread para rodar loop, separado da parte grafica
		t.start();

	}

	private void setElementstoScreen() {
		renderer.add(new Background());
		renderer.add(snake);
		renderer.add(food);
	}

	@Override
	public void run() {

		while (!isGameover()) {
			snake.move();
			food.checkIfEaten(snake, gamewindow.getDrawningArea());
			gamewindow.repaint();
			GameUtils.sleep(GAME_LOOP_TIME);

		}

		processGameOver();

	}

	public boolean isGameover() {
		return snake.collideWithitself() || isSnakeHitBounds();
	}

	public void processGameOver() {
		
		renderer.remove(snake);
		renderer.remove(food);
		renderer.add(new GameOverText(food.getEatenTimes()));
		
		//2:07:23
		gamewindow.repaint();
	}

	public boolean isSnakeHitBounds() {
		Rect head = snake.getFirsRect();
		Rect drawningArea = gamewindow.getDrawningArea();

		int headX = (int) head.getPoint().getX();
		int headY = (int) head.getPoint().getY();
		int minX = (int) drawningArea.getMinX();
		int maxX = (int) drawningArea.getMaxX();
		int minY = (int) drawningArea.getMinY();
		int maxY = (int) drawningArea.getMaxY();

		if (headX <= minX || headX + SNAKE_SIZE >= maxX) {
			return true;
		}

		if (headY <= minY || headY + SNAKE_SIZE >= maxY) {
			return true;
		}

		return false;
	}

}
