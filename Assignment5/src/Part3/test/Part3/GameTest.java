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
        assertTrue(game.checkValidMove(redFive));
        assertFalse(game.checkValidMove(greenTwo));
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
        assertTrue(game.checkValidMove(yellowFive));
        assertFalse(game.checkValidMove(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);

        // Test draw 4
        game.playDeck.push(wildFour);
        assertTrue(game.checkValidMove(yellowFive));
        assertFalse(game.checkValidMove(redFive));
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
        assertTrue(game.checkValidMove(yellowFive));
        assertFalse(game.checkValidMove(redFive));
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
        assertTrue(game.checkValidMove(yellowFive));
        assertFalse(game.checkValidMove(redFive));
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
        assertTrue(game.checkValidMove(yellowFive));
        assertFalse(game.checkValidMove(redFive));
        game.numberCard(yellowFive);
        assertEquals(game.playDeck.pop(), yellowFive);
    }

    /**
     * Assert that the wild card can be played after every card except for draw or wild draw
     */
    @Test
    public void testWild(){
        game.playDeck = new PlayDeck();
        Card wild = new Card(Card.Color.BLACK, Card.Type.WILD, 50);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card blueReverse = new Card(Card.Color.BLUE, Card.Type.REVERSE, 20);
        Card greenSkip = new Card(Card.Color.GREEN, Card.Type.SKIP, 20);
        Card wildDraw = new Card(Card.Color.BLACK, Card.Type.WILD_4, 50);
        Card redDrawTwo = new Card(Card.Color.RED, Card.Type.DRAW_2, 20);

        game.playDeck.push(yellowFive);
        assertTrue(game.checkValidMove(wild));
        game.wild(wild, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wild);

        game.playDeck.push(blueReverse);
        assertTrue(game.checkValidMove(wild));
        game.wild(wild, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wild);

        game.playDeck.push(greenSkip);
        assertTrue(game.checkValidMove(wild));
        game.wild(wild, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wild);

        // wild can not be played after a wild draw 4 or draw 2
        game.playDeck.push(wildDraw);
        assertFalse(game.checkValidMove(wild));

        game.playDeck.push(redDrawTwo);
        assertFalse(game.checkValidMove(wild));
    }

    /**
     * Assert that a wild draw four card can be played on any other card
     */
    @Test
    public void testWildDrawFour(){
        game.playDeck = new PlayDeck();
        Card wild = new Card(Card.Color.BLACK, Card.Type.WILD, 50);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card blueReverse = new Card(Card.Color.BLUE, Card.Type.REVERSE, 20);
        Card greenSkip = new Card(Card.Color.GREEN, Card.Type.SKIP, 20);
        Card wildDraw = new Card(Card.Color.BLACK, Card.Type.WILD_4, 50);
        Card redDrawTwo = new Card(Card.Color.RED, Card.Type.DRAW_2, 20);

        game.playDeck.push(wild);
        assertTrue(game.checkValidMove(wildDraw));
        game.wildDrawFour(wildDraw, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wildDraw);

        game.playDeck.push(yellowFive);
        assertTrue(game.checkValidMove(wildDraw));
        game.wildDrawFour(wildDraw, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wildDraw);

        game.playDeck.push(blueReverse);
        assertTrue(game.checkValidMove(wildDraw));
        game.wildDrawFour(wildDraw, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wildDraw);

        game.playDeck.push(greenSkip);
        assertTrue(game.checkValidMove(wildDraw));
        game.wildDrawFour(wildDraw, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wildDraw);

        game.playDeck.push(wildDraw);
        assertTrue(game.checkValidMove(wildDraw));
        game.wildDrawFour(wildDraw, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wildDraw);

        game.playDeck.push(redDrawTwo);
        assertTrue(game.checkValidMove(wildDraw));
        game.wildDrawFour(wildDraw, Card.Color.YELLOW);
        assertEquals(game.playDeck.pop(), wildDraw);
    }

    /**
     * Assert that a draw two card can only be played on a card of the same color or on another draw two card
     */
    @Test
    public void testDrawTwo(){
        game.playDeck = new PlayDeck();
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redNine = new Card(Card.Color.RED, Card.Type.NORMAL, 9);
        Card blueDrawTo = new Card(Card.Color.BLUE, Card.Type.DRAW_2, 20);
        Card redDrawTwo = new Card(Card.Color.RED, Card.Type.DRAW_2, 20);

        game.playDeck.push(yellowFive);
        assertFalse(game.checkValidMove(redDrawTwo));
        game.playDeck.push(redNine);
        game.drawTo(redDrawTwo);
        assertEquals(redDrawTwo, game.playDeck.pop());

        assertTrue(game.checkValidMove(blueDrawTo));
        assertEquals(blueDrawTo, game.playDeck.pop());
    }

    /**
     * Assert that a Skip card can only be played on a card of the same color, but not a draw two card
     */
    @Test
    public void testSkip(){
        game.playDeck = new PlayDeck();
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card redNine = new Card(Card.Color.RED, Card.Type.NORMAL, 9);
        Card blueReverse = new Card(Card.Color.BLUE, Card.Type.REVERSE, 20);
        Card redReverse = new Card(Card.Color.RED, Card.Type.REVERSE, 20);
        Card redDrawTwo = new Card(Card.Color.RED, Card.Type.DRAW_2, 20);

        game.playDeck.push(yellowFive);
        assertFalse(game.checkValidMove(redReverse));
        game.playDeck.push(redNine);
        assertTrue(game.checkValidMove(redReverse));
        game.reverse(redReverse);
        assertEquals(redReverse, game.playDeck.pop());
        assertFalse(game.checkValidMove(blueReverse));

        game.playDeck.push(redDrawTwo);
        assertFalse(game.checkValidMove(redReverse));
    }

    /**
     * Check that after a reverse card, the direction of the game actually changes
     */
    @Test
    public void testReverse(){
        game.direction = true;
        game.playDeck = new PlayDeck();
        Card yellowReverse = new Card(Card.Color.YELLOW, Card.Type.REVERSE, 20);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);

        game.playDeck.push(yellowFive);
        assertTrue(game.checkValidMove(yellowReverse));
        game.reverse(yellowReverse);
        assertEquals(yellowReverse, game.playDeck.pop());
        assertFalse(game.direction);
        assertTrue(game.checkValidMove(yellowReverse));
        assertTrue(game.direction);

    }
}