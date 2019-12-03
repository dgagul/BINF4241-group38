package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class PlayerTest {

    private Game game;
    private int boardsize;
    private Square[] squares;
    private Player player;
    private String player1name = "Player1";
    private String player2name = "Player2";
    private String player3name = "Player3";
    private int pos = 0;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        game = new Game(20,player1name,player2name,player3name,"None"); //Initial State gets printed, due to Game constructor...
        boardsize = game.getBoardsize();
        squares = game.getSquares();
    }

    /**
     * Player constructor test with valid inputs
     */
    @Test
    public void playerConstructor(){
        player = new Player(player1name, pos);
        assertEquals(player1name, player.getName());
        assertEquals(pos, player.getPosition());
    }

    /**
     * Test Player constructor with null as name input
     */
    @Test
    public void createNullPlayer(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create null player");
        Player player = new Player(null, pos);
    }

    // this test failed and therefore had to add if statement in PlayerClass

    /**
     * Test Player constructor with empty string as name
     */
    @Test
    public void createEmptyNamePlayer(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create empty name player");
        Player player = new Player("", pos);
    }

    /**
     * Test Player constructor with player position smaller than
     */
    @Test
    public void createPlayerPositionSmallerThanOne(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create player at negative position");
        Player player = new Player(player1name, -20);
    }

    /**
     * Test if newPosition is right after a move of a player
     */
    @Test
    public void newPositionMove(){
        player = new Player(player1name, pos);
        //move 5 squares
        int delta = 5;
        int newPos = player.getPosition() + delta;
        player.move(delta,squares);
        assertEquals(newPos, player.getPosition());

        //move 2 squares
        delta = 2;
        newPos += delta;
        player.move(delta,squares);
        assertEquals(newPos, player.getPosition());
    }

    /**
     * Test that moves can not go over BoardLength
     */
    @Test
    public void movesOverBoardLength(){
        player = new Player(player1name, pos);
        player.move(21, squares);
        assertTrue(squares[boardsize-1].getIsOccupied());
    }

    /**
     * Test that landing on occupied squares is not possible and therefore the player has to go home
     */
    @Test
    public void landingOnOccupied(){
        //remove player3 from home (start square)
        squares[0].getOccupants().remove(2);

        //move player1 to square #2
        Player player1 = game.getPlayerQueue().poll();
        player1.move(2,squares);
        game.getPlayerQueue().add(player1);

        //move player2 to square #2
        Player player2 = game.getPlayerQueue().poll();
        player2.move(2,squares);
        game.getPlayerQueue().add(player2);
        assertEquals(0, player2.getPosition());
    }

    /**
     * Test that you can land on first Square (start position) even if this
     * square is already occupied
     */
    @Test
    public void landingOnHomeIfOccupied(){
        //move player1 to square #2
        Player player1 = game.getPlayerQueue().poll();
        player1.move(2,squares);
        game.getPlayerQueue().add(player1);

        //move player2 to occupied square -> go to home (start square) that is also occupied
        Player player2 = game.getPlayerQueue().poll();
        player2.move(2,squares);
        game.getPlayerQueue().add(player2);
        assertEquals(0, player2.getPosition());
    }

    /**
     * Test that moves including landing on snadders work
     */
    @Test
    public void movingToSnadder(){
        // at square 3 is a snadder

        //move player1 to square #3
        Player player1 = game.getPlayerQueue().poll();
        player1.move(3,squares);
        game.getPlayerQueue().add(player1);
        assertTrue(player1.getPosition() != 3);
        assertTrue(player1.getPosition() == 1 || player1.getPosition() == 5);
    }

    /**
     *         I DONT KNOW :) todo
     */
    @Test
    public void topOfSnadderIsOccupied(){
        // at square 3 is a snadder

        //move player1 to square #3 -> takes ladder or snake
        Player player1 = game.getPlayerQueue().poll();
        player1.move(3,squares);
        game.getPlayerQueue().add(player1);
        assertTrue(player1.getPosition() != 3);

        //move player2 to square #3 -> takes same ladder or snake, but square is already occupied
        Player player2 = game.getPlayerQueue().poll();
        player2.move(3,squares);
        game.getPlayerQueue().add(player2);
        assertEquals(0, player2.getPosition());
        assertTrue(player1.getPosition() != player2.getPosition());
    }






}
