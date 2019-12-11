package Part3;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    public boolean direction;
    private boolean isOver;
    private DrawDeck drawDeck;
    private PlayDeck playDeck;
    public Player currentPlayer;

    Player getNextPlayer(){
        return currentPlayer;
    }

    public void run(){}

    public void numberCard(){}

    public void wild(){}

    public void wildDrawFour(){}

    public void drawTo(){}

    public void skip(){}

    public void reverse(){}

    public void reshuffle(){}

    public String readInput(){
        return "";
    }

    public boolean validPlayCheck(){
        return false;
    }

    public void printScore(){}

    public void addPlayer(Player p){
        players.add(p);
    }


}
