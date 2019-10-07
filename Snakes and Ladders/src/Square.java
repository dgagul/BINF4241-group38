public class Square {
    boolean isOccupied;
    boolean isSnadder;
    int number;
    int end;
    String occupant;

    public Square(int i)
    {
        isOccupied = false;
        number = i;
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