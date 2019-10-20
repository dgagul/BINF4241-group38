public class Logic {

    private static Board board;

    Logic(Board board){
        this.board = board;
    }

    // CheckForCheck
    // CheckForCheckMate
    // CheckCoordinates
    // CheckPiece


    public Board getBoard() {
        Board aBoard = this.board;
        return aBoard;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static boolean move(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo){
        Square[][] aBoard = board.getBoard();
        for (int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if (fileFrom >= 0){ i = fileFrom; }
                else if (rankFrom >=0){j = rankFrom; }
                if (aBoard[i][j].isOccupied()){
                    if(aBoard[i][j].getPiece().getClass() == p.getClass()){
                        if(aBoard[i][j].getPiece().getColor() == p.getColor()){
                            if(aBoard[i][j].getPiece().moveIsValid(i,j,fileTo,rankTo)){
                                Piece piece = board.getBoard()[i][j].getPiece();
                                board.getBoard()[i][j].setPiece(null);
                                board.getBoard()[fileTo][rankTo].setPiece(piece);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void promotion(int fileTo, int rankTo, String promoteTo){

    }

    public static void

}
