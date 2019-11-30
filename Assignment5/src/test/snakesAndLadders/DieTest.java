package snakesAndLadders;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.snakesAndLadders.*;



public class DieTest {

    /**
     * Test Die constructor
     *
     */
    @Test
    public void testDieConstructor(){
        Die testDie = new Die();
        assertEquals(1, testDie.getMin());
        assertEquals(6, testDie.getMax());
    }


    /**
     * Perform a valid die roll
     */
    @Test
    public void testDieRange(){
        Die die = new Die();
        int result = die.roll();
        assertTrue(1 <= result && result <= 6);
    }


}
