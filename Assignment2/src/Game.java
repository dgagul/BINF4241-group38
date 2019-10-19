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
        if (player1IsWhite.equals("yes") || player1IsWhite.equals("Yes") || player1IsWhite.equals("YES")) {
            isWhite = true;
        } else {
            isWhite = false;
        }
        System.out.println("White starts...");

        // initialize Players
        Player player1 = new Player(isWhite, player1Name);
        Player player2 = new Player(!isWhite, player2Name);

        // start new game
        Game game = new Game(chessBoard, player1, player2);
        game.play();

        System.out.println("Check mate:");
        System.out.println(game.getCurrentPlayer() + "wins!");
    }


    // Todo: catch wrong input
    public void play() {
        while (!isFinished) {
            System.out.println(currentPlayer.getName() + ", what is your next move?");
            Scanner scanner = new Scanner(System.in);
            String nextMove = scanner.nextLine();
            // play and switch currentPlayer
            if (move(nextMove)) {
                if (currentPlayer.equals(aPlayer1)) {
                    currentPlayer = aPlayer2;
                } else currentPlayer = aPlayer1;
            }
            else {
                System.out.println("Invalid input, try again!");
            }
            /*
            If the move results in checkmate, the game is over.
            if (Rules.checkForMate()) {
                isFinished = true;
            }
            */
        }
    }


    // Todo: else {catch wrong input}
    public boolean move(String move) {
        boolean isWhite = currentPlayer.getIswhite();
        Piece.Color color;
        if (isWhite) {
            color = Piece.Color.WHITE;
        } else {
            color = Piece.Color.BLACK;
        }

        int[][] xy = stringToInt(move);
        int[] from = xy[0];
        int[] to = xy[1];

        //Try
        //if  (currentPlayer.getIsChecked()) { }
        //If the player was previous under check and the move does not remove the check, it must be undone.
        //If the move exposes check, it must be undone / disallowed.
        //Catch

        // castle {50,50}{50,50}    {100,100}{100,100}
        // If the move is a castling, set the new position of the rook accordingly. But a king and rook can only castle if they haven't moved, so you need to keep track of that. And if the king moves through a check to castle, that's disallowed, too.

        // promotion e8=Q
        // If the piece is a pawn reaching the back rank, promote it.

        // capture Ta1xa5
        // If player captures a piece, remove the piece (including en passant!)

        // move Ta1a5
        if (move.length() == 5) {
            // pawn
            if ((move.charAt(0) == 112 || move.charAt(0) == 80)) {
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Pawn) {
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        if (aChessBoard.getBoxes()[to[0]][to[1]].isOccupied()) {
                            return false;
                        }
                        else {
                            if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[1], from[0], to[1], to[0])) {
                                Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                                aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                                aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                                ChessBoard.printBoard(aChessBoard.getBoxes());
                                return true;
                            }
                        }
                    }
                }
            }
            // tower
            if ((move.charAt(0) == 116 || move.charAt(0) == 84)) {
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Tower) {
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[1], from[0], to[1], to[0])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                            ChessBoard.printBoard(aChessBoard.getBoxes());
                            return true;
                        }
                    }
                }
            }
            // knight
            if ((move.charAt(0) == 110 || move.charAt(0) == 78)) {
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Knight) {
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[1], from[0], to[1], to[0])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                            ChessBoard.printBoard(aChessBoard.getBoxes());
                            return true;
                        }
                    }
                }
            }
            // bishop
            if ((move.charAt(0) == 98 || move.charAt(0) == 66)) {
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Bishop) {
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[1], from[0], to[1], to[0])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                            ChessBoard.printBoard(aChessBoard.getBoxes());
                            return true;
                        }
                    }
                }
            }
            // queen
            if ((move.charAt(0) == 113 || move.charAt(0) == 81)) {
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof Queen) {
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[1], from[0], to[1], to[0])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                            ChessBoard.printBoard(aChessBoard.getBoxes());
                            return true;
                        }
                    }
                }
            }
            // king
            if ((move.charAt(0) == 107 || move.charAt(0) == 75)) {
                if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece() instanceof King) {
                    if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().getaColor() == color) {
                        if (aChessBoard.getBoxes()[from[0]][from[1]].getPiece().moveIsValid(from[1], from[0], to[1], to[0])) {
                            Piece piece = aChessBoard.getBoxes()[from[0]][from[1]].getPiece();
                            aChessBoard.getBoxes()[from[0]][from[1]].setPiece(null);
                            aChessBoard.getBoxes()[to[0]][to[1]].setPiece(piece);
                            ChessBoard.printBoard(aChessBoard.getBoxes());
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        // Todo: exceptions (two towers in same row...)
        return true;
    }


    // Be4b7
    // Qd1xh5
    // 0-0
    // 0-0-0
    // e8=Q
    public static int[][] stringToInt(String move) {
        if (move.equals("0-0")){return new int[][] {{50,50}, {50,50}};}
        if (move.equals("0-0-0")){return new int[][] {{100,100}, {100,100}};}
        // promotion
        if (move.charAt(2) == 61){
            // FROM COORDINATES
            int[] from = new int[2];
            int[] to = new int[2];
            // a or A
            if ((int) move.charAt(0) == 97 || (int) move.charAt(0) == 65) {
                from[1] = 0;
                to[1] = 0;
            }
            // b or B
            else if ((int) move.charAt(0) == 98 || (int) move.charAt(0) == 67) {
                from[1] = 1;
                to[1] = 1;
            }
            // c or C
            else if ((int) move.charAt(0) == 99 || (int) move.charAt(0) == 66) {
                from[1] = 2;
                to[1] = 2;
            }
            // d or D
            else if ((int) move.charAt(0) == 100 || (int) move.charAt(0) == 68) {
                from[1] = 3;
                to[1] = 3;
            }
            // e or E
            else if ((int) move.charAt(0) == 101 || (int) move.charAt(0) == 69) {
                from[1] = 4;
                to[1] = 4;
            }
            // f or F
            else if ((int) move.charAt(0) == 102 || (int) move.charAt(0) == 70) {
                from[1] = 5;
                to[1] = 5;
            }
            // g or G
            else if ((int) move.charAt(0) == 103 || (int) move.charAt(0) == 71) {
                from[1] = 6;
                to[1] = 6;
            }
            // h or H
            else if ((int) move.charAt(0) == 104 || (int) move.charAt(0) == 72) {
                from[1] = 7;
                to[1] = 7;
            }
            // wrong input
            else {
                from[1] = 100;
                to[1] = 100;
            }

            // 1
            if ((int) move.charAt(2) == 49) {
                from[0] = 6;
                to[0] = 7;
            }
            // 8
            else if ((int) move.charAt(2) == 56) {
                from[0] = 1;
                to[0] = 0;
            }
            // wrong input
            else {
                from[0] = 100;
            }
            return new int[][] {from, to};
        }
        // regular move Bc1d2
        // FROM COORDINATES
        int[] from = new int[2];
        // a or A
        if ((int) move.charAt(1) == 97 || (int) move.charAt(1) == 65) {
            from[1] = 0;
        }
        // b or B
        else if ((int) move.charAt(1) == 98 || (int) move.charAt(1) == 67) {
            from[1] = 1;
        }
        // c or C
        else if ((int) move.charAt(1) == 99 || (int) move.charAt(1) == 66) {
            from[1] = 2;
        }
        // d or D
        else if ((int) move.charAt(1) == 100 || (int) move.charAt(1) == 68) {
            from[1] = 3;
        }
        // e or E
        else if ((int) move.charAt(1) == 101 || (int) move.charAt(1) == 69) {
            from[1] = 4;
        }
        // f or F
        else if ((int) move.charAt(1) == 102 || (int) move.charAt(1) == 70) {
            from[1] = 5;
        }
        // g or G
        else if ((int) move.charAt(1) == 103 || (int) move.charAt(1) == 71) {
            from[1] = 6;
        }
        // h or H
        else if ((int) move.charAt(1) == 104 || (int) move.charAt(1) == 72) {
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

        // Capture Qd1xh5
        // TO COORDINATES
        if (move.charAt(3) == 120) {
            int[] to = new int[2];
            // a or A
            if ((int) move.charAt(4) == 97 || (int) move.charAt(4) == 65) {
                to[1] = 0;
            }
            // b or B
            else if ((int) move.charAt(4) == 98 || (int) move.charAt(4) == 66) {
                to[1] = 1;
            }
            // c or C
            else if ((int) move.charAt(4) == 99 || (int) move.charAt(4) == 67) {
                to[1] = 2;
            }
            // d or D
            else if ((int) move.charAt(4) == 100 || (int) move.charAt(4) == 68) {
                to[1] = 3;
            }
            // e or E
            else if ((int) move.charAt(4) == 101 || (int) move.charAt(4) == 69) {
                to[1] = 4;
            }
            // f or F
            else if ((int) move.charAt(4) == 102 || (int) move.charAt(4) == 70) {
                to[1] = 5;
            }
            // g or G
            else if ((int) move.charAt(4) == 103 || (int) move.charAt(4) == 71) {
                to[1] = 6;
            }
            // h or H
            else if ((int) move.charAt(4) == 104 || (int) move.charAt(4) == 72) {
                to[1] = 7;
            }
            // wrong input
            else {
                to[1] = 100;
            }

            // 1
            if ((int) move.charAt(5) == 49) {
                to[0] = 7;
            }
            // 2
            else if ((int) move.charAt(5) == 50) {
                to[0] = 6;
            }
            // 3
            else if ((int) move.charAt(5) == 51) {
                to[0] = 5;
            }
            // 4
            else if ((int) move.charAt(5) == 52) {
                to[0] = 4;
            }
            // 5
            else if ((int) move.charAt(5) == 53) {
                to[0] = 3;
            }
            // 6
            else if ((int) move.charAt(5) == 54) {
                to[0] = 2;
            }
            // 7
            else if ((int) move.charAt(5) == 55) {
                to[0] = 1;
            }
            // 8
            else if ((int) move.charAt(5) == 56) {
                to[0] = 0;
            }
            // wrong input
            else {
                to[0] = 100;
            }
            return new int[][] {from, to};
        }

        // regular move Be4b7
        // TO COORDINATES
        else {
            int[] to = new int[2];
            // a or A
            if ((int) move.charAt(3) == 97 || (int) move.charAt(3) == 65) {
                to[1] = 0;
            }
            // b or B
            else if ((int) move.charAt(3) == 98 || (int) move.charAt(3) == 66) {
                to[1] = 1;
            }
            // c or C
            else if ((int) move.charAt(3) == 99 || (int) move.charAt(3) == 67) {
                to[1] = 2;
            }
            // d or D
            else if ((int) move.charAt(3) == 100 || (int) move.charAt(3) == 68) {
                to[1] = 3;
            }
            // e or E
            else if ((int) move.charAt(3) == 101 || (int) move.charAt(3) == 69) {
                to[1] = 4;
            }
            // f or F
            else if ((int) move.charAt(3) == 102 || (int) move.charAt(3) == 70) {
                to[1] = 5;
            }
            // g or G
            else if ((int) move.charAt(3) == 103 || (int) move.charAt(3) == 71) {
                to[1] = 6;
            }
            // h or H
            else if ((int) move.charAt(3) == 104 || (int) move.charAt(3) == 72) {
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
            return new int[][] {from, to};
        }
    }

    public String getCurrentPlayer() {
        Player player = currentPlayer;
        return player.getName();
    }
}