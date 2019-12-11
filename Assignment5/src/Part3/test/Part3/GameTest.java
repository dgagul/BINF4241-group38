package Part3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /*
    Assert that if there is a player in game.players getNextPlayer() does not return null
     */
    @Test
    public void TestGetNextPlayer(){
        Game game = new Game();
        Player p = new Player();
        game.addPlayer(p);
        Player p2 = game.getNextPlayer();
        Assert.assertNotNull(p2);
    }



}