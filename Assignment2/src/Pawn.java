import javafx.util.Pair;

public class Pawn extends Piece {

    public Pawn(boolean available, Color col){
        super(available, col);
    }


    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        // ToDo: implement capture?
        // lynn
        //EnPassantValid?
        if (Game.readInput().isCaptured){ //how to access isCaptured??
            //whiteplayer
            if (this.getColor() == Color.WHITE){
                // if both on the rank 5
                if (fromY ==5 && (Game.getlastMove()[2] == fromY) &&
                        // and next together
                    (fromX == Game.getlastMove()[1] -1 || fromX == Game.getlastMove()[1] + 1) &&
                        // and last move was 2 forward
                        (Game.getlastMove()[2] - Game.getlastMove()[3] == 2) &&
                        // and last moved Piece was a Pawn
                        (Game.getlastMove()[4] == 1) &&
                        // and move is diagonal 1 field
                        (toX == Game.getlastMove()[1] && toY == Game.getlastMove()[3]+1 ))
                        { return true; }
                // EnPassant Capture not possible
                else { return false; }
            }
            else if (this.getColor() == Color.BLACK){
                //if both Rank 5 seen from Black, means Rank 4
                if (fromY == 4 && Game.getlastMove()[3] == fromY &&
                        // and next together
                        (fromX == Game.getlastMove()[1] -1 || fromX == Game.getlastMove()[1] + 1) &&
                        // and last move was 2 forward
                        Game.getlastMove()[2] - Game.getlastMove()[3] == -2 &&
                        // and last moved piece was a pawn
                        Game.getlastMove()[4] == 1 &&
                        // and move is diagonal 1 field
                        (toX == Game.getlastMove()[1] && toY == Game.getlastMove()[3]-1))
                { return true; }
                // EnPassant Capture not possible
                else {return false; }
            }
        }
        //lynn


        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        if (this.getColor() == Color.WHITE){
            // If not first move
            if(fromY>1)
                return ((fromX == toX) && ((fromY + 1) == toY));
                // In their first move, Pawns can go forward two squares
            else
                return ((fromX == toX) && (((fromY + 1) == toY) || fromY+2 == toY));
        }
        else if (this.getColor() == Color.BLACK){
            if(fromY < 6){
                return ((fromX == toX) && ((fromY + 1) == toY));
            }
            else return ((fromX == toX) && (((fromY -1) == toY) || ((fromY -2) == toY)));
        }
        else return false;
    }

    @Override
    public String toString(){
        return super.toString() + "P";
    }
}
