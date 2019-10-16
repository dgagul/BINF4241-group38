import javafx.util.Pair;
import java.lang.Math;

public class Bishop extends Piece {
    public Bishop(boolean available, Pair<Integer,Integer> pos, String col){
        super(available, pos, col);
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        return (Math.abs(toX - fromX) == Math.abs(toY - fromY));
    }
}