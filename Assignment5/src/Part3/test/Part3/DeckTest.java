package Part3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Game game = new Game();

    /**
     * Assert that isEmpty only returns true if the deck is empty
     */
    @Test
    public void testIsEmpty(){
        Card yellowNine = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 9);
        game.playDeck.push(yellowNine);
        assertFalse(game.playDeck.isEmpty());
        game.playDeck.pop();
        assertTrue(game.playDeck.isEmpty());
    }

    /**
     * Assert that draw() returns the card on top of the deck
     */
    @Test
    public void testDraw(){
        Card yellowNine = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 9);
        Card greenNine = new Card(Card.Color.GREEN, Card.Type.NORMAL, 9);
        game.drawDeck.push(greenNine);
        game.drawDeck.push(yellowNine);
        Card c = game.drawDeck.draw();
        assertNotEquals(c, greenNine);
        assertEquals(c, yellowNine);
    }

    /**
     * Assert that isLastCard returns true only if there is one card left on the stack
     */
    @Test
    public void testIsLastCard(){
        Card yellowNine = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 9);
        Card greenNine = new Card(Card.Color.GREEN, Card.Type.NORMAL, 9);
        game.drawDeck.push(greenNine);
        game.drawDeck.push(yellowNine);
        assertFalse(game.drawDeck.isLastCard());
        game.drawDeck.pop();
        assertTrue(game.drawDeck.isLastCard());
    }

    /**
     * Assert that after calling removeAll on the playDeck, the playDeck is empty afterwards
     */
    @Test
    public void testRemoveAll(){
        Card yellowNine = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 9);
        Card greenNine = new Card(Card.Color.GREEN, Card.Type.NORMAL, 9);
        game.playDeck.push(greenNine);
        game.playDeck.push(yellowNine);
        game.playDeck.removeAll();
        assertEquals(game.playDeck.cards.size(), 0);
    }


}