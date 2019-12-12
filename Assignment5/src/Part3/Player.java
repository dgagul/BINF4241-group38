package Part3;

import java.util.ArrayList;

public class Player {

    public ArrayList<Card> handCards;
    public String name;
    private int score;
    boolean announcedUNO;


    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void printCards(){}

    public void addCard(Card card){}

    public Card getCard(Card.Color color, Card.Type type, int number){return null;}

    public void removeCard(Card card){}

    public void removeAllCard(){}

    public void setUno(){}


}
