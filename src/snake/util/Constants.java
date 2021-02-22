package snake.util;

import java.awt.Color;
import java.awt.Point;

public class Constants {

	public static final String GAME_TITLE = "Snake Game!";
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGTH = 600;

	public static final Color BACKGROUND_COLOR = Color.DARK_GRAY;

	public static final Color SNAKE_COLOR = Color.WHITE;
	public static final int SNAKE_SIZE = 10;
	public static final int SNAKE_INITIAL_LENGTH = 3;
	public static final int SNAKE_INITIAL_X = 400;
	public static final int SNAKE_INITIAL_Y = 300;

	public static final Color FOOD_COLOR = Color.RED;
	public static final int FOOD_SIZE = 10;

	public static final int GAME_LOOP_TIME = 40;
	public static final int GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS = 40;
	public static final int PIECES_TO_ELONGATE = 5;

	public static final String GAME_OVER_TEXT = "GAME OVER! \n %d PONTOS";
	public static final Color GAME_OVER_COLOR = Color.RED;
	public static final int GAME_OVER_FONT_SIZE = 20;
	public static final Point GAME_OVER_LOCATION = new Point(WINDOW_WIDTH / 2 - 100, WINDOW_HEIGTH / 2);

}
