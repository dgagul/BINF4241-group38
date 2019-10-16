import java.util.Scanner;

public class Game{
    private static boolean isFinished;
    private static Player currentPlayer;
    private ChessBoard aChessBoard;
    private Player aPlayer1;
    private Player aPlayer2;

    public Game(ChessBoard pChessBoard, Player pPlayer1, Player pPlayer2) {
        isFinished = false;
        aChessBoard = pChessBoard;
        aPlayer1 = pPlayer1;
        aPlayer2 = pPlayer2;
        if (aPlayer1.getIswhite()) {
            currentPlayer = aPlayer1;
        }
        else {currentPlayer = aPlayer2;}
    }


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
        if (player1IsWhite == "yes" || player1IsWhite == "Yes") {
            isWhite = true;
        }
        else { isWhite = false; }


        // initialize Players
        Player player1 = new Player(isWhite, player1Name);
        Player player2 = new Player(!isWhite, player2Name);


        // start new game
        Game game = new Game(chessBoard,player1,player2);
        //game.play();
    }

    // Todo: play, catch wrong input
    public static void play() {
        while (!isFinished) {
            System.out.println(currentPlayer.getName() + ", what is your next move?");
            System.out.println("e.g. Bishop to g6");
            Scanner scanner = new Scanner(System.in);
            String nextMove = scanner.nextLine();
            // print ChessBoard
        }
    }

    // Todo: finish
    // helping function
    private void cutNextMove(String nextMove) {
    }

    // Todo: finish
    public ChessBoard getChessBoard() {
        ChessBoard pChessBoard = aChessBoard;
        return pChessBoard;
    }
}
