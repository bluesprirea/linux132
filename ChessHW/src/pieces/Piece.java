package pieces;

public class Piece {
	
	private double strength;
	public void setStrength(double strength) {
		this.strength = strength;
		}
		public double getStrength() {
		return strength;
		}
		
		public int compareTo(Piece that) {
		if (this.strength < that.strength)
		return 1;
		if (this.strength > that.strength)
		return 0;
		return -1;
		}
	
	
	public static Piece createWhitePawn() {
		return create(Color.WHITE, Type.PAWN);
		}
		public static Piece createBlackPawn() {
		return create(Color.BLACK, Type.PAWN);
		}
		public static Piece createWhiteRook() {
		return create(Color.WHITE, Type.ROOK);
		}
		public static Piece createBlackRook() {
		return create(Color.BLACK, Type.ROOK);
		}
		public static Piece createWhiteKnight() {
		return create(Color.WHITE, Type.KNIGHT);
		}
		public static Piece createBlackKnight() {
		return create(Color.BLACK, Type.KNIGHT);
		}
		public static Piece createWhiteBishop() {
		return create(Color.WHITE, Type.BISHOP);
		}
		public static Piece createBlackBishop() {
		return create(Color.BLACK, Type.BISHOP);
		}
		public static Piece createWhiteQueen() {
		return create(Color.WHITE, Type.QUEEN);
		}
		public static Piece createBlackQueen() {
		return create(Color.BLACK, Type.QUEEN);
		}
		public static Piece createWhiteKing() {
		return create(Color.WHITE, Type.KING);
		}
		public static Piece createBlackKing() {
		return create(Color.BLACK, Type.KING);
		}
		private static Piece create(Color color, Type type) {
		if (color.equals(Color.WHITE))
		whitePieceCount++;
		else
		blackPieceCount++;
		return new Piece(color, type);
		}
	public enum Color { WHITE, BLACK };
	public enum Type {
		PAWN(1.0, 'p'),
		ROOK(5.0, 'r'),
		KNIGHT(2.5, 'n'),
		BISHOP(3.0, 'b'),
		QUEEN(9.0, 'q'),
		KING(0.0, 'k'),
		NO_PIECE(0, '.');
		private double baseValue;
		private char representation;
		Type(double baseValue, char representation) {
			this.baseValue = baseValue;
			this.representation = representation;
		}
		public double getBaseValue() {
			return baseValue;
		}
		public char getRepresentation() {
			return representation;
		}
		};
		
	public static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'n';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';
	public static final Piece noPiece =
	new Piece(Color.WHITE, Type.NO_PIECE);
	private static int whitePieceCount = 0;
	private static int blackPieceCount = 0;
	private Color color;
	private Type type;
	
	public static Piece noPiece() {
	return noPiece;
	}
	public static int whitePieceCount() {
	return whitePieceCount;
	}
	public static int blackPieceCount() {
	return blackPieceCount;
	}
	public static void resetCounts() {
	whitePieceCount = 0;
	blackPieceCount = 0;
	}
	private Piece(Color color, Type type) {
	this.color = color;
	this.type = type;
	}
	public Color getColor() {
	return color;
	}
	public Type getType() {
	return type;
	}

	public char getRepresentation() {
			char representation = type.getRepresentation();
			if (color.equals(Color.BLACK))
			representation = Character.toUpperCase(representation);
			return representation;
	}
	public boolean isWhite() {
	return color.equals(Color.WHITE);
	}
	public boolean isBlack() {
	return color.equals(Color.BLACK);
	}
}
