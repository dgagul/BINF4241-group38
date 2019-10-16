import javafx.util.Pair;

public class Pawn extends Piece {
    public Pawn(boolean available, Pair<Integer,Integer> pos, String col){
        super(available, pos, col);
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        // ToDo: implement capture?
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        // If not first move
        if(fromY>1)
            return ((fromX == toX) && ((fromY + 1) == toY));
        // In their first move, Pawns can go forward two squares
        else
            return ((fromX == toX) && (((fromY + 1) == toY) || fromY+2 == toY));
    }
}
