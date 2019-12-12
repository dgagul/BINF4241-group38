package Part3;

import java.util.ArrayList;

public class Player {

    public ArrayList<Card> handCards;
    public String name;
    public int score;
    boolean announcedUNO;


    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void printCards(){}

    public void addCard(Card card){}

    public Card getCard(Card.Color color, Card.Type type, int points){return null;}

    public void removeCard(Card card){}

    public void removeAllCards(){}

    public void setUno(){}


}
