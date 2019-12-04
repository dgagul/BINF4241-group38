package main.snakesAndLadders;

import java.util.Random;

public class Snadder extends Square {
    int end;

    /**
     * Snadder constructor to create snadder obj.
     *
     * @param i the index of the board where the snadder is located
     */
    public Snadder(int i) {
        super(i);
        Random random = new Random();
        boolean isLadder = random.nextBoolean();
        if (isLadder) { end = number + 2;}
        else { end = number - 2; } }

    /**
     * Getter function to get the private int end which describes
     * if this specific square is an endSquare - this means it's the goal square
     */
    public int getEnd() {
        int copyEnd = end;
        return copyEnd;}
}