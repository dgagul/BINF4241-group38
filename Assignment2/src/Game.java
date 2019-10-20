import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Game{
    private static boolean isFinished = false;
    private static Player playerWhite;
    private static Player playerBlack;
    private static Board board;
    private static Logic logic;

    public Game(){
        playerWhite = new Player(Player.Color.WHITE);
        playerBlack = new Player(Player.Color.BLACK);
        board = new Board();
        logic = new Logic(board);
    }

    public static void play(){
        ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<>(2);
        playerQueue.add(playerWhite);
        playerQueue.add(playerBlack);
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while(!isFinished){
            Player currentPlayer = playerQueue.poll();
            readInput(currentPlayer);
            board.printBoard();
            playerQueue.add(currentPlayer);

        }
    }

    public static void readInput(Player currentPlayer){
        boolean validInput = false;
        boolean validMove = false;
        boolean isMove = false;
        boolean isCapture = false;
        boolean isPromotion = false;
        boolean isCastling = false;
        String piece = "";
        String promoteTo = "";
        int fileFrom = -1;
        int rankFrom = -1;
        int fileTo = -1;
        int rankTo = -1;
        Scanner inputScanner = new Scanner(System.in);
        while(!validInput){
            System.out.printf("%s: Enter your next move: \n", currentPlayer.getName());
            String userInput = inputScanner.nextLine();
            if (userInput.length() == 1){
                System.out.println("Invalid input! Please try again.");
            }
            else if(userInput.length() == 2){
                // Pawn move
                if(userInput.matches("[a-h][1-8]")){
                    isMove = true;
                    piece = "P";
                    fileTo = StrToInt(userInput.substring(0,1));
                    fileFrom = fileTo;
                    rankTo = Integer.parseInt(userInput.substring(1,2));
                    validInput = true;
                }
            }
            else if(userInput.length() == 3){
                if(userInput.matches("^[B|K|N|Q|T][a-h][1-8]$")){
                    isMove = true;
                    piece = userInput.substring(0,1);
                    fileTo = StrToInt(userInput.substring(1,2));
                    rankTo = Integer.parseInt(userInput.substring(2,3));
                    validInput = true;
                }
                else if(userInput.matches("^[a-h][0|8][Q|N|T]$")){
                    validInput = true;
                    isPromotion = true;
                    fileTo = StrToInt(userInput.substring(0,1));
                    fileFrom = fileTo;
                    rankTo = Integer.parseInt(userInput.substring(1,2));
                    promoteTo = userInput.substring(2,3);
                }
                else if(userInput.matches("^0-0$")){
                    // ToDo: Castling method with boolean kingsideCastling (=true)
                    isCastling = true;
                }
            }
            else if(userInput.length()==4){
                if(userInput.matches("^[B|K|N|Q|T][a-h][a-h][1-8]$")){
                    isMove = true;
                    piece = userInput.substring(0,1);
                    fileFrom = StrToInt(userInput.substring(1,2));
                    fileTo = StrToInt(userInput.substring(2,3));
                    rankTo = Integer.parseInt((userInput.substring(3,4)));
                }
                if(userInput.matches("^[B|K|N|Q|T][1-8][a-h][1-8]$")){
                    isMove = true;
                    piece = userInput.substring(0,1);
                    rankFrom = StrToInt(userInput.substring(1,2));
                    fileTo = StrToInt(userInput.substring(2,3));
                    rankTo = Integer.parseInt((userInput.substring(3,4)));
                }
                else if(userInput.contains("x")){
                    isCapture = true;
                    if(userInput.matches("^[B|K|N|Q|T]x[e-h][1-8]$")){
                        validInput = true;
                        piece = userInput.substring(0,1);
                        fileTo = StrToInt(userInput.substring(2,3));
                        rankTo = Integer.parseInt(userInput.substring(3,4));
                    }
                    else if(userInput.matches("^[a-h]x[a-h][1-8]$")){
                        validInput = true;
                        piece = "P";
                        fileTo = StrToInt(userInput.substring(2,3));
                        rankTo = Integer.parseInt(userInput.substring(3,4));
                    }
                }
            }
            if(!validInput){
                System.out.println("Invalid input! Please try again.");
            }
        }
        if (isMove){
            Piece p = StrToPiece(piece, currentPlayer.getColor());
            if(Logic.move(p, fileFrom, rankFrom-1, fileTo, rankTo-1)){
                validMove = true;
            }
        }else if (isPromotion){
            Piece p = StrToPiece("P", currentPlayer.getColor());
            Piece promotePiece = StrToPiece(promoteTo, currentPlayer.getColor());
            if(Logic.promotion(p, fileFrom, fileTo, promotePiece)){
                validMove = true;
            }
        }
        if(!validMove){
            System.out.println("Invalid input! Please try again.");
            readInput(currentPlayer);
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

    public static Piece StrToPiece(String p, Player.Color color){
        Piece.Color color2;
        if(color == Player.Color.BLACK){ color2 = Piece.Color.BLACK;}
        else {color2 = Piece.Color.WHITE;}
        if(p.equals("P")) {return new Pawn(true, color2);}
        else if (p.equals("B")) {return new Bishop(true, color2);}
        else if (p.equals("K")) {return new King(true, color2);}
        else if (p.equals("N")) {return new Knight(true, color2);}
        else if (p.equals("Q")) {return new Queen(true, color2);}
        else return new Tower(true, color2);
    }

    public static void main(String[] args) {
        Game game = new Game();
        play();
        //currentPlayer = player1;
    }

}
