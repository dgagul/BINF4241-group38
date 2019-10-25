import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private static Board board;
    private static int[] lastMove;

    Logic(Board board) {
        Logic.board = board;
    }

    // CheckForCheck
    // CheckForCheckMate
    // CheckCoordinates
    // CheckPiece

    private static int[] getLastMove() {
        return lastMove;
    }

    private static void setLastMove(int[] move, Piece piece) {
        lastMove = move;
        if (piece instanceof Pawn) {
            lastMove[4] = 1;
        } else {
            lastMove[4] = 0;
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        Logic.board = board;
    }

    static boolean move(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
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
                    if (aBoard[i][j].getPiece().getClass() == p.getClass() && aBoard[i][j].getPiece().getColor() == p.getColor()) {
                        if (aBoard[i][j].getPiece().moveIsValid(i, j, fileTo, rankTo) && checkPath(i, j, fileTo, rankTo)) {
                            Piece piece = board.getBoard()[i][j].getPiece();
                            board.getBoard()[fileTo][rankTo].setPiece(piece);
                            board.getBoard()[i][j].setPiece(null);
                            // If player was already in check and didn't resolve it or moves into check
                            if (checkForCheck(piece.getColor())) {
                                undoMove(i, j, fileTo, rankTo, piece);
                                System.out.println("This is a suicide move! This is not allowed.");
                                return false;
                            } else {
                                checkKingOrTowerMove(piece);
                                setLastMove(new int[]{i, fileTo, j, rankTo, 3}, piece);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    static boolean capture(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        // ToDo: add piece to captured_pieces
        boolean isValid = false;
        // Pawn capture
        if (p.getClass() == Pawn.class) {
            if (p.getColor() == Color.color.WHITE) {
                rankFrom = rankTo - 1;
            } else {
                rankFrom = rankTo + 1;
            }
            Piece captured = board.getBoard()[fileTo][rankTo].getPiece();
            Piece piece = board.getBoard()[fileFrom][rankFrom].getPiece();
            if (piece == null || piece.getClass() != Pawn.class)
                return false;
            if (captured == null) {
                if (enPassant(p, fileFrom, rankFrom, fileTo, rankTo)) {
                    return true;
                }
            }
            if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
                return false;
            }
            board.getBoard()[fileFrom][rankFrom].setPiece(null);
            board.getBoard()[fileTo][rankTo].setPiece(p);
            if (checkForCheck(p.getColor())) {
                System.out.println("This is a suicide move! This is not allowed.");
                undoMove(fileFrom, rankFrom, fileTo, rankTo, piece);
                board.getBoard()[fileTo][rankTo].setPiece(captured);
                return false;
            }
            return true;
        }
        Piece captured = board.getBoard()[fileTo][rankTo].getPiece();
        Piece piece = board.getBoard()[fileFrom][rankFrom].getPiece();
        if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
            return false;
        }
        if (captured != null) {
            board.getBoard()[fileTo][rankTo].setPiece(null);
            if (!move(p, fileFrom, rankFrom, fileTo, rankTo)) {
                board.getBoard()[fileTo][rankTo].setPiece(captured);
                return false;
            }
            if (checkForCheck(p.getColor())) {
                System.out.println("This is a suicide move! This is not allowed.");
                undoMove(fileFrom, rankFrom, fileTo, rankTo, piece);
                board.getBoard()[fileTo][rankTo].setPiece(captured);
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean enPassant(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        if(checkForCheck(p.getColor())){
            return false;
        }
        boolean moveIsValid = false;
        if (p.getColor() == Color.color.WHITE) {
            if (rankFrom == 4 && (getLastMove()[3] == rankFrom)) {
                if (fileFrom == getLastMove()[1] - 1 || fileFrom == getLastMove()[1] + 1) {
                    if (getLastMove()[2] - getLastMove()[3] == 2) {
                        if (getLastMove()[4] == 1) {
                            if (fileTo == getLastMove()[1] && rankTo == getLastMove()[3] + 1) {
                                moveIsValid = true;
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
                                moveIsValid = true;
                            }
                        }
                    }
                }
            }
        }
        if (moveIsValid) {
            board.getBoard()[fileFrom][rankFrom].setPiece(null);
            board.getBoard()[lastMove[1]][lastMove[3]].setPiece(null);
            board.getBoard()[fileTo][rankTo].setPiece(p);
            return true;
        }
        return false;
    }

    static boolean castling(boolean kingSide, Color.color col) {
        Piece k;
        Piece t;
        int rank = (col == Color.color.WHITE) ? 0 : 7;
        if (checkForCheck(col)) {
            return false;
        }
        if (kingSide) {
            k = board.getBoard()[4][rank].getPiece();
            t = board.getBoard()[7][rank].getPiece();
            if (k.getClass() == King.class && t.getClass() == Tower.class) {
                King king = (King) k;
                Tower tower = (Tower) t;
                if (!king.isFirstMove() || !tower.isFirstMove()) {
                    return false;
                }
                for (int i = 5; i < 7; i++) {
                    if (board.getBoard()[i][rank].getPiece() != null || checkForCheck(col)) {
                        return false;
                    }
                }
                board.getBoard()[4][rank].setPiece(null);
                board.getBoard()[7][rank].setPiece(null);
                board.getBoard()[6][rank].setPiece(k);
                board.getBoard()[5][rank].setPiece(t);
                return true;
            }
        }
        if (!kingSide) {
            k = board.getBoard()[4][rank].getPiece();
            t = board.getBoard()[0][rank].getPiece();
            if (k.getClass() == King.class && t.getClass() == Tower.class) {
                King king = (King) k;
                Tower tower = (Tower) t;
                if (!king.isFirstMove() || !tower.isFirstMove()) {
                    return false;
                }
                for (int i = 3; i > 0; i--) {
                    if (board.getBoard()[i][rank].getPiece() != null || checkForCheck(col))
                        return false;
                }
                board.getBoard()[4][rank].setPiece(null);
                board.getBoard()[0][rank].setPiece(null);
                board.getBoard()[2][rank].setPiece(k);
                board.getBoard()[3][rank].setPiece(t);
                return true;
            }
        }
        return false;
    }

    static boolean promotion(Piece p, int fileFrom, int fileTo, Piece promoteTo) {
        int rankFrom = (p.getColor() == Color.color.WHITE) ? 6 : 1;
        int rankTo = (p.getColor() == Color.color.WHITE) ? 7 : 0;
        if (move(p, fileFrom, rankFrom, fileTo, rankTo)) {
            Piece pawn = board.getBoard()[fileFrom][rankFrom].getPiece();
            board.getBoard()[fileTo][rankTo].setPiece(promoteTo);
            if (checkForCheck(p.getColor())) {
                System.out.println("This is a suicide move! This is not allowed.");
                undoMove(fileFrom, rankFrom, fileTo, rankTo, pawn);
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean checkPath(int fileFrom, int rankFrom, int fileTo, int rankTo) {
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

    // returns true if path is free
    private static boolean checkPathForCheckmate(int fileFrom, int rankFrom, int fileTo, int rankTo, Color.color col) {
        //horizontal move
        ArrayList<Pair<Integer, Integer>> coordsList = new ArrayList<>();
        if (rankFrom == rankTo) {
            if (fileFrom + 1 < fileTo) {
                for (int i = fileFrom + 1; i < fileTo; i++) {
                    Pair<Integer, Integer> coords = new Pair<>(i, rankTo);
                    coordsList.add(coords);
                }
            } else if (fileFrom - 1 > fileTo) {
                for (int i = fileFrom - 1; i > fileTo; i--) {
                    Pair<Integer, Integer> coords = new Pair<>(i, rankTo);
                    coordsList.add(coords);
                }
            }
        } else if (fileFrom == fileTo) {
            if (rankFrom + 1 < rankTo) {
                for (int i = rankFrom + 1; i < rankTo; i++) {
                    Pair<Integer, Integer> coords = new Pair<>(fileTo, i);
                    coordsList.add(coords);
                }
            } else if (rankFrom - 1 > rankTo) {
                for (int i = rankFrom - 1; i > rankTo; i--) {
                    Pair<Integer, Integer> coords = new Pair<>(fileTo, i);
                    coordsList.add(coords);
                }
            }
        } else if (rankFrom + 1 < rankTo && fileFrom - 1 > fileTo) {
            int j = rankFrom + 1;
            for (int i = fileFrom - 1; i > fileTo; i--) {
                Pair<Integer, Integer> coords = new Pair<>(i, j);
                coordsList.add(coords);
                j++;
            }
        } else if (rankFrom - 1 > rankTo && fileFrom - 1 > fileTo) {
            int j = rankFrom - 1;
            for (int i = fileFrom + 1; i < fileTo; i++) {
                Pair<Integer, Integer> coords = new Pair<>(i, j);
                coordsList.add(coords);
                j--;
            }
        } else if (rankFrom + 1 < rankTo && fileFrom + 1 < fileTo) {
            int j = rankFrom + 1;
            for (int i = fileFrom + 1; i < fileTo; i++) {
                Pair<Integer, Integer> coords = new Pair<>(i, j);
                coordsList.add(coords);
                j++;
            }
        } else if (rankFrom - 1 > rankTo && fileFrom + 1 < fileTo) {
            int j = rankFrom - 1;
            for (int i = fileFrom - 1; i > fileTo; i--) {
                Pair<Integer, Integer> coords = new Pair<>(i, j);
                coordsList.add(coords);
                j--;
            }
        }
        for (Pair<Integer, Integer> coords : coordsList) {
            int file = coords.getKey();
            int rank = coords.getValue();
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    Piece p = board.getBoard()[j][k].getPiece();
                    if (board.getBoard()[j][k].isOccupied() && p.getColor() == col) {
                        if (p.moveIsValid(j, k, file, rank) && Logic.checkPath(j, k, file, rank)) {
                            board.getBoard()[file][rank].setPiece(p);
                            board.getBoard()[j][k].setPiece(null);
                            if (checkForCheck(col)) {
                                board.getBoard()[file][rank].setPiece(null);
                                board.getBoard()[j][k].setPiece(p);
                            } else {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // return true if king is in check
    private static boolean checkForCheck_xy(int x, int y, Color.color color) {
        // find King
        Piece king = board.getBoard()[x][y].getPiece();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = board.getBoard()[i][j].getPiece();
                if (board.getBoard()[i][j].isOccupied() && (p.getColor() != color))
                    if (p.moveIsValid(i, j, x, y)) {
                        board.getBoard()[x][y].setPiece(null);
                        if (checkPath(i, j, x, y)) {
                            board.getBoard()[x][y].setPiece(king);
                            return true;
                        }
                        board.getBoard()[x][y].setPiece(king);
                    }
            }
        }
        return false;
    }

    // checkForCheck method if King's coordinates are unknown
    static boolean checkForCheck(Color.color color) {
        int[] kingCoords;
        kingCoords = getKingCoords(color);
        int x = kingCoords[0];
        int y = kingCoords[1];
        return checkForCheck_xy(x, y, color);
    }

    // returns true if checkmate
    static boolean checkForCheckmate(Color.color color) {
        // Check if king can move out of check (and does not move into next check situation)
        int[] kingCoords = getKingCoords(color);
        int kingX = kingCoords[0];
        int kingY = kingCoords[1];
        for (int i = kingX - 1; i <= kingX + 1; i++) {
            for (int j = kingY - 1; j <= kingY + 1; j++) {
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7)
                    if (checkPath(kingX, kingY, i, j))
                        if (!checkForCheck_xy(i, j, color))
                            return false;

            }
        }

        int[] lastMove = getLastMove();
        int lastX = lastMove[1];
        int lastY = lastMove[3];
        // Check if a piece can capture the menacing piece

        // Check if a piece can move in the way
        return !checkPathForCheckmate(lastX, lastY, kingX, kingY, color);
    }


    private static void checkKingOrTowerMove(Piece piece) {
        if (piece.getClass() == King.class) {
            King king = (King) piece;
            king.setFirstMove(false);
        } else if (piece.getClass() == Tower.class) {
            Tower tower = (Tower) piece;
            tower.setFirstMove(false);
        }
    }

    private static int[] getKingCoords(Color.color color) {
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

    private static void undoMove(int fileFrom, int rankFrom, int fileTo, int rankTo, Piece p) {
        board.getBoard()[fileFrom][rankFrom].setPiece(p);
        board.getBoard()[fileTo][rankTo].setPiece(null);
    }

}
