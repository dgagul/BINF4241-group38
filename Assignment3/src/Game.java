import javafx.util.Pair;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Game {
    private static boolean isFinished = false;
    private static Player playerWhite;
    private static Player playerBlack;
    private static Board board;
    private static Logic logic;
    private static Color.color black = Color.color.BLACK;
    private static Color.color white = Color.color.WHITE;
    private Scoreboard scoreboard;
    private static ArrayList<Observer> observerCollection;

    private static Game firstInstance = null;

    private Game() {
        playerWhite = new Player(white);
        playerBlack = new Player(black);
        board = new Board();
        logic = new Logic(board, playerWhite, playerBlack);
        observerCollection = new ArrayList<>();
    }

    public static void registerObserver(Observer observer){
        observerCollection.add(observer);
    }

    public static void unregisterObserver(Observer observer){
        observerCollection.remove(observer);
    }

    public static void notifyObserver(){
        for (Observer observer : observerCollection){
            observer.update();
        }
    }

    public Board getBoard(){
        Board aBoard = board;
        return aBoard;
    }

    public static Game getInstance(){
        if(firstInstance == null) {
            synchronized (Game.class) {
                if (firstInstance == null) {
                    firstInstance = new Game();
                }
            }
        }
        return firstInstance; }

    public static void play() {
        ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<>(2);
        playerQueue.add(playerWhite);
        playerQueue.add(playerBlack);
        notifyObserver();
        while (!isFinished) {
            Player currentPlayer = playerQueue.poll();
            readInput(currentPlayer);
            notifyObserver();
            Color.color otherPlayersColor;
            assert currentPlayer != null;
            if (currentPlayer.getColor() == Color.color.WHITE) {
                otherPlayersColor = Color.color.BLACK;
            } else {
                otherPlayersColor = Color.color.WHITE;
            }

            if (Logic.checkForCheck(otherPlayersColor)) {
                System.out.println("Check!");
                if (Logic.checkForCheckmate(otherPlayersColor)) {
                    isFinished = true;
                    System.out.printf("Checkmate! %s wins!\n", currentPlayer.getName());
                }
            }
            playerQueue.add(currentPlayer);
        }
    }

    private static void readInput(Player currentPlayer) {
        boolean validInput = false;
        boolean validMove = false;
        boolean isMove = false;
        boolean isCapture = false;
        boolean isPromotion = false;
        boolean isCastling = false;
        boolean isKingside = false;
        String piece = "";
        String promoteTo = "";
        int fileFrom = -1;
        int rankFrom = -1;
        int fileTo = -1;
        int rankTo = -1;
        Scanner inputScanner = new Scanner(System.in);
        while (!validInput) {
            System.out.printf("%s: Enter your next move: \n", currentPlayer.getName());
            String userInput = inputScanner.nextLine();
            if (userInput.length() == 1) {
                System.out.println("Invalid input! Please try again.");
            } else if (userInput.length() == 2) {
                // Pawn move
                if (userInput.matches("[a-h][1-8]")) {
                    isMove = true;
                    piece = "P";
                    fileTo = StrToInt(userInput.substring(0, 1));
                    fileFrom = fileTo;
                    rankTo = Integer.parseInt(userInput.substring(1, 2));
                    validInput = true;
                }
            } else if (userInput.length() == 3) {
                if (userInput.matches("^[B|K|N|Q|T][a-h][1-8]$")) {
                    isMove = true;
                    piece = userInput.substring(0, 1);
                    fileTo = StrToInt(userInput.substring(1, 2));
                    rankTo = Integer.parseInt(userInput.substring(2, 3));
                    validInput = true;
                } else if (userInput.matches("^[a-h][0|8][Q|N|T]$")) {
                    validInput = true;
                    isPromotion = true;
                    fileTo = StrToInt(userInput.substring(0, 1));
                    fileFrom = fileTo;
                    rankTo = Integer.parseInt(userInput.substring(1, 2));
                    promoteTo = userInput.substring(2, 3);
                } else if (userInput.matches("^0-0$")) {
                    validInput = true;
                    isCastling = true;
                    isKingside = true;
                }
            } else if (userInput.length() == 4) {
                if (userInput.matches("^[B|K|N|Q|T][a-h][a-h][1-8]$")) {
                    isMove = true;
                    piece = userInput.substring(0, 1);
                    fileFrom = StrToInt(userInput.substring(1, 2));
                    fileTo = StrToInt(userInput.substring(2, 3));
                    rankTo = Integer.parseInt((userInput.substring(3, 4)));
                }
                if (userInput.matches("^[B|K|N|Q|T][1-8][a-h][1-8]$")) {
                    isMove = true;
                    piece = userInput.substring(0, 1);
                    rankFrom = StrToInt(userInput.substring(1, 2));
                    fileTo = StrToInt(userInput.substring(2, 3));
                    rankTo = Integer.parseInt((userInput.substring(3, 4)));
                } else if (userInput.contains("x")) {
                    isCapture = true;
                    if (userInput.matches("^[B|K|N|Q|T]x[a-h][1-8]$")) {
                        validInput = true;
                        piece = userInput.substring(0, 1);
                        fileTo = StrToInt(userInput.substring(2, 3));
                        rankTo = Integer.parseInt(userInput.substring(3, 4));
                    } else if (userInput.matches("^[a-h]x[a-h][1-8]$")) {
                        validInput = true;
                        piece = "P";
                        fileFrom = StrToInt(userInput.substring(0, 1));
                        fileTo = StrToInt(userInput.substring(2, 3));
                        rankTo = Integer.parseInt(userInput.substring(3, 4));
                    }
                }
            } else if (userInput.length() == 5) {
                if (userInput.matches("^0-0-0$")) {
                    validInput = true;
                    isCastling = true;
                    isKingside = false;
                }
                else if(userInput.matches("^[Q][a-h][1-8][a-h][1-8]$")) {
                    validInput = true;
                    isMove = true;
                    validInput = true;
                    piece = userInput.substring(0, 1);
                    fileFrom = StrToInt(userInput.substring(1, 2));
                    rankFrom = Integer.parseInt(userInput.substring(2, 3));
                    fileTo = StrToInt(userInput.substring(3, 4));
                    rankTo = Integer.parseInt(userInput.substring(4, 5));
                }
                else if(userInput.contains("x")) {
                    isCapture = true;
                    if (userInput.matches("^[B|K|N|Q|T][a-h]x[a-h][1-8]$")) {
                        validInput = true;
                        piece = userInput.substring(0, 1);
                        fileFrom = StrToInt(userInput.substring(1, 2));
                        fileTo = StrToInt(userInput.substring(3, 4));
                        rankTo = Integer.parseInt(userInput.substring(4, 5));
                    }
                    else if (userInput.matches("^[B|N|K|Q|T][1-8]x[a-h][1-8]$")) {
                        validInput = true;
                        piece = userInput.substring(0, 1);
                        rankFrom = StrToInt(userInput.substring(1, 2));
                        fileTo = StrToInt(userInput.substring(3, 4));
                        rankTo = Integer.parseInt(userInput.substring(4, 5));
                    }
                }
            }
            else if(userInput.length() == 6 && userInput.contains("x")) {
                isCapture = true;
                if (userInput.matches("^[Q][a-h][1-8]x[a-h][1-8]$")) {
                    validInput = true;
                    piece = userInput.substring(0, 1);
                    fileFrom = StrToInt(userInput.substring(1, 2));
                    rankFrom = Integer.parseInt(userInput.substring(2, 3));
                    fileTo = StrToInt(userInput.substring(4, 5));
                    rankTo = Integer.parseInt(userInput.substring(5, 6));
                }
            }
            if (!validInput) {
                System.out.println("Invalid input! Please try again.");
            }
        }
        if (isMove) {
            Piece p = StrToPiece(piece, currentPlayer.getColor());
            if (Logic.move(p, fileFrom, rankFrom - 1, fileTo, rankTo - 1)) {
                validMove = true;
            }
        } else if (isCapture) {
            Piece p = StrToPiece(piece, currentPlayer.getColor());
            if (Logic.capture(p, fileFrom, rankFrom - 1, fileTo, rankTo - 1))
                validMove = true;
        } else if (isPromotion) {
            Piece p = StrToPiece("P", currentPlayer.getColor());
            Piece promotePiece = StrToPiece(promoteTo, currentPlayer.getColor());
            if (Logic.promotion(p, fileFrom, fileTo, promotePiece))
                validMove = true;
        } else if (isCastling) {
            if (Logic.castling(isKingside, currentPlayer.getColor()))
                validMove = true;
        }
        if (!validMove) {
            System.out.println("Invalid input! Please try again.");
            readInput(currentPlayer);
        }
    }

    private static int StrToInt(String s) {
        // ToDo: move to Game.java
        if (s.equals("a")) {
            return 0;
        } else if (s.equals("b")) {
            return 1;
        } else if (s.equals("c")) {
            return 2;
        } else if (s.equals("d")) {
            return 3;
        } else if (s.equals("e")) {
            return 4;
        } else if (s.equals("f")) {
            return 5;
        } else if (s.equals("g")) {
            return 6;
        } else if (s.equals("h")) {
            return 7;
        }
        // wrong letter coordinate
        return -1;
    }

    private static Piece StrToPiece(String p, Color.color color) {
        if (p.equals("P")) {
            return new Pawn(true, color);
        } else if (p.equals("B")) {
            return new Bishop(true, color);
        } else if (p.equals("K")) {
            return new King(true, color);
        } else if (p.equals("N")) {
            return new Knight(true, color);
        } else if (p.equals("Q")) {
            return new Queen(true, color);
        } else return new Tower(true, color);
    }

    public static Player getPlayerWhite(){
        return playerWhite;
    }
    public static Player getPlayerBlack(){
        return playerBlack;
    }
}