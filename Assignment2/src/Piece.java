import javafx.util.Pair;

import java.io.*;

abstract class Piece {
    enum Color {
        BLACK,
        WHITE;
    }

    private Color color;
    private boolean isAvailable;
    // Does piece need to know its position? --> not if we pass arguments fromX and fromY in isValid() method

    Piece(boolean available, Color col) {
        // ToDo: Maybe initialize with true from the start?
        isAvailable = available;
        switch (col) {
            case BLACK:
                color = Color.BLACK;
                break;
            case WHITE:
                color = Color.WHITE;
        }
    }

    public Color getColor() {
        return color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String toString(){
        String line = "";
        if (getColor() == Color.WHITE){
            line += "W";
        }
        else if(getColor() == Color.BLACK){
            line += "B";
        }
        return line;
    }

    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        // Piece must stay on the board and Piece can't stay on the same square
        return !(fromX < 0 || toX < 0 || fromY < 0 || toY < 0 || fromX > 7 || toX > 7 || fromY > 7 || toY > 7) && !(toX == fromX && toY == fromY);
    }
}
