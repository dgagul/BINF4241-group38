public class Player {
    public int id;
    public String name;
    public int position;
    boolean isWinner;

    public Player(String newName, int pos){
        name = newName;
        position = pos;
    }

    public void move(int delta, Square[] squares){
        int newpos = position + delta;                                   // newpos is where the player lands
        position = landHereOrGoHome(newpos, squares);                    // is new position occupied?
        if (position != 0){                                              // if new position was not occupied
            if (squares[position].isSnadder){                            // if new position is bottom of Ladder?
                squares[position].isOccupied = false;                    // position is being left
                position = landHereOrGoHome(Snadder.end, squares);       // is new position (after ladder) occupied?
            }
        }
    }

    // Helper method that checks whether player can land at newpos or has to go to square 1
    public int landHereOrGoHome(int newpos, Square[] squares){
        squares[position].occupant = null;
        if (squares[newpos].isOccupied){
            squares[0].occupant = name;
            return 0;
        }
        else{
            squares[newpos].isOccupied = true;
            squares[newpos].occupant = name;
            return newpos;
        }
    }
}
