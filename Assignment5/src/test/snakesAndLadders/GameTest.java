package test.snakesAndLadders;

import org.junit.Test;

import main.snakesAndLadders.*;

import static org.junit.Assert.*;

public class GameTest {


    /**
     * Test Die constructor
     *
     */
    @Test
    public void testGameConstructor(){
        Game testgame = new Game(7,"Diego", "Alena", "Emanuel", "Rachel");
        assertEquals(7, testgame.getBoardsize());
        assertNotNull(testgame.getPlayerQueue().poll());

    }
}
