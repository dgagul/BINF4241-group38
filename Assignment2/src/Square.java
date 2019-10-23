public class Square {

    private Color.color color;
    private Piece piece = null;

    public Square(Color.color pColor) {
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
}
