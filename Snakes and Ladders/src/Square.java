import java.util.ArrayList;
import java.util.List;

public class Square {
    boolean isSnadder;
    boolean isOccupied;
    int number;
    List[] occupants;

    public Square(int i)
    {
        this.isSnadder = false;
        this.isOccupied = false;
        this.number = i;
        this.occupants = new ArrayList[4];
    }
}




