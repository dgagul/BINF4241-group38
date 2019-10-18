import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public enum Color{
        BLACK,
        WHITE;
    }

    private Color color;
    private String name;

    private List<Piece> rest_pieces = new ArrayList<>();
    private List<Piece> eaten_pieces = new ArrayList<>();

    public Player(Color playerColor){
        color = playerColor;
        Scanner player = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid){
            System.out.printf("Please enter a name for the Player with Color %s.\n", playerColor);
            name = player.nextLine();
            if (name.matches("^[a-zA-Z1-9]*$")&& !name.equals("") && name.length() < 15){
                isValid = true;
            }
            else System.out.println("Please enter a non-empty name with a maximum length of 15 and only containing characters from a-Z and 1-9.");
        }
    }

    public Color getColor(){
        return color;
    }

    public String getName(){
        return name;
    }

    // Lists are mutable
    public List<Piece> getRest_pieces(){
        return new ArrayList<Piece>(rest_pieces);
    }

    public List<Piece> getEaten_pieces() {
        return new ArrayList<Piece>(eaten_pieces);
    }
}
