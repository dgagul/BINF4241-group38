package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class GameTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test for Game constructor with valid inputs
     */
    @Test
    public void gameConstructor() {
        int boardsize = 20;
        String player1name = "Player1";
        String player2name = "Player2";
        String player3name = "Player3";
        String player4name = "Player4";
        Game game = new Game(20,player1name,player2name,player3name,player4name);
        assertEquals(boardsize, game.getBoardsize());
        assertEquals(player1name, game.getPlayerQueue().poll().getName());
        assertEquals(player2name, game.getPlayerQueue().poll().getName());
        assertEquals(player3name, game.getPlayerQueue().poll().getName());
        assertEquals(player4name, game.getPlayerQueue().poll().getName());
        assertTrue(game.getPlayerQueue().size() == 0);
    }

    /**
     * Test Game constructor with null player name at first position
     */
    @Test
    public void gameConstructorNullPlayerInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with null player");
        Game game = new Game(6, null, "Player2", "Player3", "Player4");
    }

    /**
     * Test Game constructor with null player name at last position
     */
    @Test
    public void gameConstructorNullPlayerInput1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with null player");
        Game game4 = new Game(6, "Player1", "Player2", "Player3", null);
    }


    /**
     * Test Game constructor with empty name at first position
     */
    @Test
    public void gameConstructorEmptyStringInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with no name players");
        Game game = new Game(6, "", "Player2", "Player3", "Player4");
    }

    /**
     * Test Game constructor with empty name at last position
     */
    @Test
    public void gameConstructorEmptyStringInput1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with no name players");
        Game game4 = new Game(6, "Player1", "Player2", "Player3","");
    }

    /**
     * Test Game constructor with invalid boardsize: negative
     */
    @Test
    public void gameConstructorBoardSizeSmallerThan2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with board size < 2");
        Game game = new Game(-1, "Player1", "Player2", "Player3", "Player4");
    }

    /**
     * Test Game constructor with invalid boardsize: smaller than two
     */
    @Test
    public void gameConstructorBoardSizeSmallerThan2_1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create game with board size < 2");
        Game game3 = new Game(1, "Player1", "Player2", "Player3", "Player4");
    }

    /**
     * Test initializeBoard method functionalities: length, instances and numbers
     */
    @Test
    public void gameInitializeBoard() {
        Game testGame = new Game(10, "P1", "P2", "P3", "None");
        testGame.initializeBoard();

        assertEquals(10, testGame.getSquares().length);
        assertTrue(testGame.getSquares()[0] != null);
        assertTrue(testGame.getSquares()[0] instanceof Square);
        assertTrue(testGame.getSquares()[9] instanceof  Square);
        assertEquals(9, testGame.getSquares()[9].getNumber());
        assertEquals(0, testGame.getSquares()[0].getNumber());
    }

    /**
     * Test setSnadders() method: check whether Snadders are set every 5 Squares beginning by 3
     * and ending by boardsize - 5
     */
    @Test
    public void setSnaddersBoardsize19(){
        Game testGame = new Game(19, "P1", "P2", "P3", "None");
        testGame.setSnadders();

        assertTrue(testGame.getSquares()[3] instanceof Snadder);
        assertTrue(testGame.getSquares()[8] instanceof Snadder);
        assertTrue(testGame.getSquares()[13] instanceof Snadder);
        assertFalse(testGame.getSquares()[2] instanceof Snadder);
        assertFalse(testGame.getSquares()[4] instanceof  Snadder);
        assertFalse(testGame.getSquares()[18] instanceof Snadder);
    }

    /**
     *  Tests if the Initial state and the Final state are printed properly
     */
    @Test
    public void printInitialAndFinalState() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Game testGame = new Game(8, "Dario", "Lynn", "Diego", "None");

        // INITIAL STATE
        //snake down
        String msg1 = "Initial state:  	 [1<Dario><Lynn><Diego>] [2] [1<-3] [4] [5] [6] [7] [8]\r\n";
        //ladder up
        String msg2 = "Initial state:  	 [1<Dario><Lynn><Diego>] [2] [3->5] [4] [5] [6] [7] [8]\r\n";
        assertTrue(msg1.equals(outContent.toString()) || msg2.equals(outContent.toString()));


        // FINAL STATE
        testGame.getPlayerQueue().poll().move(8, testGame.getSquares());
        testGame.printInitialAndFinalState(false);

        //snake down
        String msg3 = "Initial state:  	 [1<Dario><Lynn><Diego>] [2] [1<-3] [4] [5] [6] [7] [8]\r\n" + "Final state:  	 [1<Lynn><Diego>] [2] [1<-3] [4] [5] [6] [7] [8<Dario>]\r\n";
        //ladder up
        String msg4 = "Initial state:  	 [1<Dario><Lynn><Diego>] [2] [3->5] [4] [5] [6] [7] [8]\r\n" + "Final state:  	 [1<Lynn><Diego>] [2] [3->5] [4] [5] [6] [7] [8<Dario>]\r\n";
        assertTrue(msg3.equals(outContent.toString()) || msg4.equals(outContent.toString()));
    }

    /**
     *  This test checks if the board is correctly changed and printed after a move has been made
     */
    @Test
    public void printState(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Game testGame = new Game(8, "Dario", "Lynn", "Diego", "None");
        // move currentPlayer 4 squares ahead (to square 5)
        Player currentPlayer = testGame.getPlayerQueue().poll();
        testGame.printState(currentPlayer,4);
        currentPlayer.move(4, testGame.getSquares());
        // move currentPlayer 6 squares ahead (to square 7)
        currentPlayer = testGame.getPlayerQueue().poll();
        testGame.printState(currentPlayer,6);

        //ladder up
        String msg1 = "Initial state:  	 [1<Dario><Lynn><Diego>] [2] [3->5] [4] [5] [6] [7] [8]\r\n" + "Dario rolls 4:	 [1<Dario><Lynn><Diego>] [2] [3->5] [4] [5] [6] [7] [8]\r\n" + "Lynn rolls 6:	 [1<Lynn><Diego>] [2] [3->5] [4] [5<Dario>] [6] [7] [8]\r\n";
        //snake up
        String msg2 = "Initial state:  	 [1<Dario><Lynn><Diego>] [2] [1<-3] [4] [5] [6] [7] [8]\r\n" + "Dario rolls 4:	 [1<Dario><Lynn><Diego>] [2] [1<-3] [4] [5] [6] [7] [8]\r\n" + "Lynn rolls 6:	 [1<Lynn><Diego>] [2] [1<-3] [4] [5<Dario>] [6] [7] [8]\r\n";

        assertTrue(msg1.equals(outContent.toString()) || msg2.equals(outContent.toString()));
    }

    /**
     * This Test checks if the logic of the play() method works - if winner and loosers are set right and
     * if their positions are valid
     */
    @Test
    public void play(){
        Game testGame = new Game(2,"Dario", "Lynn", "None", "None");
        testGame.play();
        assertEquals("Dario",testGame.getWinner().getName());

        Game testGame1 = new Game(20, "Dario", "Lynn", "None", "None");
        testGame1.play();
        assertEquals(19, testGame1.getWinner().getPosition());
        if (testGame1.getWinner().getName() == "Dario"){
            Player looser = testGame1.getPlayerQueue().poll();
            assertTrue(looser.getName() == "Lynn");
            assertTrue(looser.getPosition() < 19); }
        else {
            Player looser2 = testGame1.getPlayerQueue().poll();
            assertTrue(looser2.getName() == "Dario");
            assertTrue(looser2.getPosition() < 19); }
    }
}


