package main.snakesAndLadders;

import java.util.Random;

public class Snadder extends Square {
    int end;

    /**
     * Create a snadder object.
     *
     * @param i the index of the board where the snadder is located
     */
    public Snadder(int i) {
        super(i);
        Random random = new Random();
        boolean isLadder = random.nextBoolean();
        if (isLadder) {
            end = number + 2;
        } else {
            end = number - 2;
        }
    }


    /**
     * Getter function to get a not public attribute for testing
     *
     */
    public int getEnd() {
        int copyEnd = end;
        return copyEnd;
    }

}