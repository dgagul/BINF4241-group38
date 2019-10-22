public class Logic {

    private static Board board;
    private static int[] lastMove;

    Logic(Board board) {
        this.board = board;
    }

    // CheckForCheck
    // CheckForCheckMate
    // CheckCoordinates
    // CheckPiece


    public static int[] getLastMove() {
        return lastMove;
    }

    public static void setLastMove(int[] move, Piece piece) {
        lastMove = move;
        if (piece instanceof Pawn) {
            lastMove[4] = 1;
        } else {
            lastMove[4] = 0;
        }
    }

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
                                    if (checkForCheck(p.getColor())) {
                                        Piece piece = board.getBoard()[i][j].getPiece();
                                        piece = checkKingOrTowerMove(piece);
                                        board.getBoard()[i][j].setPiece(null);
                                        board.getBoard()[fileTo][rankTo].setPiece(piece);
                                        if (checkForCheck(p.getColor())) {
                                            board.getBoard()[i][j].setPiece(piece);
                                            board.getBoard()[fileTo][rankTo].setPiece(null);
                                            return false;
                                        } else {
                                            setLastMove(new int[]{i, fileTo, j, rankTo, 3}, p);
                                            return true;
                                        }
                                    } else {
                                        Piece piece = board.getBoard()[i][j].getPiece();
                                        piece = checkKingOrTowerMove(piece);
                                        board.getBoard()[i][j].setPiece(null);
                                        board.getBoard()[fileTo][rankTo].setPiece(piece);
                                        if (checkForCheck(p.getColor())) {
                                            board.getBoard()[i][j].setPiece(piece);
                                            board.getBoard()[fileTo][rankTo].setPiece(null);
                                            return false;
                                        } else {
                                            setLastMove(new int[]{i, fileTo, j, rankTo, 3}, p);
                                            return true;
                                        }
                                    }
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
        // GEHT NICHT!!! Pawn can not capture
        if (p.getClass() == Pawn.class) {
            if (p.getColor() == Color.color.WHITE) {
                rankFrom = rankTo - 1;
            } else {
                rankFrom = rankTo + 1;
            }
            Piece pawn = board.getBoard()[fileFrom][rankFrom].getPiece();
            if (pawn == null || pawn.getClass() != Pawn.class)
                return false;
            if (board.getBoard()[fileTo][rankTo].getPiece() == null) {
                if (checkEnPassant(p, fileFrom, rankFrom, fileTo, rankTo)) {
                    board.getBoard()[fileFrom][rankFrom].setPiece(null);
                    board.getBoard()[lastMove[1]][lastMove[3]].setPiece(null);
                    board.getBoard()[fileTo][rankTo].setPiece(p);
                    return true;
                } else {
                    return false;
                }
            }
            if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
                return false;
            }
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

    public static boolean checkEnPassant(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        if (p.getColor() == Color.color.WHITE) {
            if (rankFrom == 4 && (getLastMove()[3] == rankFrom)) {
                if (fileFrom == getLastMove()[1] - 1 || fileFrom == getLastMove()[1] + 1) {
                    if (getLastMove()[2] - getLastMove()[3] == 2) {
                        if (getLastMove()[4] == 1) {
                            if (fileTo == getLastMove()[1] && rankTo == getLastMove()[3] + 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        } else if (p.getColor() == Color.color.BLACK) {
            if (rankFrom == 3 && (getLastMove()[3] == rankFrom)) {
                if (fileFrom == getLastMove()[1] - 1 || fileFrom == getLastMove()[1] + 1) {
                    if (getLastMove()[2] - getLastMove()[3] == -2) {
                        if (getLastMove()[4] == 1) {
                            if (fileTo == getLastMove()[1] && rankTo == getLastMove()[3] - 1) {
                                return true;
                            }
                        }
                    }
                }
            }
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
                for (int i = fileFrom + 1; i < fileTo; i++) {
                    if (board.getBoard()[i][rankTo].getPiece() != null)
                        return false;
                }
            } else {
                for (int i = fileFrom - 1; i > fileTo; i--) {
                    if (board.getBoard()[i][rankTo].getPiece() != null)
                        return false;
                }
            }
        }
        // vertical move
        else if (fileFrom == fileTo) {
            if (rankFrom < rankTo) {
                for (int i = rankFrom + 1; i < rankTo; i++) {
                    if (board.getBoard()[fileTo][i].getPiece() != null)
                        return false;
                }
            } else {
                for (int i = rankFrom - 1; i > rankTo; i--) {
                    if (board.getBoard()[fileTo][i].getPiece() != null)
                        return false;
                }
            }
        }
        // diagonal move
        else if (rankFrom < rankTo && fileFrom > fileTo) {
            int j = rankFrom + 1;
            for (int i = fileFrom - 1; i > fileTo; i--) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    return false;
                }
                j++;
            }
        } else if (rankFrom > rankTo && fileFrom < fileTo) {
            int j = rankFrom - 1;
            for (int i = fileFrom + 1; i < fileTo; i++) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    return false;
                }
                j--;
            }
        } else {
            if (rankFrom < rankTo) {
                int j = rankFrom + 1;
                for (int i = fileFrom + 1; i < fileTo; i++) {
                    if (board.getBoard()[i][j].getPiece() != null)
                        return false;
                    j++;
                }
            } else {
                int j = rankFrom - 1;
                for (int i = fileFrom - 1; i > fileTo; i--) {
                    if (board.getBoard()[i][j].getPiece() != null)
                        return false;
                    j--;
                }
            }
        }
        return true;
    }

    public static boolean castling(boolean kingSide, Color.color col) {
        Piece k;
        Piece t;
        if (kingSide) {
            if (col == Color.color.WHITE) {
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
                    if (col == Color.color.WHITE) {
                        if (board.getBoard()[i][0].getPiece() != null || checkForCheck(col))
                            return false;
                        board.getBoard()[4][0].setPiece(null);
                        board.getBoard()[7][0].setPiece(null);
                        board.getBoard()[6][0].setPiece(k);
                        board.getBoard()[5][0].setPiece(t);
                    } else {
                        if (board.getBoard()[i][7].getPiece() != null || checkForCheck(col))
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
            if (col == Color.color.WHITE) {
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
                    if (col == Color.color.WHITE) {
                        if (board.getBoard()[i][0].getPiece() != null || checkForCheck(col))
                            return false;
                        board.getBoard()[4][0].setPiece(null);
                        board.getBoard()[0][0].setPiece(null);
                        board.getBoard()[2][0].setPiece(k);
                        board.getBoard()[3][0].setPiece(t);
                    } else {
                        if (board.getBoard()[i][7].getPiece() != null || checkForCheck(col))
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
    public static boolean checkForCheck(Color.color color) {
        // find King
        int[] kingCoords = new int[2];
        kingCoords = findKing(color);
        int x = kingCoords[0];
        int y = kingCoords[1];
        Piece king = board.getBoard()[x][y].getPiece();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = board.getBoard()[i][j].getPiece();
                if (board.getBoard()[i][j].isOccupied() && (p.getColor() != color))
                    if (p.moveIsValid(i, j, x, y)) {
                        if (checkPath(i, j, x, y)) {
                            return true;
                        }
                    }
            }
        }
        return false;
    }

    public static boolean promotion(Piece p, int fileFrom, int fileTo, Piece promoteTo) {
        if (p.getColor() == Color.color.WHITE) {
            if (move(p, fileFrom, 6, fileTo, 7)) {
                board.getBoard()[fileTo][7].setPiece(promoteTo);
                return true;
            }
            return false;
        } else if (p.getColor() == Color.color.BLACK) {
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

    public static int[] findKing(Color.color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].isOccupied())
                    if (board.getBoard()[i][j].getPiece().getClass() == King.class)
                        if (board.getBoard()[i][j].getPiece().getColor() == color)
                            return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }


}