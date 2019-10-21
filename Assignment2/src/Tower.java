import javafx.util.Pair;

public class Tower extends Piece {

    private boolean firstMove;

    public Tower(boolean available, Color.color col){
        super(available, col);
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
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
