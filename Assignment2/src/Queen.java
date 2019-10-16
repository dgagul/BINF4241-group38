import javafx.util.Pair;

public class Queen extends Piece {
    public Queen(Color pColor, String pName){
        super(pColor, pName);
    }


    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        return (Math.abs(toX - fromX) == Math.abs(toY - fromY)) || (fromX == toX) || (fromY == toY);
    }
}
