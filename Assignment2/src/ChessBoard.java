import java.util.ArrayList;

public class ChessBoard {
    private Box[][] boxes = new Box[8][8];
    // Do we need this?
    private ArrayList<Piece> removedPieces;

    public ChessBoard() {
        colorBoard(boxes);
        setStartingPieces();

        printBoard(boxes); //helping function
    }

    private void colorBoard(Box[][] boxes1) {
        // rows
        for (int i = 0; i < 8; i += 2) {
            // columns
            for (int k = 0; k < 8; k++) {
                // First row First column
                Box box11 = new Box(Box.Color.WHITE);
                boxes1[i][k] = box11;
                // First row Second column
                Box box12 = new Box(Box.Color.BROWN);
                boxes1[i][k + 1] = box12;
                // Second row First column
                Box box21 = new Box(Box.Color.BROWN);
                boxes1[i + 1][k] = box21;
                // Second row Second column
                Box box22 = new Box(Box.Color.WHITE);
                boxes1[i + 1][k + 1] = box22;
            }
        }
    }

    private void setStartingPieces() {
        // look through boxes
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                // if corner place rock
                if (i==0 && k==0 || i==0 && k== 7 || i==7 && k==0 || i==7 && k==7) {

                }
                // if second row place pawns
                // ...
            }
        }
    }

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

    public static int[] stringToInt(String str) {
        int first;
        int second;
        // a or A
        if ((int) str.charAt(0) == 97 || (int) str.charAt(0) == 65) { first = 7; }
        // b or B
        else if ((int) str.charAt(0) == 98 || (int) str.charAt(0) == 66) { first = 6; }
        // c or C
        else if ((int) str.charAt(0) == 99 || (int) str.charAt(0) == 67) { first = 5; }
        // d or D
        else if ((int) str.charAt(0) == 100 || (int) str.charAt(0) == 68) { first = 4; }
        // e or E
        else if ((int) str.charAt(0) == 101 || (int) str.charAt(0) == 69) { first = 3; }
        // f or F
        else if ((int) str.charAt(0) == 102 || (int) str.charAt(0) == 70) { first = 2; }
        // g or G
        else if ((int) str.charAt(0) == 103 || (int) str.charAt(0) == 71) { first = 1; }
        // h or H
        else if ((int) str.charAt(0) == 104 || (int) str.charAt(0) == 72) { first = 0; }
        // wrong input
        else { first = 100; }

        // 1
        if ((int) str.charAt(1) == 49) { second = 0; }
        // 2
        else if ((int) str.charAt(1) == 50) { second = 1; }
        // 3
        else if ((int) str.charAt(1) == 51) { second = 2; }
        // 4
        else if ((int) str.charAt(1) == 52) { second = 3; }
        // 5
        else if ((int) str.charAt(1) == 53) { second = 4; }
        // 6
        else if ((int) str.charAt(1) == 54) { second = 5; }
        // 7
        else if ((int) str.charAt(1) == 55) { second = 6; }
        // 8
        else if ((int) str.charAt(1) == 56) { second = 7; }
        // wrong input
        else { second = 100; }

        return new int[]{first, second};
    }


    // helping function
    public void printBoard(Box[][] boxes1){
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                System.out.print(boxes1[i][k].getaColor());   // Todo: change .getaColor() to getPiece()
            }
            System.out.println(" ");
        }
    }

}
