package main.snakesAndLadders;

import java.util.Random;

public class Snadder extends Square {
    int end;

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

}