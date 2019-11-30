package main.snakesAndLadders;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


// Initialize Game, keep track of game status and player queue
public class Game {
    private Player winner;
    private boolean isFinished;
    private int boardsize;
    private Square[] squares;
    private ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<Player>(4);

    public ArrayBlockingQueue<Player> getPlayerQueue(){
        return playerQueue;
    }

    public int getBoardsize(){
        return this.boardsize;
    }


    public Game(int boardsize, String name1, String name2, String name3, String name4) {
        this.isFinished = false;
        this.winner = null;
        this.boardsize = boardsize;
        this.squares = new Square[boardsize];

        initializeBoard();
        initializePlayers(name1, name2, name3, name4);
        setSnadders();
        printInitialAndFinalState(true);
    }

    // Method to play the game
    private void play() {
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
        printInitialAndFinalState(false);
        System.out.println(winner.getName() + " wins!");
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
                Snadder snadder = new Snadder(j);
                squares[j] = snadder;
            }
        } else if (boardsize > 4) {
            Snadder snadder = new Snadder(2);
            squares[2] = snadder;
        }
    }

    private void printState(Player currentPlayer, int rolled){
        StringBuilder line = new StringBuilder(currentPlayer.getName() + " rolls " + rolled);
        line.append(":" + "\t [1");
        for (String name : squares[0].occupants){
            line.append("<").append(name).append(">");
        }
        line.append("]");
        for (int k = 1; k < boardsize; k++) {
            int i = k + 1;
            line.append(" [");
            if (squares[k].getClass() == Snadder.class) {
                Snadder snadder = (Snadder)squares[k];
                int j = snadder.end + 1;
                if (snadder.end < k) {
                    line.append(j).append("<-").append(i);
                } else {
                    line.append(i).append("->").append(j);
                }
            } else if (squares[k].isOccupied) {
                line.append(i);
                for (String name : squares[k].occupants) {
                    line.append("<").append(name).append(">");
                }
            } else {
                line.append(i);
            }
            line.append("]");
        }

        System.out.println(line);
    }

    private void printInitialAndFinalState(boolean isInitial) {
        StringBuilder line;
        if(isInitial){
            line = new StringBuilder("Initial state: ");
        }
        else{
            line = new StringBuilder("Final state: ");}
        line.append(" \t [1");
        for (String name : squares[0].occupants) {
            line.append("<").append(name).append(">");
        }
        line.append("]");
        for (int k = 1; k < boardsize; k++) {
            int i = k + 1;
            line.append(" [");
            if (squares[k].getClass()==Snadder.class) {
                Snadder snadder = (Snadder)squares[k];
                int j = snadder.end + 1;
                if (snadder.end < k) {
                    line.append(j).append("<-").append(i);
                } else {
                    line.append(i).append("->").append(j);
                }
            } else if (squares[k].isOccupied) {
                line.append(i);
                for (String name : squares[k].occupants) {
                    line.append("<").append(name).append(">");
                }
            } else {
                line.append(i);
            }
            line.append("]");
        }

        System.out.println(line);
    }


    public static void main(String[] args) {
        String name1, name2, name3, name4;

        // get user input names and board size
        // will be placed in the main method
        Scanner name = new Scanner(System.in);
        System.out.print("Please enter the name of player 1: ");
        name1 = name.nextLine();

        System.out.print("Please enter the name of player 2: ");
        name2 = name.nextLine();

        System.out.print("Please enter the name of player 3. If you don't want any more players please type None. ");
        name3 = name.nextLine();

        if (!name3.equals("None")) {
            System.out.print("Please enter the name of player 4. If you don't want any more players please type None. ");
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

