import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private boolean isFinished;
    private ChessBoard aChessBoard;
    private Player aPlayer1;
    private Player aPlayer2;
    private Player currentPlayer;
    private History aHistory;

    public Game(ChessBoard pChessBoard, Player pPlayer1, Player pPlayer2) {
        isFinished = false;
        aChessBoard = pChessBoard;
        aPlayer1 = pPlayer1;
        aPlayer2 = pPlayer2;
        if (aPlayer1.getIswhite()) {
            currentPlayer = aPlayer1;
        } else {
            currentPlayer = aPlayer2;
        }
        aHistory = new History();
    }

    //MAIN
    public static void main(String args[]) {


        // initialize ChessBoard
        ChessBoard chessBoard = new ChessBoard();

        // Todo: catch wrong input
        // get Player input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player1: What is your name?");
        String player1Name = scanner.nextLine();

        System.out.println("Player2: What is your name?");
        String player2Name = scanner.nextLine();

        System.out.println(player1Name + ", do you play white figures? Type 'yes' or 'no'...");
        String player1IsWhite = scanner.nextLine();

        boolean isWhite;
        if (player1IsWhite.equals("yes") || player1IsWhite.equals("Yes") ||player1IsWhite.equals("YES")) {
            isWhite = true;
        } else {
            isWhite = false;
        }

        // initialize Players
        Player player1 = new Player(isWhite, player1Name);
        Player player2 = new Player(!isWhite, player2Name);

        // start new game
        Game game = new Game(chessBoard, player1, player2);
        game.play();
    }


    // Todo: play, catch wrong input
    public void play() {
        while (!isFinished) {
            System.out.println(currentPlayer.getName() + ", what is your next move?");
            Scanner scanner = new Scanner(System.in);
            String nextMove = scanner.nextLine();
            boolean done = move(nextMove);
            // switch currentPlayer
            if (done) {
                if (currentPlayer.equals(aPlayer1)) {
                    currentPlayer = aPlayer2;
                }
                else currentPlayer = aPlayer1;
            }
            //if (Rules.checkForMate()) {
            //    isFinished = true;
            //}
        }
    }


    // Todo: else {catch wrong input}, perform move
    public boolean move(String move) {
        boolean isWhite = currentPlayer.getIswhite();
        Piece.Color color;
        if (isWhite) {color = Piece.Color.WHITE;}
        else {color = Piece.Color.BLACK;}

        /*
        // castle
        else if (move.charAt(1) == 45 || move.charAt(0) == 48) {
            // 0-0
            if (move.length() == 3) {
                if (Rules.canKingsideCastle()) {
                    castleKS();
                }
            }
            // 0-0-0
            else if (Rules.canQueensideCastle()) {
                movePiece();
            }
        }
        // promotion e8=Q
        else if (move.charAt(2) == 61) {
        }
        // capture Ta1xa5
        else if (move.charAt(3) == 120 && move.length() == 6) {
            // pawn
            if (move.charAt(0) == 112 || move.charAt(0) == 80) {
                // en passant Pe5xd6e.p.
                if (move.length() == 10) {
                    return "en passant";
                }
                // Pc4xd5
                else if (move.length() == 6) {
                    return "pawn capture";
                }
            }
            // tower
            else if (move.charAt(0) == 116 || move.charAt(0) == 84) {
                return "tower capture";
            }
            // knight
            else if (move.charAt(0) == 110 || move.charAt(0) == 78) {
                return "knight capture";
            }
            // bishop
            else if (move.charAt(0) == 98 || move.charAt(0) == 66) {
                return "bishop capture";
            }
            // queen
            else if (move.charAt(0) == 113 || move.charAt(0) == 81) {
                return "queen capture";
            }
            // king
            else if (move.charAt(0) == 107 || move.charAt(0) == 75) {
                return "king capture";
            }
            // Todo: else {catch wrong input}
        }
        */

        // move Ta1a5
        if (move.length() == 5) {
            int[][] xy = stringToInt(move);
            int[] from = xy[0];
            int[] to = xy[1];
            // pawn
            if ((move.charAt(0) == 112 || move.charAt(0) == 80)) {
                // is pawn
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Pawn) {
                    // right color
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        // move valid
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[0], from[1], to[0], to[1])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                        }
                    }

                }
            }
            // tower
            else if (move.charAt(0) == 116 || move.charAt(0) == 84) {
                // is tower
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Tower) {
                    // right color
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        // move valid
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[0], from[1], to[0], to[1])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                        }
                    }

                }
            }
            // knight
            else if (move.charAt(0) == 110 || move.charAt(0) == 78) {
                // is knight
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Knight) {
                    // right color
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        // move valid
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[0], from[1], to[0], to[1])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                        }
                    }

                }
            }
            // bishop
            else if (move.charAt(0) == 98 || move.charAt(0) == 66) {
                // is bishop
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Bishop) {
                    // right color
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        // move valid
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[0], from[1], to[0], to[1])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                        }
                    }

                }
            }
            // queen
            else if (move.charAt(0) == 113 || move.charAt(0) == 81) {
                // is queen
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Queen) {
                    // right color
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        // move valid
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[0], from[1], to[0], to[1])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                        }
                    }

                }
            }
            // king
            else if (move.charAt(0) == 107 || move.charAt(0) == 75) {
                // is king
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof King) {
                    // right color
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        // move valid
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[0], from[1], to[0], to[1])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                        }
                    }

                }
            }
            // Todo: else {catch wrong input}
        }
        ChessBoard.printBoard(aChessBoard.getBoxes());
        return true;
    }

    /*
    Player chooses piece to move.
    Piece makes legal move according to its own move rules.
    In addition to purely move-based rules, there's also capture logic, so a bishop cannot move from a1-h8 if there's a piece sitting on c3.
    If the player was previous under check and the move does not remove the check, it must be undone.
    If the move exposes check, it must be undone / disallowed.
    If player captures a piece, remove the piece (including en passant!)
    If the piece is a pawn reaching the back rank, promote it.
    If the move is a castling, set the new position of the rook accordingly. But a king and rook can only castle if they haven't moved, so you need to keep track of that. And if the king moves through a check to castle, that's disallowed, too.
    If the move results in a stalemate or checkmate, the game is over.
     */


    /*
    private void eatPiece(Piece predator, Piece prey, int[] from, int[] to) {
        boxes[from[0]][from[1]].aPiece = null;
        boxes[to[0]][to[1]].aPiece = predator;
    }*/



    // Be4b7
    public static int[][] stringToInt(String move) {
        // FROM COORDINATES
        int[] from = new int[2];
        // a or A
        if ((int) move.charAt(1) == 97 || (int) move.charAt(0) == 65) {
            from[1] = 0;
        }
        // b or B
        else if ((int) move.charAt(1) == 98 || (int) move.charAt(0) == 66) {
            from[1] = 1;
        }
        // c or C
        else if ((int) move.charAt(1) == 99 || (int) move.charAt(0) == 67) {
            from[1] = 2;
        }
        // d or D
        else if ((int) move.charAt(1) == 100 || (int) move.charAt(0) == 68) {
            from[1] = 3;
        }
        // e or E
        else if ((int) move.charAt(1) == 101 || (int) move.charAt(0) == 69) {
            from[1] = 4;
        }
        // f or F
        else if ((int) move.charAt(1) == 102 || (int) move.charAt(0) == 70) {
            from[1] = 5;
        }
        // g or G
        else if ((int) move.charAt(1) == 103 || (int) move.charAt(0) == 71) {
            from[1] = 6;
        }
        // h or H
        else if ((int) move.charAt(1) == 104 || (int) move.charAt(0) == 72) {
            from[1] = 7;
        }
        // wrong input
        else {
            from[1] = 100;
        }

        // 1
        if ((int) move.charAt(2) == 49) {
            from[0] = 7;
        }
        // 2
        else if ((int) move.charAt(2) == 50) {
            from[0] = 6;
        }
        // 3
        else if ((int) move.charAt(2) == 51) {
            from[0] = 5;
        }
        // 4
        else if ((int) move.charAt(2) == 52) {
            from[0] = 4;
        }
        // 5
        else if ((int) move.charAt(2) == 53) {
            from[0] = 3;
        }
        // 6
        else if ((int) move.charAt(2) == 54) {
            from[0] = 2;
        }
        // 7
        else if ((int) move.charAt(2) == 55) {
            from[0] = 1;
        }
        // 8
        else if ((int) move.charAt(2) == 56) {
            from[0] = 0;
        }
        // wrong input
        else {
            from[0] = 100;
        }



        // TO COORDINATES
        int[] to = new int[2];
        // a or A
        if ((int) move.charAt(3) == 97 || (int) move.charAt(0) == 65) {
            to[1] = 0;
        }
        // b or B
        else if ((int) move.charAt(3) == 98 || (int) move.charAt(0) == 66) {
            to[1] = 1;
        }
        // c or C
        else if ((int) move.charAt(3) == 99 || (int) move.charAt(0) == 67) {
            to[1] = 2;
        }
        // d or D
        else if ((int) move.charAt(3) == 100 || (int) move.charAt(0) == 68) {
            to[1] = 3;
        }
        // e or E
        else if ((int) move.charAt(3) == 101 || (int) move.charAt(0) == 69) {
            to[1] = 4;
        }
        // f or F
        else if ((int) move.charAt(3) == 102 || (int) move.charAt(0) == 70) {
            to[1] = 5;
        }
        // g or G
        else if ((int) move.charAt(3) == 103 || (int) move.charAt(0) == 71) {
            to[1] = 6;
        }
        // h or H
        else if ((int) move.charAt(3) == 104 || (int) move.charAt(0) == 72) {
            to[1] = 7;
        }
        // wrong input
        else {
            to[1] = 100;
        }

        // 1
        if ((int) move.charAt(4) == 49) {
            to[0] = 7;
        }
        // 2
        else if ((int) move.charAt(4) == 50) {
            to[0] = 6;
        }
        // 3
        else if ((int) move.charAt(4) == 51) {
            to[0] = 5;
        }
        // 4
        else if ((int) move.charAt(4) == 52) {
            to[0] = 4;
        }
        // 5
        else if ((int) move.charAt(4) == 53) {
            to[0] = 3;
        }
        // 6
        else if ((int) move.charAt(4) == 54) {
            to[0] = 2;
        }
        // 7
        else if ((int) move.charAt(4) == 55) {
            to[0] = 1;
        }
        // 8
        else if ((int) move.charAt(4) == 56) {
            to[0] = 0;
        }
        // wrong input
        else {
            to[0] = 100;
        }
        return new int[][]{from, to};
    }
}

