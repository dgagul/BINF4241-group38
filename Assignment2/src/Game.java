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

        int[][] xy = stringToInt(move);
        int fromX = xy[0][0];
        int fromY = xy[0][1];
        int toX = xy[1][0];
        int toY = xy[1][1];

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

        Piece piece = aChessBoard.getBoxes()[fromX][fromY].getPiece();
        aChessBoard.getBoxes()[fromX][fromY].setPiece(null);
        aChessBoard.getBoxes()[toX][toY].setPiece(piece);
        ChessBoard.printBoard(aChessBoard.getBoxes());
        return true;
    }


    // Bb7
    // Qxh5
    // e8=Q
    public int[][] stringToInt(String move) {
        boolean isWhite = currentPlayer.getIswhite();
        Piece.Color color;
        if (isWhite) {
            color = Piece.Color.WHITE;
        } else {
            color = Piece.Color.BLACK;
        }

        int[] to = new int[2];
        int[] from = new int[2];

        // promotion
        if (move.charAt(2) == 61){
            // FROM COORDINATES
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



        // Capture Qxh5
        // TO COORDINATES
        if (move.charAt(1) == 120) {
            // TO COORDINATES
            // a
            if ((int) move.charAt(2) == 97) {
                to[1] = 0;
            }
            // b
            else if ((int) move.charAt(2) == 98) {
                to[1] = 1;
            }
            // c
            else if ((int) move.charAt(2) == 99) {
                to[1] = 2;
            }
            // d
            else if ((int) move.charAt(2) == 100) {
                to[1] = 3;
            }
            // e
            else if ((int) move.charAt(2) == 101) {
                to[1] = 4;
            }
            // f
            else if ((int) move.charAt(2) == 102) {
                to[1] = 5;
            }
            // g
            else if ((int) move.charAt(2) == 103) {
                to[1] = 6;
            }
            // h
            else if ((int) move.charAt(2) == 104) {
                to[1] = 7;
            }
            // wrong input
            else {
                to[1] = 100;
            }

            // 1
            if ((int) move.charAt(3) == 49) {
                to[0] = 7;
            }
            // 2
            else if ((int) move.charAt(3) == 50) {
                to[0] = 6;
            }
            // 3
            else if ((int) move.charAt(3) == 51) {
                to[0] = 5;
            }
            // 4
            else if ((int) move.charAt(3) == 52) {
                to[0] = 4;
            }
            // 5
            else if ((int) move.charAt(3) == 53) {
                to[0] = 3;
            }
            // 6
            else if ((int) move.charAt(3) == 54) {
                to[0] = 2;
            }
            // 7
            else if ((int) move.charAt(3) == 55) {
                to[0] = 1;
            }
            // 8
            else if ((int) move.charAt(3) == 56) {
                to[0] = 0;
            }
            // wrong input
            else {
                to[0] = 100;
            }

            // B for Bishop
            // Todo: exceptions (two Bishops in same row...)
            if (move.charAt(0) == 66) {
                for (int i=0; i<8; i++) {
                    for (int k=0; k<8; k++) {
                        if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                            if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Bishop) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                    if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                        from[0] = i;
                                        from[1] = k;
                                        return new int[][] {from, to};
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // K for King
            if (move.charAt(0) == 75) {
                for (int i=0; i<8; i++) {
                    for (int k=0; k<8; k++) {
                        if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                            if (aChessBoard.getBoxes()[i][k].getPiece() instanceof King) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                    if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                        from[0] = i;
                                        from[1] = k;
                                        return new int[][]{from, to};
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // N for Knight
            if (move.charAt(0) == 78) {
                for (int i=0; i<8; i++) {
                    for (int k=0; k<8; k++) {
                        if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                            if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Knight) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                    if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                        from[0] = i;
                                        from[1] = k;
                                        return new int[][] {from, to};
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // P for Pawn
            if (move.charAt(0) == 80) {
                for (int i=0; i<8; i++) {
                    for (int k=0; k<8; k++) {
                        if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                            if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Pawn) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                    if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                        from[0] = i;
                                        from[1] = k;
                                        return new int[][] {from, to};
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // Q for Queen
            if (move.charAt(0) == 81) {
                for (int i=0; i<8; i++) {
                    for (int k=0; k<8; k++) {
                        if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                            if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Queen) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                    if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                        from[0] = i;
                                        from[1] = k;
                                        return new int[][] {from, to};
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // T for Tower
            if (move.charAt(0) == 84) {
                for (int i=0; i<8; i++) {
                    for (int k=0; k<8; k++) {
                        if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                            if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Tower) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                    if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                        from[0] = i;
                                        from[1] = k;
                                        return new int[][] {from, to};
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }



        // regular move Bd2
        // TO COORDINATES
        // a
        if ((int) move.charAt(1) == 97) {
            to[1] = 0;
        }
        // b
        else if ((int) move.charAt(1) == 98) {
            to[1] = 1;
        }
        // c
        else if ((int) move.charAt(1) == 99) {
            to[1] = 2;
        }
        // d
        else if ((int) move.charAt(1) == 100) {
            to[1] = 3;
        }
        // e
        else if ((int) move.charAt(1) == 101) {
            to[1] = 4;
        }
        // f
        else if ((int) move.charAt(1) == 102) {
            to[1] = 5;
        }
        // g
        else if ((int) move.charAt(1) == 103) {
            to[1] = 6;
        }
        // h
        else if ((int) move.charAt(1) == 104) {
            to[1] = 7;
        }
        // wrong input
        else {
            to[1] = 100;
        }

        // 1
        if ((int) move.charAt(2) == 49) {
            to[0] = 7;
        }
        // 2
        else if ((int) move.charAt(2) == 50) {
            to[0] = 6;
        }
        // 3
        else if ((int) move.charAt(2) == 51) {
            to[0] = 5;
        }
        // 4
        else if ((int) move.charAt(2) == 52) {
            to[0] = 4;
        }
        // 5
        else if ((int) move.charAt(2) == 53) {
            to[0] = 3;
        }
        // 6
        else if ((int) move.charAt(2) == 54) {
            to[0] = 2;
        }
        // 7
        else if ((int) move.charAt(2) == 55) {
            to[0] = 1;
        }
        // 8
        else if ((int) move.charAt(2) == 56) {
            to[0] = 0;
        }
        // wrong input
        else {
            to[0] = 100;
        }



        // B for Bishop
        // Todo: exceptions (two Bishops in same row...)
        if (move.charAt(0) == 66) {
            for (int i=0; i<8; i++) {
                for (int k=0; k<8; k++) {
                    if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                        if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Bishop) {
                            if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                    from[0] = i;
                                    from[1] = k;
                                    return new int[][] {from, to};
                                }
                            }
                        }
                    }
                }
            }
        }
        // K for King
        if (move.charAt(0) == 75) {
            for (int i=0; i<8; i++) {
                for (int k=0; k<8; k++) {
                    if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                        if (aChessBoard.getBoxes()[i][k].getPiece() instanceof King) {
                            if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                    from[0] = i;
                                    from[1] = k;
                                    return new int[][]{from, to};
                                }
                            }
                        }
                    }
                }
            }
        }
        // N for Knight
        if (move.charAt(0) == 78) {
            for (int i=0; i<8; i++) {
                for (int k=0; k<8; k++) {
                    if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                        if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Knight) {
                            if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                    from[0] = i;
                                    from[1] = k;
                                    return new int[][] {from, to};
                                }
                            }
                        }
                    }
                }
            }
        }
        // P for Pawn
        if (move.charAt(0) == 80) {
            for (int i=0; i<8; i++) {
                for (int k=0; k<8; k++) {
                    if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                        if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Pawn) {
                            if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                    from[0] = i;
                                    from[1] = k;
                                    return new int[][] {from, to};
                                }
                            }
                        }
                    }
                }
            }
        }
        // Q for Queen
        if (move.charAt(0) == 81) {
            for (int i=0; i<8; i++) {
                for (int k=0; k<8; k++) {
                    if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                        if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Queen) {
                            if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                    from[0] = i;
                                    from[1] = k;
                                    return new int[][] {from, to};
                                }
                            }
                        }
                    }
                }
            }
        }
        // T for Tower
        if (move.charAt(0) == 84) {
            for (int i=0; i<8; i++) {
                for (int k=0; k<8; k++) {
                    if (aChessBoard.getBoxes()[i][k].isOccupied()) {
                        if (aChessBoard.getBoxes()[i][k].getPiece() instanceof Tower) {
                            if (aChessBoard.getBoxes()[i][k].getPiece().getaColor() == color) {
                                if (aChessBoard.getBoxes()[i][k].getPiece().moveIsValid(k, i, to[1], to[0])) {
                                    from[0] = i;
                                    from[1] = k;
                                    return new int[][] {from, to};
                                }
                            }
                        }
                    }
                }
            }
        }

        return new int[][] {from, to};
    }

    public String getCurrentPlayer() {
        Player player = currentPlayer;
        return player.getName();
    }
}