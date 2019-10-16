import java.util.ArrayList;

public class ChessBoard {
    private Box[][] boxes = new Box[8][8];
    //private List<Piece> removedPieces;

    public ChessBoard() {
        colorBoard(boxes);
        //setStartingPieces();

        printBoard(boxes); //helping function
    }

    private void colorBoard(Box[][] boxes1) {
        ArrayList<String> aTOh = new ArrayList<String>();
        aTOh.add("a");aTOh.add("b");aTOh.add("c");aTOh.add("d");aTOh.add("e");aTOh.add("f");aTOh.add("g");aTOh.add("h");

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

    //private void setStartingPieces() {
    /*    // look through boxes
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                // if corner place rock
                // if second row place pawns
                // ...
            }
        }
    }*/

    //public void movePiece(Piece piece, String fromLetter,int fromNumber, String toLetter,int toNumber) {
    /*    // letter coordinate to int
        int fromTrans = StrToInt(fromLetter);
        int toTrans = StrToInt(toLetter);

        if (boxes[fromNumber-1][fromTrans].aPiece == piece) {
            // set FROM box/square to empty
            boxes[fromNumber - 1][fromTrans].aPiece = null;
            if (boxes[toNumber - 1][toTrans].aPiece == null) {
                // place piece at TO box/square
                boxes[toNumber - 1][toTrans].aPiece = piece;
            }
            // check for check
            else if(boxes[toNumber - 1][toTrans].aPiece = piece instanceof King) {
                // Todo: set check
            }
            else { // Todo: eat piece}
        }
    }*/

    //private static Piece removePiece(Piece piece, String fromLetter, int fromNumber) {
    /*    int fromTrans = StrToInt(fromLetter);

        return piece;
    }*/

    //public List<Piece> getRemovedPieces() {
    /*    return removedPieces;
    }*/

    public static int StrToInt(String s) {
        if (s=="a") {return 1;}
        else if (s=="b") {return 1;}
        else if (s=="c") {return 2;}
        else if (s=="d") {return 3;}
        else if (s=="e") {return 4;}
        else if (s=="f") {return 5;}
        else if (s=="g") {return 6;}
        else if (s=="h") {return 7;}
        // wrong letter coordinate
        return 100;
    }


    // helping function
    public void printBoard(Box[][] boxes1){
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                System.out.print(boxes1[i][k].getCoordinates() + " ");   // Todo: change .getColor() to getPiece()
            }
            System.out.println(" ");
        }
    }

}
