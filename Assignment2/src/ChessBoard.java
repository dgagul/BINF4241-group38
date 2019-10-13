import java.util.ArrayList;

public class ChessBoard {
    private Box[][] boxes = new Box[8][8];
    //private List<Piece> removedPieces;

    public ChessBoard() {
        colorBoard(boxes);
        printBoard(boxes); //Note: just to display board
    }

    private void colorBoard(Box[][] boxes1) {
        ArrayList<String> aTOh = new ArrayList<String>();
        aTOh.add("a");
        aTOh.add("b");
        aTOh.add("c");
        aTOh.add("d");
        aTOh.add("e");
        aTOh.add("f");
        aTOh.add("g");
        aTOh.add("h");

        // rows
        for (int i = 0; i < 8; i += 2) {
            // columns
            for (int k = 0; k < 8; k += 2) {
                // First row First column
                Box box11 = new Box(Box.Color.WHITE, aTOh.get(k), 8-i);
                boxes1[i][k] = box11;
                // First row Second column
                Box box12 = new Box(Box.Color.BROWN, aTOh.get(k+1), 8-i);
                boxes1[i][k + 1] = box12;
                // Second row First column
                Box box21 = new Box(Box.Color.BROWN, aTOh.get(k), 7-i);
                boxes1[i + 1][k] = box21;
                // Second row Second column
                Box box22 = new Box(Box.Color.WHITE, aTOh.get(k+1), 7-i);
                boxes1[i + 1][k + 1] = box22;
            }
        }
    }

    public void printBoard(Box[][] boxes1){
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                System.out.print(boxes1[i][k].getCoordinates() + " ");   // Todo: change .getColor() to getPiece()
            }
            System.out.println(" ");
        }
    }

    /*public boolean movePiece(piece, int sourceX,int sourceY, int destX,int destY) {
        if (boxes[     .getPiece() == piece)
    }*/


    /*public List<Piece> getRemovedPieces() {
        return removedPieces;
    }*/


}
