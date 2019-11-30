package main.snakesAndLadders;

import java.util.ArrayList;

public class Square {
    boolean isOccupied;
    int number;
    ArrayList<String >occupants;


    /**
     * Create a square object.
     *
     * @param i the index of the board where the square is located
     */
    public Square(int i)
    {
        isOccupied = false;
        number = i;
        occupants = new ArrayList<>();
    }


    /**
     * Getter function to get a not public attribute for testing
     *
     */
    public boolean getIsOccupied() {
        boolean copyIsOccupied = isOccupied;
        return copyIsOccupied;
    }
    /**
     * Getter function to get a not public attribute for testing
     *
     */
    public int getNumber() {
        int copyNumber = number;
        return copyNumber;
    }

}