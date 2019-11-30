package main.snakesAndLadders;

import java.util.Random;

public class Die {
    private int min;
    private int max;

    // creates this getters in order to test the constructor
    public int getMin(){
        return min; }

    public int getMax(){
        return max;
    }
    public Die(){
        min = 1;
        max = 6;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }


}