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
            squares[i + 1] = square;
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
        }

        else if (boardsize>4){
            Snadder snadder = new Snadder(2, true);
            }


        String line = "Initial state: [1 <" + name1 + "><" + name2 + ">";
        switch (playerQueue.size()) {
            case 3:
                line += "<" + name3 + ">";
                break;
            case 4:
                line += "<" + name4 + ">";
                break;
            default:
                break;
        }
        line += "]";
        for (int k = 1; k < boardsize; k++) {
            line += "[";
            if (squares[k].isSnadder) {
                line += k + "->" + squares[k].end;
            }
            line += "]";
        }
    }

    public void play() {
        Die die = new Die();
        // Todo: output state
        while (!isfinished) {
            Player currentPlayer = playerQueue.poll();
            int rolled = die.roll();
            assert currentPlayer != null;
            currentPlayer.move(rolled, squares);
            if (squares[boardsize].isOccupied) {
                winner = currentPlayer;
                isfinished = true;
            } else {
                playerQueue.add(currentPlayer);
            }
        }
    }


    /*public static void main(String args[]){

            // get user input names and board size
            // will be placed in the main method
            Scanner name = new Scanner(System.in);
            System.out.print("Please enter the name of player 1.");
            name1 = name.nextLine();

            System.out.print("Please enter the name of player 2.");
            name2 = name.nextLine();

            System.out.print("Please enter the name of player 3. If you don't want more players please type None");
            name3 = name.nextLine();

            System.out.print("Please enter the name of player 4. If you don't want more players please type None\" ");
            name4 = name.nextLine();

            System.out.print("Please enter the board size");
            boardsize = name.nextInt();

            // call Game constructer by creating an object actualgame
            Game actualgame = new Game(boardsize, name1, name2, name3, name4);*/

    // }

}

