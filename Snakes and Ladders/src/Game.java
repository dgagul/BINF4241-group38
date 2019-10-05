import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;


// Initialize Game, keep track of game status and player queue
public class Game {
    String winner;
    boolean isfinished;
    int boardsize;
    ArrayBlockingQueue<String> playerqueue = new ArrayBlockingQueue<String>(4);



    Game(int boardsize, String name1, String name2, String name3, String name4) {
        // set isfinished to false and winner to null
        isfinished = false;
        winner = null;
        this.boardsize = boardsize;

        //initialize Players called player1,player2,player3,player4
        // and playerqueue
        // and sets position of all players to 1
        // Player class needs to have attrubtes: name and position
        if (!name1.equals("None")){
            playerqueue.add(name1);
            Player player1 = new Player();
            player1.name = name1;
            player1.position = 1;}

        if (!name2.equals("None")){
            playerqueue.add(name2);
            Player player2 = new Player();
            player2.name = name2;
            player2.position = 1;

        if (name3.equals("None")){
            playerqueue.add(name3);
            Player player3 = new Player();
            player3.name = name3;
            player3.position = 1;}

        if (!name4.equals("None")){
            playerqueue.add(name4);
            Player player4 = new Player();
            player4.name = name2;
            player4.position = 1;}

            // Initializes Squares
            // sets isoccupied of firstsquare to true
            // sets isstart of firstsquare to true
            // sets isend of lastsquare to true
            // this means that the constructor of the Square class has to set all
            // attributes to false initially

        for (int i = 1; i<= boardsize; i++) {
            Square square = new Squares();
            square.number = i;
            if (i == 1) {
                square.isoccupied = true;
                square.isstart = true;
            }

            if (i == boardsize) {
                square.isend = true; }
            }

            // Set random Snadders (random if its a ladder or a snadder)
            // all 5 Squares starting by  4and ending by -4
            // Snadder class needs to have an attribute start and end
            // Snadder.start is declared in this construcotr
            // .end needs to be calculated in Snadder class
            // when it is a ladder make square.number + 2
            // when it is a snake make square.number - 2
        for (int j=4; j < boardsize -4; j+= 5){
            Snadder snadder = new Snadder();
            snadder.start = j;
            Random random = new Random();
            ladderorsnadder = random.nextBoolean();
            snadder.isladder = ladderorsnadder;
            snadder.issnake = !ladderorsnadder;}

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

    }


}