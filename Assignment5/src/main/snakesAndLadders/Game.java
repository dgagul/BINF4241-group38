package main.snakesAndLadders;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class Game {
    private Player winner;
    private boolean isFinished;
    private int boardsize;
    private Square[] squares;
    private ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<Player>(4);


    /**
     * Game constructor to create Game obj.
     * @param boardsize an int with the size of the board
     * @param name1 an String containing the name of the player1
     * @param name2 an String containing the name of the player2
     * @param name3 an String containing the name of the player3
     * @param name4 an String containing the name of the player4
     */
    public Game(int boardsize, String name1, String name2, String name3, String name4) {
        // ****
        if(boardsize < 2){
            throw new IllegalArgumentException("cannot create game with board size < 2"); }

        if(name1.equals("") || name2.equals("") || name3.equals("") || name4.equals("")){
            throw new IllegalArgumentException("cannot create game with no name players"); }

        if(name1.equals(null) || name2.equals(null) || name3.equals(null) || name4.equals(null)){
            throw new IllegalArgumentException("cannot create null player");
        }
        // ****
        this.isFinished = false;
        this.winner = null;
        this.boardsize = boardsize;
        this.squares = new Square[boardsize];

        initializeBoard();
        initializePlayers(name1, name2, name3, name4);
        setSnadders();
        printInitialAndFinalState(true);
    }


    /**
     * Method to play the game while no player has reached the last square
     */
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
        System.out.println(winner.name + " wins!");
    }

    /**
     * Method to initialize players
     *
     * @param name1 an String containing the name of the player1
     * @param name2 an String containing the name of the player2
     * @param name3 an String containing the name of the player3
     * @param name4 an String containing the name of the player4
     * */
    private void initializePlayers(String name1, String name2, String name3, String name4) {
        // ****

        if (name1 == null || name2 == null || name3 == null || name4 == null) {
            throw new IllegalArgumentException("cannot create null player");
        }

        // ****

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

    /**
     * method to initialize the Board
     */
    public void initializeBoard() {
        for (int i = 0; i < boardsize; i++) {
            Square square = new Square(i);
            squares[i] = square;
        }
    }

    /**
     * method to set the snadders every 5 squares beginning by square at index 3 and ending
     * by square at index boardsize-5
     *
     */

    public void setSnadders() {
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

    /**
     * method to print the state of the game after every move
     * @param currentPlayer Player obj for the player who is actually playing
     * @param rolled int between and including 1 and 6 from the die roll
     */

    public void printState(Player currentPlayer, int rolled){
        StringBuilder line = new StringBuilder(currentPlayer.name + " rolls " + rolled);
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

    /**
     * method to print special states - the initial and the final state
     * @param isInitial boolean True when function should print initial state - False when function should print final state
     */
    public void printInitialAndFinalState(boolean isInitial) {
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

    /**
     * main method to get user input and to create and start a game
     * @param args
     * @throws Exception if name input is empty string or if boardsize is not an int >1
     */
    public static void main(String[] args) throws Exception {
        String name1, name2, name3, name4;

        Scanner name = new Scanner(System.in);
        System.out.print("Please enter the name of player 1: ");
        name1 = name.nextLine();
        // ****
        if (name1.equals("")){
            throw new Exception("Can not create an empty name player");}
        // ****
        System.out.print("Please enter the name of player 2: ");
        name2 = name.nextLine();
        // ****
        if (name2.equals("")){
            throw new Exception("Can not create an empty name player");}
        // ****
        System.out.print("Please enter the name of player 3. If you don't want any more players please type None. ");
        name3 = name.nextLine();
        // ****
        if (name3.equals("")){
            throw new Exception("Can not create an empty name player");}
        // ****
        if (!name3.equals("None")) {
            System.out.print("Please enter the name of player 4. If you don't want any more players please type None. ");
            name4 = name.nextLine();
            // ****
            if (name4.equals("")){
                throw new Exception("Can not create an empty name player");}}
            // ****
        else {name4 = "None";}

        System.out.print("Please enter the board size: ");
        String input = name.nextLine();
        int boardsize1;

        // ****
        try {
            boardsize1 = Integer.parseInt(input);}
        catch(NumberFormatException e) {
            throw new Exception("boardsize has to be an integer"); }

        if (boardsize1 < 2){
            throw new Exception("cannot create a board with size < 2");}
        // ****

        Game game = new Game(boardsize1, name1, name2, name3, name4);
        game.play();
    }

    /**
     * Getter function to get the private list squares containing
     * all the squares on the board
     */
    public Square[] getSquares(){
        Square[] copy = squares;
        return copy; }

    /**
     * Getter function to get the private int boardsize describing
     * the number of squares on the board
     */
    public int getBoardsize(){
        int copy = boardsize;
        return copy;}

    /**
     * Getter function to get the private ArrayBlockingQueue playerQueue containing
     * all the players playing the game
     */
    public ArrayBlockingQueue<Player> getPlayerQueue(){
        ArrayBlockingQueue<Player> copy = playerQueue;
        return copy; }
}

