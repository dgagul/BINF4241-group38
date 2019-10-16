import java.util.Scanner;

public class Game{
    private static boolean isFinished;
    private static Player currentPlayer;

    public Game(ChessBoard chessBoard, Player player1, Player player2) {
        isFinished = false;
        if (player1.getIswhite()) {
            currentPlayer = player1;
        }
        else {currentPlayer = player2;}
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
        //game.startgame();
    }


    public static void startgame() {
        while (!isFinished) {
            // Todo: play
        }
    }
}
