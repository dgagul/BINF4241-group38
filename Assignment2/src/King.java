import javafx.util.Pair;

public class King extends Piece {
    public King(Color pColor, Name pName){
        super(pColor, pName);
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        int dist = (int)(Math.pow(fromX-toX,2) + Math.pow(fromY-toY, 2));
        return (dist == 1) || (dist == 2);
    }
}
