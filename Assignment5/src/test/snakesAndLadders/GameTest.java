package test.snakesAndLadders;

import org.junit.Before;
import org.junit.Test;

import main.snakesAndLadders.*;

import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.*;

public class GameTest {
    private Game testGame;
    private Player winner;
    private int boardsize;
    private Square[] squares;
    private ArrayBlockingQueue<Player> playerQueue = new ArrayBlockingQueue<>(4);

    @Before
    public void setUp(){
        Game testGame = new Game(7,"Diego", "Alena", "Emanuel", "Rachel");
        playerQueue = testGame.getPlayerQueue();
    }

    /**
     * Test Die constructor
     *
     */
    @Test
    public void testGameConstructor(){
        assertEquals(7, testGame.getBoardsize());
        assertNotNull(testGame.getPlayerQueue().poll());
    }

    @Test
    public void testInitializePlayers() {
        Player testplayer = testGame.getPlayerQueue().poll();
        //assert testplayer != null;
        assertEquals("Diego" ,testplayer.getName());


    }
}
