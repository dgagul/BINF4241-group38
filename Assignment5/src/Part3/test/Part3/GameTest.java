package Part3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    /**
     * Assert that validPlayCheck returns true if a move is valid and false otherwise
     * Assert that numberCard() works correctly (by playing valid or non-valid cards)
     */
    @Test
    public void testNumberCard(){
        game.playDeck = new PlayDeck();
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redFive = new Card(Card.Color.RED, Card.Type.NORMAL, 5);
        Card greenTwo = new Card(Card.Color.GREEN, Card.Type.NORMAL, 2);

        game.playDeck.push(yellowFive);
        assertTrue(game.validPlayCheck(redFive));
        assertFalse(game.validPlayCheck(greenTwo));
        game.numberCard(redFive);
        Assert.assertEquals(game.playDeck.pop(), redFive);
        game.numberCard(greenTwo);
    }

    /**
     * Assert that on a wild card where the color yellow was chosen, only a yellow card can be played
     */
    @Test
    public void testNumberCardOnWildCards(){
        game.playDeck = new PlayDeck();
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redFive = new Card(Card.Color.RED, Card.Type.NORMAL, 5);
        Card wild = new Card(Card.Color.BLACK, Card.Type.WILD, 50);
        Card wildFour = new Card(Card.Color.BLACK, Card.Type.WILD_4, 50);

        // Test wild
        game.playDeck.push(wild);
        assertTrue(game.validPlayCheck(yellowFive));
        assertFalse(game.validPlayCheck(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);

        // Test draw 4
        game.playDeck.push(wildFour);
        assertTrue(game.validPlayCheck(yellowFive));
        assertFalse(game.validPlayCheck(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);

    }

    /**
     * Assert that on a yellow plus two card, no other number card than a yellow one can be played
     */
    @Test
    public void testNumberCardOnDraw_2(){
        game.playDeck = new PlayDeck();
        Card yellowPlusTwo = new Card(Card.Color.YELLOW, Card.Type.DRAW_2, 20);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redFive = new Card(Card.Color.RED, Card.Type.NORMAL, 5);

        game.playDeck.push(yellowPlusTwo);
        assertTrue(game.validPlayCheck(yellowFive));
        assertFalse(game.validPlayCheck(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);
    }

    /**
     * Assert that on a yellow skip card, no other number card than a yellow one can be played
     */
    @Test
    public void testNumberCardOnSkip() {
        game.playDeck = new PlayDeck();
        Card yellowSkip = new Card(Card.Color.YELLOW, Card.Type.SKIP, 20);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redFive = new Card(Card.Color.RED, Card.Type.NORMAL, 5);

        game.playDeck.push(yellowSkip);
        assertTrue(game.validPlayCheck(yellowFive));
        assertFalse(game.validPlayCheck(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);
    }

    /**
     * Assert that on a yellow reverse card, no other number card than a yellow one can be played
     */
    @Test
    public void testNumberCardOnReverse(){
        game.playDeck = new PlayDeck();
        Card yellowReverse = new Card(Card.Color.YELLOW, Card.Type.REVERSE, 20);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redFive = new Card(Card.Color.RED, Card.Type.NORMAL, 5);

        game.playDeck.push(yellowReverse);
        assertTrue(game.validPlayCheck(yellowFive));
        assertFalse(game.validPlayCheck(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);
    }












}