public class Board {
    private Square[][] board = new Square[8][8];

    public Board() {
        initializeBoard();
        setPieces();
        printBoard(); //helping function
    }

    private void initializeBoard() {
        // rows
        for (int i = 0; i < 7; i+=2) {
            // columns
            for (int k = 0; k < 7; k += 2) {
                // First row First column
                board[i][k] = new Square(Square.Color.BLACK);
                // First row Second column
                board[i][k + 1] = new Square(Square.Color.WHITE);
                // Second row First column
                board[i + 1][k] = new Square(Square.Color.WHITE);
                // Second row Second column
                board[i + 1][k + 1] = new Square(Square.Color.BLACK);
            }
        }
    }

    private void setPieces(){
        int pawns = 8;
        for(int i=0; i<pawns; i++){
            board[i][1].setPiece(new Pawn(true, Piece.Color.WHITE));
        }
        board[0][0].setPiece(new Tower(true, Piece.Color.WHITE));
        board[7][0].setPiece(new Tower(true, Piece.Color.WHITE));
        board[1][0].setPiece(new Knight(true, Piece.Color.WHITE));
        board[6][0].setPiece(new Knight(true, Piece.Color.WHITE));
        board[2][0].setPiece(new Bishop(true, Piece.Color.WHITE));
        board[5][0].setPiece(new Bishop(true, Piece.Color.WHITE));
        board[3][0].setPiece(new Queen(true, Piece.Color.WHITE));
        board[4][0].setPiece(new King(true, Piece.Color.WHITE));

        for(int i=0; i<pawns; i++){
            board[i][6].setPiece(new Pawn(true, Piece.Color.BLACK));
        }
        board[0][7].setPiece(new Tower(true, Piece.Color.BLACK));
        board[7][7].setPiece(new Tower(true, Piece.Color.BLACK));
        board[1][7].setPiece(new Knight(true, Piece.Color.BLACK));
        board[6][7].setPiece(new Knight(true, Piece.Color.BLACK));
        board[2][7].setPiece(new Bishop(true, Piece.Color.BLACK));
        board[5][7].setPiece(new Bishop(true, Piece.Color.BLACK));
        board[3][7].setPiece(new Queen(true, Piece.Color.BLACK));
        board[4][7].setPiece(new King(true, Piece.Color.BLACK));
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

    public static int StrToInt(String s) {
        // ToDo: move to Game.java
        if (s.equals("a")) {return 0;}
        else if (s.equals("b")) {return 1;}
        else if (s.equals("c")) {return 2;}
        else if (s.equals("d")) {return 3;}
        else if (s.equals("e")) {return 4;}
        else if (s.equals("f")) {return 5;}
        else if (s.equals("g")) {return 6;}
        else if (s.equals("h")) {return 7;}
        // wrong letter coordinate
        return -1;
    }


    // helping function
    public void printBoard(){
        for (int i = 7; i >=0; i--) {
            for (int k = 0; k <=7; k++) {
                Piece currPiece = board[k][i].getPiece();
                if(currPiece != null){
                    System.out.print("[" + currPiece.toString() + "] ");
                }
                else {
                    System.out.print("[  ] ");
                }
            }
            System.out.println(" ");
        }
    }

}
