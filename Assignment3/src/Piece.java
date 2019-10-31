import javafx.util.Pair;

import java.io.*;

abstract class Piece {

    private Color.color color;
    private boolean isAvailable;
    // Does piece need to know its position? --> not if we pass arguments fromX and fromY in isValid() method

    Piece(boolean available, Color.color col) {
        isAvailable = available;
        switch (col) {
            case BLACK:
                color = Color.color.BLACK;
                break;
            case WHITE:
                color = Color.color.WHITE;
        }
    }

    public Color.color getColor() {
        return color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String toString(){
        String line = "";
        if (getColor() == Color.color.WHITE){
            line += "W";
        }
        else if(getColor() == Color.color.BLACK){
            line += "B";
        }
        return line;
    }

    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        // Piece must stay on the board and Piece can't stay on the same square
        return !(fromX < 0 || toX < 0 || fromY < 0 || toY < 0 || fromX > 7 || toX > 7 || fromY > 7 || toY > 7) && !(toX == fromX && toY == fromY);
    }
}