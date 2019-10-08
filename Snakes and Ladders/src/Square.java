public class Square {
    boolean isOccupied;
    boolean isSnadder;
    int number;
    List occupants = new ArrayList();

    public Square(int i)
    {
        this.isSnadder = false;
        this.isOccupied = false;
        this.number = i;
    }

}