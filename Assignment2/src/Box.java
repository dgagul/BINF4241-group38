public class Box {
    public enum Color {WHITE, BROWN}
    private Color aColor;
    //public Piece aPiece;

    public Box(Color pColor) {
        // color Box
        if (pColor == Color.WHITE) {
            aColor = pColor;
        }
        else if (pColor == Color.BROWN){
            aColor = pColor;
        }

    }

    public Color getColor() {return aColor;}

    //public Piece getPiece() {return aPiece;}

    //public void setPiece(Piece pPiece) {aPiece = pPiece}
}
