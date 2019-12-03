package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class GameTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test for Game constructor with valid inputs
     *@throws Exception if input is not valid: if player is null oder playername is empty or boardsize is not an int >1.
     */
    @Test
    public void gameConstructor() throws Exception {
        int boardsize = 20;
        String player1name = "Player1";
        String player2name = "Player2";
        String player3name = "Player3";
        String player4name = "None";
        Game game = new Game(20,player1name,player2name,player3name,player4name);
        assertEquals(boardsize, game.getBoardsize());
        assertEquals(player1name, game.getPlayerQueue().poll().getName());
        assertEquals(player2name, game.getPlayerQueue().poll().getName());
        assertEquals(player3name, game.getPlayerQueue().poll().getName());
        assertTrue(game.getPlayerQueue().size() == 0);
    }

    /**
     * Test Game constructor with null players
     * @throws Exception if input is not valid: if player is null oder playername is empty or boardsize is not an int >1.
     */
    @Test
    public void gameConstructorNullPlayerInput() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with null player");
        Game game = new Game(6, null, "Player2", "Player3", "Player4");
        Game game2 = new Game(6, "Player1", null, "Player3", "Player4");
        Game game3 = new Game(6, "Player1", "Player2", null, "Player4");
        Game game4 = new Game(6, "Player1", "Player2", "Player3", null);
    }

    /**
     * Test Game constructor with empty names
     * @throws Exception if input is not valid: if player is null oder playername is empty or boardsize is not an int >1.
     */
    @Test
    public void gameConstructorEmptyStringInput() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create players with no name");
        Game game = new Game(6, "", "Player2", "Player3", "Player4");
        Game game2 = new Game(6, "Player1", "", "Player3", "Player4");
        Game game3 = new Game(6, "Player1", "Player2", "", "Player4");
        Game game4 = new Game(6, "Player1", "Player2", "Player3","");
    }

    /**
     * Test Game constructor with invalid boardsizes: smaller than two
     * @throws Exception if input is not valid: if player is null oder playername is empty or boardsize is not an int >1.
     */
    @Test
    public void gameConstructorBoardSizeSmallerThan2() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with boardsize < 2");
        Game game = new Game(-1, "Player1", "Player2", "Player3", "Player4");
        Game game1 = new Game(-10, "Player1", "Player2", "Player3", "Player4");
        Game game2 = new Game(0, "Player1", "Player2", "Player3", "Player4");
        Game game3 = new Game(1, "Player1", "Player2", "Player3", "Player4");
    }

    /**
     * Test initializeBoard method functionalities: length, instances and numbers
     * @throws Exception if input is not valid: if player is null oder playername is empty or boardsize is not an int >1.
     */
    @Test
    public void gameInitializeBoard() throws Exception {
        Game testGame = new Game(10, "P1", "P2", "P3", "None");
        testGame.initializeBoard();

        assertEquals(10, testGame.getSquares().length);
        assertTrue(testGame.getSquares()[0] != null);
        assertTrue(testGame.getSquares()[0] instanceof Square);
        assertTrue(testGame.getSquares()[9] instanceof  Square);
        assertEquals(10, testGame.getSquares()[9].getNumber());
        assertEquals(1, testGame.getSquares()[0].getNumber());
    }

    /**
     * Test setSnadders() method: check whether Snadders are set every 5 Squares beginning by 3
     * and ending by boardsize - 5
     * @throws Exception if input is invalid in Game constructor
     */
    @Test
    public void setSnaddersBoardsize15() throws Exception {
        Game testGame = new Game(19, "P1", "P2", "P3", "None");
        testGame.setSnadders();

        assertTrue(testGame.getSquares()[3] instanceof Snadder);
        assertTrue(testGame.getSquares()[8] instanceof Snadder);
        assertTrue(testGame.getSquares()[13] instanceof Snadder);
        assertFalse(testGame.getSquares()[2] instanceof Snadder);
        assertFalse(testGame.getSquares()[4] instanceof  Snadder);
        assertFalse(testGame.getSquares()[18] instanceof Snadder);
    }

    //TODO: write tests for printState, printInitialAndFinalState and play (all in Game.java)
    @Test
    public void printState() throws Exception {
        Game testGame = new Game(15, "Dario", "Lynn", "Diego", "None");



    }




}
