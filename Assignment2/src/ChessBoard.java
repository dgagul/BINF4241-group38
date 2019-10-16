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
            for (int k = 0; k < 8; k += 2) {
                // First row First column
                Box box11 = new Box(Box.Color.WHITE);
                boxes1[i][k] = box11;
                // First row Second column
                Box box12 = new Box(Box.Color.BLACK);
                boxes1[i][k + 1] = box12;
                // Second row First column
                Box box21 = new Box(Box.Color.BLACK);
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

                // WHITE PIECES
                // place Rock
                if (i==7 && k==0 || i==7 && k== 7) {
                    Piece WT = new Tower(Piece.Color.WHITE, "WT");
                    boxes[i][k].setPiece(WT);
                }
                // place Knight
                if (i==7 && k==1 || i==7 && k== 6) {
                    Piece WN = new Knight(Piece.Color.WHITE, "WN");
                    boxes[i][k].setPiece(WN);
                }
                // place Bishop
                if (i==7 && k==2 || i==7 && k== 5) {
                    Piece WB = new Bishop(Piece.Color.WHITE, "WB");
                    boxes[i][k].setPiece(WB);
                }
                // place Queen
                if (i==7 && k==3) {
                    Piece WQ = new Queen(Piece.Color.WHITE, "WQ");
                    boxes[i][k].setPiece(WQ);
                }
                // place King
                if (i==7 && k==4) {
                    Piece WK = new King(Piece.Color.WHITE, "WK");
                    boxes[i][k].setPiece(WK);
                }
                // place Pawns
                if (i==6) {
                    Piece WP = new Pawn(Piece.Color.WHITE, "PA");
                    boxes[i][k].setPiece(WP);
                }


                // BLACK PIECES
                // place Rock
                if (i==0 && k==0 || i==0 && k== 7) {
                    Piece BR = new Tower(Piece.Color.BLACK, "BR");
                    boxes[i][k].setPiece(BR);
                }
                // place Knight
                if (i==0 && k==1 || i==0 && k== 6) {
                    Piece BN = new Knight(Piece.Color.BLACK, "BN");
                    boxes[i][k].setPiece(BN);
                }
                // place Bishop
                if (i==0 && k==2 || i==0 && k== 5) {
                    Piece BB = new Bishop(Piece.Color.BLACK, "BB");
                    boxes[i][k].setPiece(BB);
                }
                // place Queen
                if (i==0 && k==4) {
                    Piece BQ = new Queen(Piece.Color.BLACK, "BQ");
                    boxes[i][k].setPiece(BQ);
                }
                // place King
                if (i==0 && k==3) {
                    Piece BK = new King(Piece.Color.BLACK, "BK");
                    boxes[i][k].setPiece(BK);
                }
                // place Pawns
                if (i==1) {
                    Piece WP = new Pawn(Piece.Color.WHITE, "WP");
                    boxes[i][k].setPiece(WP);
                }
            }
        }
    }

    // Todo: check rules, public or private
    public void movePiece(Piece piece, String from, String to) {
        // letter coordinate to int
        int[] fromTrans = stringToInt(from);
        int[] toTrans = stringToInt(to);

        if (boxes[fromTrans[0]][fromTrans[1]].aPiece == piece) {
            // Todo: is move is allowed for this piece
            // Todo: is no other piece blocking the way
            // Todo: is TO occupied
            // Todo: is it check, if no
            //      eatPiece(piece, boxes[toTrans[0]][toTrans[1]].aPiece, fromTrans, toTrans);
            // Todo: is it checkmate
        }
    }

    private void eatPiece(Piece predator, Piece prey, int[] from, int[] to) {
            boxes[from[0]][from[1]].aPiece = null;
            boxes[to[0]][to[1]].aPiece = predator;
    }

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
    public static void printBoard(Box[][] boxes1){
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (boxes1[i][k].getPiece() == null) {
                    System.out.print("[  ] ");
                }
                else {System.out.print("[" + boxes1[i][k].aPiece.getaName() + "] ");}
            }
            System.out.println(" ");
        }
    }

}
