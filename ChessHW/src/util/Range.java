package util;

public class Range {
	private int start;
	private int stop;
	public Range(int start, int stop) {
		this.start = start;
		this.stop = stop;
	}
	public boolean includes(int ch) {
		return start <= ch && ch <= stop;
	}
}
