package snake.graphics;

import static snake.util.Constants.GAME_OVER_FONT_SIZE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class Text extends Drawable {

	private String text;
	private Point location;

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.setFont(new Font("Arial", Font.PLAIN, GAME_OVER_FONT_SIZE));
		g.drawString(text, (int) location.getX(), (int) location.getY());
	}

	public Text(String text, Point location, Color color) {
		this.text = text;
		this.location = location;
		setColor(color);
	}

}
