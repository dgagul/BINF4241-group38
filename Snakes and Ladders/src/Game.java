import java.util.Scanner;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;


// Initialize Game, keep track of game status and player queue
public class Game {
    private Player winner;
    private boolean isfinished;
    private int boardsize;
    private Square[] squares;
    private ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<Player>(4);
    private StringBuilder boardview;


    Game(int boardsize, String name1, String name2, String name3, String name4) {
        // set isfinished to false and winner to null
        this.isfinished = false;
        this.winner = null;
        this.boardsize = boardsize;
        this.squares = new Square[boardsize];

        // initialize Players called player1,player2,player3,player4
        // and playerqueue
        // and sets position of all players to 1
        // Player class needs to have attributes: name and position
        if (!name1.equals("None")) {
            Player player1 = new Player(name1, 1);
            playerQueue.add(player1);
        }

        if (!name2.equals("None")) {
            Player player2 = new Player(name2, 1);
            playerQueue.add(player2);
        }

        if (!name3.equals("None")) {
            Player player3 = new Player(name3, 1);
            playerQueue.add(player3);
        }

        if (!name4.equals("None")) {
            Player player4 = new Player(name4, 1);
            playerQueue.add(player4);
        }

        // Initializes Squares
        // sets isoccupied of firstsquare to true
        // sets isstart of firstsquare to true
        // sets isend of lastsquare to true
        // this means that the constructor of the Square class has to set all
        // attributes to false initially

        //Square[] squares = new Square[boardsize];

        for (int i = 0; i < boardsize; i++) {
            Square square = new Square(i + 1);
            squares[i] = square;
        }

        // Set random Snadders (random if its a ladder or a snadder)
        // all 5 Squares starting by  4and ending by -4
        // Snadder class needs to have an attribute start and end
        // Snadder.start is declared in this construcotr
        // .end needs to be calculated in Snadder class
        // when it is a ladder make square.number + 2
        // when it is a snake make square.number - 2
        if (boardsize > 9) {
            for (int j = 4; j < boardsize - 4; j += 5) {
                Random random = new Random();
                boolean isladder = random.nextBoolean();
                Snadder snadder = new Snadder(j, isladder);
                squares[j] = snadder;
            }
        } else if (boardsize > 4) {
            Snadder snadder = new Snadder(2, true);
        }

    }

    public StringBuilder calculateBoard() {
        for (int i = 0; i < boardsize; i++) {
            boardview.append("[" + squares[i].number);
            if (squares[i].isOccupied){
                // problem with StartSquare multiple occupants
                boardview.append("<" + squares[i].occupant + ">" + "] ");
            }
            // problem with arrow up or down
            else if (squares[i].isLadder) {
                // squares.end not reachable, even if it is a Snadder
                boardview.append("->" + squares[i].end + "] ");
            }
            else if (squares[i].isSnake) {
                boardview.append("<-" + squares[i].end + "] ");
            }
            else {
                boardview.append("] ");
            }
        }
        return boardview;
    }


    public void play() {
        Die die = new Die();
        // output state
        System.out.println("Initial state:\t" + calculateBoard());
        while (!isfinished) {
            Player currentPlayer = playerQueue.poll();
            int rolled = die.roll();
            assert currentPlayer != null;
            System.out.println(currentPlayer.name + " rolls " + rolled + ":\t" + calculateBoard());
            currentPlayer.move(rolled, squares);
            if (squares[boardsize].isOccupied) {
                winner = currentPlayer;
                isfinished = true;
                System.out.println("Final State:\t" + calculateBoard());
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

            // call Game constructer by creating an object actualgame
            Game actualgame = new Game(boardsize, name1, name2, name3, name4);

            // start the game with the play() method
            actualgame.play();

    }

}

