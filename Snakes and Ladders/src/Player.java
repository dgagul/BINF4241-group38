public class Player {
    String name;
    int position;

    public Player(String newName, int pos){
        name = newName;
        position = pos;
    }

    public void move(int delta, Object[] squares){
        int newpos = position + delta;                                   // newpos is where the player lands
        position = landHereOrGoHome(newpos, squares);                    // is new position occupied?
        if (position != 0){                                              // if new position was not occupied
            if (squares[position].isSnadder){                            // if new position is bottom of Ladder?
                squares[position].isOccupied = false;                    // position is being left
                position = landHereOrGoHome(squares[position].end, squares);       // is new position (after ladder) occupied?
            }
        }
    }

    // Helper method that checks whether player can land at newpos or has to go to square 1
    private int landHereOrGoHome(int newpos, Object[] squares){
        // Todo: check this method
        for (i = 0; i < squares[position].occupant.size(); i++) {
            if (squares[position].occupant[i] = Game.currentPlayer) {
                squares[position].occupant = null;
            }
        }
        if (squares[newpos].isOccupied){
            // Todo: add Playername to !Array! occupant
            squares[0].occupant = name;
            return 0;
        }
        else{
            squares[newpos].isOccupied = true;
            // Todo: add Playername to !Array! occupant
            squares[newpos].occupant = name;
            return newpos;
        }
    }
}

