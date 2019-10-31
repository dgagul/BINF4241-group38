import javafx.util.Pair;
<<<<<<< HEAD
import java.util.ArrayList;
=======

import java.util.ArrayList;
import java.util.List;
>>>>>>> master

public class Logic {

    private static Board board;
    private static int[] lastMove;

    Logic(Board board) {
        Logic.board = board;
    }

<<<<<<< HEAD
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
=======

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
>>>>>>> master
    }

    static boolean move(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        Square[][] aBoard = board.getBoard();
        int iter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                iter++;
                // abortion criteria if userInput is invalid
                if (iter == 65)
                    return false;
                if (fileFrom >= 0) {
                    i = fileFrom;
                }
                if (rankFrom >= 0) {
                    j = rankFrom;
                }
                if (aBoard[i][j].isOccupied()) {
<<<<<<< HEAD
                    if (aBoard[i][j].getPiece().getClass() == p.getClass()) {
                        if (aBoard[i][j].getPiece().getColor() == p.getColor()) {
                            if (aBoard[i][j].getPiece().moveIsValid(i, j, fileTo, rankTo)) {
                                if (checkPath(i, j, fileTo, rankTo)) {
                                    if (!board.getBoard()[fileTo][rankTo].isOccupied()){
                                        if (checkForCheck(p.getColor())) {
                                            Piece piece = board.getBoard()[i][j].getPiece();
                                            piece = checkKingOrTowerMove(piece);
                                            board.getBoard()[i][j].setPiece(null);
                                            board.getBoard()[fileTo][rankTo].setPiece(piece);
                                            // did not remove check
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
                                            // suicide move
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
=======
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
>>>>>>> master
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

<<<<<<< HEAD
    public static boolean capture(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        if (checkForCheck(p.getColor())) {
            return false;
        }
        // ToDo: add piece to captured_pieces
        // GEHT NICHT!!! Pawn can not capture
=======
    static boolean capture(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        // ToDo: add piece to captured_pieces
        boolean isValid = false;
        // Pawn capture
>>>>>>> master
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
<<<<<<< HEAD
            if (board.getBoard()[fileTo][rankTo].getPiece() == null) {
                if (checkEnPassant(p, fileFrom, rankFrom, fileTo, rankTo)) {
                    board.getBoard()[fileFrom][rankFrom].setPiece(null);
                    board.getBoard()[lastMove[1]][lastMove[3]].setPiece(null);
                    board.getBoard()[fileTo][rankTo].setPiece(p);
                    return true;
                } else {
                    return false;
=======
            if (captured == null) {
                if (enPassant(p, fileFrom, rankFrom, fileTo, rankTo)) {
                    return true;
>>>>>>> master
                }
            }
            if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
                return false;
            }
            board.getBoard()[fileFrom][rankFrom].setPiece(null);
            board.getBoard()[fileTo][rankTo].setPiece(piece);
            if (checkForCheck(p.getColor())) {
                System.out.println("This is a suicide move! This is not allowed.");
                undoMove(fileFrom, rankFrom, fileTo, rankTo, piece);
                board.getBoard()[fileTo][rankTo].setPiece(captured);
                return false;
            }
            return true;
        }
        Piece captured = board.getBoard()[fileTo][rankTo].getPiece();
<<<<<<< HEAD
        if (captured.getColor() == p.getColor()){
=======
        if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
>>>>>>> master
            return false;
        }
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

<<<<<<< HEAD
    public static boolean checkEnPassant(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        if (checkForCheck(p.getColor())) {
            return false;
        }
=======
    private static boolean enPassant(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
        if (checkForCheck(p.getColor())) {
            return false;
        }
        boolean moveIsValid = false;
>>>>>>> master
        if (p.getColor() == Color.color.WHITE) {
            if (rankFrom == 4 && (getLastMove()[3] == rankFrom)) {
                if (fileFrom == getLastMove()[1] - 1 || fileFrom == getLastMove()[1] + 1) {
                    if (getLastMove()[2] - getLastMove()[3] == 2) {
                        if (getLastMove()[4] == 1) {
                            if (fileTo == getLastMove()[1] && rankTo == getLastMove()[3] + 1) {
<<<<<<< HEAD
                                return true;
=======
                                moveIsValid = true;
>>>>>>> master
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
<<<<<<< HEAD
                                return true;
=======
                                moveIsValid = true;
>>>>>>> master
                            }
                        }
                    }
                }
            }
        }
<<<<<<< HEAD
        return false;
    }

    public static boolean checkPath(int fileFrom, int rankFrom, int fileTo, int rankTo) {
=======
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
>>>>>>> master
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

<<<<<<< HEAD
    public static boolean checkPathMovableTo(int fileFrom, int rankFrom, int fileTo, int rankTo, Color.color color) {
        // horizontal move
        if (rankFrom == rankTo) {
            if (fileFrom < fileTo) {
                    for (int u = 0; u < 8; u++) {
                        for (int v = 0; v < 8; v++) {
                            Piece piece = board.getBoard()[u][v].getPiece();
                            if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                                for (int i = fileFrom + 1; i < fileTo; i++) {
                                    if (piece.moveIsValid(u, v, i, rankTo)) {
                                        if (piece.getClass() == King.class){continue;}
                                        if (checkPath(u, v, i, rankTo)) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
            } else {
                for (int u = 0; u < 8; u++) {
                    for (int v = 0; v < 8; v++) {
                        Piece piece = board.getBoard()[u][v].getPiece();
                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                            for (int i = fileFrom - 1; i > fileTo; i--) {
                                if (piece.moveIsValid(u, v, i, rankTo)) {
                                    if (piece.getClass() == King.class){continue;}
                                    if (checkPath(u, v, i, rankTo)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        // vertical move
        else if (fileFrom == fileTo) {
            if (rankFrom < rankTo) {
                for (int u = 0; u < 8; u++) {
                    for (int v = 0; v < 8; v++) {
                        Piece piece = board.getBoard()[u][v].getPiece();
                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                            for (int i = rankFrom + 1; i < rankTo; i++) {
                                if (piece.moveIsValid(u, v, fileTo, i)) {
                                    if (piece.getClass() == King.class){continue;}
                                    if (checkPath(u, v, fileTo, i)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }

            } else {
                for (int u = 0; u < 8; u++) {
                    for (int v = 0; v < 8; v++) {
                        Piece piece = board.getBoard()[u][v].getPiece();
                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                            for (int i = rankFrom - 1; i > rankTo; i--) {
                                if (piece.moveIsValid(u, v, fileTo, i)) {
                                    if (piece.getClass() == King.class){continue;}
                                    if (checkPath(u, v, fileTo, i)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // diagonal move
        else if (rankFrom < rankTo && fileFrom > fileTo) {
            for (int u = 0; u < 8; u++) {
                for (int v = 0; v < 8; v++) {
                    Piece piece = board.getBoard()[u][v].getPiece();
                    if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                        int j = rankFrom + 1;
                        for (int i = fileFrom - 1; i > fileTo; i--) {
                            if (piece.moveIsValid(u, v, i, j)) {
                                if (piece.getClass() == King.class){continue;}
                                if (checkPath(u, v, i, j)) {
                                    return true;
                                }
                            }
                            j++;
                        }
                    }
                }
            }
        } else if (rankFrom > rankTo && fileFrom < fileTo) {
                for (int u = 0; u < 8; u++) {
                    for (int v = 0; v < 8; v++) {
                        Piece piece = board.getBoard()[u][v].getPiece();
                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                            int j = rankFrom - 1;
                            for (int i = fileFrom + 1; i < fileTo; i++) {
                                if (piece.moveIsValid(u, v, i, j)) {
                                    if (piece.getClass() == King.class){continue;}
                                    if (checkPath(u, v, i, j)) {
                                        return true;
                                    }
                                }
                                j--;
                            }
                        }
                    }
                }
        } else {
            if (rankFrom < rankTo) {
                for (int u = 0; u < 8; u++) {
                    for (int v = 0; v < 8; v++) {
                        Piece piece = board.getBoard()[u][v].getPiece();
                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                            int j = rankFrom + 1;
                            for (int i = fileFrom + 1; i < fileTo; i++) {
                                if (piece.moveIsValid(u, v, i, j)) {
                                    if (piece.getClass() == King.class){continue;}
                                    if (checkPath(u, v, i, j)) {
                                        return true;
                                    }
                                }
                                j++;
                            }
                        }
                    }
                }
            } else {
                for (int u = 0; u < 8; u++) {
                    for (int v = 0; v < 8; v++) {
                        Piece piece = board.getBoard()[u][v].getPiece();
                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() == color)) {
                            int j = rankFrom - 1;
                            for (int i = fileFrom - 1; i > fileTo; i--) {
                                if (piece.moveIsValid(u, v, i, j)) {
                                    if (piece.getClass() == King.class){continue;}
                                    if (checkPath(u, v, i, j)) {
                                        return true;
                                    }
                                }
                                j--;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean castling(boolean kingSide, Color.color col) {
        if (checkForCheck(col)) {
            return false;
        }
        Piece k;
        Piece t;
        if (kingSide) {
            if (col == Color.color.WHITE) {
                k = board.getBoard()[4][0].getPiece();
                t = board.getBoard()[7][0].getPiece();
            } else {
                k = board.getBoard()[4][7].getPiece();
                t = board.getBoard()[7][7].getPiece();
=======
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
>>>>>>> master
            }
        } else if (fileFrom == fileTo) {
            if (rankFrom + 1 < rankTo) {
                for (int i = rankFrom + 1; i < rankTo; i++) {
                    Pair<Integer, Integer> coords = new Pair<>(fileTo, i);
                    coordsList.add(coords);
                }
<<<<<<< HEAD
                for (int i = 5; i < 7; i++) {
                    if (col == Color.color.WHITE) {
                        if (board.getBoard()[i][0].getPiece() != null || checkForCheck(col)) {
                            return false;
                        }
                    } else {
                        if (board.getBoard()[i][7].getPiece() != null || checkForCheck(col)) {
                            return false;
                        }
                    }
=======
            } else if (rankFrom - 1 > rankTo) {
                for (int i = rankFrom - 1; i > rankTo; i--) {
                    Pair<Integer, Integer> coords = new Pair<>(fileTo, i);
                    coordsList.add(coords);
>>>>>>> master
                }
                if (col == Color.color.WHITE){
                    board.getBoard()[4][0].setPiece(null);
                    board.getBoard()[7][0].setPiece(null);
                    board.getBoard()[6][0].setPiece(k);
                    board.getBoard()[5][0].setPiece(t);
                    return true;
                }
                else {
                    board.getBoard()[4][7].setPiece(null);
                    board.getBoard()[7][7].setPiece(null);
                    board.getBoard()[6][7].setPiece(k);
                    board.getBoard()[5][7].setPiece(t);
                    return true;
                }
            }
        } else if (rankFrom + 1 < rankTo && fileFrom - 1 > fileTo) {
            int j = rankFrom + 1;
            for (int i = fileFrom - 1; i > fileTo; i--) {
                Pair<Integer, Integer> coords = new Pair<>(i, j);
                coordsList.add(coords);
                j++;
            }
<<<<<<< HEAD
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
                    } else {
                        if (board.getBoard()[i][7].getPiece() != null || checkForCheck(col))
                            return false;
=======
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
>>>>>>> master
                    }
                }
                if (col == Color.color.WHITE){
                    board.getBoard()[4][0].setPiece(null);
                    board.getBoard()[0][0].setPiece(null);
                    board.getBoard()[2][0].setPiece(k);
                    board.getBoard()[3][0].setPiece(t);
                    return true;
                }
                else {
                    board.getBoard()[4][7].setPiece(null);
                    board.getBoard()[0][7].setPiece(null);
                    board.getBoard()[2][7].setPiece(k);
                    board.getBoard()[3][7].setPiece(t);
                    return true;
                }
            }
        }
        return false;
    }

    // return true if king is in check
    private static boolean checkForCheck_xy(int x, int y, Color.color color) {
        // find King
        Piece king = board.getBoard()[x][y].getPiece();
<<<<<<< HEAD
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = board.getBoard()[i][j].getPiece();
                if (board.getBoard()[i][j].isOccupied() && (p.getColor() != color)) {
                    if (p.moveIsValid(i, j, x, y)) {
                        if (p.getClass() == Knight.class){
                            return true;
                        }
                        if (checkPath(i, j, x, y)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkForCheckmate(Color.color color, Player currentPlayer){
        if (checkForCheck(color)){
            // find King
            int[] kingCoords = new int[2];
            kingCoords = findKing(color);
            int x = kingCoords[0];
            int y = kingCoords[1];
            Piece king = board.getBoard()[x][y].getPiece();

            // Check if king can move out of check (and does not move into next check situation)
            // find free spots
            ArrayList<Pair<Integer, Integer>> freeSpots = new ArrayList<>();
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (!(board.getBoard()[i][j].isOccupied())){
                        if (king.moveIsValid(x,y,i,j)){
                            Pair<Integer, Integer> spot = new Pair<>(i,j);
                            freeSpots.add(spot);
                        }
                    }
                }
            }
            // king has no free spots, can capture the attacking piece and remove chess?
            if (freeSpots.isEmpty()){
                int[] lastMove = getLastMove();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Piece p = board.getBoard()[i][j].getPiece();
                        if (board.getBoard()[i][j].isOccupied() && (p.getColor() != color)) {
                            // is pawn attacking
                            if (p.getClass() == Pawn.class) {
                                Piece pawn = board.getBoard()[i][j].getPiece();
                                if (pawn == null || pawn.getClass() != Pawn.class)
                                    continue;
                                if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                    continue;
                                }
                                if (pawn.getColor() == Color.color.BLACK){
                                    if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                        // if attacking piece is covered, cannot eat piece
                                        for (int u = 0; u < 8; u++) {
                                            for (int v = 0; v < 8; v++) {
                                                Piece piece = board.getBoard()[u][v].getPiece();
                                                if (board.getBoard()[u][v].isOccupied() && (piece.getColor() != color)) {
                                                    // is pawn protecting
                                                    if (p.getClass() == Pawn.class) {
                                                        Piece pawn2 = board.getBoard()[i][j].getPiece();
                                                        if (pawn2 == null || pawn2.getClass() != Pawn.class)
                                                            continue;
                                                        if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                                            continue;
                                                        }
                                                        if (pawn2.getColor() == Color.color.BLACK){
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                        else {
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                    // other piece protecting
                                                    if (piece.moveIsValid(u, v, lastMove[1], lastMove[3])) {
                                                        if (checkPath(u, v, lastMove[1], lastMove[3])) {
                                                            // is pawn move not protecting
                                                            if (p.getClass() == Pawn.class){
                                                                continue;
                                                            }
                                                            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        // attacking piece is not covered
                                        return false;
                                    }
                                }
                                else {
                                    if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                        // if attacking piece is covered, cannot eat piece
                                        for (int u = 0; u < 8; u++) {
                                            for (int v = 0; v < 8; v++) {
                                                Piece piece = board.getBoard()[u][v].getPiece();
                                                if (board.getBoard()[u][v].isOccupied() && (piece.getColor() != color)) {
                                                    // is pawn protecting
                                                    if (p.getClass() == Pawn.class) {
                                                        Piece pawn2 = board.getBoard()[i][j].getPiece();
                                                        if (pawn2 == null || pawn2.getClass() != Pawn.class)
                                                            continue;
                                                        if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                                            continue;
                                                        }
                                                        if (pawn2.getColor() == Color.color.BLACK){
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                        else {
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                    // other piece protecting
                                                    if (piece.moveIsValid(u, v, lastMove[1], lastMove[3])) {
                                                        if (checkPath(u, v, lastMove[1], lastMove[3])) {
                                                            // is pawn move not protecting
                                                            if (p.getClass() == Pawn.class){
                                                                continue;
                                                            }
                                                            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        // attacking piece is not covered
                                        return false;
                                    }
                                }
                            }
                            // other pieces
                            if (p.moveIsValid(i, j, lastMove[1], lastMove[3])) {
                                if (checkPath(i, j, lastMove[1], lastMove[3])) {
                                    // pawn valid move is not capture
                                    if (p.getClass() == Pawn.class){
                                        continue;
                                    }
                                    // if attacking piece is covered, cannot eat piece
                                    for (int u = 0; u < 8; u++) {
                                        for (int v = 0; v < 8; v++) {
                                            Piece piece = board.getBoard()[u][v].getPiece();
                                            if (board.getBoard()[u][v].isOccupied() && (piece.getColor() != color)) {
                                                // is pawn protecting
                                                if (p.getClass() == Pawn.class) {
                                                    Piece pawn = board.getBoard()[i][j].getPiece();
                                                    if (pawn == null || pawn.getClass() != Pawn.class)
                                                        continue;
                                                    if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                                        continue;
                                                    }
                                                    if (pawn.getColor() == Color.color.BLACK){
                                                        if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                                            // pawn protects attacking piece
                                                            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                            return true;
                                                        }
                                                    }
                                                    else {
                                                        if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                                            // pawn protects attacking piece
                                                            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                            return true;
                                                        }
                                                    }
                                                }
                                                // other piece protecting
                                                if (piece.moveIsValid(u, v, lastMove[1], lastMove[3])) {
                                                    if (checkPath(u, v, lastMove[1], lastMove[3])) {
                                                        // is pawn move not protecting
                                                        if (p.getClass() == Pawn.class){
                                                            continue;
                                                        }
                                                        System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    // attacking piece is not covered
                                    return false;
                                }
                            }
                        }
                    }
                }
                // cannot capture, therefore mate
                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                return true;
            }


            ArrayList<Pair<Integer, Integer>> movableSpot = new ArrayList<>();
            // is free spot not attacked
            for (Pair<Integer, Integer> spot : freeSpots) {
                int toX = spot.getKey();
                int toY = spot.getValue();
                int itter = 0;
                boolean canAttack = false;
                for (int i=0;i<8;i++) {
                    if (canAttack) {
                        break;
                    }
                    for (int j = 0; j < 8; j++) {
                        itter++;
                        Piece p = board.getBoard()[i][j].getPiece();
                        if (board.getBoard()[i][j].isOccupied() && (p.getColor() != color)) {
                            if (p.moveIsValid(i, j, toX, toY)) {
                                if (checkPath(i, j, toX, toY)) {
                                    // pawn valid move is not capture
                                    if (p.getClass() == Pawn.class){
                                        continue;
                                    }
                                    canAttack = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!canAttack) {
                    movableSpot.add(spot);
                }
            }
            // free and not attacked spots available?
            if (!movableSpot.isEmpty()){
                return false;
            }


            // can my figure eat the last moved figure and remove chess
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Piece p = board.getBoard()[i][j].getPiece();
                    if (board.getBoard()[i][j].isOccupied() && (p.getColor() == color)) {
                        if (p.moveIsValid(i, j, lastMove[1], lastMove[3])) {
                            // can pawn capture
                            if (p.getClass() == Pawn.class) {
                                Piece pawn = board.getBoard()[i][j].getPiece();
                                if (pawn == null || pawn.getClass() != Pawn.class)
                                    continue;
                                if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                    continue;
                                }
                                if (pawn.getColor() == Color.color.BLACK){
                                    if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                        // if attacking piece is covered, cannot eat piece
                                        for (int u = 0; u < 8; u++) {
                                            for (int v = 0; v < 8; v++) {
                                                Piece piece = board.getBoard()[u][v].getPiece();
                                                if (board.getBoard()[u][v].isOccupied() && (piece.getColor() != color)) {
                                                    // is pawn protecting
                                                    if (p.getClass() == Pawn.class) {
                                                        Piece pawn2 = board.getBoard()[i][j].getPiece();
                                                        if (pawn2 == null || pawn2.getClass() != Pawn.class)
                                                            continue;
                                                        if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                                            continue;
                                                        }
                                                        if (pawn2.getColor() == Color.color.BLACK){
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                        else {
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                    // other piece protecting
                                                    if (piece.moveIsValid(u, v, lastMove[1], lastMove[3])) {
                                                        if (checkPath(u, v, lastMove[1], lastMove[3])) {
                                                            // is pawn move not protecting
                                                            if (p.getClass() == Pawn.class){
                                                                continue;
                                                            }
                                                            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        // attacking piece is not covered
                                        return false;
                                    }
                                }
                                else {
                                    if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                        // if attacking piece is covered, cannot eat piece
                                        for (int u = 0; u < 8; u++) {
                                            for (int v = 0; v < 8; v++) {
                                                Piece piece = board.getBoard()[u][v].getPiece();
                                                if (board.getBoard()[u][v].isOccupied() && (piece.getColor() != color)) {
                                                    // is pawn protecting
                                                    if (p.getClass() == Pawn.class) {
                                                        Piece pawn2 = board.getBoard()[i][j].getPiece();
                                                        if (pawn2 == null || pawn2.getClass() != Pawn.class)
                                                            continue;
                                                        if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                                            continue;
                                                        }
                                                        if (pawn2.getColor() == Color.color.BLACK){
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                        else {
                                                            if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                                                // pawn protects attacking piece
                                                                System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                    // other piece protecting
                                                    if (piece.moveIsValid(u, v, lastMove[1], lastMove[3])) {
                                                        if (checkPath(u, v, lastMove[1], lastMove[3])) {
                                                            // is pawn move not protecting
                                                            if (p.getClass() == Pawn.class){
                                                                continue;
                                                            }
                                                            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        // attacking piece is not covered
                                        return false;
                                    }
                                }
                            }
                            // other piece can capture
                            if (checkPath(i, j, lastMove[1], lastMove[3])) {
                                if (p.getClass() == Pawn.class){
                                    continue;
                                }
                                // if attacking piece is covered, cannot eat piece
                                for (int u = 0; u < 8; u++) {
                                    for (int v = 0; v < 8; v++) {
                                        Piece piece = board.getBoard()[u][v].getPiece();
                                        if (board.getBoard()[u][v].isOccupied() && (piece.getColor() != color)) {
                                            // is pawn protecting
                                            if (p.getClass() == Pawn.class) {
                                                Piece pawn = board.getBoard()[i][j].getPiece();
                                                if (pawn == null || pawn.getClass() != Pawn.class)
                                                    continue;
                                                if (board.getBoard()[lastMove[1]][lastMove[3]].getPiece().getColor() == p.getColor()) {
                                                    continue;
                                                }
                                                if (pawn.getColor() == Color.color.BLACK){
                                                    if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]+1){
                                                        // pawn protects attacking piece
                                                        System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                        return true;
                                                    }
                                                }
                                                else {
                                                    if ((i == lastMove[1]-1 || i == lastMove[1]+1) &&  j == lastMove[3]-1){
                                                        // pawn protects attacking piece
                                                        System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                        return true;
                                                    }
                                                }
                                            }
                                            // other piece protecting
                                            if (piece.moveIsValid(u, v, lastMove[1], lastMove[3])) {
                                                if (checkPath(u, v, lastMove[1], lastMove[3])) {
                                                    // is pawn move not protecting
                                                    if (p.getClass() == Pawn.class){
                                                        continue;
                                                    }
                                                    System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                                // attacking piece is not covered
                                return false;
                            }
                        }
=======
        if (checkForPawnCheck(x, y, color)) {
            return true;
        }
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
>>>>>>> master
                    }
                }
            }


            // can a piece block the chess
            if (checkPathMovableTo(lastMove[1],lastMove[3],x,y,color)){
                return false;
            }

            // can not do anything
            System.out.println("Checkmate, " + currentPlayer.getName() + " wins!");
            return true;

        }
        return false;
    }

<<<<<<< HEAD
    public static boolean promotion(Piece p, int fileFrom, int fileTo, Piece promoteTo) {
        if (checkForCheck(p.getColor())) {
            return false;
        }
        if (p.getColor() == Color.color.WHITE) {
            if (move(p, fileFrom, 6, fileTo, 7)) {
                board.getBoard()[fileTo][7].setPiece(promoteTo);
                return true;
=======
    // checkForCheck method if King's coordinates are unknown
    static boolean checkForCheck(Color.color color) {
        int[] kingCoords;
        kingCoords = getKingCoords(color);
        if (kingCoords[0] == -1 && kingCoords[1] == -1) {
            return true;
        }
        int x = kingCoords[0];
        int y = kingCoords[1];
        return checkForCheck_xy(x, y, color);
    }

    // returns true if checkmate
    static boolean checkForCheckmate(Color.color color) {
        // Check if king can move out of check (and does not move into next check situation)
        int[] kingCoords = getKingCoords(color);
        if (kingCoords[0] == -1 && kingCoords[1] == -1) {
            return true;
        }
        int kingX = kingCoords[0];
        int kingY = kingCoords[1];
        for (int i = kingX - 1; i <= kingX + 1; i++) {
            for (int j = kingY - 1; j <= kingY + 1; j++) {
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7)
                    if (checkPath(kingX, kingY, i, j))
                        if (!checkForCheck_xy(i, j, color))
                            return false;

>>>>>>> master
            }
        }

        int[] lastMove = getLastMove();
        int lastX = lastMove[1];
        int lastY = lastMove[3];
        Piece menacing = board.getBoard()[lastX][lastY].getPiece();
        // Check if a piece can capture the menacing piece
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].isOccupied()) {
                    Piece p = board.getBoard()[i][j].getPiece();
                    if (p.getColor() == color) {
                        if (checkCapture(p, i, j, lastX, lastY)) {
                            return false;
                        }
                    }
                }
            }
        }
        // Check if a piece can move in the way
        return !checkPathForCheckmate(lastX, lastY, kingX, kingY, color);
    }

    static boolean checkCapture(Piece p, int fileFrom, int rankFrom, int fileTo, int rankTo) {
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
            if (piece == null || piece.getClass() != Pawn.class || captured == null)
                return false;
            if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
                return false;
            }
            if (checkForCheck(p.getColor())) {
                System.out.println("This is a suicide move! This is not allowed.");
                undoMove(fileFrom, rankFrom, fileTo, rankTo, piece);
                return false;
            }
            return true;
        }
        Piece piece = board.getBoard()[fileFrom][rankFrom].getPiece();
        Piece captured = board.getBoard()[fileTo][rankTo].getPiece();
        if (board.getBoard()[fileTo][rankTo].getPiece().getColor() == p.getColor()) {
            return false;
        }
        if (captured != null) {
            board.getBoard()[fileTo][rankTo].setPiece(null);
            if (!move(p, fileFrom, rankFrom, fileTo, rankTo)) {
                board.getBoard()[fileTo][rankTo].setPiece(captured);
                return false;
            }
            board.getBoard()[fileTo][rankTo].setPiece(piece);
            board.getBoard()[fileTo][rankTo].setPiece(captured);
            return true;
        }
        return false;
    }

    private static boolean checkForPawnCheck(int x, int y, Color.color color) {
        int pRank = (color == Color.color.WHITE) ? y + 1 : y - 1;
        for (int i = x - 1; i <= x + 1; i++) {
            if (board.getBoard()[i][pRank].isOccupied()) {
                if ((board.getBoard()[i][pRank].getPiece().getClass() == Pawn.class) && (board.getBoard()[i][pRank].getPiece().getColor() != color)) {
                    return true;
                }
            }
        }
        return false;
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

<<<<<<< HEAD
=======
    private static void undoMove(int fileFrom, int rankFrom, int fileTo, int rankTo, Piece p) {
        board.getBoard()[fileFrom][rankFrom].setPiece(p);
        board.getBoard()[fileTo][rankTo].setPiece(null);
    }
>>>>>>> master

}