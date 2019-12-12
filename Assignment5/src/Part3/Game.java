package Part3;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    public boolean direction;
    private boolean isOver;
    DrawDeck drawDeck;
    PlayDeck playDeck;
    public Player currentPlayer;

    Player getNextPlayer(){
        return currentPlayer;
    }

    public void run(){}


    public void numberCard(Card card){}

    public void wild(){}

    public void wildDrawFour(){}

    public void drawTo(){}

    public void skip(){}

    public void reverse(){}

    public void reshuffle(){}

    public String readInput(){
        return "";
    }

    public boolean validPlayCheck(Card card){
        return false;
    }

    public void printScore(){}

    public void addPlayer(Player p){
        players.add(p);
    }


}
