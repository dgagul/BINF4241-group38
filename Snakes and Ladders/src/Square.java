import java.util.*;

public class Square {
    boolean isOccupied;
    boolean isSnadder;
    int number;
    int end;
    ArrayList<String >occupants;

    public Square(int i)
    {
        isOccupied = false;
        number = i;
        occupants = new ArrayList<String>();
    }

    public void setSnadder(boolean isLadder){
        isSnadder = true;
        if (isLadder) {
            end = number + 2;
        } else {
            end = number - 2;
        }
    }

}