public class Player {
    public String name;
    public int position;
    boolean isWinner;

    public Player(String newName, int pos) {
        name = newName;
        position = pos;
    }

    public void move(int delta, Square[] squares) {
        int newPos = position + delta;
        if (newPos >= squares.length) {
            squares[position].occupant = null;
            squares[squares.length - 1].isOccupied = true;
            squares[squares.length -1].occupant = name;
            position = squares.length-1;
        } else {
            position = landHereOrGoHome(newPos, squares);                    // is new position occupied?
            if (position != 0) {                                              // if new position was not occupied
                if (squares[position].isSnadder) {                            // if new position is bottom of Ladder?
                    squares[position].isOccupied = false;                    // position is being left
                    position = landHereOrGoHome(squares[position].end, squares);       // is new position (after ladder) occupied?
                }
            }
        }
    }

    // Helper method that checks whether player can land at newpos or has to go to square 1
    private int landHereOrGoHome(int newPos, Square[] squares) {
        squares[position].isOccupied = false;
        squares[position].occupant = null;
        if (squares[newPos].isOccupied) {
            squares[0].occupant = name;
            return 0;
        } else {
            squares[newPos].isOccupied = true;
            squares[newPos].occupant = name;
            return newPos;
        }
    }
}

