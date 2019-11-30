package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp(){
        game = new Game(20,player1name,player2name,player3name,"None"); //Initial State gets printed, due to Game constructor...
        boardsize = game.getBoardsize();
        squares = game.getSquares();
    }

    @Test
    public void playerConstructor(){
        player = new Player(player1name, pos);
        assertEquals(player1name, player.getName());
        assertEquals(pos, player.getPosition());
    }

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

    @Test
    public void movesOverBoardLength(){
        player = new Player(player1name, pos);
        player.move(21, squares);
        assertTrue(squares[boardsize-1].getIsOccupied());
    }

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
