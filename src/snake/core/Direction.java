package snake.core;

public enum Direction {

	NONE(0, 0), UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGTH(1, 0);

	int x;
	int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean canChangeTo(Direction d) {
		return !(getX() + d.getX() == 0 && getY() + d.getY() == 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
