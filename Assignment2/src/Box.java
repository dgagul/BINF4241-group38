public class Box {
    enum Color {WHITE, BLACK}
    private Color aColor;
    public Piece aPiece;

    public Box(Color pColor) {
        // color Box
        if (pColor == Color.WHITE) {
            aColor = pColor;
        }
        else if (pColor == Color.BLACK){
            aColor = pColor;
        }
    }

    public boolean isOccupied() {return (getPiece() != null);}

    public Piece getPiece() {Piece pPiece = aPiece; return pPiece;}

    public void setPiece(Piece pPiece) {aPiece = pPiece;}
}
