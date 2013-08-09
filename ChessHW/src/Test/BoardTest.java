package Test;

import junit.framework.TestCase;
import pieces.Piece;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;
import chess.Board;

public class BoardTest extends TestCase {
	private Board board;
	protected void setUp() {
		board = new Board();
	}
	public void testCreate() {
		assertEquals(Piece.noPiece(), board.get("a1"));
		assertEquals(Piece.noPiece(), board.get("a8"));
		assertEquals(Piece.noPiece(), board.get("h1"));
		assertEquals(Piece.noPiece(), board.get("h8"));
	}
	public void testPlacement() {
		board.put("b6", Piece.createBlackKing());
		board.put("b5", Piece.createBlackRook());
		board.put("c4", Piece.createWhiteKing());
		assertPiece(BLACK, KING, board.get("b6"));
		assertPiece(BLACK, ROOK, board.get("b5"));
		assertPiece(WHITE, KING, board.get("c4"));
	}
	public static void assertPiece(
		Piece.Color color, Piece.Type type, Piece piece) {
		assertEquals(color, piece.getColor());
		assertEquals(type, piece.getType());
	}
}