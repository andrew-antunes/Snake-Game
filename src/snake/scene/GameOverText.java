package snake.scene;

import static snake.util.Constants.GAME_OVER_COLOR;
import static snake.util.Constants.GAME_OVER_LOCATION;
import static snake.util.Constants.GAME_OVER_TEXT;

import snake.graphics.Text;

public class GameOverText extends Text {

	public GameOverText(int score) {
		super(String.format(GAME_OVER_TEXT, score), GAME_OVER_LOCATION, GAME_OVER_COLOR);
	}

}
