import javafx.util.Pair;

public class Pawn extends Piece {
    private boolean hasMoved;
    public Pawn(Color pColor, Name pName){
        super(pColor, pName);
        hasMoved = false;
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        // ToDo: implement capture?
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;

        // If not first move
        if(hasMoved) {
            if (this.getaColor() == Color.WHITE) {
                return ((fromX == toX) && ((fromY - 1) == toY));
            }
            else {
                return ((fromX == toX) && ((fromY + 1) == toY));
            }
        }
        // In their first move, Pawns can go forward two squares
        else {
            if (this.getaColor() == Color.WHITE) {
                if ((fromX == toX) && (((fromY - 1) == toY) || ((fromY - 2) == toY))){
                    hasMoved = true;
                    return true;
                }
            }
            else {
                if ((fromX == toX) && (((fromY + 1) == toY) || ((fromY + 2) == toY))){
                    hasMoved = true;
                    return true;
                }
            }
        }
        return false;
    }
}
