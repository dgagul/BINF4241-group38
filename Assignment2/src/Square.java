public class Square {

    private Color.color color;
    private Piece piece = null;

<<<<<<< HEAD
    public Square(Color.color pColor) {
=======
    Square(Color pColor) {
        // color Box
>>>>>>> master
        color = pColor;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    boolean isOccupied(){
        return !(piece==null);
    }
}

