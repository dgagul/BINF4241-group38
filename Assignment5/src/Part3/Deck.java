package Part3;

import java.util.Stack;

public abstract class Deck {

    public Stack<Card> cards = new Stack<>();

    public Card pop(){
        return cards.pop();
    }

    public void push(Card card){
        cards.push(card);
    }

    public boolean isEmpty(){
        return false;
    }
}
