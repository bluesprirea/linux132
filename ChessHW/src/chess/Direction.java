package chess;

public enum Direction {
	NW(1, -1), N(1, 0), NE(1, 1),
	E(0, 1),
	SE(-1, 1), S(-1, 0), SW(-1, -1),
	W(0, -1);
	private int y;
	private int x;
	Direction(int y, int x) {
		this.y = y;
		this.x = x;
	}
	int getY() {
		return y;
	}
	int getX() {
		return x;
	}
}
