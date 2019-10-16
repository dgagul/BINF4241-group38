import javafx.util.Pair;
import java.io.*;

abstract class Piece {
    // Does a piece need to know its color? --> I don't think so
    private String color;
    private boolean isAvailable;
    // Does piece need to know its position? --> not if we pass arguments fromX and fromY in isValid() method
    private Pair<Integer, Integer> position;

    Piece(boolean available, Pair<Integer,Integer> pos, String col){
        isAvailable = available;
        position = pos;
        color = col;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    // ToDo: write string-to-int converter in Game.java
    // ToDo: check if piece is in the way of path?
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY){
        // Piece can't stay on the same square
        if(toX == fromX || toY == fromY)
            return false;
        // Piece must stay on the board
        return !(fromX<0 || toX<0 || fromY<0 || toY<0 || fromX>7 || toX>7 || fromY>7 || toY>7);
    }
}
