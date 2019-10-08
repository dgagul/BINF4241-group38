import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;


// Initialize Game, keep track of game status and player queue
public class Game {
    private Player winner;
    private boolean isfinished;
    private int boardsize;
    private Object[] squares;
    private ArrayBlockingQueue<Player> playerQueue;
    private StringBuilder boardview;


    public Game(Board board, String name1, String name2, String name3, String name4) {
        // set isfinished to false and winner to null
        this.winner = null;
        this.isfinished = false;
        this.playerQueue = new ArrayBlockingQueue<Player>(4);

        // Create Players
        Player player1 = new Player(name1, 1);
        playerQueue.add(player1);

        Player player2 = new Player(name2, 1);
        playerQueue.add(player2);

        if (!name3.equals("None")) {
            Player player3 = new Player(name3, 1);
            playerQueue.add(player3);
        }

        if (!name4.equals("None")) {
            Player player4 = new Player(name4, 1);
            playerQueue.add(player4);
        }

        squares = board.initializeSquares();
        board.setSnakesAndLadders();

    }

    public void play(Board board) {
        Die die = new Die();
        // output state at initial state
        System.out.println("Initial state:\t" + board.calculateBoard());
        while (!isfinished) {
            Player currentPlayer = playerQueue.poll();
            int rolled = die.roll();
            assert currentPlayer != null;
            // output state before every move
            System.out.println(currentPlayer.name + " rolls " + rolled + ":\t" + board.calculateBoard());
            currentPlayer.move(rolled, squares);
            if (LastSquare.isOccupied) {
                winner = currentPlayer;
                isfinished = true;
                // output state when game is finished
                System.out.println("Final State:\t" + board.calculateBoard());
                System.out.println(currentPlayer.name + " wins!");
            } else {
                playerQueue.add(currentPlayer);
            }
        }
    }

    public static void main(String args[]){

            // get user input names and board size
            // will be placed in the main method
            Scanner name = new Scanner(System.in);
            System.out.print("Please enter the name of player 1.");
            String name1 = name.nextLine();

            System.out.print("Please enter the name of player 2.");
            String name2 = name.nextLine();

            System.out.print("Please enter the name of player 3. If you don't want more players please type None");
            String name3 = name.nextLine();

            System.out.print("Please enter the name of player 4. If you don't want more players please type None\" ");
            String name4 = name.nextLine();

            System.out.print("Please enter the board size");
            int boardsize = name.nextInt();
            Board board = new Board(boardsize);

            // call Game constructer by creating an object actualgame
            Game actualgame = new Game(board, name1, name2, name3, name4);

            // start the game with the play() method
            actualgame.play(board);
    }

}

