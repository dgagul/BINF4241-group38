import java.util.Scanner;

public class Game{
    private static boolean isFinished = false;
    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    public Game(){
        playerWhite = new Player(Player.Color.WHITE);
        playerBlack = new Player(Player.Color.BLACK);
        board = new Board();
    }

    public static void main(String[] args) {
        Game game = new Game();
        //currentPlayer = player1;
    }

    public static void readInput(){
        boolean validInput = false;
        Scanner inputScanner = new Scanner(System.in);
        while(!validInput){
            System.out.println("Enter your next move: ");
            String userInput = inputScanner.nextLine();
            if (userInput.length() == 1){
                System.out.println("Invalid input! Please try again.");
            }
            else if (userInput.length() == 2){
                if(!userInput.matches("[a-h][1-8]")){
                    System.out.println("Invalid input! Please try again.");
                }
                int file = StrToInt(userInput.substring(0,1));
                int rank = Integer.parseInt(userInput.substring(1,1));
            }
        }
    }

    public static int StrToInt(String s) {
        // ToDo: move to Game.java
        if (s.equals("a")) {return 0;}
        else if (s.equals("b")) {return 1;}
        else if (s.equals("c")) {return 2;}
        else if (s.equals("d")) {return 3;}
        else if (s.equals("e")) {return 4;}
        else if (s.equals("f")) {return 5;}
        else if (s.equals("g")) {return 6;}
        else if (s.equals("h")) {return 7;}
        // wrong letter coordinate
        return -1;
    }

}
