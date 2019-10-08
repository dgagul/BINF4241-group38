import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;


// Initialize Game, keep track of game status and player queue
public class Game {
    private Player winner;
    private boolean isFinished;
    private int boardsize;
    private Square[] squares;
    private ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<Player>(4);


    public Game(int boardsize, String name1, String name2, String name3, String name4) {
        this.isFinished = false;
        this.winner = null;
        this.boardsize = boardsize;
        this.squares = new Square[boardsize];

        initializeBoard();
        initializePlayers(name1, name2, name3, name4);
        setSnadders();
        printInitialState(name1, name2, name3, name4);
    }

    public void play() {
        Die die = new Die();
        while (!isFinished) {
            Player currentPlayer = playerQueue.poll();
            int rolled = die.roll();
            assert currentPlayer != null;
            currentPlayer.move(rolled, squares);
            if (squares[boardsize - 1].isOccupied) {
                winner = currentPlayer;
                isFinished = true;
            } else {
                playerQueue.add(currentPlayer);
            }
            printState(currentPlayer, rolled);
        }
        System.out.println(winner.name + " wins!");
    }

    private void initializePlayers(String name1, String name2, String name3, String name4) {
        if (!name1.equals("None")) {
            Player player1 = new Player(name1, 0);
            playerQueue.add(player1);
            squares[0].occupants.add(name1);
        }

        if (!name2.equals("None")) {
            Player player2 = new Player(name2, 0);
            playerQueue.add(player2);
            squares[0].occupants.add(name2);
        }

        if (!name3.equals("None")) {
            Player player3 = new Player(name3, 0);
            playerQueue.add(player3);
            squares[0].occupants.add(name3);
        }

        if (!name4.equals("None")) {
            Player player4 = new Player(name4, 0);
            playerQueue.add(player4);
            squares[0].occupants.add(name4);
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < boardsize; i++) {
            Square square = new Square(i);
            squares[i] = square;
        }
    }

    private void setSnadders() {
        if (boardsize > 9) {
            for (int j = 3; j < boardsize - 4; j += 5) {
                Random random = new Random();
                boolean isLadder = random.nextBoolean();
                squares[j].setSnadder(isLadder);
            }
        } else if (boardsize > 4) {
            squares[2].setSnadder(true);
        }
    }

    private void printInitialState(String name1, String name2, String name3, String name4) {
        String line = "Initial state: [1 <" + name1 + "><" + name2 + ">";
        switch (playerQueue.size()) {
            case 3:
                line += "<" + name3 + ">";
                break;
            case 4:
                line += "<" + name3 + "><" + name4 + ">";
                break;
            default:
                break;
        }
        line += "]";
        for (int k = 1; k < boardsize; k++) {
            line += "[";
            if (squares[k].isSnadder) {
                int i = squares[k].end + 1;
                int j = k+1;
                if(squares[k].end > k){
                    line += j + "->" + i;
                }
                else{
                    line += i + "<-" + j;
                }

            } else {
                line += k + 1;
            }
            line += "]";
        }
        System.out.println(line);
    }

    private void printState(Player currentPlayer, int rolled){
        String line = currentPlayer.name + " rolls " + rolled;
        line += ": [1";
        for (String name : squares[0].occupants){
            line += "<" + name + ">";
        }
        line += "]";
        for (int k = 1; k < boardsize; k++) {
            int i = k + 1;
            line += " [";
            if (squares[k].isSnadder) {
                int j = squares[k].end + 1;
                if (squares[k].end < k) {
                    line += j + "<-" + i;
                } else {
                    line += i + "->" + j;
                }
            } else if (squares[k].isOccupied) {
                line += i;
                for (String name : squares[k].occupants) {
                    line += "<" + name + ">";
                }
            } else {
                line += i;
            }
            line += "]";
        }

        System.out.println(line);
    }


    public static void main(String args[]) {
        String name1, name2, name3, name4;

        // get user input names and board size
        // will be placed in the main method
        Scanner name = new Scanner(System.in);
        System.out.print("Please enter the name of player 1: ");
        name1 = name.nextLine();

        System.out.print("Please enter the name of player 2: ");
        name2 = name.nextLine();

        System.out.print("Please enter the name of player 3. If you don't want more players please type None. ");
        name3 = name.nextLine();

        if (!name3.equals("None")) {
            System.out.print("Please enter the name of player 4. If you don't want more players please type None. ");
            name4 = name.nextLine();
        } else {
            name4 = "None";
        }

        System.out.print("Please enter the board size: ");
        int boardsize = name.nextInt();

        // call Game constructor
        Game game = new Game(boardsize, name1, name2, name3, name4);
        game.play();

    }

}

