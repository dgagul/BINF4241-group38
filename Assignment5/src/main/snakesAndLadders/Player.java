package main.snakesAndLadders;

public class Player {
    String name;
    private int position;

    /**
     * crate a new player object
     *
     * @param newName a string of the players name
     * @param pos the index of the board where the player is located
     */
    public Player(String newName, int pos) {
        // Todo: HAD TO ADD THIS STATEMENT

        if (newName == null) {
            throw new IllegalArgumentException("cannot create null player");
        }
        if (newName == "") {
            throw new IllegalArgumentException("cannot create empty name player");
        }
        if (pos < 1){
            throw new IllegalArgumentException("cannot create player at negative position");
        }

        //until here

        name = newName;
        position = pos;
    }

    /**
     * moves the player from its current position delta steps ahead, and checks if the player can land or has to go home
     *
     * @param delta is the number of steps the player has to move, rolled by the die
     * @param squares a array of square objects that represents the board
     */
    public void move(int delta, Square[] squares) {
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

    /**
     * checks whether player can land at newpos or has to go back to starting square
     *
     * @param newPos the new position that has to be checked
     * @param squares a array of square objects that represents the board
     * @return returns either 0 if newpos is already occupied or newpos if not already occupied
     */
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



    /**
     * Getter function to get a not public attribute for testing
     *
     */
    public int getPosition(){
        int copy = position;
        return copy;
    }
    /**
     * Getter function to get a not public attribute for testing
     *
     */
    public String getName(){
        String copy = name;
        return copy;
    }
}