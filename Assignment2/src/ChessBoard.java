import java.util.ArrayList;

public class ChessBoard {
    private Box[][] boxes;
    // Do we need this?
    private ArrayList<Piece> removedPieces;

    public ChessBoard() {
        boxes = new Box[8][8];
        colorBoard(boxes);
        setStartingPieces();
        printBoard(boxes);
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
                    Piece WT = new Tower(Piece.Color.WHITE, Piece.Name.WT);
                    boxes[i][k].setPiece(WT);
                }
                // place Knight
                if (i==7 && k==1 || i==7 && k== 6) {
                    Piece WN = new Knight(Piece.Color.WHITE, Piece.Name.WN);
                    boxes[i][k].setPiece(WN);
                }
                // place Bishop
                if (i==7 && k==2 || i==7 && k== 5) {
                    Piece WB = new Bishop(Piece.Color.WHITE, Piece.Name.WB);
                    boxes[i][k].setPiece(WB);
                }
                // place Queen
                if (i==7 && k==3) {
                    Piece WQ = new Queen(Piece.Color.WHITE, Piece.Name.WQ);
                    boxes[i][k].setPiece(WQ);
                }
                // place King
                if (i==7 && k==4) {
                    Piece WK = new King(Piece.Color.WHITE, Piece.Name.WK);
                    boxes[i][k].setPiece(WK);
                }
                // place Pawns
                if (i==6) {
                    Piece WP = new Pawn(Piece.Color.WHITE, Piece.Name.WP);
                    boxes[i][k].setPiece(WP);
                }


                // BLACK PIECES
                // place Rock
                if (i==0 && k==0 || i==0 && k== 7) {
                    Piece BT = new Tower(Piece.Color.BLACK, Piece.Name.BT);
                    boxes[i][k].setPiece(BT);
                }
                // place Knight
                if (i==0 && k==1 || i==0 && k== 6) {
                    Piece BN = new Knight(Piece.Color.BLACK, Piece.Name.BN);
                    boxes[i][k].setPiece(BN);
                }
                // place Bishop
                if (i==0 && k==2 || i==0 && k== 5) {
                    Piece BB = new Bishop(Piece.Color.BLACK, Piece.Name.BB);
                    boxes[i][k].setPiece(BB);
                }
                // place Queen
                if (i==0 && k==4) {
                    Piece BQ = new Queen(Piece.Color.BLACK, Piece.Name.BQ);
                    boxes[i][k].setPiece(BQ);
                }
                // place King
                if (i==0 && k==3) {
                    Piece BK = new King(Piece.Color.BLACK, Piece.Name.BK);
                    boxes[i][k].setPiece(BK);
                }
                // place Pawns
                if (i==1) {
                    Piece BP = new Pawn(Piece.Color.BLACK, Piece.Name.BP);
                    boxes[i][k].setPiece(BP);
                }
            }
        }
    }

    public Box[][] getBoxes() {
        Box[][] pBoxes = boxes;
        return pBoxes;
    }

    public static void printBoard(Box[][] boxes1){
        System.out.println(" ");
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (boxes1[i][k].getPiece() == null) {
                    System.out.print("[  ] ");
                }
                else {System.out.print("[" + boxes1[i][k].aPiece.getaName() + "] ");}
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }


}
