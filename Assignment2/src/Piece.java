import javafx.util.Pair;
import java.io.*;

abstract class Piece {
    enum Color {WHITE, BLACK};
    enum Name {WT,WN,WB,WQ,WK,WP,BT,BN,BB,BQ,BK,BP}
    private Color aColor;
    private Name aName;
    private boolean isAvailable;
    // Does piece need to know its position? --> not if we pass arguments fromX and fromY in isValid() method
    //private Pair<Integer, Integer> position;

    Piece(Color pColor, Name pName){
        isAvailable = true;
        aColor = pColor;
        aName = pName;
    }

    public boolean isAvailable(){ boolean pisAvailable = isAvailable; return pisAvailable; }

    public Name getaName(){ Name pName = aName; return pName; }

    public Color getaColor(){ Color pColor = aColor; return pColor; }


    // ToDo: write string-to-int converter in Game.java
    // ToDo: check if piece is in the way of path?
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY){
        // Piece can't stay on the same square
        if(toX == fromX && toY == fromY)
            return false;
        // Piece must stay on the board
        return !(fromX<0 || toX<0 || fromY<0 || toY<0 || fromX>7 || toX>7 || fromY>7 || toY>7);
    }
}
