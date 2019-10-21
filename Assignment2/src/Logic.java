public class Logic {

    private static Board board;

    Logic(Board board) {
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

    public static boolean move(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        Square[][] aBoard = board.getBoard();
        int iter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                iter++;
                // abortion criteria if userInput is invalid
                if (iter == 64)
                    return false;
                if (fileFrom >= 0) {
                    i = fileFrom;
                }
                if (rankFrom >= 0) {
                    j = rankFrom;
                }
                if (aBoard[i][j].isOccupied()) {
                    if (aBoard[i][j].getPiece().getClass() == p.getClass()) {
                        if (aBoard[i][j].getPiece().getColor() == p.getColor()) {
                            if (aBoard[i][j].getPiece().moveIsValid(i, j, fileTo, rankTo)) {
                                if (checkPath(i, j, fileTo, rankTo)) {
                                    Piece piece = board.getBoard()[i][j].getPiece();
                                    piece = checkKingOrTowerMove(piece);
                                    board.getBoard()[i][j].setPiece(null);
                                    board.getBoard()[fileTo][rankTo].setPiece(piece);
                                    Game.setLastMove(new int[]{i, fileTo, j, rankTo});
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

    public static boolean capture(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        // ToDo: add piece to captured_pieces
        if (p.getClass() == Pawn.class) {
            if (p.getColor() == Piece.Color.WHITE) {
                rankFrom = rankTo - 1;
            } else {
                rankFrom = rankTo + 1;
            }
            Piece pawn = board.getBoard()[fileFrom][rankFrom].getPiece();
            if (pawn == null || pawn.getClass() != Pawn.class)
                return false;
            if (board.getBoard()[fileTo][rankTo].getPiece() == null || board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor())
                return false;
            board.getBoard()[fileFrom][rankFrom].setPiece(null);
            board.getBoard()[fileTo][rankTo].setPiece(p);
            return true;
        }
        Piece captured = board.getBoard()[fileTo][rankTo].getPiece();
        if (captured != null) {
            board.getBoard()[fileTo][rankTo].setPiece(null);
            if (!move(p, fileFrom, rankFrom, fileTo, rankTo)) {
                board.getBoard()[fileTo][rankTo].setPiece(captured);
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkPath(int fileFrom, int rankFrom, int fileTo, int rankTo) {
        // horizontal move
        Piece p = board.getBoard()[fileFrom][rankFrom].getPiece();
        if (p.getClass() == Knight.class) {
            return (board.getBoard()[fileTo][rankTo].getPiece() == null);
        }
        if (rankFrom == rankTo) {
            if (fileFrom < fileTo) {
                for (int i = fileFrom + 1; i <= fileTo; i++) {
                    if (board.getBoard()[i][rankTo].getPiece() != null)
                        return false;
                }
            } else {
                for (int i = fileFrom - 1; i >= fileTo; i--) {
                    if (board.getBoard()[i][rankTo].getPiece() != null)
                        return false;
                }
            }
        }
        // vertical move
        else if (fileFrom == fileTo) {
            if (rankFrom < rankTo) {
                for (int i = rankFrom + 1; i <= rankTo; i++) {
                    if (board.getBoard()[fileTo][i].getPiece() != null)
                        return false;
                }
            } else {
                for (int i = rankFrom - 1; i >= rankTo; i--) {
                    if (board.getBoard()[fileTo][i].getPiece() != null)
                        return false;
                }
            }
        }
        // diagonal move
        else if (rankFrom < rankTo && fileFrom > fileTo) {
            int j = rankFrom + 1;
            for (int i = fileFrom - 1; i >= fileTo; i--) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    return false;
                }
                j++;
            }
        } else if (rankFrom > rankTo && fileFrom < fileTo) {
            int j = rankFrom - 1;
            for (int i = fileFrom + 1; i <= fileTo; i++) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    return false;
                }
                j--;
            }
        } else {
            if (rankFrom < rankTo) {
                int j = rankFrom + 1;
                for (int i = fileFrom + 1; i <= fileTo; i++) {
                    if (board.getBoard()[i][j].getPiece() != null)
                        return false;
                    j++;
                }
            } else {
                int j = rankFrom - 1;
                for (int i = fileFrom - 1; i >= fileTo; i--) {
                    if (board.getBoard()[i][j].getPiece() != null)
                        return false;
                    j--;
                }
            }
        }
        return true;
    }

    public static boolean castling(boolean kingSide, Player.Color col) {
        Piece k;
        Piece t;
        if (kingSide) {
            if (col == Player.Color.WHITE) {
                k = board.getBoard()[4][0].getPiece();
                t = board.getBoard()[7][0].getPiece();
            } else {
                k = board.getBoard()[4][7].getPiece();
                t = board.getBoard()[7][7].getPiece();
            }
            if (k.getClass() == King.class && t.getClass() == Tower.class) {
                King king = (King) k;
                Tower tower = (Tower) t;
                if (!king.isFirstMove() || !tower.isFirstMove()) {
                    return false;
                }
                for (int i = 5; i < 7; i++) {
                    if (col == Player.Color.WHITE) {
                        if (board.getBoard()[i][0].getPiece() != null || checkForCheck())
                            return false;
                        board.getBoard()[4][0].setPiece(null);
                        board.getBoard()[7][0].setPiece(null);
                        board.getBoard()[6][0].setPiece(k);
                        board.getBoard()[5][0].setPiece(t);
                    } else {
                        if (board.getBoard()[i][7].getPiece() != null || checkForCheck())
                            return false;
                        board.getBoard()[4][7].setPiece(null);
                        board.getBoard()[7][7].setPiece(null);
                        board.getBoard()[6][7].setPiece(k);
                        board.getBoard()[5][7].setPiece(t);
                    }
                }
            }
        }
        if (!kingSide) {
            if (col == Player.Color.WHITE) {
                k = board.getBoard()[4][0].getPiece();
                t = board.getBoard()[0][0].getPiece();
            } else {
                k = board.getBoard()[4][7].getPiece();
                t = board.getBoard()[0][7].getPiece();
            }
            if (k.getClass() == King.class && t.getClass() == Tower.class) {
                King king = (King) k;
                Tower tower = (Tower) t;
                if (!king.isFirstMove() || !tower.isFirstMove()) {
                    return false;
                }
                for (int i = 3; i > 0; i--) {
                    if (col == Player.Color.WHITE) {
                        if (board.getBoard()[i][0].getPiece() != null || checkForCheck())
                            return false;
                        board.getBoard()[4][0].setPiece(null);
                        board.getBoard()[0][0].setPiece(null);
                        board.getBoard()[2][0].setPiece(k);
                        board.getBoard()[3][0].setPiece(t);
                    } else {
                        if (board.getBoard()[i][7].getPiece() != null || checkForCheck())
                            return false;
                        board.getBoard()[4][7].setPiece(null);
                        board.getBoard()[0][7].setPiece(null);
                        board.getBoard()[2][7].setPiece(k);
                        board.getBoard()[3][7].setPiece(t);
                    }
                }
            }
        }
        return false;
    }

    // return true if king is in check
    public static boolean checkForCheck() {
        return false;
    }

    public static boolean promotion(Piece p, int fileFrom, int fileTo, Piece promoteTo) {
        if (p.getColor() == Piece.Color.WHITE) {
            if (move(p, fileFrom, 6, fileTo, 7)) {
                board.getBoard()[fileTo][7].setPiece(promoteTo);
                return true;
            }
            return false;
        } else if (p.getColor() == Piece.Color.BLACK) {
            if (move(p, fileFrom, 1, fileTo, 0)) {
                board.getBoard()[fileTo][8].setPiece(promoteTo);
                return true;
            }
            return false;
        }
        return false;
    }

    public static Piece checkKingOrTowerMove(Piece piece) {
        if (piece.getClass() == King.class) {
            King king = (King) piece;
            king.setFirstMove(false);
            return king;
        } else if (piece.getClass() == Tower.class) {
            Tower tower = (Tower) piece;
            tower.setFirstMove(false);
            return tower;
        }
        return piece;
    }

}
