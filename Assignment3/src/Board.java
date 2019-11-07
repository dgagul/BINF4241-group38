class Board {
    private Square[][] board = new Square[8][8];


    Board() {
        initializeBoard();
        setPieces();
        printBoard(); //helping function
    }

    Square[][] getBoard(){
        return board;
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
                // Second row First   column
                board[i + 1][k] = new Square(Square.Color.WHITE);
                // Second row Second column
                board[i + 1][k + 1] = new Square(Square.Color.BLACK);
            }
        }
    }

    private void setPieces(){
        int pawns = 8;
        for(int i=0; i<pawns; i++){
            board[i][1].setPiece(new Pawn(true, Color.color.WHITE));
        }
        board[0][0].setPiece(new Tower(true, Color.color.WHITE));
        board[7][0].setPiece(new Tower(true, Color.color.WHITE));
        board[1][0].setPiece(new Knight(true, Color.color.WHITE));
        board[6][0].setPiece(new Knight(true, Color.color.WHITE));
        board[2][0].setPiece(new Bishop(true, Color.color.WHITE));
        board[5][0].setPiece(new Bishop(true, Color.color.WHITE));
        board[3][0].setPiece(new Queen(true, Color.color.WHITE));
        board[4][0].setPiece(new King(true, Color.color.WHITE));

        for(int i=0; i<pawns; i++){
            board[i][6].setPiece(new Pawn(true, Color.color.BLACK));
        }
        board[0][7].setPiece(new Tower(true, Color.color.BLACK));
        board[7][7].setPiece(new Tower(true, Color.color.BLACK));
        board[1][7].setPiece(new Knight(true, Color.color.BLACK));
        board[6][7].setPiece(new Knight(true, Color.color.BLACK));
        board[2][7].setPiece(new Bishop(true, Color.color.BLACK));
        board[5][7].setPiece(new Bishop(true, Color.color.BLACK));
        board[3][7].setPiece(new Queen(true, Color.color.BLACK));
        board[4][7].setPiece(new King(true, Color.color.BLACK));
    }


    // helping function
    void printBoard(){
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
