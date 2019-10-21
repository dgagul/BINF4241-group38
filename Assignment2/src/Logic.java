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

    //Lynn enPassant
    //Problems: How to access isCaptured + how to access currentPlayer?

    public static void enPassant(Piece p, int fileFrom, int fileTo, int rankFrom, int rankTo) {
        if (Game.isCaptured) { //how to access isCaptured from Game class readInput()??
            //playerWhite
            if (p.Color == Piece.Color.WHITE) {
                        // if both on the rank 5
                if (rankFrom == 5 && (Game.getlastMove()[2] == rankFrom) &&
                        // and next together
                        (fileFrom == Game.getlastMove()[1] - 1 || fileFrom == Game.getlastMove()[1] + 1) &&
                        // and last move was 2 forward
                        (Game.getlastMove()[2] - Game.getlastMove()[3] == 2) &&
                        // and last moved Piece was a Pawn
                        (Game.getlastMove()[4] == 1) &&
                        // and move is diagonal 1 field
                        (fileTo == Game.getlastMove()[1] && rankTo == Game.getlastMove()[3] + 1))
                        {move(p, fileFrom, fileTo, rankFrom, rankTo); }}
            //playerBlack
            else {
                if (rankFrom == 4 && Game.getlastMove()[3] == rankFrom &&
                        // and next together
                        (fileFrom == Game.getlastMove()[1] - 1 || fileFrom == Game.getlastMove()[1] + 1) &&
                        // and last move was 2 forward
                        Game.getlastMove()[2] - Game.getlastMove()[3] == -2 &&
                        // and last moved piece was a pawn
                        Game.getlastMove()[4] == 1 &&
                        // and move is diagonal 1 field
                        (fileTo == Game.getlastMove()[1] && rankTo == Game.getlastMove()[3] - 1))
                    { move(p, fileFrom, fileTo, rankFrom, rankTo); }
            }}

        else { }

    }}
