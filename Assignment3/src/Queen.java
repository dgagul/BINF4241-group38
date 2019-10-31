import javafx.util.Pair;

public class Queen extends Piece {
    public Queen(boolean available, Color.color col){
        super(available, col);
    }

    @Override
    public boolean moveIsValid(int fromX, int fromY, int toX, int toY) {
        if(!super.moveIsValid(fromX, fromY, toX, toY))
            return false;
        return (Math.abs(toX - fromX) == Math.abs(toY - fromY)) || (fromX == toX) || (fromY == toY);
    }

    @Override
    public String toString(){
        return super.toString() + "Q";
    }
}