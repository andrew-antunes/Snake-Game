package snake.core;

import static snake.util.Constants.GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS;
import static snake.util.Constants.GAME_TITLE;
import static snake.util.Constants.WINDOW_HEIGTH;
import static snake.util.Constants.WINDOW_WIDTH;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import snake.graphics.Rect;
import snake.graphics.Renderer;
import snake.scene.Snake;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements KeyListener {

	private Renderer renderer;
	private Snake snake;
	private Image buffer;
	private Graphics gImage;
	private Rect drawningArea;
	private long lastKeyboardEventTime;
	
	public GameWindow(Snake snake) {

		this.snake = snake;
		renderer = new Renderer();

		setTitle(GAME_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGTH);
		setLocationRelativeTo(null); // Centraliza a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra a aplicação quando fechar a janela
		setResizable(false);
		addKeyListener(this);
		setVisible(true);

		buffer = createImage(WINDOW_WIDTH, WINDOW_HEIGTH);
		gImage = buffer.getGraphics();

		defineDrawingArea();
	}

	private void defineDrawingArea() {
		int upperY = WINDOW_HEIGTH - (int) getContentPane().getSize().getHeight();
		drawningArea = new Rect(0, upperY, WINDOW_WIDTH, WINDOW_HEIGTH - upperY);

	}

	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public void paint(Graphics g) {
		if (renderer != null && gImage != null && buffer != null) {
			renderer.render(gImage);
			g.drawImage(buffer, 0, 0, null);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		long now = System.currentTimeMillis();

		if (now - lastKeyboardEventTime < GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS) {
			return;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			snake.up();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			snake.down();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			snake.left();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			snake.right();
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}

		lastKeyboardEventTime = now;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public Rect getDrawningArea() {
		return drawningArea;
	}

}
