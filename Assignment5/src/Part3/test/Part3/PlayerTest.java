package Part3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /**
     * Assert that getName() returns the actual name
     */
    @Test
    public void testGetName(){
        Player p = new Player();
        p.name = "Mary";
        String n = p.getName();
        assertEquals(n, "Mary");
    }

    /**
     * Assert that getScore returns the actual score of a player
     */
    @Test
    public void testGetScore(){
        Player p = new Player();
        p.score = 100;
        int s = p.getScore();
        assertEquals(s, 100);
    }

    /**
     * Assert that addCard adds the correct card to the correct player's hands
     */
    @Test
    public void testAddCard(){
        Player p = new Player();
        assertEquals(p.handCards.size(), 0);
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        p.addCard(yellowFive);
        assertEquals(p.handCards.size(), 1);
    }

    @Test
    public void testGetCard(){
        Player p = new Player();
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        p.addCard(yellowFive);
        Card c = p.getCard(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        assertNotNull(c);
    }

    @Test
    public void testRemoveAllCards(){
        Player p = new Player();
        Card yellowFive = new Card(Card.Color.YELLOW, Card.Type.NORMAL, 5);
        Card blueDrawTo = new Card(Card.Color.BLUE, Card.Type.DRAW_2, 20);
        p.addCard(yellowFive);
        p.addCard(blueDrawTo);
        p.removeAllCards();
        assertEquals(p.handCards.size(), 0);
    }

}