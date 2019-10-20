import javafx.util.Pair;

public class Pawn extends Piece {

    public Pawn(boolean available, Color col){
        super(available, col);
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        // ToDo: implement capture?

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
