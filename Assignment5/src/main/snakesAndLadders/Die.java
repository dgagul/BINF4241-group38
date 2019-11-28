package main.snakesAndLadders;

import java.util.Random;

public class Die {
    private int min;
    private int max;

    public Die(){
        min = 1;
        max = 6;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }


}