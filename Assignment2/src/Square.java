public class Square {
    enum Color {WHITE, BLACK;}

    private Color color;
    private Piece piece = null;

    public Square(Color pColor) {
        // color Box
        color = pColor;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isOccupied(){
        return !(piece==null);
    }

    //public void setPiece(Piece pPiece) {aPiece = pPiece}
}
