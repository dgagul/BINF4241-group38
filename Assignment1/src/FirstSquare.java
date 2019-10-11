import java.util.List;

public class FirstSquare extends Square {
    boolean isFirst;
    String[] occupants;

    public FirstSquare(int i) {
        super(i);
        isFirst = true;
        isOccupied = true;
        occupants = new String[4];
    }
}
