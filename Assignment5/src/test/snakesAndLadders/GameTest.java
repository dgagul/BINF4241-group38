package snakesAndLadders;

import main.snakesAndLadders.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GameTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void gameConstructor(){
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

    @Test
    public void gameConstructorNullInput(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("cannot create null player");
        Game game = new Game(0, null, "Player2", "Player3", "Player4");
        Game game2 = new Game(0, "Player1", null, "Player3", "Player4");
        Game game3 = new Game(0, "Player1", "Player2", null, "Player4");
        Game game4 = new Game(0, "Player1", "Player2", "Player3", null);
    }

    @Test
    public void initializePlayerNullInput(){

    }
}
