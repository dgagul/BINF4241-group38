package Part3;

import org.junit.Assert;
import org.junit.Test;

class GameTest {
    Game game = new Game();

    /**
     * Assert that getNextPlayer() returns the next Player in the players-list
     */
    @Test
    public void getNextPlayer(){
        Player p = new Player();
        Player r = new Player();
        game.addPlayer(p);
        game.addPlayer(r);
        Player next = game.getNextPlayer();
        Assert.assertEquals(next,r);
    }

    @Test
    public void numberCard(){
        PlayDeck playDeck = new PlayDeck();
        Card blueFive = new Card(Card.Color.BLUE, Card.Type.NORMAL, 5);
        Card redFive = new Card(Card.Color.RED, Card.Type.NORMAL, 5);
        Card greenTwo = new Card(Card.Color.GREEN, Card.Type.NORMAL, 2);
        Card yellowTwo = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 2);

        playDeck.cards.push(blueFive);
        // ToDO: finish
    }



}