package main.snakesAndLadders;

public class Player {
    String name;
    private int position;

    // needed to create this getter method in order to testConstructor Player
    public int getPosition(){
        int copy = position;
        return copy;
    }

    public Player(String newName, int pos) {
        name = newName;
        position = pos;
    }

    void move(int delta, Square[] squares) {
        int newPos = position + delta;
        if (newPos >= squares.length) {
            squares[position].occupants.remove(0);
            squares[squares.length - 1].isOccupied = true;
            squares[squares.length -1].occupants.add(name);
            position = squares.length-1;
        } else {
            position = landHereOrGoHome(newPos, squares);
            if (position != 0) {
                if (squares[position].getClass() == Snadder.class) {
                    squares[position].isOccupied = false;
                    Snadder snadder = (Snadder)squares[position];
                    position = landHereOrGoHome(snadder.end, squares);
                }
            }
        }
    }

    // Helper method that checks whether player can land at newpos or has to go to square 1
    private int landHereOrGoHome(int newPos, Square[] squares) {
        squares[position].isOccupied = false;
        if(!squares[position].occupants.isEmpty()){
            squares[position].occupants.remove(0);
        }
        if (squares[newPos].isOccupied) {
            squares[0].occupants.add(name);
            return 0;
        } else {
            squares[newPos].isOccupied = true;
            squares[newPos].occupants.add(name);
            return newPos;
        }
    }
}