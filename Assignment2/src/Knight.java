import javafx.util.Pair;

public class Knight extends Piece {
    public Knight(Color pColor, String pName){
        super(pColor, pName);
    }


    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        return (((fromX+1==toX || fromX-1==toX) && (fromY+2==toY || fromY-2==toY))
                || ((fromX+2==toX || fromX-2==toX) && (fromY+1==toY || fromY-1==toY)));
    }
}
