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
                if (rankFrom >=0){ j = rankFrom; }
                if (aBoard[i][j].isOccupied()){
                    if(aBoard[i][j].getPiece().getClass() == p.getClass()){
                        if(aBoard[i][j].getPiece().getColor() == p.getColor()){
                            if(aBoard[i][j].getPiece().moveIsValid(i,j,fileTo,rankTo)){
                                if(checkPath(i, j, fileTo, rankTo)){
                                    Piece piece = board.getBoard()[i][j].getPiece();
                                    piece = checkKingOrTowerMove(piece);
                                    board.getBoard()[i][j].setPiece(null);
                                    board.getBoard()[fileTo][rankTo].setPiece(piece);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkPath(int fileFrom, int rankFrom, int fileTo, int rankTo){
        // horizontal move
        if(rankFrom == rankTo){
            if(fileFrom < fileTo){
                for(int i = fileFrom+1; i<=fileTo; i++){
                    if (board.getBoard()[i][rankTo].getPiece() != null)
                        return false;
                }
            }
            else {
                for(int i = fileFrom-1; i>=fileTo; i--){
                    if (board.getBoard()[i][rankTo].getPiece() != null)
                        return false;
                }
            }
        }
        // vertical move
        else if(fileFrom == fileTo){
            if(rankFrom < rankTo){
                for(int i = rankFrom+1; i<=rankTo; i++){
                    if (board.getBoard()[fileTo][i].getPiece() != null)
                        return false;
                }
            }
            else{
                for(int i = fileFrom-1; i>=fileTo; i--){
                    if (board.getBoard()[fileTo][i].getPiece() != null)
                        return false;
                }
            }
        }
        // diagonal move
        else if(rankFrom < rankTo && fileFrom > fileTo){
            int j = rankFrom + 1;
            for(int i = fileFrom-1; i>=fileTo; i--){
                if(board.getBoard()[i][j].getPiece() != null){
                    return false;
                }
                j++;
            }
        }
        else if(rankFrom > rankTo && fileFrom < fileTo){
            int j = rankFrom - 1;
            for(int i = fileFrom+1; i<=fileTo; i++){
                if(board.getBoard()[i][j].getPiece() != null){
                    return false;
                }
                j--;
            }
        }
        else {
            if(rankFrom < rankTo){
                int j = rankFrom +1;
                for(int i = fileFrom+1; i<=fileTo; i++){
                    if (board.getBoard()[i][j].getPiece() != null)
                        return false;
                    j++;
                }
            }
            else{
                int j = rankFrom-1;
                for(int i = fileFrom-1; i>=fileTo; i--){
                    if (board.getBoard()[i][j].getPiece() != null)
                        return false;
                    j--;
                }
            }
        }
        return true;
    }

    public static boolean promotion(Piece p, int fileFrom, int fileTo, Piece promoteTo){
        if(p.getColor() == Piece.Color.WHITE){
            if (move(p, fileFrom, 6, fileTo, 7)){
                board.getBoard()[fileTo][7].setPiece(promoteTo);
                return true;
            }
            return false;
        }
        else if(p.getColor() == Piece.Color.BLACK){
            if (move(p, fileFrom, 1, fileTo, 0)){
                board.getBoard()[fileTo][8].setPiece(promoteTo);
                return true;
            }
            return false;
        }
        return false;
    }

    public static Piece checkKingOrTowerMove(Piece piece){
        if(piece.getClass() == King.class){
            King king = (King)piece;
            king.setFirstMove(false);
            return king;
        }
        else if(piece.getClass() == Tower.class){
            Tower tower = (Tower)piece;
            tower.setFirstMove(false);
            return tower;
        }
        return piece;
    }

}
