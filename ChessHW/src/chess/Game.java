package chess;
import pieces.Piece;
import java.util.*;
import util.StringUtil;
import chess.Board;
public class Game {
	private Board board = new Board();
	private int pieceCount = 0;
	public void initialize() {
		Piece.resetCounts();
		addBlackBackRank();
		addBlackPawnRank();
		addWhitePawnRank();
		addWhiteBackRank();
		pieceCount = 32;
	}
	public int pieceCount() {
		return pieceCount;
	}
	public Piece get(String square) {
		return board.get(square);
	}
	public void put(String square, Piece piece) {
		board.put(square, piece);
	}
	private void addBlackBackRank() {
		put("a8", Piece.createBlackRook());
		put("b8", Piece.createBlackKnight());
		put("c8", Piece.createBlackBishop());
		put("d8", Piece.createBlackQueen());
		put("e8", Piece.createBlackKing());
		put("f8", Piece.createBlackBishop());
		put("g8", Piece.createBlackKnight());
		put("h8", Piece.createBlackRook());
	}
	private void addWhiteBackRank() {
		put("a1", Piece.createWhiteRook());
		put("b1", Piece.createWhiteKnight());
		put("c1", Piece.createWhiteBishop());
		put("d1", Piece.createWhiteQueen());
		put("e1", Piece.createWhiteKing());
		put("f1", Piece.createWhiteBishop());
		put("g1", Piece.createWhiteKnight());
		put("h1", Piece.createWhiteRook());
	}
	private void addWhitePawnRank() {
		put("a2", Piece.createWhitePawn());
		put("b2", Piece.createWhitePawn());
		put("c2", Piece.createWhitePawn());
		put("d2", Piece.createWhitePawn());
		put("e2", Piece.createWhitePawn());
		put("f2", Piece.createWhitePawn());
		put("g2", Piece.createWhitePawn());
		put("h2", Piece.createWhitePawn());
	}
	private void addBlackPawnRank() {
		put("a7", Piece.createBlackPawn());
		put("b7", Piece.createBlackPawn());
		put("c7", Piece.createBlackPawn());
		put("d7", Piece.createBlackPawn());
		put("e7", Piece.createBlackPawn());
		put("f7", Piece.createBlackPawn());
		put("g7", Piece.createBlackPawn());
		put("h7", Piece.createBlackPawn());
	}
	public String print() {
		StringBuilder builder = new StringBuilder();
		for (ArrayList<Piece> rank: board.ranks()) {
			StringBuilder line = new StringBuilder();
			for (Piece piece: rank)
				line.append(piece.getRepresentation());
				builder.append(StringUtil.appendNewLine(line.toString()));
		}
		return builder.toString();
	}
	public int count(Piece.Color color, Piece.Type type) {
		int total = 0;
		for (List<Piece> rank: board.ranks())
			for (Piece piece: rank)
					if (piece.getColor().equals(color) &&
						piece.getType().equals(type))
						total++;
		return total;
	}
	public List<Piece> piecesByStrength(Piece.Color color) {
		List<Piece> pieces = ratePiecesForStrength(color);
		return pieces;
	}
	public double strength(Piece.Color color) {
		double strength = 0;
		List<Piece> pieces = ratePiecesForStrength(color);
		for (Piece piece: pieces)
			strength += piece.getStrength();
		return strength;
	}
	private List<Piece> ratePiecesForStrength(Piece.Color color) {
		List<Piece> pieces = new ArrayList<Piece>();
		int rankIndex = 0;
			for (List<Piece> rank: board.ranks()) {
				int fileIndex = 0;
				for (Piece piece: rank) {
						if (piece.getColor().equals(color)) {
							piece.setStrength(
							strength(color, piece, rankIndex, fileIndex));
							pieces.add(piece);
							}
							fileIndex++;
							}
							rankIndex++;
							}
		return pieces;
	}
	private double strength(
		Piece.Color color, Piece piece, int rank, int file) {
		if (piece.getType().equals(Piece.Type.PAWN) &&
		otherPawnsInSameFile(color, rank, file))
			return 0.5;
		return piece.getType().getBaseValue();
	}
	private boolean otherPawnsInSameFile(
		Piece.Color color, int rankIndex, int fileIndex) {
		int index = 0;
		for (List<Piece> rank: board.ranks()) {
			if (index != rankIndex) {
				Piece piece = rank.get(fileIndex);
				if (piece.getColor().equals(color) &&
						piece.getType().equals(Piece.Type.PAWN))
						return true;
						}
				index++;
		}
	return false;
	}
	public List<String> getPossibleMoves(String square) {
		Piece piece = get(square);
		List<String> moves = new ArrayList<String>();
		if (piece.getType().equals(Piece.Type.KING)) {
			for (Direction direction: Direction.values())
				if (board.hasNeighbor(square, direction))
					moves.add(board.neighbor(square, direction));
				}
				else {
					for (Direction direction: Direction.values())
						gatherToEdge(moves, square, direction);
			}
		return moves;
	}
	private void gatherToEdge(
		List<String> moves, String square, Direction direction) {
		if (board.hasNeighbor(square, direction)) {
			String neighbor = board.neighbor(square, direction);
			moves.add(neighbor);
			gatherToEdge(moves, neighbor, direction);
		}
	}
}