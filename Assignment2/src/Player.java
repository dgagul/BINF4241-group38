import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Color.color color;
    private String name;

    private List<Piece> rest_pieces = new ArrayList<>();

    private List<Piece> captured_pieces = new ArrayList<>();

    public Player(Color.color playerColor){
        color = playerColor;
        Scanner player = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid){
            System.out.printf("Please enter a name for the Player with Color %s.\n", playerColor);
            name = player.nextLine();
            if (name.matches("^[a-zA-Z1-9]*$")&& !name.equals("")){
                isValid = true;
            }
            else System.out.println("Please enter a non-empty name only containing characters from a-Z and 1-9.");
        }
    }

    public Color.color getColor(){
        return color;
    }

    public String getName(){
        return name;
    }

    // Lists are mutable
    public List<Piece> getRest_pieces(){
        return new ArrayList<Piece>(rest_pieces);
    }

    public List<Piece> getCaptured_pieces() {
        return new ArrayList<Piece>(captured_pieces);
    }

    public void setCaptured_pieces(Piece captured) {
        this.captured_pieces.add(captured);
    }
}
