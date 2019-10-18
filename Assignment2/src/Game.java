import java.util.List;
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
        boolean isCapture = false;
        boolean isPromotion = false;
        boolean isCastling = false;
        Scanner inputScanner = new Scanner(System.in);
        while(!validInput){
            System.out.println("Enter your next move: ");
            String userInput = inputScanner.nextLine();
            if (userInput.length() == 1){
                System.out.println("Invalid input! Please try again.");
            }
            else if(userInput.length() == 2){
                // Pawn move
                if(userInput.matches("[a-h][1-8]")){
                    String piece = "P";
                    int fileTo = StrToInt(userInput.substring(0,1));
                    int rankTo = Integer.parseInt(userInput.substring(1,1));
                    validInput = true;
                }
            }
            else if(userInput.length() == 3){
                if(userInput.matches("^[B|K|N|Q|T][a-h][1-8]$")){
                    String piece = userInput.substring(0,0);
                    int fileTo = StrToInt(userInput.substring(1,1));
                    int rankTo = Integer.parseInt(userInput.substring(2,2));
                    validInput = true;
                }
                else if(userInput.matches("^[a-h]8[Q|N|T]$")){
                    validInput = true;
                    isPromotion = true;
                    int fileTo = StrToInt(userInput.substring(0,0));
                    int rankTo = Integer.parseInt(userInput.substring(1,1));
                    String promoteTo = userInput.substring(2,2);
                }
                else if(userInput.matches("^0-0$")){
                    // ToDo: Castling method with boolean kingsideCastling (=true)
                    isCastling = true;
                }
            }
            else if(userInput.length()==4){
                if(userInput.matches("^[B|K|N|Q|T][a-h][a-h][1-8]$")){
                    String piece = userInput.substring(0,0);
                    int fileFrom = StrToInt(userInput.substring(1,1));
                    int fileTo = StrToInt(userInput.substring(2,2));
                    int rankTo = Integer.parseInt((userInput.substring(3,3)));
                }
                else if(userInput.contains("x")){
                    isCapture = true;
                    if(userInput.matches("^[B|K|N|Q|T]x[e-h][1-8]$")){
                        validInput = true;
                        String piece = userInput.substring(0,0);
                        int fileTo = StrToInt(userInput.substring(2,2));
                        int rankTo = Integer.parseInt(userInput.substring(3,3));
                    }
                    else if(userInput.matches("^[a-h]x[a-h][1-8]$")){
                        validInput = true;
                        String piece = "P";
                        int fileTo = StrToInt(userInput.substring(2,2));
                        int rankTo = Integer.parseInt(userInput.substring(3,3));
                    }
                }
            }
            if(!validInput){
                System.out.println("Invalid input! Please try again.");
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
