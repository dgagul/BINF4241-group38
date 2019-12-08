package main.snakesAndLadders;

import java.util.ArrayList;

public class Square {
    boolean isOccupied;
    int number;
    ArrayList<String >occupants;

    /**
     * Square constructor to create Square obj
     *
     * @param i the index of the board where the square is located
     */
    public Square(int i) {
        isOccupied = false;
        number = i;
        occupants = new ArrayList<>();}

    /**
     * Getter function to get a the private boolean isOccupied which describes
     * if this specific square is occupied, means if there are other players on it
     */
    public boolean getIsOccupied() {
        boolean copy = isOccupied;
        return copy; }

    /**
     * Getter function to get the private in number which describes
     * the number of the square, this is the position of the square in the board
     */
    public int getNumber() {
        int copy = number;
        return copy; }

    /**
     * Getter function to get the private ArrayList occupants
     * which describes which players are on this specific square on the board
     */
    public ArrayList<String> getOccupants() {
        ArrayList<String> copy = occupants;
        return copy; }

}