import java.util.List;

public class ChessBoard {
    private Box[][] boxes = new Box[8][8];
    //private List<Piece> removedPieces;

    public ChessBoard() {
        colorBoard(boxes);
        printBoard(boxes); //Note: just to display board
    }

    private void colorBoard(Box[][] boxes1) {
        // ODD columns
        // Coloring boxes BROWN-white-brown-white...
        List<char> AtoH = new List<char>();
        for (int i = 0; i < 8; i += 2) {
            for (int k = 0; k < 8; k += 2) {
                Box box = new Box(Box.Color.WHITE, AtoH[i],k+1);
                boxes1[i][k] = box;
            }
            for (int k = 1; k < 8; k += 2) {
                Box box = new Box(Box.Color.BROWN);
                boxes1[i][k] = box;
            }
        }

        // EVEN columns
        // coloring boxes WHITE-brown-white-brown....
        for (int i = 1; i < 8; i += 2) {
            for (int k = 0; k < 8; k += 2) {
                Box box = new Box(Box.Color.BROWN);
                boxes1[i][k] = box;
            }
            for (int k = 1; k < 8; k += 2) {
                Box box = new Box(Box.Color.WHITE);
                boxes1[i][k] = box;
            }
        }
    }

    public void printBoard(Box[][] boxes1){
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                System.out.print(boxes1[i][k].getColor() + " ");   // Todo: change .getColor() to getPiece()
            }
            System.out.println(" ");
        }
    }

    /*public boolean movePiece(pieceColor, int sourceX,int sourceY, int destX,int destY) {
        if (boxes[
    }*/


    /*public List<Piece> getRemovedPieces() {
        return removedPieces;
    }*/


}
