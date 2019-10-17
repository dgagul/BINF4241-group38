import javafx.util.Pair;

public class Tower extends Piece {
    public Tower(boolean available, Color col){
        super(available, col);
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        if (!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        // Tower can move in horizontal or vertical straight lines
        return (fromX == toX) || (fromY == toY);
    }

    @Override
    public String toString(){
        return super.toString() + "T";
    }
}
