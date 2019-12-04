package main.snakesAndLadders;

import java.util.Random;

public class Die {
    private int min;
    private int max;

    /**
     * Getter method to get the private in min which describes
     * the minimum of the int that the die can show
     * @return an int describing the minimum eyes showing up on this die
     */
    public int getMin(){
        return min; }

    /**
     * Getter method to get the private int max which describes
     * the maximum of the int that the die can show
     * @return an int describing the maximum eyes showing up on this die
     */
    public int getMax(){
        return max;
    }

    /**
     * Die constructor to create Die obj.
     */
    public Die(){
        min = 1;
        max = 6;
    }

    /**
     * method to perform a Die roll
     * @return a random generated int between and including min and max
     */
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }
}