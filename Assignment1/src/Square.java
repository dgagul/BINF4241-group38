import java.util.ArrayList;

class Square {
    boolean isOccupied;
    int number;
    ArrayList<String >occupants;

    Square(int i)
    {
        isOccupied = false;
        number = i;
        occupants = new ArrayList<>();
    }

}