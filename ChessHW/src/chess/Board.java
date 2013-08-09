package chess;
import java.util.*;
import pieces.Piece;
import util.Range;

public class Board {
	private List<ArrayList<Piece>> board =
	new ArrayList<ArrayList<Piece>>();
	private int pieceCount = 0;
	public Board() {
		fillBoard();
	}
	private void fillBoard() {
		addBlankRank();
		addBlankRank();
		addBlankRank();
		addBlankRank();
		addBlankRank();
		addBlankRank();
		addBlankRank();
		addBlankRank();
	}
	private void addBlankRank() {
		Piece blank = Piece.noPiece();
		ArrayList<Piece> rank = new ArrayList<Piece>();
		rank.add(blank);
		rank.add(blank);
		rank.add(blank);
		rank.add(blank);
		rank.add(blank);
		rank.add(blank);
		rank.add(blank);
		rank.add(blank);
		board.add(rank);
	}
	int pieceCount() {
		return pieceCount;
	}
	public List<Piece> get(int index) {
		return board.get(index);
	}
	public Piece get(String square) {
		List<Piece> rank = getRank(square);
		return rank.get(getFileIndex(square));
	}
	public void put(String square, Piece piece) {
		List<Piece> rank = getRank(square);
		rank.set(getFileIndex(square), piece);
	}
	private List<Piece> getRank(String square) {
		char rankChar = square.charAt(1);
		int rankIndex = 8 - Character.digit(rankChar, 10);
		return board.get(rankIndex);
	}
	public List<ArrayList<Piece>> ranks() {
		return board;
	}
	private int getFileIndex(String square) {
		char fileChar = square.charAt(0);
		return
		Character.getNumericValue(fileChar) -
		Character.getNumericValue('a');
	}
	char file(String square) {
		return square.charAt(0);
	}
	char rank(String square) {
		return square.charAt(1);
	}
	boolean isValidRank(int rank) {
		return new Range('1', '8').includes(rank);
	}
	boolean isValidFile(int file) {
		return new Range('a', 'h').includes(file);
	}
	String neighbor(String square, Direction direction) {
		StringBuilder builder = new StringBuilder();
		builder.append(toChar(file(square) + direction.getX()));
		builder.append(toChar(rank(square) + direction.getY()));
		return builder.toString();
	}
	private char toChar(int value) {
	switch (value) {
		case '1': return '1';
		case '2': return '2';
		case '3': return '3';
		case '4': return '4';
		case '5': return '5';
		case '6': return '6';
		case '7': return '7';
		case '8': return '8';
		case 'a': return 'a';
		case 'b': return 'b';
		case 'c': return 'c';
		case 'd': return 'd';
		case 'e': return 'e';
		case 'f': return 'f';
		case 'g': return 'g';
		case 'h': return 'h';
		default: return '?';
	}
	}
	boolean hasNeighbor(String square, Direction direction) {
		return
		isValidFile(file(square) + direction.getX()) &&
		isValidRank(rank(square) + direction.getY());
	}
}