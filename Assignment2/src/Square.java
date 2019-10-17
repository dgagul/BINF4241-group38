public class Square {
    enum Color {WHITE, BLACK;}

    private Color aColor;
    private Piece aPiece = null;

    public Square(Color pColor) {
        // color Box
        aColor = pColor;
    }

    public void setPiece(Piece piece) {
        aPiece = piece;
    }

    public Piece getPiece() {
        return aPiece;
    }

    //public void setPiece(Piece pPiece) {aPiece = pPiece}
}
