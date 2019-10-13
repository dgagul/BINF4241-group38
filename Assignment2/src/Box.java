public class Box {
    enum Color {WHITE, BROWN}
    private Color aColor;
    private String X;
    private int Y;
    // Todo: public Piece aPiece;

    public Box(Color pColor, String pX, int pY) {
        // color Box
        if (pColor == Color.WHITE) {
            aColor = pColor;
        }
        else if (pColor == Color.BROWN){
            aColor = pColor;
        }
        // add coordinates
        X = pX;
        Y = pY;
        //aPiece = new Piece();
    }

    public Color getColor() {return aColor;}

    public String getCoordinates() {
        String y = Integer.toString(Y);
        return (X + y);
    }

    //public Piece getPiece() {return aPiece;}

    //public void setPiece(Piece pPiece) {aPiece = pPiece}
}
