public class Box {
    enum Color {WHITE, BROWN}
    private Color aColor;
    public Piece aPiece;

    public Box(Color pColor) {
        // color Box
        if (pColor == Color.WHITE) {
            aColor = pColor;
        }
        else if (pColor == Color.BROWN){
            aColor = pColor;
        }
    }



    public Piece getPiece() {Piece pPiece = aPiece; return pPiece;}

    public void setPiece(Piece pPiece) {aPiece = pPiece;}

    public Color getaColor() {Color pColor = aColor; return pColor;}
}
