package main.snakesAndLadders;

import java.util.ArrayList;

public class Square {
    boolean isOccupied;
    int number;
    ArrayList<String >occupants;

    public Square(int i)
    {
        isOccupied = false;
        number = i;
        occupants = new ArrayList<>();
    }

}