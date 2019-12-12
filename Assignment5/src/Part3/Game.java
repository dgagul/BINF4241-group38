package Part3;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    public boolean direction;
    public boolean isOver;
    DrawDeck drawDeck;
    PlayDeck playDeck;
    public Player currentPlayer;

    Player getNextPlayer(){
        return currentPlayer;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void run(){}

    public void numberCard(Card card){}

    public void wild(Card card, Card.Color color){}

    public void wildDrawFour(Card card, Card.Color color){}

    public void drawTo(Card card){}

    public void skip(Card card){}

    public void reverse(Card card){}

    public DrawDeck reshuffle(){
        return drawDeck;
    }

    // This method should not be tested because it simply reads the command line input into a string
    public String readInput(){
        return "";
    }

    public boolean parseNumberOfPlayers(String number){return false;}

    public boolean parseNamesOfPlayers(String name){return false;}

    public ArrayList<Object> parseCommands(String Command){return null;}

    public boolean checkForUno(){return false;}

    public boolean checkValidMove(Card card){
        return false;
    }

    public void checkForWinner(){}

    public void askForRematch(){}

    public void printScore(){}


}
