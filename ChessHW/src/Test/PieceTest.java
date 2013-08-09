package Test;

import pieces.Piece;
import pieces.Piece.Type;
import junit.framework.TestCase;



public class PieceTest extends TestCase {
	public void testCreate() {
		verifyCreation(
		Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
		verifyCreation(
		Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
		verifyCreation(
		Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
		verifyCreation(
		Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
		verifyCreation(
		Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
		verifyCreation(
		Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);
		Piece blank = Piece.noPiece();
		assertEquals('.', blank.getRepresentation());
		assertEquals(Type.NO_PIECE, blank.getType());
		}
		private void verifyCreation(Piece whitePiece, Piece blackPiece,
		Piece.Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(type.getRepresentation(),
		whitePiece.getRepresentation());
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(Character.toUpperCase(type.getRepresentation()),
		blackPiece.getRepresentation());
		}
		public void testColorCounts() {
		Piece.resetCounts();

		assertCounts(0, 0);
		Piece.createBlackBishop();
		assertCounts(1, 0);
		Piece.createBlackQueen();
		assertCounts(2, 0);
		Piece.createWhiteKing();
		assertCounts(2, 1);
		Piece.createBlackRook();
		assertCounts(3, 1);
		Piece.createWhitePawn();
		assertCounts(3, 2);
		Piece.createWhitePawn();
		assertCounts(3, 3);
		Piece.createBlackKnight();
		assertCounts(4, 3);

		}
		private void assertCounts(int blackCount, int whiteCount) {
		assertEquals(blackCount, Piece.blackPieceCount());
		assertEquals(whiteCount, Piece.whitePieceCount());
		}
}

