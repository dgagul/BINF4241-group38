package Part3;

import java.util.Stack;

public abstract class Deck {

    public Stack<Card> cards;

    public void shuffle(){}

    public boolean isEmpty(){
        return false;
    }
}
