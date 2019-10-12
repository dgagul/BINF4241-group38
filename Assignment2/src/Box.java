public class Box {
    enum Color {WHITE, BROWN}
    private Color aColor;
    private char X;
    private int Y;
    //public Piece aPiece;

    public Box(Color pColor, char pX, int pY) {
        // color Box
        if (pColor == Color.WHITE) {
            aColor = pColor;
            X = pX;
            Y = pY;
        }
        else if (pColor == Color.BROWN){
            aColor = pColor;
            X = pX;
            Y = pY;
        }

    }

    public Color getColor() {return aColor;}

    //public Piece getPiece() {return aPiece;}

    //public void setPiece(Piece pPiece) {aPiece = pPiece}
}
