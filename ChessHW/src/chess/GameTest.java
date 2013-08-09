package chess;

import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;
import pieces.Piece;
import util.StringUtil;
import junit.framework.TestCase;
import java.util.List;
import Test.BoardTest;

public class GameTest extends TestCase {
	private Game game;
	protected void setUp() {
	game = new Game();
	}
	public void testInitialize() {
		game.initialize();
		assertEquals(32, game.pieceCount());
		assertEquals(16, Piece.whitePieceCount());
		assertEquals(16, Piece.blackPieceCount());
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(
		StringUtil.appendNewLine("RNBQKBNR") +
		StringUtil.appendNewLine("PPPPPPPP") +
		blankRank + blankRank + blankRank + blankRank +
		StringUtil.appendNewLine("pppppppp") +
		StringUtil.appendNewLine("rnbqkbnr"),
		game.print());
	}
	public void testPieceCounts() {
		game.initialize();
		assertEquals(8, game.count(WHITE, PAWN));
		assertEquals(8, game.count(BLACK, PAWN));
		assertEquals(2, game.count(WHITE, ROOK));
		assertEquals(2, game.count(BLACK, ROOK));
		assertEquals(2, game.count(WHITE, KNIGHT));
		assertEquals(2, game.count(BLACK, KNIGHT));
		assertEquals(2, game.count(WHITE, BISHOP));
		assertEquals(2, game.count(BLACK, BISHOP));
		assertEquals(1, game.count(WHITE, QUEEN));
		assertEquals(1, game.count(BLACK, KING));
	}
	public void testPosition() {
		game.initialize();
		BoardTest.assertPiece(BLACK, KNIGHT, game.get("b8"));
		BoardTest.assertPiece(WHITE, KING, game.get("e1"));
	}
	public void testStrength() {
		game.put("a7", Piece.createBlackPawn());
		game.put("b6", Piece.createBlackPawn());
		game.put("b8", Piece.createBlackKing());
		game.put("c7", Piece.createBlackPawn());
		game.put("c8", Piece.createBlackRook());
		game.put("d7", Piece.createBlackBishop());
		game.put("e6", Piece.createBlackQueen());
		game.put("e1", Piece.createWhiteRook());
		game.put("f1", Piece.createWhiteKing());
		game.put("f2", Piece.createWhitePawn());
		game.put("f3", Piece.createWhitePawn());
		game.put("f4", Piece.createWhiteKnight());
		game.put("g2", Piece.createWhitePawn());
		game.put("g4", Piece.createWhiteQueen());
		game.put("h3", Piece.createWhitePawn());
		assertEquals(20.0, game.strength(BLACK));
		assertEquals(19.5, game.strength(WHITE));
	}
	public void testOrderByStrength() {
		game.put("a1", Piece.createWhiteQueen());
		game.put("a8", Piece.createBlackQueen());
		game.put("a7", Piece.createBlackRook());
		game.put("b2", Piece.createWhitePawn());
		List<Piece> pieces = game.piecesByStrength(BLACK);
		BoardTest.assertPiece(BLACK, QUEEN, pieces.get(0));
		BoardTest.assertPiece(BLACK, ROOK, pieces.get(1));
		pieces = game.piecesByStrength(WHITE);
		BoardTest.assertPiece(WHITE, QUEEN, pieces.get(0));
		BoardTest.assertPiece(WHITE, PAWN, pieces.get(1));
	}
	public void testKingMoveNotOnEdge() {
		game.put("d3", Piece.createBlackKing());
		List<String> squares = game.getPossibleMoves("d3");
		assertEquals(8, squares.size());
		assertTrue(squares.contains("c4"));
		assertTrue(squares.contains("d4"));
		assertTrue(squares.contains("e4"));
		assertTrue(squares.contains("c3"));
		assertTrue(squares.contains("e3"));
		assertTrue(squares.contains("c2"));
		assertTrue(squares.contains("d2"));
		assertTrue(squares.contains("e2"));
	}
	public void testKingMoveOnBoardEdge() {
		game.put("a1", Piece.createBlackKing());
		List<String> squares = game.getPossibleMoves("a1");
		assertEquals(3, squares.size());
		assertTrue(squares.contains("a2"));
		assertTrue(squares.contains("b2"));
		assertTrue(squares.contains("b1"));
	}
}